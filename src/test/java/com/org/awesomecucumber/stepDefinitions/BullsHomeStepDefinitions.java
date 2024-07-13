package com.org.awesomecucumber.stepDefinitions;

import com.org.awesomecucumber.constants.Endpoints;
import com.org.awesomecucumber.context.TestContext;
import com.org.awesomecucumber.pages.HomePage_Bulls;
import com.org.awesomecucumber.pages.PageFactoryManager;
import com.org.awesomecucumber.utils.CSVWriterUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BullsHomeStepDefinitions {
    private WebDriver driver;
    private TestContext testContext;
    private HomePage_Bulls homePage_bulls;

    public BullsHomeStepDefinitions(TestContext testContext) {
        driver = testContext.driver;
        this.testContext = testContext;
        homePage_bulls = PageFactoryManager.getHomepage_bulls(driver);
    }

    @Given("I'm on the Bulls HomePage")
    public void i_m_on_the_bulls_home_page() {
        homePage_bulls.load(Endpoints.BULLS_HOME_PAGE.endpoint);
    }

    @When("I find all the hyperlinks and add it to CSV file")
    public void i_find_all_the_hyperlinks_and_add_it_to_csv_file() throws IOException {
        List<String> allFooterLinks_href = homePage_bulls.getFooterLinks();
        String[] linksHref = allFooterLinks_href.toArray(new String[allFooterLinks_href.size()]);
        CSVWriterUtils.writeDataToCSV("links", linksHref);
    }

    @Then("Validate if any duplicate hyperlinks are present and report in csv")
    public void validate_if_any_duplicate_hyperlinks_are_present_and_report_in_csv() throws IOException {
        List<String> allFooterLinks_href = homePage_bulls.getFooterLinks();
        List<String> duplicate_list = new ArrayList<>();
        Set<String> duplicate_links = new HashSet();
        for (String duplicate_link : allFooterLinks_href) {
            if (duplicate_links.add(duplicate_link) == false)
                duplicate_list.add(duplicate_link);
        }
        CSVWriterUtils.writeDataToCSV("duplicate_links",
                duplicate_list.toArray(new String[duplicate_list.size()]));
    }
}

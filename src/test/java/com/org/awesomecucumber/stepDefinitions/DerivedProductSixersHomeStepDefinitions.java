package com.org.awesomecucumber.stepDefinitions;

import com.org.awesomecucumber.constants.Endpoints;
import com.org.awesomecucumber.context.TestContext;
import com.org.awesomecucumber.pages.DerivedProductSixersHomePage;
import com.org.awesomecucumber.pages.PageFactoryManager;
import com.org.awesomecucumber.objects.Slides;
import com.org.awesomecucumber.utils.JacksonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DerivedProductSixersHomeStepDefinitions {
    private final WebDriver driver;
    private TestContext testContext;
    SoftAssert softAssert = new SoftAssert();
    private DerivedProductSixersHomePage derivedProductSixersHomePage;

    public DerivedProductSixersHomeStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        driver = testContext.driver;
        derivedProductSixersHomePage = PageFactoryManager.getDerivedProductSixersHomePage(driver);
    }

    @Given("I'm on the derived product one sixers home page")
    public void i_m_on_the_derived_product_sixers_home_page() {
        derivedProductSixersHomePage.load(Endpoints.DERIVED_PRODUCT1_HOME_PAGE_SIXERS.endpoint);
    }

    @When("I count the number of slides present on the page")
    public void i_count_the_number_of_slides_present_on_the_page() {
        System.out.println("The number of slides are " + derivedProductSixersHomePage.getSlidesTitle().size());
    }

    @Then("Validate the title of each slide against the expected data in file {string}")
    public void validate_the_title_of_each_slide_against_the_expected_data_in_file(String fileName) throws IOException {
        Slides[] slides = JacksonUtils.deserializeJson(fileName, Slides[].class);
        List<WebElement> slidesTitleFromPage = derivedProductSixersHomePage.getSlidesTitle();
        for (WebElement slideTitle : slidesTitleFromPage) {
            String actualTitle = slideTitle.getText();
            boolean flag = false;
            for (Slides slide : slides) {
                if (slide.getTitle().equals(actualTitle))
                    flag = true;
            }
            if (!flag)
                softAssert.assertEquals(true, false, actualTitle + " is not present in the list of expected titles");
        }
    }

    @And("Validate the duration of each slide against the expected data")
    public void validate_duration_for_each_slide() throws IOException {
        List<WebElement> allSlides = derivedProductSixersHomePage.getSlides();
        Slides[] slides = JacksonUtils.deserializeJson("slides.json", Slides[].class);
        HashMap<String, Double> durations = new HashMap();
        for (WebElement slide : allSlides) {
            while (Boolean.valueOf(slide.getAttribute("aria-selected")) == false) {
            }
            long startTime = System.currentTimeMillis();
            while (Boolean.valueOf(slide.getAttribute("aria-selected")) == true) {
            }
            long endTime = System.currentTimeMillis();
            durations.put(slide.getText(), (endTime - startTime) / 1000d);
        }
        Arrays.stream(slides).forEach(slide -> {
            double timeForSlide = durations.get(slide.getTitle());
            softAssert.assertTrue(timeForSlide >= slide.getDuration() + 1 || timeForSlide <= slide.getDuration() - 1,
                    "Time taken by the slide while playing is out of range " + timeForSlide);
        });
    }

}

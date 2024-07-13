package com.org.awesomecucumber.stepDefinitions;

import com.org.awesomecucumber.constants.Endpoints;
import com.org.awesomecucumber.context.TestContext;
import com.org.awesomecucumber.pages.CoreProductHomePage;
import com.org.awesomecucumber.pages.CoreProductNewsPage;
import com.org.awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CoreProductNewFeaturesStepDefinitions {
    private final WebDriver driver;
    private TestContext testContext;
    private CoreProductNewsPage coreProductNewsPage;

    public CoreProductNewFeaturesStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        driver = testContext.driver;
        coreProductNewsPage = PageFactoryManager.getCoreProductNewsPage(driver);
    }

    @Then("I count the number of video feeds")
    public void i_count_the_number_of_video_feeds() {
        coreProductNewsPage.getHeadersAndMenu().
                waitUntilVisibilityOfElement(coreProductNewsPage.getHeadersAndMenu().getHoverMenuItem());
        coreProductNewsPage.waitUntilUrlMatches(Endpoints.CORE_PRODUCT_NEWS_PAGE.endpoint);
        System.out.println("The total number of video feeds are " + coreProductNewsPage.getVideoFeedsCount().size());
    }

    @Then("I count the feeds those are present in the page greater than equal to {int} days")
    public void i_count_the_feeds_those_are_present_in_the_page_greater_than_equal_to_days(int days) {
        List<WebElement> videoFeeds = coreProductNewsPage.getVideoFeedsCountWithDays();
        int numberOfFeeds = 0;
        for (WebElement video : videoFeeds) {
            if (video.getText().contains("d")) {
                int videoDay = Integer.parseInt(video.getText().replace("d", ""));
                if (videoDay >= days)
                    numberOfFeeds++;
            } else numberOfFeeds++;
        }
        System.out.println("The total number of feeds with days greater than equal to " + days + " are " + numberOfFeeds);
    }
}

package com.org.awesomecucumber.stepDefinitions;

import com.org.awesomecucumber.constants.Endpoints;
import com.org.awesomecucumber.context.TestContext;
import com.org.awesomecucumber.pages.CoreProductHomePage;
import com.org.awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class CoreProductHomeStepDefinitions {
    private final WebDriver driver;
    private TestContext testContext;
    private CoreProductHomePage coreProductHomePage;

    public CoreProductHomeStepDefinitions(TestContext testContext) {
        this.testContext = testContext;
        driver = testContext.driver;
        coreProductHomePage = PageFactoryManager.getCoreProductHomePage(driver);
    }

    @Given("I'm on the core product home page")
    public void i_m_on_the_core_product_home_page() {
        coreProductHomePage.load(Endpoints.CORE_PRODUCT_HOME_PAGE.endpoint);
    }

    @When("I hover to the menu and click on News and features")
    public void i_hover_to_the_menu_and_click_on_news_and_features() {
        coreProductHomePage.closePopUp();
        coreProductHomePage.getHeadersAndMenu().hoverAndSelectNewsAndFeaturesItems();
    }
}

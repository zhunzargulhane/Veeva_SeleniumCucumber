package com.org.awesomecucumber.pages.components;

import com.org.awesomecucumber.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HeadersAndMenu extends BasePage {

    @FindBy(xpath = "//nav[@aria-label='header-secondary-menu']/ul/li/a")
    private WebElement hoverMenuItem;

    @FindBy(xpath = "(//nav[@aria-label='header-secondary-menu']//a[normalize-space(text())='News & Features'])[1]")
    private WebElement NewsAndFeatures;

    public HeadersAndMenu(WebDriver driver) {
        super(driver);
    }

    public void hoverAndSelectNewsAndFeaturesItems() {
        waitUntilVisibilityOfElement(hoverMenuItem);
        Actions hoverMenu = new Actions(driver);
        hoverMenu.moveToElement(hoverMenuItem).moveToElement(NewsAndFeatures).click().build().perform();
    }

    public WebElement getHoverMenuItem() {
        return hoverMenuItem;
    }

}

package com.org.awesomecucumber.pages;

import com.org.awesomecucumber.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage_Bulls extends BasePage {
    @FindBy(xpath = "//footer[@data-testid='footer']//a[@href]")
    private List<WebElement> footerLinks;

    public HomePage_Bulls(WebDriver driver) {
        super(driver);
    }

    public List<String> getFooterLinks() {
        List<WebElement> allFooterLinks = waitUntilVisibilityOfAllElements(footerLinks);
        List<String> href_footerLinks = new ArrayList<>();
        for (WebElement webElement : allFooterLinks) {
            href_footerLinks.add(webElement.getAttribute("href"));
        }
        return href_footerLinks;
    }
}

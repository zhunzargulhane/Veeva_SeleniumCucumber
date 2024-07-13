package com.org.awesomecucumber.base;

import com.org.awesomecucumber.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected final WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        PageFactory.initElements(driver, this);
    }

    public void load(String endpoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl()+endpoint);
    }

    public List<WebElement> waitUntilVisibilityOfAllElements(List<WebElement> elements){
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement waitUntilVisibilityOfElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilUrlMatches(String endpoint){
        wait.until(ExpectedConditions.urlContains(endpoint));
    }
}

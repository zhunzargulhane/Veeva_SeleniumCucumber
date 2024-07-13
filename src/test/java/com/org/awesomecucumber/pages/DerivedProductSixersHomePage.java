package com.org.awesomecucumber.pages;

import com.org.awesomecucumber.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DerivedProductSixersHomePage extends BasePage {
    @FindBy(xpath = "//button[contains(@class,'TileHeroStories_')]/div[1]")
    private List<WebElement> slidesTitle;
    @FindBy(xpath = "//div[@class='TileHeroStories_tileHeroStoriesButtonTitle__8Xiey']/parent::button")
    private List<WebElement> slides;

    public DerivedProductSixersHomePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSlidesTitle() {
        return waitUntilVisibilityOfAllElements(slidesTitle);
    }

    public List<WebElement> getSlides() {
        return slides;
    }

}

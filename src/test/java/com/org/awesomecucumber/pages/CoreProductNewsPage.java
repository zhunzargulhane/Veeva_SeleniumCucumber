package com.org.awesomecucumber.pages;

import com.org.awesomecucumber.base.BasePage;
import com.org.awesomecucumber.pages.components.HeadersAndMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CoreProductNewsPage extends BasePage {

    private HeadersAndMenu headersAndMenu;

    public CoreProductNewsPage(WebDriver driver) {
        super(driver);
        headersAndMenu = new HeadersAndMenu(driver);
    }

    public HeadersAndMenu getHeadersAndMenu() {
        return headersAndMenu;
    }

    @FindBy(xpath = "//h3[text()='VIDEOS']/parent::div[1]/following-sibling::div/div/ul/li")
    private List<WebElement> videoFeeds;

    @FindBy(xpath = "//h3[text()='VIDEOS']/parent::div[1]/following-sibling::div//div[@class='TileArticle_tileArticleContent__RyqlU']/descendant::time/span")
    private List<WebElement> videoFeedsWithDays;


    public List<WebElement> getVideoFeedsCount() {
        return waitUntilVisibilityOfAllElements(videoFeeds);
    }

    public List<WebElement> getVideoFeedsCountWithDays() {
        return waitUntilVisibilityOfAllElements(videoFeedsWithDays);
    }


}

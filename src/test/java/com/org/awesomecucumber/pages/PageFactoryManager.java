package com.org.awesomecucumber.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    private static HomePage_Bulls homepage_bulls;
    private static CoreProductHomePage coreProductHomePage;
    private static CoreProductNewsPage coreProductNewsPage;
    private static DerivedProductSixersHomePage derivedProductSixersHomePage;

    public static HomePage_Bulls getHomepage_bulls(WebDriver driver) {
        if (homepage_bulls == null)
            homepage_bulls = new HomePage_Bulls(driver);
        return homepage_bulls;
    }

    public static CoreProductHomePage getCoreProductHomePage(WebDriver driver) {
        if (coreProductHomePage == null)
            coreProductHomePage = new CoreProductHomePage(driver);
        return coreProductHomePage;
    }

    public static CoreProductNewsPage getCoreProductNewsPage(WebDriver driver) {
        if (coreProductNewsPage == null)
            coreProductNewsPage = new CoreProductNewsPage(driver);
        return coreProductNewsPage;
    }

    public static DerivedProductSixersHomePage getDerivedProductSixersHomePage(WebDriver driver) {
        if (derivedProductSixersHomePage == null)
            derivedProductSixersHomePage = new DerivedProductSixersHomePage(driver);
        return derivedProductSixersHomePage;
    }
}

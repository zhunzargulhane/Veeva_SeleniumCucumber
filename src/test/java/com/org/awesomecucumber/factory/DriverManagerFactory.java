package com.org.awesomecucumber.factory;

import com.org.awesomecucumber.constants.DriverType;

public class DriverManagerFactory {
    public static DriverManager getManager(String browser){
        switch (DriverType.valueOf(browser)) {
            case CHROME -> {
                return new ChromeDriverManager();
            }
            case FIREFOX -> {
                return new FirefoxDriverManager();
            }
            default -> throw new RuntimeException("Invalid browser name supplied "+browser);
        }
    }
}

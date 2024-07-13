package com.org.awesomecucumber.constants;

public enum Endpoints {
    BULLS_HOME_PAGE("/bulls"),
    CORE_PRODUCT_HOME_PAGE("/warriors"),
    CORE_PRODUCT_NEWS_PAGE("/news"),
    DERIVED_PRODUCT1_HOME_PAGE_SIXERS("/sixers");
    public String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }
}

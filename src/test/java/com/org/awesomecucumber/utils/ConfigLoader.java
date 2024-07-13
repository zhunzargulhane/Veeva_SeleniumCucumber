package com.org.awesomecucumber.utils;

import com.org.awesomecucumber.constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader configLoader;
    private static Properties properties;

    private ConfigLoader() {
        String env = System.getProperty("env", "DP2");
        switch (EnvType.valueOf(env)) {
            case DP1 -> {
                properties = PropertyUtils.getPropertyLoader("src\\test\\resources\\config_dp1.properties");
            }
            case DP2 -> {
                properties = PropertyUtils.getPropertyLoader("src\\test\\resources\\config_dp2.properties");
            }
            case CP -> {
                properties = PropertyUtils.getPropertyLoader("src\\test\\resources\\config_cp.properties");
            }
            default -> throw new IllegalArgumentException("INVALID ENVIRONMENT IS PROVIDED " + env);
        }
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null)
            configLoader = new ConfigLoader();
        return configLoader;
    }

    public String getBaseUrl(){
        String baseUrl = properties.getProperty("baseUrl");
        if(baseUrl==null)
            throw new RuntimeException("PROPERTY IS NOT PRESENT IN THE FILE");
        return baseUrl;
    }
}

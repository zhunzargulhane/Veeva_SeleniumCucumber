package com.org.awesomecucumber.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties getPropertyLoader(String filePath) {
        BufferedReader bufferedReader;
        Properties properties = new Properties();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(bufferedReader);
            } catch (IOException ioException) {
                throw new RuntimeException("Unable to load properties file " + filePath);
            }
        } catch (IOException ioException) {
            throw new RuntimeException("properties file not found " + filePath);
        }
        return properties;
    }
}

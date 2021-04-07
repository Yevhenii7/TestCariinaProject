package com.qaprosoft.carina.demo.web.citrus.ua.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}

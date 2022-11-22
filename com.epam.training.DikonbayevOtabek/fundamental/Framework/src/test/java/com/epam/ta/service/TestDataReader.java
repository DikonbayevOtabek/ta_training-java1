package com.epam.ta.service;

import java.util.ResourceBundle;

public class TestDataReader {

    //System.getProperty("environment")
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("dev");

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}

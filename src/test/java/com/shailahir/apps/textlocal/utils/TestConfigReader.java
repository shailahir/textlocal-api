package com.shailahir.apps.textlocal.utils;

import java.io.InputStream;
import java.util.Properties;

public class TestConfigReader {

    public static String getApiKey() {
        Properties properties = getTestProperties();
        return properties.getProperty("textlocal.api.key");
    }

    public static String getMobileNumber() {
        Properties properties = getTestProperties();
        return properties.getProperty("textlocal.test.mobile");
    }

    private static Properties getTestProperties() {
        Properties properties = new Properties();
        try {
            InputStream in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("textlocal.test.properties");
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}

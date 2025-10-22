package com.selenium_accessibility.utility;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("selenium_accessibility/config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in resources/selenium");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public static Properties getProperty() {
        return properties;
    }
}


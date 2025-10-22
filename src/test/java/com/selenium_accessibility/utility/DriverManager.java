package com.selenium_accessibility.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() throws IOException {
        if (driver.get() == null) {
            driver.set(initDriver());
        }
        return driver.get();
    }

    private static WebDriver initDriver() {
        Properties props = ConfigReader.getProperty();
        String browser = props.getProperty("browser").toLowerCase();
        WebDriver driverInstance;

        switch (browser) {
            case "chrome":
                driverInstance = new ChromeDriver();
                break;
            case "firefox":
                driverInstance = new FirefoxDriver();
                break;
            case "edge":
                driverInstance = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        return driverInstance;
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
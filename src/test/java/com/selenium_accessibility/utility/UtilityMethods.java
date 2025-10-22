package com.selenium_accessibility.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class UtilityMethods {

    public static void launchingBrowser(WebDriver driver, String URL) {
        //driver.get("URL");
        //driver.manage().window().maximize();
        System.out.println("Successfully launched browser and landed on login page");
        Log.info("Successfully launched the browser");
    }

    public static void login(WebDriver driver, String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
        System.out.println("Logged in Successfully");
        Log.info("Logged in Successfully");
    }

    public static void captureScreenshot(String fileName, WebDriver driver) {

        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile((ts.getScreenshotAs(OutputType.FILE)), new File("target/Screenshot/" + fileName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Log.info("Screenshot captured successfully");

    }

    public static void checkBrokenLinks(WebDriver driver) {
        Log.info("Started to verify broken links");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + links.size());
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url == null || url.isEmpty()) {
                System.out.println("Null href: " + link.getText());
                continue;
            }
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();
                int statusCode = connection.getResponseCode();
                if (statusCode >= 400) {
                    System.out.println("Broken Link: " + url + " | Status Code: " + statusCode);
                } else {
                    System.out.println("Valid Link: " + url + " | Status Code: " + statusCode);
                }
            } catch (Exception e) {
                System.out.println("Exception for URL: " + url + " | " + e.getMessage());
            }

        }
        Log.info("Verified broken links");
    }
}

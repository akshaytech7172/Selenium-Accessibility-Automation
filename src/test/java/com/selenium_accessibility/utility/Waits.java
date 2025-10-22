package com.selenium_accessibility.utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
        // Explicit Wait - Element visible
        public WebElement waitForElementVisible(WebDriver driver, By locator, int timeout) {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        // Explicit Wait - Element clickable
        public WebElement waitForElementClickable(WebDriver driver, By locator, int timeout) {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        }
        // Wait for alert
        public Alert waitForAlert(WebDriver driver, int timeout) {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.alertIsPresent());
        }
        // Wait for page title
        public boolean waitForTitle(WebDriver driver, String title, int timeout) {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .until(ExpectedConditions.titleContains(title));
        }
        // Fluent Wait Example (custom polling)
        public WebElement fluentWait(WebDriver driver, By locator, int timeout, int polling) {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofMillis(polling))
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        // Hard wait (use only when absolutely needed!)
        public void hardWait(int millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


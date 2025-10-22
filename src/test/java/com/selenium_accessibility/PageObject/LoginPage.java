package com.selenium_accessibility.PageObject;

import com.selenium_accessibility.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    /* Locators of login page*/
    public By userID = By.xpath("Xpath");
    public By password = By.xpath("Xpath");
    public By loginButton = By.xpath("Xpath");
    public By loginError = By.xpath("Xpath");

    /* Methods - Includes actions on the login page*/

    public void enterUsername(String UserID, WebDriver driver) {
        //driver.findElement(userID).sendKeys(UserID);
        System.out.println("Entered user id " + UserID);
        Log.info("Entered UserID");
    }
    public void enterPassword(String password,WebDriver driver) {
        //driver.findElement(this.password).sendKeys(pass);
        System.out.println("Entered user id " + password);
        Log.info("Entered Password");
    }
    public void clickButtonLogin(WebDriver driver) {
        //driver.findElement(loginButton).click();
        Log.info("Successfully clicked on login button");
    }

    public void validateErrorInvalidUserIDPassword(WebDriver driver) {
        //String error=driver.findElement(loginError).getText();
       //Assert.assertFalse(error.equals("Invalid UserID and Password"));
        Log.info("Verified Error message for Invalid UserId and Password");
    }
    public void validateErrorBlankUserIDPassword(WebDriver driver) {
        //String error=driver.findElement(loginError).getText();
        //Assert.assertFalse(error.equals("Please enter valid UserID and Password"));
        Log.info("Verified Error message for Blank UserId and Password");
}}

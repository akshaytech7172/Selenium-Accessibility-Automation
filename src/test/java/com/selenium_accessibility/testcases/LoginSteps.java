package com.selenium_accessibility.testcases;

import com.selenium_accessibility.utility.*;
import com.selenium_accessibility.PageObject.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LoginSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    public static WebDriver driver;

    static {
        try {
            driver = DriverManager.getDriver();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    LoginPage login = new LoginPage();
    Waits wait=new Waits();
    AccessibilityViolation violation=new AccessibilityViolation();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        UtilityMethods.launchingBrowser(driver, "url");
        //wait.waitForTitle(driver, "login Page", 10);   //Waits till title visible
        //UtilityMethods.checkBrokenLinks(driver);       //Check broken links
        //violation.ViolationCheck(driver);             //Check accessibility Violations
    }

    @io.cucumber.java.en.When("I enter username {string}")
    public void iEnterUsername(String ID) {
        login.enterUsername(ID, driver);
    }

    @io.cucumber.java.en.And("I enter password {string}")
    public void iEnterPassword(String Pass) {
        login.enterPassword(Pass, driver);
    }

    @io.cucumber.java.en.And("I click on login button")
    public void iClickOnLoginButton() {
        login.clickButtonLogin(driver);
    }

    @io.cucumber.java.en.Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomepage() {
        Log.info("Landed on Homepage");
    }

    @io.cucumber.java.en.And("I should see a homepage")
    public void iShouldSeeAHomepage() {
        //wait.waitForTitle(driver, "Home page", 10);
        Log.info("On homepage");
        UtilityMethods.captureScreenshot("SuccessfullyLoggedIn", driver);
    }

    @Then("I should see an error message for blank credentials {string}")
    public void iShouldSeeAnErrorMessageForBlankCredentials(String arg0) {
        log.info("Clicking on login button without UserID and Password");
        login.validateErrorBlankUserIDPassword(driver);
        UtilityMethods.captureScreenshot("BlankUserIDPassword", driver);
    }

    @Then("I should see an error message for incorrect ID and password {string}")
    public void iShouldSeeAnErrorMessageForIncorrectIDAndPassword(String arg0) {
        login.validateErrorInvalidUserIDPassword(driver);
        UtilityMethods.captureScreenshot("IncorrectUserIDPassword", driver);
    }
}
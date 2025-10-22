package com.selenium_accessibility.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src\\test\\resources\\selenium_accessibility\\features",
        glue = {"com.selenium_accessibility.testcases"},
        plugin = {"pretty", "html:target/cucumber-reports/html-report.html"},
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}git config --global user.name "akshaytech7172"
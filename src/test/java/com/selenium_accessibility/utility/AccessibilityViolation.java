package com.selenium_accessibility.utility;
import com.deque.axe.AXE;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import java.net.URL;

public class AccessibilityViolation {
    private static final URL scriptUrl = AccessibilityViolation.class.getResource("/axe.min.js");
    public void ViolationCheck(WebDriver driver) {
        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");
        if (violations.length() == 0) {
            System.out.println("No accessibility violations found!");
        } else {
            System.out.println("Accessibility violations:");
            for (int i = 0; i < violations.length(); i++) {
                JSONObject violation = violations.getJSONObject(i);
                System.out.println("Violation Number: " + i+1);
                System.out.println("Rule: " + violation.getString("id"));
                System.out.println("Impact: " + violation.getString("impact"));
                System.out.println("Description: " + violation.getString("description"));
                System.out.println("HelpURL: " + violation.getString("helpUrl"));
                System.out.println("Help: " + violation.getString("help"));
                JSONArray nodes = violation.getJSONArray("nodes");
                System.out.println("Nodes Summary: " + nodes.toString(i));
                JSONArray tags = violation.getJSONArray("tags");
                System.out.println("Tags: " + tags.toString());
            }
        }
        driver.quit();
    }
}


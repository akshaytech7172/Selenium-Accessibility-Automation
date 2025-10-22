Feature: Login functionality

  As a user of the application
  I want to be able to login with valid credentials
  So that I can access my account securely

  Background:
    Given I am on the login page

  @sanity @login
  Scenario Outline: Successful login with valid credentials
    When I enter username <ID>
    And I enter password <Pass>
    And I click on login button
    Then I should be redirected to the homepage
    And I should see a homepage
    Examples:
      | ID       | Pass         |
      | "user123" | "Password123" |

  @regression @login
  Scenario Outline: Login fails with invalid password
    When I enter username <ID>
    And I enter password <Pass>
    And I click on login button
    Then I should see an error message for incorrect ID and password "Invalid username or password"
    Examples:
      | ID         | Pass            |
      | "123user" | "wrongPassword" |

  @regression @login
  Scenario: Login fails with blank credentials
    When I click on login button
    Then I should see an error message for blank credentials "Username and Password are required"

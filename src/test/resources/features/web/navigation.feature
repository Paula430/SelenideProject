@web @navigation
Feature: Navigation through application
  @logout
  Scenario: Logs out successfully
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    And I click the logout button
    Then I should see the login button

  @about
  Scenario: Navigate to About page
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    And I open the sidebar menu
    And I click on the About link
    Then I should see the About page header "Build apps users love with AI-driven insights"
@web @login
Feature: User Login
  @correctLogin
  Scenario: Valid user login
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the home page

  @invalidLogin
  Scenario: Locked out user login
    Given I am on the login page
    When I enter username "locked_out_user" and password "secret_sauce"
    And I click the login button
    Then I should see an error message "Epic sadface: Sorry, this user has been locked out."

  @invalidLogin
  Scenario: Invalid credentials user login
    Given I am on the login page
    When I enter username "incorrect_user" and password "wrong_password"
    And I click the login button
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"

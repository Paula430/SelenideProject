@web @purchase
Feature: Product purchase flow
  @cart
  Scenario: Add a product to the cart
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    And I add "Sauce Labs Backpack" to the cart
    Then The cart badge should show "1"

  @cart
  Scenario: Remove a product from the home page
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    And I add "Sauce Labs Backpack" to the cart
    Then The cart badge should show "1"
    When I remove "Sauce Labs Backpack" from the home page
    Then The cart badge should not be visible

  @cart
  Scenario: Remove a product from the cart page
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    And I add "Sauce Labs Bike Light" to the cart
    And I go to the cart
    And I remove "Sauce Labs Bike Light" from the cart
    And I continue shopping
    Then The cart badge should not be visible

  @checkout
  Scenario: Complete the checkout process
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    And I add "Sauce Labs Backpack" to the cart
    And I go to the cart
    And I proceed to checkout
    Then I should see the subpage title "Checkout: Your Information"
    When I fill in checkout info with first name "John", last name "Doe", and postal code "12345"
    And I continue to overview
    Then I should see the subpage title "Checkout: Overview"
    And I should see the product "Sauce Labs Backpack" in checkout
    When I finish the checkout
    Then I should see the message "Thank you for your order!"
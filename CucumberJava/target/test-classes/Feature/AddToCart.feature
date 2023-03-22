Feature: To test add to cart functionality

  @SmokeTest
  Scenario: Check add to cart is successful
    Given user is on home page
    And user clicks on the shopall menu option
    And user clicks on active play option
    And user clicks on any option
    When user clicks on add to cart
    And User clicks on checkout button
    Then user navigate to checkout page

  @RegressionTest
  Scenario: Check multiple items add to cart is successful
    Given user is on home page
    And user clicks on the shopall menu option
    And user clicks on active play option
    And user click scroll down option
    And user clicks on any option
    And user clicks on Quantity drop-downs select a option
    When user clicks on add to cart
    And User clicks on checkout button
    Then user navigate to checkout page

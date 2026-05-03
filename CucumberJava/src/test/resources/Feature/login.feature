Feature: To test login functionality

  @RegressionTest
  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters <username> and <password>
    And click on  login button
    Then user navigated to the home page

    Examples: 
      | username         | password  |
      | student | Password123 |

  Scenario Outline: Check validation message is displayed on login with invalid credentials
    Given user is on login page
    And user clicks on login button
    When user enters <username12> and <password12>
    And click on  login button
    Then validation message should be displayed

    Examples: 
      | username12      | password12 |
      | test23@test.com | qqqq12345  |

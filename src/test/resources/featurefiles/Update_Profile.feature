Feature: Update Profile Information

@First
  Scenario: Verify User is able to successfully log in the website
    Given User is able to launch shopping website
   	When User clicks on 'Sign in' link
    And User enters login details
    And User clicks on 'Sign In' button
    Then User is able to login successfully

@Close
  Scenario: User is able to update Account Information
    Given User clicks on 'My personal information' option
    And User updates the first name details
    And User enters password
    And User clicks on 'Save' button
    Then User verifies account information is updated
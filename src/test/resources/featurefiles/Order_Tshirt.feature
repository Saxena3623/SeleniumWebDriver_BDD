#Author: Rishu Saxena
Feature: Ordering new T-shirt

  @First
  Scenario: Verify User is able to successfully log in the website
    Given User is able to launch shopping website
   	When User clicks on 'Sign in' link
    And User enters login details
    And User clicks on 'Sign In' button
    Then User is able to login successfully
    
   @Close
    Scenario: User places an order of T-shirt
    When User clicks on 'T-shirts' tab
    And User selects item to adds to cart
    And User clicks on checkout button
    And User is on 'Summary' Tab and clicks on 'Proceed to checkout'
    And User is on 'Address' Tab and clicks on 'Proceed to checkout'
    And User checkout after selecting Terms and Services 
    And User selects payment method 'bankwire' on payment tab
    And User clicks on 'I confirm my order'
    Then User verifies order is successful
    And User verifies recent order in history


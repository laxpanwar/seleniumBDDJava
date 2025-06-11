Feature: Adding a product to the cart
  As a user want to add a product to the cart
  I will to go to shopping cart
  So that I can verify it is added in the shopping cart
  Background:
    Given I am on the OpenCart login page

    Scenario: Add a product to the cart successfully
#      Given I have entered a valid username and password
#      When I click on the login button
      When I have entered valid product in the search bar
      Then Product displayed correctly
      When I click on the add to cart button
      Then The product should get added to cart successfully

  Scenario: Place an order
#    Given I have searched a valid product name
#
    When I have entered valid product in the search bar
    Then Product displayed correctly
    When I click on the add to cart button
    Then The product should get added to cart successfully
    And I have clicked on the checkout button
#    Then I am on the checkout page
    And I click on the billing details continue button
    And I click on the delivery details continue button
    And I click on the delivery methods continue button
    And I click on terms and condition checkbox
    And I click on the payment methods continue button
    And I click on the confirm order button
    Then order placed success message should display

#
#    When I enter the billing details
#    And I click on the Confirm Order button
#    Then Order confirmation message should be displayed
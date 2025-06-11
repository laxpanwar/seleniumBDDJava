Feature: Search Functionality for OpenCart E-commerce Website
  As a user of the OpenCart website
  I want to be able to log in with my account
  So that I search valid products by using search bar

  Background:
    Given I am on the OpenCart login page

  Scenario: Successful search a product
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    When I have entered valid product in the search bar
    Then Product displayed correctly

  Scenario: Search invalid product validation message
#      Given I have entered a valid username and password
#      When I click on the login button
      When I have entered an invalid product in the search bar
      Then Correct inavlid validation message should display
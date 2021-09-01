@all
Feature: Search feature

  @sanity3
  Scenario: Search a product in the app
    Given I am on the search page
    When I will search a product named "robe"
    Then The name of the products should be matches with the search

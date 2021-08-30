Feature: Basket feature

  @sanity2
  Scenario: Add a product to the basket
    Given I am on the search page
    And I will search a product named "Robe"
    When I add the product to the basket at the size "5A"
    And I go to the basket page
    Then I should be able to see the correct product in the basket

  @sanity2
  Scenario: Remove product of the basket
    Given I am on the search page
    And I will search a product named "Robe"
    And I add the product to the basket at the size "5A"
    And I go to the basket page
    When I remove the product of the basket
    Then The basket should be empty

Feature: Login feature

  @sanity
  Scenario: Login in the app
    Given I am on the login page
    When I will use credential "Lucas.Domes@gmail.com" and password "LucasDomes1234"
    And I click on the login button
    Then I should be able to be connected

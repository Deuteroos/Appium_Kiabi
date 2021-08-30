Feature: Create Account feature

  @sanity
  Scenario: Create Account in the app
    Given I am on the login page
    And I click on the create account button
    And I click on the refused cookies button
    When I fill the creation account form with lastName "DOMES", firstName "Lucas", birthDate "12/10/1996", email "Lucas.Domes@gmail.com" and password "LucasDomes1234"
    And I click on the submit creation account button
    And I refused the fidelity programs
    Then I should be on the home page
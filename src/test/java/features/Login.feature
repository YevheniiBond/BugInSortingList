Feature: Application Login

  Scenario: Home page default login

    Given User is on landing page
    When  User clicking on Enter button
    When  User login into pop up with "+380665631180" and password "StrongPa$$word123"
    And   User press confirm button

    Then  Account button is present
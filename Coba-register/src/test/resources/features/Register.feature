Feature: As a user i have be able to register so that i can see login screen

  Background:
    Given user on the login screen
    And user click "No account yet? Create one"

  @Success_register_with_input_valid_name_email_password_and_confirm_password
  Scenario: As a user i want to login with input valid name, email, password, and confirm password
    When user input valid name
    And user input valid email for register
    And user input valid password for register
    And user input valid confirm password
    And user click register button
    Then user view "Registration Successful"
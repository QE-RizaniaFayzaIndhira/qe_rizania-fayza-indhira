Feature: POST - add new user
  As a user
  I want to see list of users
  So that i can add new user

  @POST_add_new_user_with_valid_query_parameter
  Scenario: POST - as a user i want to add new user with valid query parameter
    Given user set POST endpoint for new user
    When user send POST HTTP request for new user
    Then user received HTTP response code 200 for new user

  @POST_add_new_user_with_invalid_query_parameter
  Scenario: POST - as a user i want to add new user with invalid query parameter
    Given user set POST endpoint with invalid query parameter for new user
    When user send POST HTTP request with invalid query parameter for new user
    Then user received POST HTTP response code 404 for new user

  @POST_add_new_user
  Scenario: POST - as a user i want to add new user
    Given user set POST endpoint for new user
    When user send POST HTTP request for new user
    Then user received HTTP response code 200 for new user
    And user received valid data for new user
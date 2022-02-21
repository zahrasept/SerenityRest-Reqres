Feature: Reqres API

  @Register
  Scenario: Registration
    When I create new Account with a valid email is "eve.holt@reqres.in" and password is "pistol"
    Then Register Successful
    And New Account with token is "QpwL5tke4Pnpja7X4"

  @Login
  Scenario: Login
    When I click login button with valid email is "eve.holt@reqres.in" and valid password is "cityslicka"
    Then Login Success
    And Login Account with token is "QpwL5tke4Pnpja7X4"

  @postCreateUser
  Scenario: Create new user
    When I create new User with name is "Zahra" and job is "Quality Assurance"
    Then New user is created
    And New user name is "Zahra" and job is "Quality Assurance"

  @getReqres
  Scenario: Get List User
    When I request list of user in page 2
    Then The system send 12 user in the list
    And the first user is "Michael"

  @getReqres2
  Scenario: Get single user
    When I click on user number 2
    Then The system send user with name "Janet"


Feature: Login scenarios

  @sprint1 @test
  Scenario: Valid admin login
    #Given user is navigated to HRMS application
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in
    #Then user closes the browser





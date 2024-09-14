Feature: Employee search
Background:  //Background keyword is used to define steps that are common to all scenarios in a feature file. It helps reduce redundancy by grouping steps that need to be executed before every scenario in that feature. Essentially, it's a way to define preconditions that apply to all scenarios within a feature file.

 # Given user is navigated to HRMS application
  When user enters admin username and password
  And user clicks on login button
  Then user is successfully logged in
  When user clicks on PIM option
  And user clicks on Employee List option


  @sprint2 @ahmed @regression @emp @test
    Scenario: Search an employee by Id
     # Given user is navigated to HRMS application
     # When user enters admin username and password
     # And user clicks on login button
     # Then user is successfully logged in
     # When user clicks on PIM option
     # And user clicks on Employee List option
      When  user enters employee id
      And user clicks on search button
      Then user should be able to see employee details
      #Then user closes the browser

@sprint4 @ali @regression @emp @test
      Scenario: Search an employee by name
      #  Given user is navigated to HRMS application
      #  When user enters admin username and password
      #  And user clicks on login button
      #  Then user is successfully logged in
      #  When user clicks on PIM option
      #  And user clicks on Employee List option
        When  user enters valid employee name
        And user clicks on search button
        Then user should be able to see employee details
      # Then user closes the browser



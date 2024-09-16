Feature: add employee scenario

  Background:
    When user enters admin username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    And user clicks on add employee option

  @addemp @test
  Scenario: Adding one employee in the hrms system
    #Given user is navigated to HRMS application
    #When user enters admin username and password
    #And user clicks on login button
    #Then user is successfully logged in
    #When user clicks on PIM option
    #And user clicks on add employee option
    When user enters firstName, middleName and lastName
    And user clicks on save button
    Then employee added successfully
    #Then user close the browser

  @cucumber

  Scenario: Adding one employee using feature file
    #When user enters admin username and password
    #And user clicks on login button
    #Then user is successfully logged in
    #When user clicks on PIM option
    #And user clicks on add employee option
    When user enters "klevisa" and "ms" and "kolaj"
    And user clicks on save button
    Then employee added successfully


  @ddt
  Scenario Outline: adding multiple employees from feature file
    When user enters "<firstName>" and "<middleName>" and enter "<lastName>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName     | middleName    | lastName    |
      | donald        | ms            | duck        |
      | tamoha        | ms            | jimo        |
      | joe           | ms            | trump       |


    @excel
    Scenario: Adding multiple employees from excel file
      When user adds multiple employees from excel using "Sheet1" and verify




      @datatable
      Scenario: adding multiple employees from data table
        When user adds multiple employees from data table
          | firstName     | middleName    | lastName    |
          | donald12        | ms            | duck        |
          | tamoha12        | ms            | jimo        |
          | joe12           | ms            | trump       |

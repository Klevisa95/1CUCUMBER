Feature: Syntax API workflow feature

  Background:
    Given a JWT is generated

  @api
  Scenario: create an employee via API
    Given a JWT is generated
    Given a request is prepared to create an employee
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee id "Employee.employee_id" is stored as global variable for another request


    @api
    Scenario: get the created employee
      Given a request is prepared to get the created employee
      When a GET call is made to get the employee
      Then the status code for this employee is 200
      And the global employee id must match with "employee.employee_id" key
      And the retreived data at "employee" object matches the data used to create employee


      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |klevisa      |kolaj       |ms             |Female    |1995-10-10  |confirmed |sdet           |




      @json
      Scenario: Creating the employee using json payload
        Given a request is prepared for creating an employee via json payload
        When a POST call is made to create an employee
        Then the status code for this request is 201
        And the employee id "Employee.employee_id" is stored as global variable for another
        And the response body contains "Message" key and value "Employee Created"


        @jsondynamic
  Scenario: Creating the employee using json payload
    Given a request is prepared for creating an employee with dynamic data "klevisa", "kolaj", "ms", "F", "1995-10-10", "confirmed", "sdet"
    When a POST call is made to create an employee
    Then the status code for this request is 201
    And the employee id "Employee.employee_id" is stored as global variable for another
    And the response body contains "Message" key and value "Employee Created"



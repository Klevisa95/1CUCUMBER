package APIsteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.runner.Request;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class APIWorkFlowSteps {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api"; //get url from swagger document
    public static String token;
    RequestSpecification request;
    Response response;
    public static String employee_id;


    @Given("a JWT is generated")
    public void a_jwt_is_generated() {

        //prepare the request | here we are creating the token so we write all elements: body, header
        request = given().
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"email\": \"testbatch1721@gmail.com\",\n" +
                        "  \"password\": \"Test@1231\"\n" +
                        "}");
        //send the request
        response = request.when().post("/generateToken.php");
        //storing the token after generating
        token = "Bearer" + response.jsonPath().getString("token");
        System.out.println(token);


    }

    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {

        request = given().
                header("Content-Type", "application/json").
                header("Authorization", token)
                .body("{\n" +
                        "  \"emp_firstname\": \"klevisa\",\n" +
                        "  \"emp_lastname\": \"kolaj\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"1995-10-10\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"sdet\"\n" +
                        "}");
    }

    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {

        response = request.when().post("/createEmployee.php");
        //to print the response in console
        response.prettyPrint();


    }

    @Then("the status code for this request is {int}")
    public void the_status_code_for_this_request_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);

        response.then().assertThat().
                body("Message", equalTo("Employee Created"));
        response.then().assertThat().
                body("Employee.emp_firstname", equalTo("klevisa"));

        response.then().assertThat()
                .header("Connection", equalTo("Keep-Alive"));

    }


    @Then("the employee id {string} is stored as global variable for another request")
    public void the_employee_id_is_stored_as_global_variable_for_another_request(String empID) {
        //empID is the parameter coming from feature file which is the path of employee id
        employee_id = response.jsonPath().getString(empID);
        System.out.println(employee_id);
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @Given("a request is prepared to get the created employee")
    public void aRequestIsPreparedToGetTheCreatedEmployee() {

        request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);


    }

    @When("a GET call is made to get the employee")
    public void aGETCallIsMadeToGetTheEmployee() {
        response = request.when().get("/getOneEmployee.php");
        response.prettyPrint();
       // response.then().assertThat().statusCode(200);


    }

    @Then("the status code for this employee is {int}")
    public void theStatusCodeForThisEmployeeIs(int statusCode) {

        response.then().assertThat().statusCode(statusCode);

    }

    @And("the global employee id must match with {string} key")
    public void theGlobalEmployeeIdMustMatchWithKey(String empId) {

        String tempEmpId = response.jsonPath().
                getString(empId);
        Assert.assertEquals(tempEmpId, employee_id);

    }


    @And("the retreived data at {string} object matches the data used to create employee")
    public void theRetreivedDataAtObjectMatchesTheDataUsedToCreateEmployee
            (String employeeObject, io.cucumber.datatable.DataTable dataTable) {

        //one map comes from data table

        List<Map<String, String>> expectedData = dataTable.asMaps();

        //another map comes from employee object response
        //get is going to return the whole map, getString returns just one value
        Map<String, String> actualData =
                response.body().jsonPath().get(employeeObject);

        for (Map<String, String> map : expectedData) {
            //storing all the keys under set
            Set<String> keys = map.keySet();

            //from set of keys to one key at one time
            for (String key : keys) {

                //this will return the value against key
                String expectedValue = map.get(key);
                //this will return the value against the employee object
                String actualValue = actualData.get(key);
                Assert.assertEquals(actualValue, expectedValue);
            }
        }
    }
}


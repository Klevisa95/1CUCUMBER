package API;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    //in rest assured base uri = base URL
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api"; //get url from swagger document
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MjY4MDE1ODgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcyNjg0NDc4OCwidXNlcklkIjoiNjc3MiJ9.r50ByY5iT40lSXU59Ib08xQ5rsBF9LSWjXjDkKT5tQM";
    static String employee_id;

    @Test
    public void aacreateEmployee() {
        //STEP.1: prepare the request
        //request specification allows us to prepare the request and gives it in variable
        RequestSpecification request = given().
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
                        "}"); //pra header + body + token + base uri si tek Postman merre kte nga create employee postman

        //STEP.2: send the request for creating the employee
        //response is the class which holds the complete response body and the info
        Response response = request.when().post("/createEmployee.php"); //thats how you send the request automatically (manual you just press send in postman)

        //to print the response in console
        response.prettyPrint();

        //STEP.3 (VALIDATE THE RESPONSE)
        response.then().assertThat().statusCode(201);


        //validate (verify) the body
        response.then().assertThat().
                body("Message", equalTo("Employee Created"));
        response.then().assertThat().
                body("Employee.emp_firstname", equalTo("klevisa")); //pra verifikojme nese jane si body qe kemi vendos me siper

        /*
      response --> object which represents the result returned from an API call.
      .then() --> tells RestAssured that after receiving the response, we want to validate certain parts of it.
      .assertThat()  --> This is used to begin specifying assertions or conditions to check in the response.
      body("Message", equalTo("Employee Created")); --> this line is verifying that the API response contains a field called Message and that its value is "Employee Created".

         */


        //merr info nga header
        response.then().assertThat()
                .header("Connection", equalTo("Keep-Alive")); //e merr kte nga console-headers-connection-keepalive

        //to store the employee id after generating the employee
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

    }


    @Test
    public void bgetCreatedEmployee() {

        //prepare the request
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");

        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        //validate employee_id's one from post call another from get call
        String tempEmpId = response.jsonPath().
                getString("employee.employee_id");

        Assert.assertEquals(tempEmpId, employee_id);


    }


    @Test

    public void cUpdateEmployee() {
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"kleviskaa\",\n" +
                        "  \"emp_lastname\": \"kokakola\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2022-09-10\",\n" +
                        "  \"emp_status\": \"nope\",\n" +
                        "  \"emp_job_title\": \"ncuq\"\n" +
                        "}"); //you get this body from update employee (first body )

        Response response = request.when().put("/updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void dgetupdatedEmployee(){

        //prepare the request
        RequestSpecification request = given().
                header("Content-Type", "application/json").
                header("Authorization", token).
                queryParam("employee_id", employee_id);

        Response response = request.when().get("/getOneEmployee.php");

        response.prettyPrint();
        response.then().assertThat().statusCode(200);

        //validate employee_id's one from post call another from get call
        String tempEmpId = response.jsonPath().
                getString("employee.employee_id");

        Assert.assertEquals(tempEmpId, employee_id);



    }
}






//everything that is written here hardcoded is in apiworkflow steps in step definitions page























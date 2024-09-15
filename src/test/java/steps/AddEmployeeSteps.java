package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
       // WebElement addEmployeeButton = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
        click(dashboardPage.addEmployeeButton); //merr click methods nga utils (reuse code) //dashboardPage->coming from pages class reuse code
    }
    @When("user enters firstName, middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
      //  WebElement firstName = driver.findElement(By.id("firstName"));
      //  WebElement middleName = driver.findElement(By.id("middleName"));
      //  WebElement lastName = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.firstNameLoc, "Klevisa"); //sendText short method qe e kemi te utils, short version
        sendText(addEmployeePage.middleNameLoc, "Ko");
        sendText(addEmployeePage.lastNameLoc, "La"); //addemployeepage -> coming from add employee page class

    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
      //  WebElement saveButton = driver.findElement(By.id("btnSave"));
        click(addEmployeePage.saveBtn); //click method nga utils short version |addEmployeePage -> vjen nga AddEmployeePage class in pages  |saveBtn-> vjen nga e njejta class

    }
    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added");

    }
    @Then("user close the browser")
    public void user_close_the_browser() {
        driver.close();


    }

    @When("user enters {string} and {string} and {string}")
    public void user_enters_and_and(String firstN, String middleN, String lastN) {

        //WebElement firstName = driver.findElement(By.id("firstName"));
     //   WebElement middleName = driver.findElement(By.id("middleName"));
     //   WebElement lastName = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.firstNameLoc, firstN); //sendText short method qe e kemi te utils, short version
        sendText(addEmployeePage.middleNameLoc, middleN);
        sendText(addEmployeePage.lastNameLoc, lastN); //get addEmployeePage directly from AddEmployeePage class reuse code


    }

    @When("user enters {string} and {string} and enter {string}")
    public void user_enters_and_and_enter(String firstN, String middleN, String lastN) {

      //  WebElement firstName = driver.findElement(By.id("firstName"));
      //  WebElement middleName = driver.findElement(By.id("middleName"));
      //  WebElement lastName = driver.findElement(By.id("lastName"));

        sendText(addEmployeePage.firstNameLoc, firstN); //sendText short method qe e kemi te utils, short version | addEmployeePage.firstNameLoc -> vjen nga klasa e AddEmployeePage reuse code
        sendText(addEmployeePage.middleNameLoc, middleN);
        sendText(addEmployeePage.lastNameLoc, lastN);

    }

}

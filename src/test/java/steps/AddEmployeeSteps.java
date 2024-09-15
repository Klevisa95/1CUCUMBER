package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeButton = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
        click(addEmployeeButton); //merr click methods nga utils (reuse code)
    }
    @When("user enters firstName, middleName and lastName")
    public void user_enters_first_name_middle_name_and_last_name() {
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement middleName = driver.findElement(By.id("middleName"));
        WebElement lastName = driver.findElement(By.id("lastName"));

        sendText(firstName, "Klevisa"); //sendText short method qe e kemi te utils, short version
        sendText(middleName, "Ko");
        sendText(lastName, "La");

    }
    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        WebElement saveButton = driver.findElement(By.id("btnSave"));
        click(saveButton); //clcik method nga utils short version

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

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement middleName = driver.findElement(By.id("middleName"));
        WebElement lastName = driver.findElement(By.id("lastName"));

        sendText(firstName, firstN); //sendText short method qe e kemi te utils, short version
        sendText(middleName, middleN);
        sendText(lastName, lastN);


    }

    @When("user enters {string} and {string} and enter {string}")
    public void user_enters_and_and_enter(String firstN, String middleN, String lastN) {

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement middleName = driver.findElement(By.id("middleName"));
        WebElement lastName = driver.findElement(By.id("lastName"));

        sendText(firstName, firstN); //sendText short method qe e kemi te utils, short version
        sendText(middleName, middleN);
        sendText(lastName, lastN);

    }

}

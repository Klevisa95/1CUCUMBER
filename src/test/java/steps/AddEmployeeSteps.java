package steps;

import com.sun.tools.jconsole.JConsoleContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    @When("user adds multiple employees from excel using {string} and verify")
    public void userAddsMultipleEmployeesFromExcelUsingAndVerify(String sheetName) throws InterruptedException {
        //from the list of maps, we need one map at one point of time this iterator will give me one map to add one employee at a time
        List<Map<String, String>> newEmployees = ExcelReader.read(sheetName, Constants.TESTDATA_FILEPATH); //ExcelReader coming from ExcelReader class | sheetName coming from feature file | Consstants.TESTDATA_FILEPATH coming from Constants class.
        Iterator<Map<String, String>> itr = newEmployees.iterator(); //this will give me first map
        while (itr.hasNext()) { //it checks whether we have values in map or not

            Map<String, String> employeeMap = itr.next(); //it will return the keys and the values of the map which we store in this variable

            sendText(addEmployeePage.firstNameLoc, employeeMap.get("FirstName"));
            sendText(addEmployeePage.middleNameLoc, employeeMap.get("MiddleName"));
            sendText(addEmployeePage.lastNameLoc, employeeMap.get("LastName"));
            sendText(addEmployeePage.photograph, employeeMap.get("Photograph")); //''Photograph '' --> vjen nga excel sheet
            if (!addEmployeePage.checkbox.isSelected()) { //nqs check box nk eshte selected
                click(addEmployeePage.checkbox); //kliko ne checkbox
            }

            sendText(addEmployeePage.usernameEmp, employeeMap.get("Username"));
            sendText(addEmployeePage.passwordEmp, employeeMap.get("Password"));
            sendText(addEmployeePage.confirmPass, employeeMap.get("ConfirmPassword"));
            String empIDValue= addEmployeePage.employeeIdLocator.getAttribute("value"); //storing the emp id from the locator

            //we are storing the emp id from the locator
            String empIdValue = addEmployeePage.employeeIdLocator.getAttribute("value");
            click(addEmployeePage.saveBttn); //Bttn me 2tt. sepse ke dhe 1 tj btn

            Thread.sleep(2000);


            click(addEmployeePage.saveBttn);
            sendText(addEmployeePage.employeeIdLocator, empIDValue);
            click(employeeSearchPage.searchBtn);

            List<WebElement> rowData=
                    driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));


            for(int i= 0; i<rowData.size(); i++){

                //it will give me the data from all the cell of the row
               String rowText= rowData.get(i).getText();
                System.out.println(rowText);

                String expectedDataFromExcel = empIDValue + " " + employeeMap.get("FirstName")+ " "+ employeeMap.get("MiddleName")+ " "+ employeeMap.get("LastName");
                System.out.println(expectedDataFromExcel);
                Assert.assertEquals(expectedDataFromExcel, rowData);

            }
            //we want to add many employees so:
            click(dashboardPage.addEmployeeButton);
            Thread.sleep(2000);

            //verification of employee still pending


        }


    }

    @When("user adds multiple employees from data table")
    public void user_adds_multiple_employees_from_data_table
            (io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        for (Map<String, String> map : employeeNames

        ) {
            sendText(addEmployeePage.firstNameLoc, map.get("firstName"));
            sendText(addEmployeePage.middleNameLoc, map.get("middleName"));
            sendText(addEmployeePage.lastNameLoc, map.get("lastName"));
            click(addEmployeePage.saveBttn);
            Thread.sleep(2000);
            click(dashboardPage.addEmployeeButton);
            Thread.sleep(2000);

        }


    }
}


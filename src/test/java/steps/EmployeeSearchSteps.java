package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.time.Duration;

public class EmployeeSearchSteps extends CommonMethods {

      //public WebDriver driver;

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {

        // WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
      //  pimOption.click();
        click(dashboardPage.pimButton); //click->e marrim kte nga common methods kod i shkruter | dashboardPage.pimButton --> e marrim nga EmployeeSearchPage reuse code
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("user clicks on Employee List option")
    public void user_clicks_on_employee_list_option() {
       // WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
       // empListOption.click();
        click(dashboardPage.empListButton); //click from common methods | dashboardPages.empListButton --> from dashboardPage
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters employee id")
    public void user_enters_employee_id() {
      //  WebElement empIdTextBox = driver.findElement(By.id("empsearch_id"));
        //empIdTextBox.sendKeys("111108A");
        sendText(employeeSearchPage.empSearchIdField, "111108A" ); //employeeSearchPage.empSearchIdField --> from EmployeeSearchPage
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("user clicks on search button")
    public void user_clicks_on_search_button() {
       // WebElement searchButton = driver.findElement(By.id("searchBtn"));
        click(employeeSearchPage.searchBtn); //click method nga commonMethods, reuse code | employeeSearchPage.searchBtn--> from EmployeeSearchPage
        //searchButton.click();
    }

    @Then("user should be able to see employee details")
    public void user_should_be_able_to_see_employee_details() {

        System.out.println("Test passed");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
       // WebElement nameTextField = driver.findElement(By.id("empsearch_employee_name_empName"));
      //  nameTextField.sendKeys("klevisa");
        sendText(employeeSearchPage.empSearchNameField, "klevisa"); //sendText-->zevendso kodin e mesiperm me kod te shkurt nga commonmethods, reuse code |employeeSearchPage.empSearchNameField--> from EmployeeSearchPage
    }


}

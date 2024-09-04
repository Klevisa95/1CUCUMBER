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

        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
      //  pimOption.click();
        click(pimOption); //e marrim kte nga common methods kod i shkruter
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("user clicks on Employee List option")
    public void user_clicks_on_employee_list_option() {
        WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
       // empListOption.click();
        click(empListOption);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user enters employee id")
    public void user_enters_employee_id() {
        WebElement empIdTextBox = driver.findElement(By.id("empsearch_id"));
        //empIdTextBox.sendKeys("111108A");
        sendText(empIdTextBox,"111108A" );
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @And("user clicks on search button")
    public void user_clicks_on_search_button() {
        WebElement searchButton = driver.findElement(By.id("searchBtn"));
        click(searchButton); //click method nga commonmethods, reuse code
        //searchButton.click();
    }

    @Then("user should be able to see employee details")
    public void user_should_be_able_to_see_employee_details() {

        System.out.println("Test passed");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        WebElement nameTextField = driver.findElement(By.id("empsearch_employee_name_empName"));
      //  nameTextField.sendKeys("klevisa");
        sendText(nameTextField, "klevisa"); //zevendso kodin e mesiperm me kod te shkurt nga commonmethods, reuse code
    }


}

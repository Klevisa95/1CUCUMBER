package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);

    // public WebDriver driver; //STEP1: declare the driver


    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() throws InterruptedException {
    //    driver = new ChromeDriver(); //STEP2
    //    driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
         openBrowserAndLaunchApplication(); //skemi nevoje per te gjithe lines e mesiperme sepse tgjitha methods i kemi tek common methods class under openBrowserAndLaunchApp

    }
    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() throws InterruptedException {
       // LoginPage lp = new LoginPage(); //kte e marrim nga login page nga pages class dhe na ndihmon me webelements

        //WebElement usernameTextField = driver.findElement(By.xpath("//*[@id='txtUsername']"));
       // usernameTextField.sendKeys("Admin"); //STEP3
      // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
        sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("username")); //we use commonmethods class x ta shkr shkurt, it will read the value of "username"


       // WebElement passwordTextField = driver.findElement(By.xpath("//*[@id='txtPassword']"));
        sendText(loginPage.passwordTextField, ConfigReader.getPropertyValue("password")); //pra ConfigReader class ka 1 getproperty method qe aty you can call config.properties info. Dmth we call the username na vjen admin. Kjo fjali ka 2 funksione: clear the data and send data. Vjen nga common methods
        //passwordTextField.sendKeys("Hum@nhrm123");



    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
      //  LoginPage lp=new LoginPage(); //nga ktu marrim short webelements nga pages class
       // WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
       click(loginPage.loginBtn);   //click coming from commonMethods, it will wait for element to be clickable | loginPage -> coming rom PageInitializer | loginBtn -> coming from LoginPage in pages.
        // loginBtn.click(); //STEP4
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait



    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("My test passed");

        //assertion to check if the element exists
        //assertTrue(condition): to check if condition is true or false
       // Assert.assertEquals();
        Assert.assertTrue(dashboardPage.welcomeAdminLocator.isDisplayed());

        // Assert.assertTrue() method to verify that a particular element (represented by dashboardPage.welcomeAdminLocator) is visible on the webpage.
        //dashboardPage.welcomeAdminLocator refers to a WebElement, likely representing the "Welcome, Admin" text or similar element on the dashboard page.
        //.isDisplayed() checks whether that WebElement is currently visible to the user on the webpage.
        //Assert.assertTrue() checks whether the result of .isDisplayed() is true.
        //If the element is visible (i.e., isDisplayed() returns true), the assertion passes, and the test continues. If the element is not visible (i.e., isDisplayed() returns false), the assertion fails, causing the test to stop and report an error.


    }

}

/*
CUCUMBER AS A TOOL:

1.Delete main
2.Right click on 'test' create resources.
3.Create Login.features under resources.
4.Create the Scenario in Login.feature class and press Run.
5.All the steps will show in the console.
6.Copy the steps and create a 'steps' package in Java also create a class LoginSteps and paste the steps there.
7.go to login.feature, right click, press 'go to' + declaration. (like that you link the login feature with the login steps).
8.Tek given (step1) declare the driver and the browser
9.Tek when step2 (merr webelements per password and username)
10.tek When merr webelement per login button
11.Tek Then e funit step4.
 */

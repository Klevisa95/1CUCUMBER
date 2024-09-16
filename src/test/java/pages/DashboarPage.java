package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboarPage extends CommonMethods {   //per t gjet webelements per pjesen tjeter te kodeve

    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimButton;


    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListButton;


    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeButton;


    @FindBy(id="welcome")
    public WebElement welcomeAdminLocator;



    public DashboarPage(){  //use this constructor to initialize these locators


        PageFactory.initElements(driver, this); //driver coming from comon methods this keyword means this page

    }

}

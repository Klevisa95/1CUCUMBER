package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy (id="txtUsername")  //here you write the locator to reuse it (nqs ke xpath update instead of id use xpath or name etc)
    public WebElement usernameTextField;


    @FindBy (id="txtPassword")
    public WebElement passwordTextField;


    @FindBy (id="btnLogin")
    public WebElement loginBtn;


    public LoginPage(){
        PageFactory.initElements(driver, this);
        //we need this page factory to initialize the elements. Driver we get it from commonMethods, and this keyword means we want to initialize all the elements of the page IN THIS SPECIFIC CLASS

    }

}


//short way to write locators to call them in other classes
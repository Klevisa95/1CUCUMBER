package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods { //create this to reuse code, short webelements

    @FindBy(id="firstName")
    public WebElement firstNameLoc;

    @FindBy(id="middleName")
    public WebElement middleNameLoc;

    @FindBy(id="lastName")
    public WebElement lastNameLoc;

    @FindBy(id="btnSave")
    public WebElement saveBtn;

    @FindBy (id="photofile")
    public WebElement photograph;

    @FindBy (id="chkLogin")
    public WebElement checkbox;

    @FindBy (id="user_name")
    public WebElement usernameEmp;

    @FindBy (id="user_password")
    public WebElement passwordEmp;

    @FindBy (id="re_password")
    public WebElement confirmPass;

    @FindBy (id="btnSave")
    public WebElement saveBttn;

    @FindBy(id="employeeId")
    public WebElement employeeIdLocator;




    public AddEmployeePage(){

        PageFactory.initElements(driver, this);


    }



}

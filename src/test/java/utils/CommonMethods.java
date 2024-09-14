package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {

    public static WebDriver driver;


    public static void openBrowserAndLaunchApplication(){

        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH); //this will read the final parameters from Constants class (parameters that don't change)


        switch (ConfigReader.getPropertyValue("browser")){ //per tu hapur ne webs te ndryshme e merr kte nha configReader class
            case"chrome":
                driver=new ChromeDriver();
                break;
            case"firefox":
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("invalid browser name");
        }
        driver.manage().window().maximize(); //to maximize the window
        driver.get(ConfigReader.getPropertyValue("url"));  //to launch the web
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT)); //This means WebDriver will wait for a specified maximum amount of time when trying to find an element on the page before throwing a NoSuchElementException.
    }


    public static void sendText(WebElement element, String textToSend){

        element.clear();  // Clears any existing text in the input field
        element.sendKeys(textToSend);  // Sends the text to the element

    }

    public static WebDriverWait getWait(){  //this will read the explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)); // is used to set a specific wait time (explicit wait) for a condition.
        return wait;
    }

    public static void waitForClickability(WebElement element){ // to wait until a web element is clickable before interacting with it
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click (WebElement element){
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSexecutor(){ //JavascriptExecutor in Selenium lets you run JavaScript on a webpage when normal commands (like click() or sendKeys()) don't work.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element){
        getJSexecutor().executeScript("arguments[0].click()'", element);

    }

    public void closeBrowser(){
        driver.close();
    }



}



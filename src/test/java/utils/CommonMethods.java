package utils;

import io.netty.handler.codec.http.multipart.FileUpload;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer { //extend pageinitializer to reuse code so when you extend common methods in other pages you also access page initializer code

    public static WebDriver driver;


    public static void openBrowserAndLaunchApplication() {

        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH); //this will read the final parameters from Constants class (parameters that don't change)


        switch (ConfigReader.getPropertyValue("browser")) { //per tu hapur ne webs te ndryshme e merr kte nha configReader class
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("invalid browser name");
        }
        driver.manage().window().maximize(); //to maximize the window
        driver.get(ConfigReader.getPropertyValue("url"));  //to launch the web
        initializePageObjects(); //from page initializer class
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT)); //This means WebDriver will wait for a specified maximum amount of time when trying to find an element on the page before throwing a NoSuchElementException.
    }


    public static void sendText(WebElement element, String textToSend) {

        element.clear();  // Clears any existing text in the input field
        element.sendKeys(textToSend);  // Sends the text to the element

    }

    public static WebDriverWait getWait() {  //this will read the explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT)); // is used to set a specific wait time (explicit wait) for a condition.
        return wait;
    }

    public static void waitForClickability(WebElement element) { // to wait until a web element is clickable before interacting with it
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static JavascriptExecutor getJSexecutor() { //JavascriptExecutor in Selenium lets you run JavaScript on a webpage when normal commands (like click() or sendKeys()) don't work.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static void jsClick(WebElement element) {
        getJSexecutor().executeScript("arguments[0].click()'", element);

    }

    public void closeBrowser() {
        driver.close();
    }

    //take screenshot method for capturing all the screenshots
    public static byte[] takeScreenshot(String fileName) {


        TakesScreenshot ts = (TakesScreenshot) driver;
        //in cucumber screenshot should be taken in array of byte format
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        //we will pass the path os screenshot from constants class
        try {
            FileUtils.copyFile
                    (sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName+ " "+getTimeStamp("yyyy-MM-dd-HH-") +".png"));       //this is the path where screenshot will be saved

        } catch (IOException e) {
            e.printStackTrace();
        }

        return picByte;

    }

    //in java we have a module which returns current data and time

    public static String getTimeStamp(String pattern){
        Date date = new Date();
        //after getting the date, I need to format it as per my requirement
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        //it will return the formated date as per the pattern in string format
        return sdf.format(date);

    }


}





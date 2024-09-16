package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

import java.util.Scanner;

public class Hooks extends CommonMethods {

    @Before
    public void start(){
        openBrowserAndLaunchApplication();


    }

    @After
    public void end (Scenario scenario){
        byte[] pic; //byte because screenshot duhet te ishte byte
       if(scenario.isFailed()){
           pic= takeScreenshot("failed/"+scenario.getName());   //before closing take screenshot | scenario class holds the info of execution | getName is a method which returns the name of the scenario that we are executing
       }else{
           pic=takeScreenshot("passed/"+scenario.getName()); //pra nqs screenshot tregon qe testi ka fail save ne 1 vend nqs test passed save screenshot ne folder tjeter
       }
       scenario.attach(pic, "image/png", scenario.getName()); //pic is array of byte | png is media type | getName is the name of scenario
        driver.close();


    }

}


/*
-use @Before & @After from cucumber not java
-@Before Hook: Runs before each scenario. It's used for setup tasks, like opening a browser.
-@After Hook: Runs after each scenario. It's used for cleanup tasks, like closing the browser.

example:

@Before
public void setUp() {
    // Setup code (e.g., open browser)
}

@After
public void tearDown() {
    // Cleanup code (e.g., close browser)
}


*since you have them here you can reuse this code then go to feature files and comment them out. you can call them from here.
 */
package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void start(){
        openBrowserAndLaunchApplication();


    }

    @After
    public void end (){
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
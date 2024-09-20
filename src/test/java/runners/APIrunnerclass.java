package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "src/test/resources/features/",
        glue="APIsteps", //used to stick together the step definitions with features
        dryRun = true, //kur dryRun=true na jep ne console the step definition that we're missing also it stops the execution.
        //tags they identify the scenarios in a group and will execute specific one
        tags = "@api",  // pra run vec scenario tek @sprint4 jo scenario e tjera. Ne kte rast ose ali ose nafiseh. Nqs eshte @ali and @nafiseh then NO scenarios will be executed. Kur esht @emp do execute 2 scenarios sepse e kane te perbashket kte tag.

        //for generating the report | use the keybord "pretty" to see step definition in console
        //in your framework all reports should be generated under target folder (we will generate html report in target folder)
        plugin={"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json", "rerun:target/failed.txt"} //pra krijo html report ne target folder me emrin cucumber.html | json ->specifies that after running the tests, the results should be saved in a JSON format at the specified location, which is target/cucumber.json. | rerun --> will create failed.txt under target for all failed tc
)





public class APIrunnerclass {



}

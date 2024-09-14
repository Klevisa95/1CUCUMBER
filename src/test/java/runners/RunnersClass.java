package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features we use to provide the path of all the feature files
        features = "src/test/resources/features/",
        glue="steps", //used to stick together the step definitions with features
        dryRun = false, //kur dryRun=true na jep ne console the step definition that we're missing also it stops the execution, for execution set dryRun=false (e perdorim kur duam te shtojme new scenarion tek feature dhe aty na jep ne console step deffinition qe ta cojme ne steps
        //tags they identify the scenarios in a group and will execute specific one
        tags = "@addemp"  // pra run vec scenario tek @sprint4 jo scenario e tjera. Ne kte rast ose ali ose nafiseh. Nqs eshte @ali and @nafiseh then NO scenarios will be executed. Kur esht @emp do execute 2 scenarios sepse e kane te perbashket kte tag.

)


public class RunnersClass {
    //this block will be empty we don't write code here

}






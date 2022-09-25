package step_defs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.EnvironmentManager;

public class Hooks {
    @Before
    public void setUp() throws Exception {
        //u don't need to set up ur driver
        //here you can set up ur environment variable
        //we will have environment manager that will store all the env variables
        //and our before hook will call the environment manager to set up all
        //the variables correctly depending on the env we are running our
        //tests against
        EnvironmentManager.setUpEnvironment();
    }
    @After
    public void tearDown(Scenario scenario){
        //I can attach a screenshot to a failing scenario
        try {
            if (scenario.isFailed()) {
                //this line will take a screenshot
                final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).
                        getScreenshotAs(OutputType.BYTES);
                //add screenshot to the html report
                scenario.embed(screenshot, "image/png");
            }
        }catch (Exception e){
            System.out.println("The error happened while taking a screenshot and cleaning up after the test");
        e.getMessage();
        }
        Driver.closeDriver();
    }
}

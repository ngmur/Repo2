package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"step_defs"},
        plugin = {
                //"pretty",
                "html:target/default-cucumber-reports"
             //   "json:target/cucumber.json"
        },
      //  tags = {"@regression","~@ignore"},
            tags={"@smoke"},
        dryRun = false
)
public class Runner {
}

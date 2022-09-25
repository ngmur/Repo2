package step_defs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class BasicValidationDefs {

@Given("^User navigates to the https://www\\.meetup\\.com web page$")
public void user_navigates_to_the_https_www_meetup_com_web_page() {
        }

@When("^User is navigated to the web page$")
public void user_is_navigated_to_the_web_page(){

        }

@Then("^Title of the web page should be displayed as \"([^\"]*)\"$")
public void title_of_the_web_page_should_be_displayed_as(String arg1) {


}  }
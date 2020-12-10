package cucumber.bStepDefinitions;

import cucumber.cSerenitySteps.CustomerRegistrationSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class CustomerRegistration {
	
	@Steps 
	CustomerRegistrationSteps customerRegistrationSteps;
	@Given("^The user prepares a (.+) for registering the customer$")
    public void the_user_prepares_a_for_registering_the_customer(String requestbody) throws Throwable {
         
    }

    @When("^User makes a POST request on the Customer Registration$")
    public void user_makes_a_post_request_on_the_customer_registration() throws Throwable {
         
    }

    @Then("^Status code for Site API returns (.+)$")
    public void status_code_for_site_api_returns(String statuscode) throws Throwable {
         
    }

    @And("^User has the invalid (.+) authorization token of the login$")
    public void user_has_the_invalid_authorization_token_of_the_login(String authorization) throws Throwable {
         
    }

    @And("^Error code for Site API returns (.+)$")
    public void error_code_for_site_api_returns(String errorcode) throws Throwable {
         
    }

    @And("^Error description for Site API returns (.+)$")
    public void error_description_for_site_api_returns(String errordesc) throws Throwable {
         
    }

    @And("^User has the valid authorization token of the login$")
    public void user_has_the_valid_authorization_token_of_the_login() throws Throwable {
         
    }

}

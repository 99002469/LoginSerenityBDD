package cucumber.StepDefinitions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import cucumber.sereniySteps.CustomerRegStepsApi;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class CustomerRegistrationApi {
	
	@Steps
	CustomerRegStepsApi customerReg;
	static ValidatableResponse responseCustReg;
	
    @Given("^The user prepares a (.+) for (.+) registering the customer$")
    public void the_user_prepares_a_for_registering_the_customer(String requestBody, String authorization) throws Throwable {
         customerReg.getTheRequestBody(requestBody, authorization);
    }

    @When("^User makes a POST request on the Customer Registration using (.+) and (.+)$")
    public void user_makes_a_post_request_on_the_customer_registration_using_and(String requestBody, String authorization) throws Throwable {
         responseCustReg = customerReg.makePostRequest(requestBody, authorization);
    }

    @Then("^Status code for Site API returns (.+)$")
    public void status_code_for_site_api_returns(int statuscode) {
    	assertThat(responseCustReg.extract().statusCode() , is(equalTo(statuscode))); 
    }

    @And("^Error code for Site API returns (.+)$")
    public void error_code_for_site_api_returns(String errorcode) throws Throwable {
    	assertThat(responseCustReg.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
    }

    @And("^Error description for Site API returns (.+)$")
    public void error_description_for_site_api_returns(String errordesc) throws Throwable {
    	assertThat(responseCustReg.extract().jsonPath().getString("errorDescription"), equalTo(errordesc));
    }
	
}

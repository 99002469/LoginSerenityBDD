package cucumber.StepDefinitions;


import cucumber.sereniySteps.CustomerRegStepsApi;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class CustomerRegistrationApi {
	
	@Steps
	CustomerRegStepsApi customerReg;
	static ValidatableResponse responseCustReg;

    @When("^User makes a POST request on the Customer Registration using \\\"([^\\\"]*)\\\" add \\\"([^\\\"]*)\\\" add \\\"([^\\\"]*)\\\" add \\\"([^\\\"]*)\\\" add \\\"([^\\\"]*)\\\" add \\\"([^\\\"]*)\\\" and (.+)")
    public void user_makes_a_post_request_on_the_customer_registration(String customername, String contactname, String phoneNumber, String emailId, String contactMethod, String additionalInfo, String authorization) throws Throwable {
    	customerReg.makePostRequest(customername, contactname, phoneNumber, emailId, contactMethod, additionalInfo, authorization);
    }

    @Then("^Status code for Site API returns (.+)$")
    public void status_code_validation(int statuscode) {
    	customerReg.validateTheStatusCode(statuscode);
    }

    @And("^Error code for Site API returns (.+)$")
    public void error_code_validation(String errorcode) {
    	customerReg.validateTheErrorCode(errorcode);

    }

    @And("^Error description for Site API returns (.+)$")
    public void error_description_validation(String errordesc) {
    	customerReg.validateTheErrorDesciption(errordesc);
    }
	
}

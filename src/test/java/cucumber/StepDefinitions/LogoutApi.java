package cucumber.StepDefinitions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import cucumber.sereniySteps.LogoutApiSteps;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class LogoutApi {
	
	@Steps
	LogoutApiSteps logoutStep;
	static ValidatableResponse logoutResponse;
	
	@Given("^User has a User id (.+) token id (.+) from the login$")
    public void user_has_a_user_id_token_id_from_the_login(String userId, String tokenId) throws Throwable {
         logoutStep.getTokenAndUserId(userId, tokenId);
    }

    @When("^User makes a DELETE request for LogOff using (.+) and (.+)$")
    public void user_makes_a_delete_request_for_logoff_using_and(String userId, String tokenId) throws Throwable {
         logoutResponse = logoutStep.makeDeleteRequest(userId, tokenId);
    }

    @Then("^Status code for Security Log off API returns (.+)$")
    public void status_code_for_security_log_off_api_returns(int statuscode) {
    	assertThat(logoutResponse.extract().statusCode(), is(equalTo(statuscode)));
         
    }

    @And("^Error code for Security Log off API returns (.+)$")
    public void error_code_for_security_log_off_api_returns(String errorcode) {
    	assertThat(logoutResponse.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
    }

    @And("^Error description for Security Log off API returns (.+)$")
    public void error_description_for_security_log_off_api_returns(String errordesc) {
    	assertThat(logoutResponse.extract().jsonPath().getString("errorDescription"), equalTo(errordesc));
    }

    @Then("Successful logoff return a message {string}")
    public void succesful_logoff_return_a_message_something(String successMsg) {
    	assertThat(logoutResponse.extract().jsonPath().getString("message"), equalTo(successMsg));
    }
    
    @Then("Error code for Security Log off API returns ")
    public void error_code_for_security_log_off_api_returns() {
        System.out.println("");
    }

    @Then("Error description for Security Log off API returns ")
    public void error_description_for_security_log_off_api_returns() {
    	System.out.println("");
    }

}

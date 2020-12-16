package cucumber.StepDefinitions;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import cucumber.sereniySteps.LoginStepsApi;
import cucumber.sereniySteps.LogoutApiSteps;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;


public class LoginApi {

	@Steps 
	LoginStepsApi loginSteps;
	
	
		static String fileData = "";
		static ValidatableResponse response;
		
		@Given("The user provides a request body for login")
		public void request_body_for_login() throws Throwable {
		    fileData = loginSteps.readFiles("LoginWithValidCreds.json");
			
		}

		@Given("^User prepares request body using (.+) for Login API$")
		public void request_body_for_login_api(String fileName) throws Throwable {
			fileData = loginSteps.readFiles(fileName);
			
		}

		@When("^User makes POST request on Login API$")
		public void post_request_on_login_api() {
			
			response = loginSteps.makePostRequest();
			
		}

		@Then("^Status code for Security API returns (.+)$")
		public void status_code_validation(int statuscode) {
			assertThat(response.extract().statusCode() , is(equalTo(statuscode))); //Assertion 
			
		}

		@And("^Error code for Security API returns (.+)$")
		public void error_code_validation(String errorcode) {
			
			assertThat(response.extract().jsonPath().getString("errorCode"), equalTo(errorcode));

		}

		@And("^Error description for Security API returns (.+)$")
		public void error_description_validation(String errordesc) {
			
			assertThat(response.extract().jsonPath().getString("errorDescription"), equalTo(errordesc));
		}
		
		@Then("^Succesful login return a message \"([^\"]*)\"$")
		public void succesful_login(String successMsg) throws IOException {
			
			assertThat(response.extract().jsonPath().getString("message"), equalTo(successMsg));
			System.out.println("Login Token after Successful Login: " + loginSteps.loginToken());
			System.out.println("User Id after Sucessful Login " + loginSteps.loginUserId());
			
		}
		
/*Logout APi */
	    @Steps
	    LogoutApiSteps logoutStep;
	    @Given("^User has a User id (.+) token id (.+) from the login$")
	    public void user_has_a_user_id_token_id_from_the_login(String userId, String tokenId) throws Throwable {
	         logoutStep.getTokenAndUserId(userId, tokenId);
	    }

	    @When("^User makes a DELETE request for LogOff using (.+) and (.+)$")
	    public void delete_request_for_logoff_using_and(String userId, String tokenId) throws Throwable {
	         response = logoutStep.makeDeleteRequest(userId, tokenId);
	        
	    }

	    @Then("Successful logoff return a message {string}")
	    public void succesful_logoff_return_a_message_something(String successMsg) {
	    	assertThat(response.extract().jsonPath().getString("message"), equalTo(successMsg));
	    }
		
			
}


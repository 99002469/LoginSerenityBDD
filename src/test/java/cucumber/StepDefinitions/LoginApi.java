package cucumber.StepDefinitions;


import java.io.IOException;

import cucumber.sereniySteps.LoginLogoutStepsApi;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;


public class LoginApi {

	@Steps 
	LoginLogoutStepsApi loginLogoutSteps;
	
	
		static String fileData = "";
		static ValidatableResponse response;
		//String endPoint = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/security/login";
		
		@Given("The user provides a request body for login")
		public void request_body_for_login() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    fileData = loginLogoutSteps.readFiles("LoginWithValidCreds.json");
			
		}

		@Given("^User prepares request body using (.+) for Login API$")
		public void request_body_for_login_api(String fileName) throws IOException {
			fileData = loginLogoutSteps.readFiles(fileName);
			
		}

		@When("^User makes POST request on Login API$")
		public void post_request_on_login_api() throws IOException {
			
			response = loginLogoutSteps.makePostRequest();
			
		}

		@Then("^Status code for Security API returns (.+)$")
		public void status_code_validation(int statuscode) {
			loginLogoutSteps.assertStatusCode(statuscode);
			
		}

		@And("^Error code for Security API returns (.+)$")
		public void error_code_validation(String errorcode) {	
			loginLogoutSteps.assertErrorCode(errorcode);

		}

		@And("^Error description for Security API returns (.+)$")
		public void error_description_validation(String errordesc) {
			loginLogoutSteps.assertErrorDescription(errordesc);
			
		}
		
		@Then("^Succesful login return a message (.+)$")
		public void succesful_login(String successMsg) throws Throwable {
			loginLogoutSteps.assertSuccessfulLogoutorLogin(successMsg);
			
				System.out.println("Login Token after Successful Login: " + loginLogoutSteps.loginToken());
				System.out.println("User Id after Sucessful Login " + loginLogoutSteps.loginUserId());
		}
		
		/* **********************  Logout API StepDefinitions   ********************** */
		

	    @When("^User makes a DELETE request for LogOff using (.+) and (.+)$")
	    public void user_makes_a_delete_request_for_logoff_using_and(String userId, String tokenId) throws IOException {
	    	response = loginLogoutSteps.makeDeleteRequest(userId, tokenId);
	    }
	    
	    @Then("^Succesful Logout return a message (.+)$")
		public void succesful_logout(String successMsg) throws Throwable {
			loginLogoutSteps.assertSuccessfulLogoutorLogin(successMsg);
			
		}

			
}
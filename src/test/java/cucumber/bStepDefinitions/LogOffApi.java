package cucumber.bStepDefinitions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import cucumber.cSerenitySteps.LogoffSteps;
import cucumber.eUtils.JsonFileRead;
import cucumber.eUtils.WriteToFile;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class LogOffApi {
	@Steps
	LogoffSteps logOffSteps;
	static ValidatableResponse responseLogOff;
	static ValidatableResponse responseLogOut;
	JsonFileRead fileRead = new JsonFileRead();
	WriteToFile fileWrite = new WriteToFile();
	LoginApiSerenity getTokenUser = new LoginApiSerenity();
	static String myToken = "";
	static String myUserId = "";
	static String baseUrl = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	static String logOffEndPoint = "security/logoff/";
	
		
	 	@Given("^User has a login id from the login$")
	    public void user_has_a_login_id_from_the_login() throws Throwable {
	         logOffSteps.loginResponseToken();
	    }

	    @When("^User makes a DELETE request for LogOff$")
	    public void user_makes_a_delete_request_for_logoff() throws Throwable {
	         responseLogOff = logOffSteps.deleteRequestLogOff();
	    }

	    @And("^User has a token id from the lgoin$")
	    public void user_has_a_token_id_from_the_lgoin() throws Throwable {
	         logOffSteps.loginResponseUserId();
	    }
	    
	    @Then("^Status code for Security logoff API returns 200$")
	    public void status_code_for_security_logoff_api_returns_200() {
	    	assertThat(responseLogOff.extract().statusCode() , is(equalTo(200)));
	    }

	    @And("^Succesful logoff return a message \"([^\"]*)\"$")
	    public void succesful_logoff_return_a_message_something(String logOffMsg) {
	    	assertThat(responseLogOff.extract().jsonPath().getString("message"), equalTo(logOffMsg));
	    }
	    
	    @Given("^User has a User id (.+) token id (.+) from the lgoin$")
	    public void user_has_a_user_id_token_id_from_the_lgoin(String userid, String tokenid) throws Throwable {
	    	myToken = getTokenUser.loginToken();
	    	myUserId = getTokenUser.loginUserId();
	    	fileWrite.writeToFile("UserId.txt", myUserId); //Writes user ID to file 
	    	fileWrite.writeToFile("TokenId.txt", myToken); //Writes token ID to file
	    	
	    	responseLogOut = SerenityRest.given()
	    			.header("Content-Type", "application/json")
	    			.header("Authorization","Bearer "+fileRead.readData(userid))
	    			.delete(baseUrl+logOffEndPoint+fileRead.readData(userid)).then();
	    	
	    }

	    @When("^User makes a DELETE request for invalid LogOff$")
	    public void user_makes_a_delete_request_for_invalid_logoff() {
	         System.out.println("\n Made the Delete Request \n");
	    }

	    @Then("^Status code for Security Log off API returns (.+)$")
	    public void status_code_for_security_log_off_api_returns(int statuscode) {
	    	assertThat(responseLogOut.extract().statusCode() , is(equalTo(statuscode)));
	    }

	    @And("^Error code for Security Log off API returns (.+)$")
	    public void error_code_for_security_log_off_api_returns(String errorcode) {
	    	assertThat(responseLogOut.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
	    }

	    @And("^Error description for Security Log off API returns (.+)$")
	    public void error_description_for_security_log_off_api_returns(String errordesc) {
	    	assertThat(responseLogOut.extract().jsonPath().getString("errorDescription"), equalTo(errordesc));
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


/* 
@Given("^User has a login id from the login (.+)$")
public void user_has_a_login_id_from_the_login(String userId) throws Throwable {
	//responseLogOff = 
	responseLogOff = SerenityRest.given()
			.header("Content-Type", "application/json")
			.header("Authorization","Bearer "+fileRead.readData(userId))
			.delete()
			
     
}

@Then("^Status code for Security Log off API returns (.+)$")
public void status_code_for_security_log_off_api_returns(int statuscode) throws Throwable {
	assertThat(responseLogOff.extract().statusCode() , is(equalTo(statuscode)));
}

@And("^User has a token id from the lgoin (.+)$")
public void user_has_a_token_id_from_the_lgoin(String tokenid) throws Throwable {
     
}

@And("^Error code for Security Log off API returns (.+)$")
public void error_code_for_security_log_off_api_returns(String errorcode) throws Throwable {
     
}

@And("^Error description for Security Log off API returns (.+)$")
public void error_description_for_security_log_off_api_returns(String errordesc) throws Throwable {
     
}
*/

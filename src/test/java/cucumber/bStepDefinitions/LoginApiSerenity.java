package cucumber.bStepDefinitions;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import cucumber.eUtils.WriteToFile;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;


public class LoginApiSerenity {
//
//	@Steps 
//	SerinityApiSteps loginSteps;
	WriteToFile writeText = new WriteToFile();
	cucumber.eUtils.JsonFileRead jsonRead = new cucumber.eUtils.JsonFileRead();
	static String fileData = "";
	static String token = "";
	static String userId = "";
		static ValidatableResponse response;
		String endPoint = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/security/login";
		
		@Given("The user provides a request body for login")
		public void the_user_provides_a_request_body_for_login() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			fileData = jsonRead.readData("LoginWithValidCreds.json");
		}

		@Given("^User prepares request body using (.+) for Login API$")
		public void user_prepares_request_body_using_for_login_api(String fileName) throws Throwable {

			//given().header("Content-Type", "application/json").body(); // readfile,
			fileData = jsonRead.readData(fileName);
			
			
		}

		@When("^User makes POST request on Login API$")
		public void user_makes_post_request_on_login_api() {
			
			response = SerenityRest.given().header("Content-Type", "application/json").body(fileData).when()
					.post(endPoint).then(); //validatable response

		}

		@Then("^Status code for Security API returns (.+)$")
		public void status_code_for_security_api_returns(int statuscode) {
			assertThat(response.extract().statusCode() , is(equalTo(statuscode))); //Assertion 
			
		}

		@And("^Error code for Security API returns (.+)$")
		public void error_code_for_security_api_returns(String errorcode) {
			
			assertThat(response.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
			// Assert the extracted error code
			//assertThat(response.extract().asString(), is(equalTo errorcode);

		}

		@And("^Error description for Security API returns (.+)$")
		public void error_description_for_security_api_returns(String errordesc) {
			
			assertThat(response.extract().jsonPath().getString("errorDescription"), equalTo(errordesc));
			//assertThat(response.extract().response().path("errorDescription"), is(equalTo(errordesc)));
		}
		
		@Then("^Succesful login return a message \"([^\"]*)\"$")
		public void succesful_login(String successMsg) {
		    // Write code here that turns the phrase above into concrete actions
			assertThat(response.extract().jsonPath().getString("message"), equalTo(successMsg));
			token = response.extract().jsonPath().getString("data.token");
			userId = response.extract().jsonPath().getString("data.id");
			System.out.println("TokenNumber is:" +token);
			System.out.println("User ID is: " +userId);
		}
		
		public String loginToken() throws Throwable {
			token = response.extract().jsonPath().getString("data.token");
			writeText.writeToFile("TokenId.txt", token);
			return token;
			
		}
		
		public String loginUserId() throws Throwable {
			userId = response.extract().jsonPath().getString("data.id");
			writeText.writeToFile("UserId.txt", userId);
			return userId;
		}
		
		
	
}


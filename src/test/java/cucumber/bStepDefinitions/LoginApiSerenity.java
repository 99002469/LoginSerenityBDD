package cucumber.bStepDefinitions;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;


public class LoginApiSerenity {

	cucumber.eUtils.JsonFileRead jsonRead = new cucumber.eUtils.JsonFileRead();
	static String fileData = "";
		static ValidatableResponse response;
		String endPoint = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/security/login";

		@Given("^User prepares request body using (.+) for Login API$")
		public void user_prepares_request_body_using_for_login_api(String fileName) throws Throwable {

			//given().header("Content-Type", "application/json").body(); // readfile,
			fileData = jsonRead.readData(fileName);
			
			
		}

		@When("^User makes POST request on Login API$")
		public void user_makes_post_request_on_login_api() throws Throwable {
			
			response = SerenityRest.given().header("Content-Type", "application/json").body(fileData).when()
					.post(endPoint).then(); //validatable response

		}

		@Then("^Status code for Security API returns (.+)$")
		public void status_code_for_security_api_returns(int statuscode) throws Throwable {
			assertThat(response.extract().statusCode() , is(equalTo(statuscode))); //Assertion 
			
		}

		@And("^Error code for Security API returns (.+)$")
		public void error_code_for_security_api_returns(String errorcode) throws Throwable {
			
			assertThat(response.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
			// Assert the extracted error code
			//assertThat(response.extract().asString(), is(equalTo errorcode);

		}

		@And("^Error description for Security API returns (.+)$")
		public void error_description_for_security_api_returns(String errordesc) throws Throwable {
			
			assertThat(response.extract().jsonPath().getString("errorDescription"), equalTo(errordesc));
			//assertThat(response.extract().response().path("errorDescription"), is(equalTo(errordesc)));
		}
	
}

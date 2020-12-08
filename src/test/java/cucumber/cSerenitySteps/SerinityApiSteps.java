package cucumber.cSerenitySteps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import cucumber.bStepDefinitions.LoginApiSerenity;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;

public class SerinityApiSteps extends LoginApiSerenity {
		
		cucumber.eUtils.JsonFileRead jsonRead = new cucumber.eUtils.JsonFileRead();
		
		static String fileData = "";
		
		static ValidatableResponse response;
		String endPoint = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/security/login";

		@Step
		public void requestBodyForLoginApi(String fileName) throws Throwable {

			//given().header("Content-Type", "application/json").body(); // readfile,
			fileData = jsonRead.readData(fileName);
						
		}

		@Step
		public void postRequestOnLoginApi() throws Throwable {
			
			response = given().header("Content-Type", "application/json").body(fileData).when()
					.post(endPoint).then(); //validatable response

		}

		@Step
		public void statusCodeFromApi(int statuscode) throws Throwable {
			assertThat(response.extract().statusCode() , is(equalTo(statuscode))); //Assertion 
			
		}

		@Step
		public void errorCodefromApi(String errorcode) throws Throwable {
			
			assertThat(response.extract().jsonPath().getString("errorCode"), equalTo(errorcode));		

		}

		@Step
		public void errorDescriptionFromApi(String errordesc) throws Throwable {
			
			assertThat(response.extract().jsonPath().getString("errorDescription"), equalTo(errordesc));
			//assertThat(response.extract().response().path("errorDescription"), is(equalTo(errordesc)));
		}
}

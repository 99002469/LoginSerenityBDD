package cucumber.cSerenitySteps;

import cucumber.bStepDefinitions.LoginApiSerenity;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class LogoffSteps {
	LoginApiSerenity loginResponse = new LoginApiSerenity();
	static String loginToken = "";
	static String loginId = "";
	static String baseUrl = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	static String logOffEndPoint = "security/logoff/";
	static ValidatableResponse responseLogOff;
	
	@Step
	public String loginResponseToken() throws Throwable {
		
		
		return loginToken = loginResponse.loginToken();
		 
	}
	
	@Step
	public String loginResponseUserId() throws Throwable {
		return loginId = loginResponse.loginUserId();
	}
	
	@Step
	public ValidatableResponse deleteRequestLogOff() throws Throwable {
		responseLogOff = 
		SerenityRest.given()
		.header("Content-Type", "application/json")
		.header("Authorization","Bearer "+ loginResponse.loginToken()).when()
		.delete(baseUrl+logOffEndPoint+loginResponse.loginUserId()).then();
		
		return responseLogOff;
	}
	
	
}

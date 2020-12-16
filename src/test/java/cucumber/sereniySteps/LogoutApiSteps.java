package cucumber.sereniySteps;

import java.io.IOException;

import cucumber.utils.FileRead;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class LogoutApiSteps {
	
	static ValidatableResponse responseLogOut;
	static String baseUrl = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	static String logOffEndPoint = "security/logoff/";
	
	FileRead readFile = new FileRead();
	
	
	@Step
	public void getTokenAndUserId(String userId, String token) {
		SerenityRest.given()
		.header("Content-Type", "application/json")
		.header("Authorization","Bearer "+readFile.readData(token))
		.delete(baseUrl+logOffEndPoint+readFile.readData(userId)).then();
	}
	
	@Step
	public ValidatableResponse makeDeleteRequest(String userId, String token)throws IOException {
		responseLogOut = SerenityRest.given()
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer "+readFile.readData(token))
				.delete(baseUrl+logOffEndPoint+readFile.readData(userId)).then();
		return responseLogOut;
	}
	
}

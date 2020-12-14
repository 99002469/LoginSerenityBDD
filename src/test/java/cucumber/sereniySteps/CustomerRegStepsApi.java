package cucumber.sereniySteps;

import cucumber.utils.FileRead;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CustomerRegStepsApi {
	
	static String CustomerRegSite = "https://fadr-site-afx-eus-dev.azurewebsites.net/api/v1/site/account/register";
	FileRead readFile = new FileRead();
	static ValidatableResponse responseCus;
	
	@Step
	public void getTheRequestBody(String requestBody, String authorization) {
		SerenityRest.given()
		.header("Content-Type", "application/json")
		.header("Authorization","Bearer "+ readFile.readData(authorization))
		.body(readFile.readData(requestBody))
		.when()
		.post(CustomerRegSite).then();
		
	}
	
	@Step
	public ValidatableResponse makePostRequest(String requestBody, String authorization) {
		responseCus = SerenityRest.given()
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer "+ readFile.readData(authorization))
				.body(readFile.readData(requestBody))
				.when()
				.post(CustomerRegSite).then();
		return responseCus;
		
	}
}

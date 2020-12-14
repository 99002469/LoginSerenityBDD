package cucumber.cSerenitySteps;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import cucumber.bStepDefinitions.LoginApiSerenity;


public class CustomerRegistrationSteps {
	
	LoginApiSerenity login = new LoginApiSerenity(); 
	static String tokenId = "";
	
	cucumber.eUtils.JsonFileRead jsonRead = new cucumber.eUtils.JsonFileRead();
	static ValidatableResponse responseCustomer;
	static String dataFromFile = "";
	
	String endPoint = "https://fadr-site-afx-eus-dev.azurewebsites.net/api/v1/site/account/register";
	
	@Step
	public void requestBodyFiles(String jsonFile) {
		
		dataFromFile = jsonRead.readData(jsonFile);
		
	}
	
	@Step 
	public ValidatableResponse makePostRequest() throws Throwable {
		//response = give
		responseCustomer =
		SerenityRest.given()
		.header("Content-Type", "application/json")
		.header("Authorization","Bearer "+ login.loginToken())
		.body(dataFromFile)
		.when()
		.post(endPoint).then();
		return responseCustomer;
	}
}

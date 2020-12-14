package cucumber.sereniySteps;

import java.io.IOException;

import cucumber.utils.FileRead;
import cucumber.utils.WriteToFile;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class LoginStepsApi {
	
	FileRead fileRead = new FileRead();
	static String dataFromFile = "";
	static String baseUrl = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	static String loginEndPoint = "security/login";
	static ValidatableResponse response;
	
	static String token = "";
	static String userId = "";
	
	WriteToFile fileWrite = new WriteToFile();
	
	@Step
	public String readFiles(String fileNames) throws Throwable {
		
		dataFromFile = fileRead.readData(fileNames);
		return dataFromFile;		
	}
	
	@Step
	public String loginEndPoint() {
		
		return (baseUrl+loginEndPoint);
		
	}
	
	@Step
	public ValidatableResponse makePostRequest() {
		response = SerenityRest.given().header("Content-Type", "application/json").body(dataFromFile).when()
		.post(baseUrl+loginEndPoint).then();
		
		return response;
	}

	@Step
	public String loginToken() throws IOException{
		token = response.extract().jsonPath().getString("data.token");
		fileWrite.writeToFile("TokenId.txt", token);
		return token;
	}
	
	@Step
	public String loginUserId() throws IOException{
		userId = response.extract().jsonPath().getString("data.id");
		fileWrite.writeToFile("UserId.txt", userId);
		return userId;
	}

}

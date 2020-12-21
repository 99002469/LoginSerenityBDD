package cucumber.sereniySteps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import cucumber.utils.FileRead;
import cucumber.utils.WriteToFile;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class LoginLogoutStepsApi {
	
	FileRead fileRead = new FileRead();
	static String dataFromFile = "";
	static String baseUrl = "https://fadr-sec-afx-eus-dev.azurewebsites.net/api/v1/";
	static String loginEndPoint = "security/login";
	static String logOffEndPoint = "security/logoff/";
	static ValidatableResponse response;
	
	static String token = "";
	static String userId = "";
	
	WriteToFile fileWrite = new WriteToFile();
	
	@Step
	public String readFiles(String fileNames) throws IOException {
		
		dataFromFile = fileRead.readData(fileNames);
		return dataFromFile;		
	}
	
	
	@Step
	public ValidatableResponse makePostRequest() throws IOException {
		response = SerenityRest.given().header("Content-Type", "application/json").body(dataFromFile).when()
		.post(baseUrl+loginEndPoint).then();
		
		return response;
	}

	@Step
	public void assertStatusCode(int statuscode) {
		assertThat(response.extract().statusCode(), is(equalTo(statuscode)));
	}
	
	@Step
	public void assertErrorCode(String errorCode) {
		assertThat(response.extract().jsonPath().getString("errorCode"), equalTo(errorCode));
	}
	
	@Step
	public void assertErrorDescription(String errorDesc) {
		assertThat(response.extract().jsonPath().getString("errorDescription"), equalTo(errorDesc));
	}
	
	@Step
	public void assertSuccessfulLogoutorLogin(String successMsg) throws Throwable {
		System.out.println(response.extract().body().asString());
		assertThat(response.extract().jsonPath().getString("message"), equalTo(successMsg));
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
	
	
	FileRead readFile = new FileRead();
	
	@Step
	public ValidatableResponse makeDeleteRequest(String userId, String token)throws IOException {
		System.out.println("Making Delete Request");
		System.out.println(readFile.readData(token));
		response = SerenityRest.given()
				.header("Content-Type", "application/json")
//				.header("Authorization","Bearer "+readFile.readData(token))
				.auth().oauth2(readFile.readData(token))
				.delete(baseUrl+logOffEndPoint+readFile.readData(userId)).then();
		return response;
	}

}
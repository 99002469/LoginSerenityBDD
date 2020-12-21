package cucumber.sereniySteps;



import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import cucumber.PayLoads.CustomerRegisterPayLoad;
import cucumber.utils.FileRead;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CustomerRegStepsApi {
		
	static String CustomerRegSite = "https://fadr-site-afx-eus-dev.azurewebsites.net/api/v1/site/account/register";
	static FileRead readFile = new FileRead();
	static ValidatableResponse responseCus;
	CustomerRegisterPayLoad customerObject;
		
	@Step
	public void makePostRequest(String customername, String contactname, String phonenumber, String emailid, 
			String contactmethod, String additionalinfo, String authorization) throws Throwable {
		
		customerObject = new CustomerRegisterPayLoad(customername,customername,phonenumber,emailid,contactmethod,additionalinfo);
		
		responseCus = SerenityRest.given()
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer "+ readFile.readData(authorization))
				.body(customerObject)
				.when()
				.post(CustomerRegSite).then();
		System.out.println("response" + responseCus.extract().toString());
		
	}
	
	@Step
	public void validateTheStatusCode(int statuscode) {
		assertThat(responseCus.extract().statusCode(), is(equalTo(statuscode)));
	}
	
	@Step 
	public void validateTheErrorCode(String errorcode) {
		assertThat(responseCus.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
	}
	
	@Step
	public void validateTheErrorDesciption(String errordesc) {
		assertThat(responseCus.extract().jsonPath().getString("errorDescription"), equalTo(errordesc));
	}
}


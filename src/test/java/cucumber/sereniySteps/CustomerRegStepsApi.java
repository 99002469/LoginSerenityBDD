package cucumber.sereniySteps;

import java.io.IOException;

import cucumber.PayLoads.CustomerRegisterPayLoad;
import cucumber.utils.FileRead;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CustomerRegStepsApi {
		
	static String CustomerRegSite = "https://fadr-site-afx-eus-dev.azurewebsites.net/api/v1/site/account/register";
	static FileRead readFile = new FileRead();
	static ValidatableResponse responseCus;
//	private static String name;
//	private static String contactName;
//	private static String phoneNumber;
//	private static String emailId;
//	private static String contactMethod;
//	private static String additionalInfo;
//	static CustomerRegisterPayLoad customerObject = new CustomerRegisterPayLoad(name, contactName, phoneNumber, emailId, contactMethod, additionalInfo);
	
	//static public CustomerRegisterPayLoad customerObject = new CustomerRegisterPayLoad();
	
	/*	
	@Step
	public void getTheRequestBody(String requestBody, String authorization) {
		SerenityRest.given()
		.header("Content-Type", "application/json")
		.header("Authorization","Bearer "+ readFile.readData(authorization))
		.body(readFile.readData(requestBody))
		.when()
		.post(CustomerRegSite).then();
		
	}
*/	
	@Step
	public ValidatableResponse makePostRequest(String customername, String contactname, String phonenumber, String emailid, 
			String contactmethod, String additionalinfo, String authorization) throws IOException {
		
//		name =  customername;
//		contactName = contactname;
//		phoneNumber = phonenumber;
//		emailId = emailid;
//		contactMethod = contactmethod;
//		additionalInfo = additionalinfo;
		
//		customerObject.setName(customername);
//		customerObject.setContactName(contactname);
//		customerObject.setPhoneNumber(phonenumber);
//		customerObject.setEmailId(emailid);
//		customerObject.setContactMethod(contactmethod);
//		customerObject.setAdditionalInfo(additionalinfo);
//		
		CustomerRegisterPayLoad customerObject = new CustomerRegisterPayLoad(customername, contactname, phonenumber, emailid, contactmethod, additionalinfo);
		responseCus = SerenityRest.given()
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer "+ readFile.readData(authorization))
				.body(customerObject)
				.when()
				.post(CustomerRegSite).then();
		
		return responseCus;
		
	}
}

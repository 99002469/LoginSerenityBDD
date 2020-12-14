package cucumber.bStepDefinitions;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import cucumber.eUtils.JsonFileRead;
import io.cucumber.java.en.*;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;


public class CustomerRegistration {
	
	static ValidatableResponse responseCus;
	static ValidatableResponse responseCustomer;
	String endPoint = "https://fadr-site-afx-eus-dev.azurewebsites.net/api/v1/site/account/register";
	JsonFileRead readFile = new JsonFileRead();
	
//	@Steps 
//	CustomerRegistrationSteps customerRegistrationSteps;
	
	
	@Given("^The user prepares a (.+) for registering the customer$")
    public void the_user_prepares_a_for_registering_the_customer(String requestBody) throws Throwable {
		responseCus =
		SerenityRest.given()
		.header("Content-Type", "application/json")
		.header("Authorization","Bearer "+ readFile.readData("InvalidTokenId.txt"))
		.body(readFile.readData(requestBody))
		.when()
		.post(endPoint).then();
    }
	
	@Given("^The user prepares a (.+) for (.+) registering the customer$")
    public void the_user_prepares_a_for_registering_the_customer(String requestbody, String authorization) throws Throwable {
		responseCustomer = 
		SerenityRest.given()
		.header("Content-Type", "application/json")
		.header("Authorization","Bearer "+ readFile.readData(authorization))
		.body(readFile.readData(requestbody))
		.when()
		.post(endPoint).then();
		
    }

    @When("^User makes a POST request on the Customer Registration$")
    public void user_makes_a_post_request_on_the_customer_registration() {
    	//responseCus = customerRegistrationSteps.makePostRequest();
         System.out.println("Made a Post Request on EndPoint: "+endPoint);
    }

    @Then("^Status code for Site API returns (.+)$")
    public void status_code_for_site_api_returns(int statuscode)throws Throwable {
    	
    	assertThat(responseCustomer.extract().statusCode() , is(equalTo(statuscode))); 
    }


    @And("^Error code for Site API returns (.+)$")
    public void error_code_for_site_api_returns(String errorcode)throws Throwable {
    	
    	assertThat(responseCustomer.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
    }

    @And("^Error description for Site API returns (.+)$")
    public void error_description_for_site_api_returns(String errordesc)throws Throwable {
    	
    	assertThat(responseCustomer.extract().jsonPath().getString("errorDescription"), equalTo(errordesc));
    }

    @And("^User has the valid authorization token of the login$")
    public void user_has_the_valid_authorization_token_of_the_login() {
         System.out.println("Valid AUthorization is passed in the Post Request");
    }
    
    @Then("^Status code for Customer Site API returns (.+)$")
    public void status_code_for_customer_site_api_returns(int statuscode) {
    	assertThat(responseCus.extract().statusCode() , is(equalTo(statuscode)));
    }

    @And("^Error code for Customer Site API returns (.+)$")
    public void error_code_for_customer_site_api_returns(String errorcode) {
    	assertThat(responseCus.extract().jsonPath().getString("errorCode"), equalTo(errorcode));
    }

    @And("^Error description for Customer Site API returns (.+)$")
    public void error_description_for_customer_site_api_returns(String errordesc) throws Throwable {
    	assertThat(responseCus.extract().jsonPath().getString("errorDescription"), equalTo(errordesc));
    }

}

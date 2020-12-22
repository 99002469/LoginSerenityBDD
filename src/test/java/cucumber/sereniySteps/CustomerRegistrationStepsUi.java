package cucumber.sereniySteps;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import cucumber.Pages.CustomerRegistrationPage;
import net.thucydides.core.annotations.Step;

public class CustomerRegistrationStepsUi {

	static CustomerRegistrationPage customerObject;
	
	@Step
	public void openCustomerReg() {
		customerObject.open();
	}
	
	@Step
	public void navigateToFactoryResetMenu() {
		customerObject.navigateToFactoryReset();
	}
	
	@Step
	public void navigateToCutomerRegistration() {
		customerObject.navigateToCustomerRegister();
	}
	
	@Step
	public void enterTheCustomerDetails(String name,String contactName, String phone, String email) {
		customerObject.enterCustomerName(name);
		customerObject.enterCustomerContactName(contactName);
		customerObject.enterCustomerPhone(phone);
		customerObject.enterCustomerEmail(email);
		
		
	}
	
	@Step 
	public void selectContactMethod(String method) {
		customerObject.selectContactMethod(method);
	}
	
	@Step
	public void addAdditioanlInformation(String additionalInfo) {
		customerObject.enterAdditionalInfo(additionalInfo);
	}
	
	@Step
	public void clickOnResetButton() {
		customerObject.clickOnResetButton();
	}
	
	@Step
	public void assertDataIsCleared() {
		String CustText = customerObject.getTextFromCustomerName();
		assertNull(CustText, null);
	}
	
	@Step 
	public void userIsOnCustomerRegisterPage() {
		assertThat(customerObject.userIsOnCustomerRegistration(), equalTo("Customer contact information"));
	}
	
	@Step 
	public void validateErrorMessage(String ErrorMessage) {
		
		List<String> errList = new ArrayList<String>();
		errList.clear();
		errList.addAll(customerObject.getErrorMessages());
		for(String error:errList) {
			 assertThat(error, equalTo(ErrorMessage));
		}
	}
	
	@Step 
	public void assertSubmitButtonEnabled() {
		 boolean submitButton = customerObject.isSubmitButtonEnabled();
		 assertTrue(submitButton); 
	}
	
	@Step 
	public void assertSubmitButtonDisabled() {
		boolean submitButton = customerObject.isSubmitButtonEnabled();
		assertFalse(submitButton != false);
	}
	
	@Step
	public void inputFeildValidationName(String custName) {
	
		String customerName = custName + "AppendThisStringForMorethan256CharactesAppendThisStringForMorethan256CharactesAppendThisStringForMorethan256CharactesAppendThisStringForMorethan256CharactesAppendThisStringForMorethan256CharactesAppendThisStringForMorethan256CharactesAppendThisStringForMorethan256CharactesAppendThisStringForMorethan256Charactes";
		customerObject.enterCustomerName(customerName);
		String CustName = customerObject.getTextFromCustomerName();
		int nameLen = CustName.length();
		System.out.println("Length From the Name Input Feild: "+ nameLen);
		int actualName = 256;
		assertThat(nameLen, is(equalTo(actualName)));
		

	}
	
	@Step 
	public void inputFeildValidationNumber(String contactPhone ) {
		String CustNum = customerObject.getTextFromCustomerPhone();
		int numLen = CustNum.length();
		int actualNum = 16;
		assertThat(numLen, is(equalTo(actualNum)));
	}
}

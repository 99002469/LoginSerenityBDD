package cucumber.sereniySteps;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
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
		assertFalse(submitButton == false);
	}
	
	@Step
	public void inputFeildValidation(String custName, String contactPhone ) {
		for(int i = 0 ; i<10 ; i++) {
			custName += custName; 
		}
		//Assert the lengths 
	}
}

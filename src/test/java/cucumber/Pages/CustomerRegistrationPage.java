package cucumber.Pages;

import java.util.List;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://smpservices-qa.eastus.cloudapp.azure.com/#/factoryreset/register_customer")

public class CustomerRegistrationPage extends PageObject {
	
	////// Navigate to the Customer Registration Page ///////////
	
	@FindBy(xpath = "//*[contains(text(),' Factory Reset ')]")
	private WebElementFacade factoryReset;

	@FindBy(xpath = "//*[@routerlink = '/factoryreset/register_customer']")
	private WebElementFacade customerRegistration;
	
	//customerName customerContactName customerContactPhone customerContactEmail
	
	@FindBy(id = "customerName")
	private WebElementFacade customerName;
	
	@FindBy(id = "customerContactName")
	private WebElementFacade customerContactName;
	
	@FindBy(id = "customerContactPhone")
	private WebElementFacade customerContactPhone;
	
	@FindBy(id = "customerContactEmail")
	private WebElementFacade customerContactEmail;
	
	@FindBy(xpath = "//*[@class = 'mat-select-value']")
	private WebElementFacade selectContactMethod;
	
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'Select contact method')]")
	private WebElementFacade selectSelectContactMethod;
	
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'E-mail')]")
	private WebElementFacade selectEmail;
	
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'Telephone')]")
	private WebElementFacade selectTelephone;
	
	@FindBy(xpath = "//span[@class='mat-option-text'][contains(text(),'Other')]")
	private WebElementFacade selectOthers;
	
	@FindBy(id = "customerTextArea")
	private WebElementFacade additionalInformation;
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Reset ')]")
	private WebElementFacade resetButton;
	
	@FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),' Submit ')]")
	private WebElementFacade submitButton;
	
	@FindBy(xpath = "//*[@class='header-text'][contains(text(),'Customer contact information')]")
	private WebElementFacade userOnCustomerRegisterPage;
	/* ******************* Error Message to a list ********************** */
	
	@FindBy(xpath = "//*[@class ='mat-error ng-star-inserted']")
    List<WebElementFacade> errorMessage;
	
	
	/* ******************* Page Operations ********************** */
	
	public void navigateToFactoryReset() {
		factoryReset.click();
	}
	
	public void navigateToCustomerRegister() {
		customerRegistration.click();
	}
	
	public String userIsOnCustomerRegistration() {
		return userOnCustomerRegisterPage.getText();
	}
	
	public void enterCustomerName(String name) {
		typeInto(customerName, name);
	}
	
	public String getTextFromCustomerName() {
		System.out.println(customerName.getValue());
		return customerName.getValue();
		
	}
	
	public void enterCustomerContactName(String contactName) {
		typeInto(customerContactName, contactName);
	}
	
	public void enterCustomerPhone(String phone) {
		typeInto(customerContactPhone, phone);
	}
	
	public String getTextFromCustomerPhone() {
		System.out.println(customerContactPhone.getValue());
		return customerContactPhone.getValue();
	}
	
	public void enterCustomerEmail(String email) {
		typeInto(customerContactEmail, email);
	}
	
	public void selectContactMethod(String contactMethod) {
		
		selectContactMethod.click();
		selectOthers.click();

	}
	
	public void enterAdditionalInfo(String additionalInfo) {
		typeInto(additionalInformation, additionalInfo);
	}
	
	public void clickOnResetButton() {
		resetButton.click();
	}
/*	
	public void clickOnSubmitButton() {
		submitButton.click();
	}
*/
	public boolean isSubmitButtonEnabled() {
		return submitButton.isEnabled();
	}
	
	/* ************** Error Message Validation **************** */
	public List<String> getErrorMessages() {
	     return  errorMessage.stream()
	    		 .map(errorMessage -> errorMessage.getText())
	    		 .collect(Collectors.toList());
	    				    		
	}
	
}

package cucumber.Pages;



import java.util.List;
import java.util.stream.Collectors;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://smpservices-qa.eastus.cloudapp.azure.com/#/")

public class LoginPage extends PageObject {
	
	//////////////ADVANCED  ///////////////////
	@FindBy(xpath = "//[@id=\"details-button\"]")
	private WebElementFacade advanced_button;
	
	@FindBy(xpath = "//*[@id=\"proceed-link\"]")
	private WebElementFacade proceed_to_link;    
	////////////////////////////////////////////
	
	////////////// WEB ELEMENTS ////////////////
	@FindBy(id = "email")
	private WebElementFacade email_input_field;			//Email Field
	
	@FindBy(id = "password")
	private WebElementFacade password_input_field;		//Password Field
	
	@FindBy(xpath = "//span[contains(text(),'LOG IN')]")
	private WebElementFacade login_button;				//Login Button
	
	@FindBy(xpath = "//div[@class=\"mat-checkbox-inner-container\"]") //Remember Me Check Box
	private WebElementFacade remember_me_checkbox;
	
	@FindBy(xpath = "//mat-icon[@class='matIcon mat-icon notranslate material-icons mat-icon-no-color']")
	private WebElementFacade eye_button;							//Password Masking button 
	
	@FindBy(xpath = "//a[@class='forgot-password']")
	private WebElementFacade forgot_password_link;					//Forgot password Link
	
	@FindBy(xpath = "//a[@class='contact-eaton']")
	private WebElementFacade eaton_support_link;					// Contact Support Link 
	
	@FindBy(xpath = "//*[@class=\"mat-card-title\"]")
	private WebElementFacade forgot_password_page_title;

	@FindBy(xpath = "//h6[contains(text(),'General Questions')]")
	private WebElementFacade eaton_support_page_title;
	
	@FindBy(xpath = "//a[contains(text(),'CST@eaton.com')]")
    private WebElementFacade support_email;

    @FindBy(xpath = "//a[contains(text(),'800-356-3292')]")
    private WebElementFacade support_contact;
    
    @FindBy(xpath = "//*[@class='mat-button-wrapper'][contains(text(),' Back ')]")
    private WebElementFacade backButton;
	
    /* ----- WebElement List -----*/
    
    @FindBy(xpath = "//*[@class ='mat-error ng-star-inserted']")
    List<WebElementFacade> errorMessage;
          
	@FindBy(id = "viewReportId")
	private WebElementFacade fadrHomePage;
    
    
	/*-------------- Advanced Operations ---------------- */
    
    public void clickOnAdvance() {
		advanced_button.click();
	}
	
	public void clickOnProceed() {
		proceed_to_link.click();
	}
	
	/*-------------Login Page Operations-----------------*/
	public void enterTheEmail(String email) {
		typeInto(email_input_field, email);
	}
	
	public void enterThePassword(String password) {
		typeInto(password_input_field, password);
	}
	
	public boolean loginButtonEnabled() {
		
		return (login_button.isEnabled()); 
		
	}
	
	public void clickOnLoginButton() {
		login_button.click();
	}
	
	public void clickOnPasswordEye() {
		eye_button.click();
	}
	
	public String getThePasswordText() {
		return eye_button.getAttribute("password");
	}
	
	public void clickOnRememberMeCheckBox() {
		remember_me_checkbox.click();
	}
	
	public boolean isRememberMeChecked() {
		return remember_me_checkbox.isSelected();
	}
	
	
	public void clickOnForgotPassword() {
		forgot_password_link.click();
	}
	
	public void clickOnContactSupport() {
		eaton_support_link.click();
	}
	
	
	public String getTheEmailContactOnSupport() {
		return support_email.getText();
	}
	
	public String getSupportContactOnForgotPass() {
		return support_contact.getText();
	}
	
	public void closeForgotPassword() {
		backButton.click();
	}
	
	/* ************************ Getting Error messages from the Locator to List ************************ */
	
	 public List<String> getErrorMessages() {
	     return  errorMessage.stream()
	    		 .map(errorMessage -> errorMessage.getText())
	    		 .collect(Collectors.toList());
	    				    		
	}
//	static String visible = "";
	public String checkPasswordVisibility () {
		
		String visible = eye_button.getText();
		return visible;
		
	}
	
	public String checkPasswordHidden() {
		String notVisible = eye_button.getText();
		return notVisible;
	}
	
	public String naviagateToHomePage() {
		return fadrHomePage.getText();
	}
	
	
	
}

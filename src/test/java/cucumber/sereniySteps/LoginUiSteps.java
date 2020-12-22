package cucumber.sereniySteps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import cucumber.Pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.is;

public class LoginUiSteps {

static LoginPage loginObjects;
	
	 @Step
	 public void OpenUrlOnBrowser() {
		 loginObjects.open();
	 }
	 
	 @Step
	 public void enterEmail(String email) {
		 loginObjects.enterTheEmail(email);
	 }
	 
	 @Step
	 public void enterPassword(String password) {
		 loginObjects.enterThePassword(password);
	 }
	 
	 @Step
	 public void clickLogin() {
		 loginObjects.clickOnLoginButton();
	 }
	 
	 @Step
	 public void clickRememberMeCheckBox() {
		 loginObjects.clickOnRememberMeCheckBox();
	 }
	 
	 @Step
	 public void contactEaton() {
		 loginObjects.clickOnContactSupport();
	 }
	 
	
	 @Step
	 public void clickPasswordEye () {
		 loginObjects.clickOnPasswordEye();
	 }
	 
	 @Step
	 public void clickForgotPassword () {
		 loginObjects.clickOnForgotPassword();
	 }
	 
	 @Step
	 public void assertForgopassword() {
		 String getContact = loginObjects.getSupportContactOnForgotPass();
	       assertThat("800-356-3292", equalTo(getContact));
	       loginObjects.closeForgotPassword();
	 }
	 
	 @Step
	 public void assertContatcEaton() {
		 String contactEmail = loginObjects.getTheEmailContactOnSupport();
		 assertThat("CST@eaton.com", equalTo(contactEmail));		 
	 }
	 
	 @Step
	 public void checkLoginButtonEnabled() {
		 boolean boolVal = loginObjects.loginButtonEnabled();
		 assertTrue(boolVal);
	 }
	 
	 @Step 
	 public void checkLoginButtonDisabled() {
		 boolean boolVal = loginObjects.loginButtonEnabled();
		 assertFalse(boolVal != false);
	 }
	 
	 /* *****************  Validating the errors using a the List   ***************** */
	 
	 @Step 
	 public void validateErrorMessage(String errormessage) {
		 
		 	List<String> list=new ArrayList<String>();  
		 	list.clear();
		 	list.addAll(loginObjects.getErrorMessages());
		 	for(String error:list) {
		 		 assertThat(error, equalTo(errormessage));		
		 	}
	 }
	 
	 
	 @Step
	 public void assertForPasswordVisibility() {
		 
		 String passwordVisibility = loginObjects.checkPasswordVisibility();		 
		 assertThat("visibility", equalTo(passwordVisibility));
			 
	 }
	 
	 @Step
	 public void assertForPaswwordMasked() {
		 String passwordHidden = loginObjects.checkPasswordHidden();
		 assertThat("visibility_off", equalTo(passwordHidden));
	 }
	 
	 /* ********************** Successful Login ************************ */
	 
	 @Step 
	 public void navigateToFadrHomePage() {
		 String homePage = loginObjects.naviagateToHomePage();
		 assertThat("View reports", equalTo(homePage));
	 }
	 
}

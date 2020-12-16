package cucumber.StepDefinitions;

import cucumber.Pages.LoginPage;
import cucumber.sereniySteps.LoginUiSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class LoginUi {

		static LoginPage loginObjects;
		
		@Steps
		LoginUiSteps loginStep;
	
	 	@Given("^The login page is open on the browser$")
	    public void the_login_page_is_open_on_the_browser() throws InterruptedException {
	        loginStep.OpenUrlBrowser();
	 	}

	    @When("^Enter the user name \"([^\"]*)\"$")
	    public void enter_the_user_name_something(String username)throws Exception {
	    	loginStep.enterEmail(username);
	    }
	    
	    @And("^Enter the Password \"([^\"]*)\"$")
	    public void enter_the_password_something(String password)throws Exception {
	    	loginStep.enterPassword(password);
	    }

	    @When("^click on login button$")
	    public void click_on_login_button()  {
	        loginStep.clickLogin();
	    }
	    /* Successful Login */
	    @Then("^Navigate to the FADR Home page$")
	    public void navigate_to_the_fadr_home_page() {
	        
	    }

	    @When("^Remember me Check box unchecked$")
	    public void remember_me_check_box_unchecked() {
	        
	    }

	    @When("^Remember me Check box checked$")
	    public void remember_me_check_box_checked() {
	        loginStep.clickRememberMeCheckBox();
	    }

	    
	    @When("^Click on the Contact Eaton Support$")
	    public void click_on_the_contact_eaton_support() {
	       loginStep.contactEaton();
	    }

	    @When("^clicked on password eye$")
	    public void clicked_on_password_eye() {
	    	loginStep.clickPasswordEye();
	    }

	    @Then("^Login button should be Enabled$")
	    public void login_button_should_be_enabled() {
	    	loginStep.checkLoginButtonEnabled();
	        	
	    }
	    
	    @Then("^Login button should be Disabled$")
	    public void login_button_should_be_disabled() {
	    	loginStep.checkLoginButtonDisabled();
	        	
	    }

	    @Then("^Error message \"([^\"]*)\" Should be displayed$")
	    public void error_message_something_should_be_displayed(String errormessage)throws Exception{
	        loginStep.validateErrorMessage(errormessage);
	     }
	        
	    /*
	    @Then("^The user is Logged out successfully $")
	    public void the_user_is_logged_out_successfully() {
	        
	    }
	    */
	    /*
	    @Then("^the Email text box should not be auto populated with the Email $")
	    public void the_email_text_box_should_not_be_auto_populated_with_the_email() throws Throwable {
	        
	    }
	    */
	    
	    @When("^Clicked on the Forgot Password link$")
	    public void clicked_on_the_forgot_password_link() {
	        loginStep.clickForgotPassword();
	    	
	    }

	    @Then("^User should be redirected to Forgot Password Page$")
	    public void user_should_be_redirected_to_forgot_password_page() {
	        loginStep.assertForgopassword();
	       
	    }

	    @Then("^A pop up window shall open showing the support details$")
	    public void a_pop_up_window_shall_open_showing_the_support_details() { 
	    	loginStep.assertContatcEaton();
	    }

	    @Then("^Password should be masked$")
	    public void password_should_be_masked() {
	    	loginStep.assertForPaswwordMasked();
	    }

	    @Then("^Password should be visible$")
	    public void password_should_be_visible() {
	    	loginStep.assertForPasswordVisibility();
	    }
	    
	    


}

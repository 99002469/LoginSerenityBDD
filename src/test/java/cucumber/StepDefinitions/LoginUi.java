package cucumber.StepDefinitions;

import cucumber.sereniySteps.LoginUiSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class LoginUi {
		
		@Steps
		LoginUiSteps loginStep;
	
	 	@Given("^The login page is open on the browser$")
	    public void the_login_page_is_open_on_the_browser() {
	        
	    }

	    @When("^Enter the user name \"([^\"]*)\"$")
	    public void enter_the_user_name_something(String username)throws Exception {
	    	loginStep.sendEmail(username);
	    }
	    
	    @And("^Enter the Password \"([^\"]*)\"$")
	    public void enter_the_password_something(String password)throws Exception {
	     
	    }

	    @When("^click on login button$")
	    public void click_on_login_button()  {
	        
	    }

	    @When("^Remember me Check box unchecked$")
	    public void remember_me_check_box_unchecked()  {
	        
	    }

	    @When("^Remember me Check box checked$")
	    public void remember_me_check_box_checked() {
	        
	    }

	    @When("^Clicked on the Forgot Password link $")
	    public void clicked_on_the_forgot_password_link() {
	        
	    }

	    @When("^Click on the Contact Eaton Support$")
	    public void click_on_the_contact_eaton_support() throws Throwable {
	        
	    }

	    @When("^clicked on password eye$")
	    public void clicked_on_password_eye() throws Throwable {
	        
	    }

	    @Then("^Login button should be Enabled$")
	    public void login_button_should_be_enabled() throws Throwable {
	        
	    }

	    @Then("^Error message \"([^\"]*)\" Should be displayed$")
	    public void error_message_something_should_be_displayed(String errormessage, String strArg1) throws Throwable {
	        
	    }

	    @Then("^The user is Logged out successfully $")
	    public void the_user_is_logged_out_successfully() throws Throwable {
	        
	    }

	    @Then("^the Email text box should not be auto populated with the Email $")
	    public void the_email_text_box_should_not_be_auto_populated_with_the_email() throws Throwable {
	        
	    }

	    @Then("^User should be redirected to Forgot Password Page$")
	    public void user_should_be_redirected_to_forgot_password_page() throws Throwable {
	        
	    }

	    @Then("^A pop up window shall open showing the support details$")
	    public void a_pop_up_window_shall_open_showing_the_support_details() throws Throwable {
	        
	    }

	    @Then("^Password should be masked$")
	    public void password_should_be_masked() throws Throwable {
	        
	    }

	    @Then("^Password should be visible$")
	    public void password_should_be_visible() throws Throwable {
	        
	    }

	    @And("^Enter the Password \"([^\"]*)\" $")
	    public void enter_the_password_something(String password, String strArg1) throws Throwable {
	        
	    }
}

package cucumber.bStepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.dPageObject.LoginPage;
import io.cucumber.java.en.*;



public class LoginUiSerinity {
	
	LoginPage login = new LoginPage();
	
	Hooks hook = new Hooks();
	WebDriver driver = Hooks.driver;
	
	@Given("^The login page is open on the browser$")
	public void the_login_page_is_open_on_the_browser() throws Throwable {
		login.wait();
	    
	}

	@When("^Enter the user name \"([^\"]*)\"$")
	public void enter_the_user_name(String Email) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  login.sendEmail(Email);   
	}

	@When("^Enter the Password \"([^\"]*)\"$")
	public void enter_the_Password(String Password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		login.sendPassword(Password);
	     
	}

	@Then("^Login button should be Enabled$")
	public void login_button_should_be_Enabled() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		login.loginButtonEnabled();
	}

	@When("^click on login button$")
	public void click_on_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		login.clickLoginButton();		
		
	}

	@Then("^Error message \"([^\"]*)\" Should be displayed$")
	public void error_message_Should_be_displayed(String errorMessage) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		
		
	}

	@When("^Remember me Check box unchecked$")
	public void remember_me_Check_box_unchecked() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}


	@Then("^The user is Logged out successfully$")
	public void the_user_is_Logged_out_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		

	}

	@Then("^the Email text box should not be auto populated with the Email$")
	public void the_Email_text_box_should_not_be_auto_populated_with_the_Email() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("^Remember me Check box checked$")
	public void remember_me_Check_box_checked() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}


	@When("^Clicked on the Forgot Password link$")
	public void clicked_on_the_Forgot_Password_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Then("^User should be redirected to Forgot Password Page$")
	public void user_should_be_redirected_to_Forgot_Password_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
		
	}

	@When("^Click on the Contact Eaton Support$")
	public void click_on_the_Contact_Eaton_Support() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Then("^A pop up window shall open showing the support details$")
	public void a_pop_up_window_shall_open_showing_the_support_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Then("^Password should be masked$")
	public void password_should_be_masked() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@When("^clicked on password eye$")
	public void clicked_on_password_eye() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

	@Then("^Password should be visible$")
	public void password_should_be_visible() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
	}

}


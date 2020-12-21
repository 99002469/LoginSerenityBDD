package cucumber.StepDefinitions;

import cucumber.sereniySteps.CustomerRegistrationStepsUi;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class CustomerRegistrationUi {

	@Steps
	CustomerRegistrationStepsUi customerRegister;
	
    @Given("^FADR Home page is open on Browser$")
    public void fadr_home_page_is_open_on_browser() {
    	customerRegister.openCustomerReg();
    }

    @When("^User Navigates to the Customer Registration$")
    public void user_navigates_to_the_customer_registration() {
        customerRegister.navigateToCutomerRegistration();
    }

    @When("^Enter the Details of the customer \"([^\"]*)\" add \"([^\"]*)\" add \"([^\"]*)\" add \"([^\"]*)\"$")
    public void enter_the_details_of_the_customer_something_something_something_something(String custname, String contactname, String contactphone, String contactemail) throws Throwable {
        customerRegister.enterTheCustomerDetails(custname, contactname, contactphone, contactemail);
    }

    @When("^User Clicks on the Reset Button$")
    public void user_clicks_on_the_reset_button() {
        customerRegister.clickOnResetButton();
    }

    @Then("^Customer registration page is open$")
    public void customer_registration_page_is_open() {
        //Assert the customer Registration page is Open
    	customerRegister.userIsOnCustomerRegisterPage();
    }

    @Then("^Submit button should be disabled$")
    public void submit_button_should_be_disabled() {
        customerRegister.assertSubmitButtonDisabled();
    }

    @Then("^Submit button should be Enabled$")
    public void submit_button_should_be_enabled() {
        customerRegister.assertSubmitButtonEnabled();
    }

    @Then("^Data Entered Should be cleared$")
    public void data_entered_should_be_cleared() throws Throwable {
        //Assert the Entered values are null after the Reset button is Clicked
    	
    }

    @Then("^Input feild should not accept the chracters more than field for \"([^\"]*)\" and \"([^\"]*)\"$")
    public void input_feild_should_not_accept_the_chracters_more_than_field_for_something_and_something(String custname, String contactphone) throws Throwable {
    	customerRegister.inputFeildValidationName(custname);
    	customerRegister.inputFeildValidationNumber(contactphone);
    	
    }

    @And("^Authorized user selects the Factory Reset from the menu$")
    public void authorized_user_selects_the_factory_reset_from_the_menu() throws Throwable {
    	customerRegister.navigateToFactoryResetMenu();
    }

    @And("^Select the Contact Method from the DropDown \"([^\"]*)\"$")
    public void select_the_contact_method_from_the_dropdown_something(String contactmethod) throws Throwable {
        customerRegister.selectContactMethod(contactmethod);
    }

    @And("^Fill the Additional Info \"([^\"]*)\"$")
    public void fill_the_additional_info_something(String additionalinfo) throws Throwable {
        customerRegister.addAdditioanlInformation(additionalinfo);
    }

    @And("^Error Message \"([^\"]*)\" is displayed$")
    public void error_message_something_is_displayed(String errormessage) throws Throwable {
        customerRegister.validateErrorMessage(errormessage);
    }

    @And("^Any error Messages Displayed are also cleared$")
    public void any_error_messages_displayed_are_also_cleared() throws Throwable {
        //Assert the Error Messages are Cleared
    }
	
}

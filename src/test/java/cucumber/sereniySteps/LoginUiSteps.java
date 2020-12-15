package cucumber.sereniySteps;

import org.openqa.selenium.support.FindBy;

import cucumber.StepDefinitions.Hooks;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://smpservices-qa.eastus.cloudapp.azure.com/#/")
public class LoginUiSteps extends PageObject {


	
	Hooks hook = new Hooks();
	
	
	@FindBy(id = "email")
    WebElementFacade userName;

    @FindBy(id = "password")
    WebElementFacade password;

    @FindBy(xpath = "//span[contains(text(),'LOG IN')]")
     WebElementFacade loginButton;

    @FindBy(xpath = "//div[@class='mat-checkbox-inner-container']")
     WebElementFacade rememberMe_chkBox;

    @FindBy(xpath = "//div[@class='mat-checkbox-inner-container'] /input")
     WebElementFacade chk_box;

    @FindBy(xpath = "//a[@class='forgot-password']")
     WebElementFacade forgotPassword_link;

    @FindBy(xpath = "//a[@class='contact-eaton']")
     WebElementFacade contactEaton_link;

    @FindBy(xpath = "//mat-icon[@class='matIcon mat-icon notranslate material-icons mat-icon-no-color']")
     WebElementFacade password_mask;

    @FindBy(xpath = "//a[contains(text(),'CST@eaton.com')]")
     WebElementFacade support_email;

    @FindBy(xpath = "//a[contains(text(),'800-356-3292')]")
     WebElementFacade support_contact;

    @FindBy(xpath = "//h1[contains(text(),'Your connection isn't private')]")
     WebElementFacade proceed;

    @FindBy(xpath = "//*[@id='details-button']")
     WebElementFacade advanced_btn;

    @FindBy(xpath = "//*[@id='proceed-link']")
     WebElementFacade proceed_link;
    
    public void openUrl_onBrowser() throws Exception {
    	
   
    }
    
    public void sendEmail(String email) {
    	userName.typeAndEnter(email);
    }
    
    public void sendPassword(String Password) {
    	password.type(Password);
    }
    
    public void clickOnLoginButon() {
    	loginButton.click();
    }
    
    public void clickOnPasswordEye() {
    	
    }
    
    
    
}

package cucumber.dPageObject;

import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;



public class PageObjectUi {
	
	@FindBy(id = "email") 
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(xpath = "//mat-icon[@class='matIcon mat-icon notranslate material-icons mat-icon-no-color']")
    WebElement passwordMask;
	
	@FindBy(xpath = "//span[contains(text(),'LOG IN')]")
	WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='mat-checkbox-inner-container']")
	WebElement rememberCheckBox;
	
	@FindBy(xpath = "//a[@class='forgot-password']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//a[@class='contact-eaton']")
	WebElement contactEatonSupportLink;
	
	@FindBy(xpath = "")
	WebElement h;
	
	

}

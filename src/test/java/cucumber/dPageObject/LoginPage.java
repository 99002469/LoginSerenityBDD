package cucumber.dPageObject;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject{
	
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
	
	@FindBy(xpath = "//*[@class = 'ng-tns-c16-0 ng-trigger ng-trigger-transitionMessages ng-star-inserted']")
	WebElement errorDesc;
	
	public void sendEmail(String userEmail) {
		userName.sendKeys(userEmail);
		System.out.println(userEmail);
	}
	
	public void sendPassword(String userPassword) {
		Password.sendKeys(userPassword);
		System.out.println(userPassword);
	}
	
	public void loginButtonEnabled() {
		loginButton.isEnabled();
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void errorDescription(String errorMsg) {
		errorDesc.getText();
		
	}
}

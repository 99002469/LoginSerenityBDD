package cucumber.StepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.sereniySteps.LoginLogoutStepsApi;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.thucydides.core.annotations.Steps;




public class Hooks {
		

		static WebDriver driver;
		@Before
		public void openBrowser()throws Exception {
			System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			//driver.get("https://smpservices-qa.eastus.cloudapp.azure.com/#/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
		@After
		public static void closeBrowser() throws Exception { 
			driver.close();
			
		}
		
		@Steps 
		LoginLogoutStepsApi securityLog;
		
		@Before("@SuccessfulLogin")
		public void makePostRequest() throws IOException {
			securityLog.makePostRequest();
			//securityLog.makeDeleteRequest("UserId.txt", "TokenId.txt");
		}
		
}



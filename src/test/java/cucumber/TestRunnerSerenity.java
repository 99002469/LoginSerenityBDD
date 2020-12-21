package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)                   
@CucumberOptions(
		
		features= {"src/test/resources/features/"
				
				},         
        glue = {"cucumber.StepDefinitions"},
        monochrome = true,
		tags = "@UI",
		plugin = {"pretty", "junit:target/automationreport.xml"})   

	
public class TestRunnerSerenity {
	
}

//"src/test/resources/features/SerenityLoginUi.feature"
//"src/test/resources/features/LoginApi.feature",
//"src/test/resources/features/SerenityCustomerRegApi.feature",
//"src/test/resources/features/SerenityLogoffApi.feature"

//"src/test/resources/features/CustomerRegistraionUI.feature"
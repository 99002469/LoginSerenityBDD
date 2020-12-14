package cucumber.aTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)                   
@CucumberOptions(
		features= {"src/test/resources/features/LoginApi.feature",
				"src/test/resources/features/SerenityCustomerRegApi.feature",
				"src/test/resources/features/SerenityLogoffApi.feature"},         
        glue = {"cucumber.bStepDefinitions"},
        monochrome = true,
		//tags = "@Security",
		plugin = {"pretty", "junit:target/automationreport.xml"})  

	

public class TestRunnerSerenity {
	
}



package cucumber.aTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)                   
@CucumberOptions(
		features="src/test/resources/features/SerenityLoginApi.feature",         
        glue = {"cucumber.bStepDefinitions"},
        monochrome = true,
//		tags = "@UI",
		plugin = {"pretty", "junit:target/automationreport.xml",  
							"json:target/automationreport.json",
				  			"html:target/automationreport.html"})  



	

public class TestRunnerSerenity {
	
}

/*
 * 	features="src/test/resources/features/SerenityLoginApi.feature",         
        glue = {"cucumber.bStepDefinitions"},
        monochrome = true,
//		tags = "@UI",
		plugin = {"pretty", "junit:target/automationreport.xml"})  

 */

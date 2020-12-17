package cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)                   
@CucumberOptions(
		features= {"src/test/resources/features/SerenityLoginUi.feature"},         
        glue = {"cucumber.StepDefinitions"},
        monochrome = true,
		//tags = "@Security",
		plugin = {"pretty", "junit:target/automationreport.xml"})   

	
public class TestRunnerSerenity {
	
}



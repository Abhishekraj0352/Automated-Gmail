package myRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\Abhi\\eclipse-workspace\\GmailBDDFramework\\src\\main\\java\\Features\\login1.feature"
		,glue={"sStepDefinitons"},
		plugin = {"pretty", "html:target/cucumber-htmlreport"}
		,monochrome = true //display the console output in a proper readable format
		,dryRun = false //to check the mapping is proper between feature file and step def file	
//		features = the path of the feature files
//				   glue=the path of the step definition files
//				   /pluginformat= to generate different types of reporting
			)
public class TestRunner {

}

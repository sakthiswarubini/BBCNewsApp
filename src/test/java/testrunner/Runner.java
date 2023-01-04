package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features =  "src/test/resources/features", glue= {"stepDefinitions"}, plugin = {"pretty","html:target/cucumber-reports/cucumber-html-report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Runner extends AbstractTestNGCucumberTests {
	
		

}

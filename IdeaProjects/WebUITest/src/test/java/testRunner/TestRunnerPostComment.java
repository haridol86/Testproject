package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @description: This class acts as an interlink between cucumber feature files and step definition classes 
 * @author Hariharan
 * @version 1.0
 * @since 11/05/2022
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:/Users/harid/IdeaProjects/cucumber-testing-framework-using-selenium-java-maven/src/main/java/login/feature/Afterlogin.feature",
		glue= {"stepDefinition"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome=true
		)
public class TestRunnerPostComment {
}
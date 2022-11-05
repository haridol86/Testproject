package stepDefinition;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import cucumber.api.java.en.Then;
import org.dom4j.Branch;
import org.jsoup.nodes.Entities;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.login;
import utility.DriverFactory;
import utility.Utility;


public class AfterLogin {
	
	public WebDriver driver;
	pages.login login;
	Entities entities;
	Branch branch;
	public List<HashMap<String, String>> datamap;
	String id;
	
	static Logger logger = Logger.getLogger(AfterLogin.class.getName());


	/**
	* @description: setUp() method to set up initial state for all test methods and tearDown() method perform cleanup after execution.
	* @param None
	* @return None
	* @author Hariharan
	* @version 1.0
	*/
	
	@Before
	public void setUp() {
		//Reporter.assignAuthor("Hariharan");
		logger.info("Instantiating chrome driver");
		driver = DriverFactory.get_driver_instance();
		login = new login(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}
	
	
	@After
	public void tearDown() {
	    Reporter.loadXMLConfig(new File(Utility.getProperty("reportConfigPath")));
	    Reporter.setSystemInfo("User Name", Utility.getProperty("uname"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.141.59");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	    driver.close();
	}

	
	@Given("^user navigates to the application$")
	public void user_is_on_the_application_home_page() throws Throwable {
		driver.get(Utility.getProperty("url"));
	}

	@When("^user log-in to the application$")
	public void user_logged_in_successfully() throws Throwable {
		Reporter.addStepLog("Login to the application");
		login.click_auth_link();
		Reporter.addStepLog("Enter User Name:");
		login.enter_username(Utility.getProperty("uname"));
		Reporter.addStepLog("Enter Password:");
		login.enter_password(Utility.getProperty("pwd"));

	}

	@Then("^user log-out the application$")
	public void user_logout_the_application() throws Throwable {
		login.click_on_logout();
	}





}

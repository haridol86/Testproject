package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @description: Page Object class for Login page
 * @author Hariharan
 * @version 1.0
 * @since 11/05/2022
*/

public class login {

	// Initialization: Page factory will initialize every web element with reference
	// to corresponding element on the actual web page based on locators
	public login(WebDriver driver) {
		/**
		   * Constructor
		 */	
		PageFactory.initElements(driver, this);
	}

	// Declare elements on Login page by @findBy annotation
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement login_lnkbtn;

	@FindBy(xpath = "//a[normalize-space()='Form Authentication']")
	private WebElement form_auth;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement username_txt;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password_txt;

	
	@FindBy(xpath = "//i[contains(text(),'Logout')]")
	private WebElement log_out_btn;



	// Utilization: Methods to perform action on the web page
	public void click_auth_link() {
		form_auth.click();
	}
	public void click_login_link() {
		login_lnkbtn.click();
	}	

	/**
	   * Enter text in username textbox.
	   * @param: uname Username
	   * Parameters:uname, must not be null
	 */	
	public void enter_username(String uname) {
		username_txt.sendKeys(uname);
	}
	
	/**
	   * Enter text in password textbox.
	   * @param: pwd Password
	   * Parameters:pwd, must not be null
	 */	
	public void enter_password(String pwd) {
		password_txt.sendKeys(pwd);
	}
	
	public void click_on_logout() {
		log_out_btn.click();
	}
	


}

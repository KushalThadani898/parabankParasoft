/**
 * 
 */
package Framework.com.parabankParasoft.productParabank.PO;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import Framework.com.parabankParasoft.core.Interfaces.ILogAndReport;
import Framework.com.parabankParasoft.core.Managers.BrowserManager;


/**
 * @author kushal
 *
 */
public class PO_LoginParaBank implements ILogAndReport {

	final Logger logger = Logger.getLogger(BrowserManager.class);
	public WebDriver driver;

	public PO_LoginParaBank(WebDriver driver1) {
		this.driver = driver1;
	}

//	...........................   Set Username For Login In Parabank   ...........................
	@FindBy(how = How.NAME , using="username") 
	public WebElement txt_u_name;
	
//	...........................   Set Password For Login In Parabank   ...........................
	@FindBy(how = How.NAME , using="password")
	public WebElement txt_passwrd;

//	...........................   Click on login button fir submitting information   ...........................
	@FindBy(how = How.XPATH , using="//*[@id=\"loginPanel\"]/form/div[3]/input")
	public WebElement txt_login;

//   .................   Method for username accessed in login process  by using find element   .........................
	public void userNameMethod(String log_username) {
		try {
			 WriteLogAndReport(logger, "info", "pass", "User name is set with user: "  + log_username);
					txt_u_name.sendKeys(log_username);	
		}catch(NoSuchElementException ob) {
			WriteLogAndReport(logger, "warn", "fail", "Unable to set user name due to exception " + ob.getMessage());
		}
	} // End username process.
	
//	...........................   Set Passowrd For Login In Parabank   ........................... 
	public void passWordMethod(String log_passwrd) {
		try {
			WriteLogAndReport(logger, "info", "pass", "Password is set with user: "  + log_passwrd);
					txt_passwrd.sendKeys(log_passwrd);	
		}catch(NoSuchElementException ob) {
			WriteLogAndReport(logger, "warn", "fail", "Unable to set password due to exception " + ob.getMessage());
		}
	} // End password process.

//	...........................    Click on login button for submitting information later on we can use our admin page   ........................... 
	public void loginMethod() {
		try {
				txt_login.click();
				WriteLogAndReport(logger, "info", "pass", "Clicked on Login button");
		}catch(NoSuchElementException ob) {
			WriteLogAndReport(logger, "info", "fail", "Unable to click on Submit due to exception " + ob.getMessage());
		}
	} // End login process.

	 public void kw_login_into_parabank(String u, String p, boolean isSupposedToBeSuccess) {
		 try {
			 userNameMethod(u);
			 passWordMethod(p);
			 loginMethod();
			 kw_validate_login(isSupposedToBeSuccess);
			 
	}catch(Exception ob) {
			 WriteLogAndReport(logger, "info", "fail", "Unable to login in to the applicaiton due to exception " + ob.getMessage());
		 }
	 }
	 public void kw_validate_login(boolean isSupposedToBeSuccess) {
		 if (driver.getTitle().contains("ParaBank | Accounts Overview")) {
			 
			 if (isSupposedToBeSuccess) {
				 WriteLogAndReport(logger, "info", "pass", "Login Successfull");
			 }else {
				 WriteLogAndReport(logger, "info", "fail", "Page title is not Account Overview. Login failed");
			 }
			 
		 }else {
			 if (isSupposedToBeSuccess) {
				 WriteLogAndReport(logger, "info", "pass", "Login failed after using incorrect user name.");
			 }else {
				 WriteLogAndReport(logger, "info", "fail", "Failed: Login success after using incorrect user name.");
			 }
		 }//end if
	 }//end method


}

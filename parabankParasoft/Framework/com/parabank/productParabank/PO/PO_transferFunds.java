/**
 * 
 */
package dev.backup.kushal.frameWork.com.yantra.paraBank.project.PO;

import java.util.NoSuchElementException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.yantra.core.managers.BrowserManager;
import dev.backup.kushal.frameWork.com.yantra.core.inheritances.ILogAndReport;

/**
 * @author Kushal  Thadani
 */
public class PO_transferFunds implements ILogAndReport {

	final Logger logger = Logger.getLogger(BrowserManager.class);
	public WebDriver driver;

	public PO_transferFunds(WebDriver drv) {
		this.driver = drv;
	}
	
//	...........................   Set Locator For transfer Funds Of Parabank Application  ...........................
	
	@FindBy(how = How.XPATH , using="//*[@id=\"leftPanel\"]/ul/li[3]/a") 
	public WebElement clck_transfer_funds_btn;
	
	@FindBy(how = How.XPATH , using="//input[@ng-model='accounts.amount' and @id='amount']") 
	public WebElement tranfer_amount;

	@FindBy(how = How.XPATH , using="//select[@id='fromAccountId']") 
	public WebElement select_account_type_from_transfer;
	
	@FindBy(how = How.XPATH , using="//input[@id='toAccountId']") 
	public WebElement select_account_to_transfer;
	
	
//....................................................................................................................................
//..................................Method For Access All These Locator .....................................................
//...................................................................................................................................	
	public void clckOnTransferFundsMethod() {
		try {
			 WriteLogAndReport(logger, "info", "pass", "User name is set with user: "  + clck_transfer_funds_btn);
			 clck_transfer_funds_btn.click();
		}catch(NoSuchElementException ob) {
			WriteLogAndReport(logger, "warn", "fail", "Unable to set user name due to exception " + ob.getMessage());
		}
	}
	
}

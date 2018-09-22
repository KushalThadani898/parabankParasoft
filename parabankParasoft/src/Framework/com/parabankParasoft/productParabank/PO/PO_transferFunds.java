/**
 * 
 */
package Framework.com.parabankParasoft.productParabank.PO;

import java.util.NoSuchElementException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import Framework.com.parabankParasoft.core.Interfaces.ILogAndReport;
import Framework.com.parabankParasoft.core.Managers.BrowserManager;


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
	
	
	@FindBy(how = How.XPATH , using="//input[@ng-model='accounts.amount' and @id='amount']") 
	private WebElement tranfer_amount;

	@FindBy(how = How.XPATH , using="//select[@id='fromAccountId']") 
	private WebElement select_account_type_from_transfer;
	
	@FindBy(how = How.XPATH , using="//select[@id=\"toAccountId\"]") 
	private WebElement select_account_to_transfer;
	
	@FindBy(how = How.XPATH , using="//*[@id=\"rightPanel\"]/div/div/form/div[2]/input")
	private WebElement click_Transfer_fund_btn;
//....................................................................................................................................
//..................................Method For Access All These Locator .....................................................
//...................................................................................................................................	
	public void enterAmountMethod() {
		try {
			 WriteLogAndReport(logger, "info", "pass", "Entered amount is successfully-:\t\t ");
			 tranfer_amount.sendKeys("1002");
		}catch(NoSuchElementException ob) {
			WriteLogAndReport(logger, "warn", "fail", "Unable to set user name due to exception " + ob.getMessage());
		}
	}
	
	public void selectFromAccountTypeMethod(String selectFromAccount) {
		try {
			select_account_type_from_transfer.click();
			Select select_from_obj = new Select(select_account_type_from_transfer);
			select_from_obj.selectByValue(selectFromAccount);
			WriteLogAndReport(logger, "info", "PASSED", "Account Number Selected For transfer Amount To Another Account Successfully.....\t\t ");
		}catch(NoSuchElementException ob) {
			WriteLogAndReport(logger, "warn", "FAILED", "Unable To Select Account Number Due To Exception " + ob.getMessage());
		}
	}
	
	
	
	public void selectToAccountTypeMethod(String selectToAccount) {
		try {
			select_account_to_transfer.click();
			Select select_from_obj = new Select(select_account_to_transfer);
			select_from_obj.selectByValue(selectToAccount);
			WriteLogAndReport(logger, "info", "PASSED", "Amount Entered Successfully.....\t\t ");
		}catch(NoSuchElementException ob) {
			WriteLogAndReport(logger, "warn", "FAILED", "Amount Didn't Credit In This Account Due To Exception " + ob.getMessage());
		}
	}
	
	
	public void clickTransferBtn() {
		click_Transfer_fund_btn.click();
	}

}

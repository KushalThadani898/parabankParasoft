/**
 * 
 */
package Framework.com.parabankParasoft.productParabank.PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author kushal
 *
 */
public class PO_CommonForAllModulesObject {

	WebDriver driver;

	public  PO_CommonForAllModulesObject(WebDriver driver)
	{
		this.driver= driver;
	}

	@FindBy(how = How.XPATH , using="//*[@id=\"leftPanel\"]/ul/li[3]/a") 
	public WebElement Link_clck_transfer_funds_btn;

	@FindBy(how=How.LINK_TEXT,using="Open New Account")
	private WebElement Link_open_new_account_btn;;

	@FindBy(how=How.LINK_TEXT,using="Accounts Overview")
	private WebElement Link_accounts_overview_btn;;

	@FindBy(how=How.LINK_TEXT,using="Bill Pay")
	private WebElement Link_bill_pay_btn;;

	@FindBy(how=How.LINK_TEXT,using="Find Transactions")
	private WebElement Link_find_transactions_btn;;

	@FindBy(how=How.LINK_TEXT,using="Update Contact Info")
	private WebElement Link_update_contact_info_btn;;

	@FindBy(how=How.LINK_TEXT,using="Request Loan")
	private WebElement Link_request_loan_btn;;

	@FindBy(how=How.LINK_TEXT,using="Log Out")
	private WebElement Link_log_out_btn;


	public void click_Open_New_Account()
	{
		Link_open_new_account_btn.click();
	}

	public void click_Accounts_Overview()
	{
		Link_accounts_overview_btn.click();
	}

	public void click_Transfer_Funds()
	{
		Link_clck_transfer_funds_btn.click();
	}

	public void click_Bill_Pay()
	{
		Link_bill_pay_btn.click();
	}
	public void click_Find_Transactions()
	{
		Link_find_transactions_btn.click();
	}
	public void click_Update_Contact_Info()
	{
		Link_update_contact_info_btn.click();
	}
	public void click_Request_Loan()
	{
		Link_request_loan_btn.click();
	}
	public void click_Log_Out()
	{
		Link_log_out_btn.click();
	}
	public void kw_common_object() {
		click_Open_New_Account();
		click_Accounts_Overview();
		click_Transfer_Funds();
		click_Bill_Pay();
		click_Find_Transactions();
		click_Update_Contact_Info();
		click_Request_Loan();
		click_Log_Out();
	}	
}

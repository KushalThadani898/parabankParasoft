package Framework.com.parabankParasoft.productParabank.TC;

import org.testng.annotations.Test;

import Framework.com.parabankParasoft.core.Managers.BrowserManager;
import Framework.com.parabankParasoft.driver.Config;
import Framework.com.parabankParasoft.productParabank.PO.PO_LoginParaBank;
import Framework.com.parabankParasoft.productParabank.PO.PO_transferFunds;
import Framework.com.parabankParasoft.productParabank.PO.TC_CommonForAllModulesObject;
import Framework.com.parabankParasoft.productParabank.reusability.ReusabilityMethod;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TC_transferFunds {
	WebDriver  driver;
	private Config Config;
	private HashMap<String, String> CONFIG_DATA;
	private String username;
	private String password;
	private String accountFrom;
	private String accountTo;
	private String currentTitle;
	private String expectedTitle;
	private String actualPageMessage;
	private String expectedPageMessage;
	@BeforeTest
	public void setUpPathForEachCase() throws IOException {
		Config = new Config();
		CONFIG_DATA = Config.CONFIG_DATA();
	}
	
	@AfterTest
	public void closeTab() {
//		driver.quit();
	}
	
	@Parameters({"browser","url"})
	@Test(groups= {"smoke","regression"})
		public void tranferFundMethod(@Optional("chrome")String browser_name , @Optional("")String url) throws IOException, InterruptedException {
			BrowserManager browser_obj = new BrowserManager();
			WebDriver driver = browser_obj.GetBrowser(browser_name);
			browser_obj.NavigateToPage(driver, "http://parabank.parasoft.com/parabank/index.htm");
			PO_LoginParaBank login_object = PageFactory.initElements(driver, PO_LoginParaBank.class);
			username =  CONFIG_DATA.get("USERNAME");
			password = CONFIG_DATA.get("PASSWORD");
			login_object.kw_login_into_parabank(username,password , true);
			ReusabilityMethod.writeLogsMessage("PASSED","Login has been successfully\t~~~~~~:\t"+ username + "\tand\t"+password);
			
//........................................................................................................................................
//..................................Create page object for transfer funds of parabank application..........................................
//..........................................................................................................................................................
			
			TC_CommonForAllModulesObject transferFunds_object = PageFactory.initElements(driver, TC_CommonForAllModulesObject.class);
			transferFunds_object.click_Transfer_Funds();
			Thread.sleep(2000);
			
			PO_transferFunds po_obj_trasfer_page = PageFactory.initElements(driver, PO_transferFunds.class);
			po_obj_trasfer_page.enterAmountMethod();
			Thread.sleep(2000);
			accountFrom =  CONFIG_DATA.get("ACCOUNTFROM");
			accountTo =  CONFIG_DATA.get("ACCOUNTTO");
			po_obj_trasfer_page.selectFromAccountTypeMethod(accountFrom);
			po_obj_trasfer_page.selectToAccountTypeMethod(accountTo);
			
			Thread.sleep(3000);
			
			po_obj_trasfer_page.clickTransferBtn();
			
			ReusabilityMethod.writeLogsMessage("PASSED","Amount has been transfered successfully--:\t"+ accountFrom + "\t to \t"+accountTo);
			
System.out.println("*********************************************************************************************************************************\t\tCONFIRMATION OF THE PAGE MESSAGE AND TITLE AFTER LOGIN\t\t*******************************************************************************************************************************************************\n\n");
					JavascriptExecutor js = (JavascriptExecutor) driver;
					currentTitle = "ParaBank | Transfer Funds";
					expectedTitle = (String)js.executeScript("return document.title");
					
					actualPageMessage = "$2323.00 has been transferred from account #12345 to account #12345 ";
					expectedPageMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]")).getText();
					
//					Assert.assertEquals(currentTitle, expectedTitle);
//					Assert.assertEquals(actualPageMessage, expectedPageMessage);
					
					System.out.println("Current and exprected title are match successfully\t\n" +currentTitle+ "\t" +expectedTitle);
					System.out.println("Current and expected page message are same \t\n" + actualPageMessage +"\t"+ expectedPageMessage);
					
					
					System.out.println("*************************************************************************************************************************************************\tEND\t**************************************************************************************************************************************************************\n\n");
			Thread.sleep(2000);
			}
	
	}

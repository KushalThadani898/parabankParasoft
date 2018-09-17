package dev.backup.kushal.frameWork.com.yantra.paraBank.project.TC;

import org.testng.annotations.Test;
import com.yantra.driver.Config;
import com.yantra.product.parabank.po.PO_TransferFunds;

import dev.backup.kushal.frameWork.com.yantra.core.managers.BrowserManager;
import dev.backup.kushal.frameWork.com.yantra.paraBank.project.PO.PO_LoginParaBank;
import dev.backup.kushal.frameWork.com.yantra.paraBank.project.PO.PO_transferFunds;
import dev.backup.kushal.frameWork.com.yantra.paraBank.project.resuability.ReusabilityMethod;

import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TC_transferFunds {
	
	private Config Config;
	private HashMap<String, String> CONFIG_DATA;
	private String username;
	private String password;
	@BeforeTest
	public void setUpPathForEachCase() throws IOException {
		Config = new Config();
		CONFIG_DATA = Config.CONFIG_DATA();
	}
	
	@Parameters({"browser","url"})
	@Test(groups= {"smoke","regression"})
		public void tranferFundMethod(@Optional("chrome")String browser_name , @Optional("")String url) throws IOException {
			BrowserManager browser_obj = new BrowserManager();
			WebDriver driver = browser_obj.GetBrowser(browser_name);
			browser_obj.NavigateToPage(driver, url);
			PO_LoginParaBank login_object = PageFactory.initElements(driver, PO_LoginParaBank.class);
			username =  CONFIG_DATA.get("USERNAME");
			password = CONFIG_DATA.get("PASSWORD");
			login_object.kw_login_into_parabank(username,password,true);
			ReusabilityMethod.writeLogsMessage("PASSED","UserName and PassWord Set successfully with text:\t"+ username + "\tand\t"+password);
			
//........................................................................................................................................
//..................................Create page object of transfer funds of parabank application..........................................
//..........................................................................................................................................................
			PO_transferFunds transfer_object = PageFactory.initElements(driver, PO_transferFunds.class);
			transfer_object.clckOnTransferFundsMethod();
	}
	}

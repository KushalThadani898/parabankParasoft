package dev.backup.kushal.frameWork.com.yantra.paraBank.project.TC;

import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.yantra.driver.Config;

import dev.backup.kushal.frameWork.com.yantra.core.managers.BrowserManager;
import dev.backup.kushal.frameWork.com.yantra.paraBank.project.PO.PO_LoginParaBank;
import dev.backup.kushal.frameWork.com.yantra.paraBank.project.resuability.ReusabilityMethod;

public class TC_login {
	public WebDriver driver;
	private Config Config;
	private HashMap<String,String> CONFIG_DATA;
	public String username;
	public String password;
	public String currentTitle;
	String expectedTitle;
	private String actualPageMessage;
	private String expectedPageMessage;

@BeforeClass
	public void TestSetUpBeforeEachTest() throws IOException {
		Config = new Config();
		CONFIG_DATA = Config.CONFIG_DATA();
	}
	
@AfterTest
	public void closedAllBrowser() {
			driver.quit();
		}
	
	@Parameters({"browser","url"})
	@Test(groups= {"smoke","regression"})
	public void tc_01_validate_parabank_login(@Optional("chrome") String browser_name,@Optional("")String url) throws IOException{
		try {
			BrowserManager oBrowserManager = new BrowserManager();
			WebDriver driver = oBrowserManager.GetBrowser(browser_name);
			oBrowserManager.NavigateToPage(driver, url);
			PO_LoginParaBank loginpage=PageFactory.initElements(driver,PO_LoginParaBank.class);
			username =  CONFIG_DATA.get("USERNAME");
			password = CONFIG_DATA.get("PASSWORD");
			loginpage.kw_login_into_parabank(username,password,true);
			ReusabilityMethod.writeLogsMessage("PASSED","UserName and PassWord Set successfully with text:\t"+ username + "\tand\t"+password);
			
			System.out.println("*********************************************************************************************************************************\t\tCONFIRMATION OF THE PAGE MESSAGE AND TITLE AFTER LOGIN\t\t*******************************************************************************************************************************************************\n\n");
					JavascriptExecutor js = (JavascriptExecutor) driver;
					currentTitle = "ParaBank | Accounts Overview";
					expectedTitle = (String)js.executeScript("return document.title");
					
					actualPageMessage = "Welcome John Smith";
					expectedPageMessage = driver.findElement(By.className("smallText")).getText();
					
					Assert.assertEquals(currentTitle, expectedTitle);
					Assert.assertEquals(actualPageMessage, expectedPageMessage);
					
					System.out.println("Current and exprected title are match successfully\t" +currentTitle+ "\t" +expectedTitle);
					System.out.println("Current and expected page message are same \t" + actualPageMessage +"\t"+ expectedPageMessage);
			
					System.out.println("*************************************************************************************************************************************************\tEND\t**************************************************************************************************************************************************************\n\n");
			Thread.sleep(2000);
			driver.quit();

		}catch(NoSuchElementException | InterruptedException ob) {
			ReusabilityMethod.writeLogsMessage("FAILED","UserName and PassWord do not Set with text:\t"+ username + password + 
					"Due to Wrong username and password "+ ob.toString());
		}
	}

	@Parameters({"browser","url"})
	//@Test(groups= {"smoke","regression"}Priority=1)
	@Test(groups= {"smoke","regression"})
	public void tc_02_validate_parabank_login_with_wrong_username(@Optional("chrome") String browser_name,@Optional("")String url) throws IOException{
		try{
			BrowserManager oBrowserManager = new BrowserManager();
			WebDriver driver = oBrowserManager.GetBrowser(browser_name);
			oBrowserManager.NavigateToPage(driver, url);
			PO_LoginParaBank loginpage=PageFactory.initElements(driver,PO_LoginParaBank.class);
			username =  "Kushal";
			password = "demo";
			loginpage.kw_login_into_parabank(username,password,true);
			if(username.equals("john")) {
				ReusabilityMethod.writeLogsMessage("PASSED","UserName and PassWord Set successfully with text:\t"+ 
				username + "\tand\t"+password);

			}else { try {
							ReusabilityMethod.writeLogsMessage("FAILED","UserName and PassWord do not Set with text:\t"+ 
							username + "\tand\t" +password);
						} catch(NoSuchElementException ob) {
							ob.printStackTrace();
						}
			      }
			System.out.println("*********************************************************************************************************************************\t\tCONFIRMATION OF THE PAGE MESSAGE AND TITLE AFTER LOGIN\t\t*******************************************************************************************************************************************************\n\n");
					JavascriptExecutor js = (JavascriptExecutor) driver;
					currentTitle = "ParaBank | Accounts Overview";
					actualPageMessage = "Welcome John Smith";

					expectedTitle = (String)js.executeScript("return document.title");
					expectedPageMessage = driver.findElement(By.className("smallText")).getText();
			
					Assert.assertEquals(currentTitle, expectedTitle);
					Assert.assertEquals(actualPageMessage, expectedPageMessage);
					
					System.out.println("Current and exprected title are match successfully\t" +currentTitle+ "\t" +expectedTitle);
					System.out.println("Current and expected page message are same \t" + actualPageMessage +"\t"+ expectedPageMessage);
		
			System.out.println("*************************************************************************************************************************************************\tEND\t**************************************************************************************************************************************************************\n\n");
			Thread.sleep(2000);
			driver.quit();

		}catch(NoSuchElementException | InterruptedException ob) {
			ReusabilityMethod.writeLogsMessage("FAILED","UserName and PassWord do not Set with text:\t"+ username +"\tand\t"+ password + ob.toString());
		}
	}
	
	@Parameters({"browser","url"})
	//@Test(groups= {"smoke","regression"}Priority=1)
	@Test(groups= {"smoke","regression"})
	public void tc_03_validate_parabank_login_with_blank_pasword(@Optional("chrome") String browser_name,@Optional("")String url) throws IOException{
		try{
			BrowserManager oBrowserManager = new BrowserManager();
			WebDriver driver = oBrowserManager.GetBrowser(browser_name);
			oBrowserManager.NavigateToPage(driver, url);
			PO_LoginParaBank loginpage=PageFactory.initElements(driver,PO_LoginParaBank.class);
			username =  "Kushal";
			password = "";
			loginpage.kw_login_into_parabank(username,password,true);
			if(username.equals("john")) {
				ReusabilityMethod.writeLogsMessage("PASSED","UserName and PassWord Set successfully with text:\t"+ 
				username + "\tand\t"+password);

			}else { try {
							ReusabilityMethod.writeLogsMessage("FAILED","UserName and PassWord do not Set with text:\t"+ 
							username + "\tand\t" +password);
						} catch(NoSuchElementException ob) {
							ob.printStackTrace();
						}
			      }
			System.out.println("*********************************************************************************************************************************\t\tCONFIRMATION OF THE PAGE MESSAGE AND TITLE AFTER LOGIN\t\t*******************************************************************************************************************************************************\n\n");
					JavascriptExecutor js = (JavascriptExecutor) driver;
					currentTitle = "ParaBank | Accounts Overview";
					actualPageMessage = "Welcome John Smith";
					
					expectedTitle = (String)js.executeScript("return document.title");
					expectedPageMessage = driver.findElement(By.className("smallText")).getText();
				
					Assert.assertEquals(currentTitle, expectedTitle);
					Assert.assertEquals(actualPageMessage, expectedPageMessage);
					
					System.out.println("Current and exprected title are match successfully\t" +currentTitle+ "\t" +expectedTitle);
					System.out.println("Current and expected page message are same \t" + actualPageMessage +"\t"+ expectedPageMessage);
			System.out.println("*************************************************************************************************************************************************\tEND\t**************************************************************************************************************************************************************\n\n");
			Thread.sleep(2000);
			driver.quit();

		}catch(NoSuchElementException | InterruptedException ob) {
			ReusabilityMethod.writeLogsMessage("FAILED","UserName and PassWord do not Set with text:\t"+ username +"\tand\t"+ password + ob.toString());
		}
	}
	
	@Parameters({"browser","url"})
	//@Test(groups= {"smoke","regression"}Priority=1)
	@Test(groups= {"smoke","regression"})
	public void tc_04_validate_parabank_login_with_blank_username(@Optional("chrome") String browser_name,@Optional("")String url) throws IOException{
		try{
			BrowserManager oBrowserManager = new BrowserManager();
			WebDriver driver = oBrowserManager.GetBrowser(browser_name);
			oBrowserManager.NavigateToPage(driver, url);
			PO_LoginParaBank loginpage=PageFactory.initElements(driver,PO_LoginParaBank.class);
			username =  "";
			password = "demo";
			loginpage.kw_login_into_parabank(username,password,true);
			if(username.equals("john")) {
				ReusabilityMethod.writeLogsMessage("PASSED","UserName and PassWord Set successfully with text:\t"+ 
				username + "\tand\t"+password);

			}else { try {
							ReusabilityMethod.writeLogsMessage("FAILED","UserName and PassWord do not Set with text:\t"+ 
							username + "\tand\t" +password);
						} catch(NoSuchElementException ob) {
							ob.printStackTrace();
						}
			      }
			System.out.println("*********************************************************************************************************************************\t\tCONFIRMATION OF THE PAGE MESSAGE AND TITLE AFTER LOGIN\t\t*******************************************************************************************************************************************************\n\n");
					JavascriptExecutor js = (JavascriptExecutor) driver;
					currentTitle = "ParaBank | Accounts Overview";
					actualPageMessage = "Welcome John Smith";
					
					expectedTitle = (String)js.executeScript("return document.title");
					expectedPageMessage = driver.findElement(By.className("smallText")).getText();
				
					Assert.assertEquals(currentTitle, expectedTitle);
					Assert.assertEquals(actualPageMessage, expectedPageMessage);
					
					System.out.println("Current and exprected title are match successfully\t" +currentTitle+ "\t" +expectedTitle);
					System.out.println("Current and expected page message are same \t" + actualPageMessage +"\t"+ expectedPageMessage);
				
				System.out.println("*************************************************************************************************************************************************\tEND\t**************************************************************************************************************************************************************\n\n");
			Thread.sleep(2000);
			driver.quit();

		}catch(NoSuchElementException | InterruptedException ob) {
			ReusabilityMethod.writeLogsMessage("FAILED","UserName and PassWord do not Set with text:\t"+ username +"\tand\t"+ password + ob.toString());
		}
	}
	
	@Parameters({"browser","url"})
	//@Test(groups= {"smoke","regression"}Priority=1)
	@Test(groups= {"smoke","regression"})
	public void tc_05_validate_parabank_login_with_wrong_password(@Optional("chrome") String browser_name,@Optional("")String url) throws IOException{
		try{
			BrowserManager oBrowserManager = new BrowserManager();
			WebDriver driver = oBrowserManager.GetBrowser(browser_name);
			oBrowserManager.NavigateToPage(driver, url);
			PO_LoginParaBank loginpage=PageFactory.initElements(driver,PO_LoginParaBank.class);
			username =  "john";
			password = "kushal";
			loginpage.kw_login_into_parabank(username,password,true);
			if(username.equals("john")) {
				ReusabilityMethod.writeLogsMessage("PASSED","UserName and PassWord Set successfully with text:\t"+ 
				username + "\tand\t"+password);

			}else { try {
							ReusabilityMethod.writeLogsMessage("FAILED","UserName and PassWord do not Set with text:\t"+ 
							username + "\tand\t" +password);
						} catch(NoSuchElementException ob) {
							ob.printStackTrace();
						}
			      }
			System.out.println("*********************************************************************************************************************************\t\tCONFIRMATION OF THE PAGE MESSAGE AND TITLE AFTER LOGIN\t\t*******************************************************************************************************************************************************\n\n");
					JavascriptExecutor js = (JavascriptExecutor) driver;
					currentTitle = "ParaBank | Accounts Overview";
					actualPageMessage = "Welcome John Smith";
					
					expectedTitle = (String)js.executeScript("return document.title");
					expectedPageMessage = driver.findElement(By.className("smallText")).getText();
				
					Assert.assertEquals(currentTitle, expectedTitle);
					Assert.assertEquals(actualPageMessage, expectedPageMessage);
					
					System.out.println("Current and exprected title are match successfully\t" +currentTitle+ "\t" +expectedTitle);
					System.out.println("Current and expected page message are same \t" + actualPageMessage +"\t"+ expectedPageMessage);
				
				System.out.println("*************************************************************************************************************************************************\tEND\t**************************************************************************************************************************************************************\n\n");
			Thread.sleep(2000);
			driver.quit();

		}catch(NoSuchElementException | InterruptedException ob) {
			ReusabilityMethod.writeLogsMessage("FAILED","UserName and PassWord do not Set with text:\t"+ username +"\tand\t"+ password + ob.toString());
		}
	}
	
}

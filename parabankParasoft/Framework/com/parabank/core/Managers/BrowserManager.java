/**
 * 
 */
package dev.backup.kushal.frameWork.com.yantra.core.managers;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.yantra.core.interfaces.ILogAndReport;
import com.yantra.driver.Config;

/**
 * @author akashtyagi
 *
 */
public class BrowserManager implements ILogAndReport {
	
	final Logger logger = Logger.getLogger(BrowserManager.class);

	public WebDriver GetBrowser(String _sBrowserName) throws IOException{
		Config config = new Config();
		HashMap<String,String> config_data = config.CONFIG_DATA();
		WebDriver driver= null;
		
		switch(_sBrowserName.toLowerCase()){
		case "chrome" :
			
			if (System.getProperty("os.name").equals("Mac OS X")){
				System.setProperty("webdriver.chrome.driver", "/Users/akashtyagi/Dropbox/AutoWorkspace/dependencies/chromedriver");
			}else{
				System.setProperty("webdriver.chrome.driver", config_data.get("CHROME_DRIVER_EXE_PATH"));
			}  
			
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", config_data.get("FIREFOX_DRIVER_EXE_PATH"));
			driver = new FirefoxDriver();
			break;
		}
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WriteLogAndReport(logger, "info", "pass", "Browser Invoked. Type: " + _sBrowserName );
		return driver;
	}//end method
	
	public boolean NavigateToPage(WebDriver driver, String url){
		driver.navigate().to(url);
		WriteLogAndReport(logger, "info", "pass", "Navigation to Url successfull : " + url);
		return true;
	}//end method
	
	
}//end class

/**
 * 
 */
package dev.backup.kushal.frameWork.com.yantra.paraBank.project.resuability;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * @author kushal
 *
 */
public class ReusabilityMethod {
	
	public static void writeLogsMessage(String logtypes , String message) {
		System.out.println(logtypes+  "  ,  " + message);
	}

	private static WebDriver driver;
	
	public static void writePageMessage(String actualTitle ,String actualPageMessage) {
		
		System.out.println("*********************************************************************************************************************************\tPAGE CONFIRM MESSAGE AND TITLE AFTER LOGIN\t*********************************************"
				+ "**********************************************************************************************************\n\n");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		actualTitle = "ParaBank | Accounts Overview";
		String expectedTitle = (String)js.executeScript("return document.title");
		
		actualPageMessage = "Welcome John Smith";
		String expectedPageMessage = driver.findElement(By.className("smallText")).getText();
		if(actualTitle.equalsIgnoreCase(expectedTitle) && actualPageMessage.equalsIgnoreCase(expectedPageMessage)) {
			System.out.println("Current and exprected title are match successfully\t" +actualTitle+ "\t" +expectedTitle);
			System.out.println("Current and expected page message are same \t" + actualPageMessage +"\t"+ expectedPageMessage);
			System.out.println("*************************************************************************************************"
					+ "********************************************************************************************************"
					+ "**********************************************************************************************************\n\n");
		} else {
			System.out.println("Both Title are do not match....!.........");
		}
	}
}

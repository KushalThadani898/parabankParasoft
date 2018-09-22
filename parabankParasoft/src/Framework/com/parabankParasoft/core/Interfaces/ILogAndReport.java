/**
 * 
 */
package Framework.com.parabankParasoft.core.Interfaces;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * @author Kushal Thadani
 * new version
 
 *
 */
public interface ILogAndReport {

	//@arguments: logger=>log4j object
	//			  sLogLevel=>info, trace, warn, debug
	//			  sLogType: pass, fail, fail_not_exit, warn, pass_no_screenshot, fail_no_screenshot, fail_not_exit_no_screenshot
	public default void WriteLogAndReport(Logger logger, String sLogLevel, String sLogType, String sMessage){
		//System.out.println("Log level:" + sLogType + " Message: " + sMessage);
		String msg = "LogLevel:" + sLogLevel + " LogType: " + sLogType + " Message: " + sMessage;
		
		switch(sLogType.toLowerCase()) {
		
		case "pass":
			Reporter.log(msg);
			Assert.assertEquals(true, true);
			break;
		case "fail":
			Reporter.log(msg);
			Assert.fail(msg);
			break;
		}
		

		switch ( sLogLevel.toLowerCase() ){
		case "info":
			logger.info("Report Log Type: "+ sLogType + " Message: " + sMessage);
			break;
		case "trace":
			logger.trace("Report Log Type: "+ sLogType + " Message: " + sMessage);
			break;
		case "debug":
			logger.debug("Report Log Type: "+ sLogType + " Message: " + sMessage);
			break;
		case "warn":
			logger.warn("Report Log Type: "+ sLogType + " Message: " + sMessage);
			break;			
		}
		
	}
}

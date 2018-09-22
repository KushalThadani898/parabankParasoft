package Framework.com.parabankParasoft.driver;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHashMapHandle {

	public WebTableHashMapHandle() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\VisionITWorkspace\\dependencies\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
		WebElement o_account_table  = driver.findElement(By.id("accountTable"));
		
		List<WebElement> o_col_rows = o_account_table.findElements(By.tagName("tr"));
		int i_row_count = o_col_rows.size();
		List<WebElement> o_col_clms;
		int i_clm_count;
		String cell_text;
		//HashMap<Integer,HashMap<Integer,String>> o = new 
		
		HashMap<Integer, HashMap<Integer, String>> result_map= new HashMap<Integer,HashMap<Integer,String>>();
		HashMap<Integer, String> o_col_map=null;;
		
		for (int i=0;i<i_row_count;i++) {
			o_col_clms = o_col_rows.get(i).findElements(By.tagName("td"));
			i_clm_count = o_col_clms.size();
			for(int j=0;j<i_clm_count;j++) {
				cell_text = o_col_clms.get(j).getText();
				//System.out.println(cell_text);
				o_col_map.put(j, cell_text);
			}
			result_map.put(i, o_col_map);
		}
		

	
		
		
		
		
	}

}

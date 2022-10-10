import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

//This class is used to setup the driver
public class DriverSetup {
	
	private static WebDriver driver;
	
	//firefox browser opening
	public WebDriver startFirefoxBrowser()
	{
		  String path=System.getProperty("user.dir");
	      String setpath=path+"\\driver\\geckodriver.exe";
	      
	      System.setProperty("webdriver.gecko.driver", setpath);
	      
	      FirefoxOptions fo=new FirefoxOptions();
		  //disable notifications
	      fo.addPreference("dom.webnotifications.enabled", false);

			
		  driver=new FirefoxDriver(fo);
			
		  //maximizing the browser window
		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
		  //navigating to https://www.snapdeal.com/
		  driver.get("https://www.snapdeal.com/");
			
		  return driver; 
	      
	}
	
	//Chrome browser opening
	public WebDriver startChromeBrowser()
	{
		
		    String path=System.getProperty("user.dir");  
	        String setpath=path+"\\driver\\chromedriver_win32\\chromedriver.exe";
	      
	        System.setProperty("webdriver.chrome.driver", setpath);
	      
	        ChromeOptions co=new ChromeOptions();
			//disable notifications
			co.addArguments("disable-notifications");
			
			driver=new ChromeDriver(co);
			
			//maximizing the browser window
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			//navigating to https://www.snapdeal.com/
			driver.get("https://www.snapdeal.com/");
			
			return driver; 
	}
	
	//closing browser
	public void CloseBrowser() {
		driver.close();
	}
	

}

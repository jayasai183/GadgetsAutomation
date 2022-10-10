import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.*;


public class GadgetAuto {
	
	public static WebDriver driver;
	
	//This method is used for searching the item "Bluetooth headphone"
	public void search(String item)
	{
		driver.findElement(By.name("keyword")).sendKeys(item);
		driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[2]/button/span")).click();
		
		//setting sortby to popularity
		driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[5]/div[3]/div[1]/div/div[2]/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[5]/div[3]/div[1]/div/div[2]/ul/li[2]")).click();
	}
	
	//This method is used for setting up the price from 700 to 1400
	public void setValue(String from,String to)
	{
		driver.findElement(By.name("fromVal")).clear();
		driver.findElement(By.name("fromVal")).sendKeys(from);
		driver.findElement(By.name("toVal")).clear();
		driver.findElement(By.name("toVal")).sendKeys(to);
		driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[4]/div/div[1]/div[2]/div[2]/div[3]/div/div[5]")).click();
	}
	
	//This method is used for getting the title and price values of first 5 shown results
	public void getTitleAndPrice()
	{
		System.out.println(driver.findElement(By.xpath("//*[@data-js-pos=\"0\"]//p")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@data-js-pos=\"0\"]//span[@class=\"lfloat product-price\"]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@data-js-pos=\"1\"]//p")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@data-js-pos=\"1\"]//span[@class=\"lfloat product-price\"]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@data-js-pos=\"2\"]//p")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@data-js-pos=\"2\"]//span[@class=\"lfloat product-price\"]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@data-js-pos=\"3\"]//p")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@data-js-pos=\"3\"]//span[@class=\"lfloat product-price\"]")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@data-js-pos=\"4\"]//p")).getText());
		System.out.println(driver.findElement(By.xpath("//*[@data-js-pos=\"4\"]//span[@class=\"lfloat product-price\"]")).getText());
	}
	
	
	//Main method
	public static void main(String[] args) throws InterruptedException
	{
		  DriverSetup browser=new DriverSetup();
		  Scanner sc=new Scanner(System.in);
	      System.out.println("Enter the browser name i.e., select one from 'chrome/firefox'");
	      String enterbrowser=sc.nextLine();
	      sc.close();
	      
	      if(enterbrowser.equalsIgnoreCase("firefox"))
	      {
	    	  System.out.println("Firefox browser is running successfully");
	    	  driver=browser.startFirefoxBrowser();
	      }
	      else if(enterbrowser.equalsIgnoreCase("chrome"))
	      {
	    	  System.out.println("chrome browser is running successfully");
	    	  driver=browser.startChromeBrowser();
	      }
	      else
	      {
	    	  System.out.println("Type the browser name from chrome/firefox");
	      }
		
		  GadgetAuto g=new GadgetAuto();
		  g.search("Bluetooth headphone");
		  g.setValue("700","1400");
          Thread.sleep(3000);
		  g.getTitleAndPrice();
		  browser.CloseBrowser();
		
	}
}

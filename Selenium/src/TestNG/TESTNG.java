package TestNG;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TESTNG {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors  = new StringBuffer(); 
	/*A string buffer is like a String, but can be modified.
	 It contains some particular sequence of characters,
	 but the length and content of the sequence can be changed through certain method calls.		 
	 */
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		driver = new ChromeDriver();
		baseUrl = "https://www.facebook.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void Test1()
	{
		driver.get(baseUrl);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("TESTERE");
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("KJDOID");
		driver.findElement(By.name("login")).click();
	}
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if(!"".equals(verificationErrorString))
		{
			fail(verificationErrorString);
			System.out.println("did this execute? aftertest");
		}
	}
	private boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
			
		}
	}
	private boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
			catch(NoSuchElementException e)
			{
				return false;
				
			}

		}
	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	
	}
	
	



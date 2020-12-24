package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest1 {
  WebDriver driver;
	@BeforeTest
  public void launch()
  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
	  driver =new ChromeDriver(); 
	  driver.get("https://www.google.com");
	  driver.manage().window().maximize();
  }
	@Test
  public void validateTitle() {
		String ExpectedlTitle = "Google";
		String ActualTitle;
		ActualTitle = driver.getTitle();
		
		if(ExpectedlTitle.equals(ActualTitle))
		{
			System.out.println("The title of the page matches with Expected Title, therefore, Test Passed");
			
		}
		else
		{
			System.out.println("Actual Title does not match with Expected Title, test Case Failed");
		}
  }
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("Browser closed!");
		driver.close();
	}
}

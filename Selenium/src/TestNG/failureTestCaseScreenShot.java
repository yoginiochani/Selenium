package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

//import com.sun.beans.introspect.PropertyInfo.Name;

public class failureTestCaseScreenShot {
	WebDriver driver;
	
	@BeforeTest
	public void configuration()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Yogini\\geckoDriver\\geckodriver-v0.28.0-win64\\geckodriver.exe"); //location of browser in local drive
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		System.out.println("configuration is done");
	}

	//There are two test cases, one openBrowser() and other input field for userName()
	@Test
	public void openBrowser()
	{
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		System.out.println("window is maximized");
	}
	
	@Test(testName = "userName")
	public void userName()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("I am in userName method");
		WebElement name = driver.findElement(By.id("identifierI")); //intensionally gave wrong name element value, so it will take screenshot of failed test case  
		name.sendKeys("yogini");
		
		
	}
	
	@AfterMethod  //this will run after all the @test are ran first.
	public void FailureTestcaseIfAny(ITestResult result)
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			//failureTestCaseScreenShot_FileNames.captureScreenshot(driver, result.getName());
			failureTestCaseScreenShot_FileNames.captureScreenshot(driver, result.getName()); //this line will print the testcase name if test case is failed
		}
		
		if(ITestResult.SUCCESS == result.SKIP) //this code will skip if the test case is passed, openBrowser() test case is passed, so it will not capture screenshot.
		{
			failureTestCaseScreenShot_FileNames.captureScreenshot(driver, result.getName()); //this line will print the testcase name if it is passed.
			//failureTestCaseScreenShot_FileNames.captureScreenshot(driver, result.getTestName());
			System.out.println("this is executed");
		}
		driver.close();
	}
	

	
}

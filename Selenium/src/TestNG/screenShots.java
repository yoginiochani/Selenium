package TestNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;





public class screenShots {
    WebDriver driver;
    
	@BeforeTest
	public void config()
	{
	System.setProperty("webdriver.gecko.driver", "C:\\Yogini\\geckoDriver\\geckodriver-v0.28.0-win64\\geckodriver.exe"); //location of browser in local drive
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	driver = new FirefoxDriver();
	}
	
	@Test        //this program takes screenshots after every action. two screenshots will be taken in this code. facebook page and facebook page with username
	public void openbrowser() throws IOException
	{
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		screenShots_fileNames.captureScreenshots(driver, "facebookPage");  //fileNames is class and calling method from that class and giving filename for captured screenshot.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(By.name("email")).sendKeys("QA automation");
		screenShots_fileNames.captureScreenshots(driver, "facebookPageWithUsername"); //this will create one more file called facebookUsername and store screenshot in this file.
		
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}

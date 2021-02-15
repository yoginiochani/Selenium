package TestNG;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakeFullPageScreenshot {
	
	WebDriver driver;
	
	@BeforeTest
	public void fullPageScreenshot()
	{
	System.setProperty("webdriver.gecko.driver", "C:\\Yogini\\geckoDriver\\geckodriver-v0.28.0-win64\\geckodriver.exe"); //location of browser in local drive
	System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	driver = new FirefoxDriver();
	}
	
	@Test
	public void openbrowser() throws IOException
	{
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("email")).sendKeys("QA automation");
		
		TakesScreenshot  scrshot =  ((TakesScreenshot) driver); //TakesScreenshot is an interface, you can't create object of interface, so we haveto create like this. typecast it.
		File srcFile = scrshot.getScreenshotAs(OutputType.FILE); //it will keep in memory and store it in file called srcFile. 
		
		FileUtils.copyFile(srcFile, new File("./screenShots/homefacebook.png")); //because the folder is in this project, I hav user ./foldername/imagename
		System.out.println("Screenshot captured");                           //homefacebook screen shot is in the screenshots folder.
		driver.close();
		
	}

}

package TestNG;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.ITestResult;
import org.testng.annotations.*;



public class elementsScreenshots {

	
	WebDriver driver;
	
	@BeforeTest
	public void config()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Yogini\\geckoDriver\\geckodriver-v0.28.0-win64\\geckodriver.exe"); //location of browser in local drive
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
	}
	
	@Test (priority = 0)
	public void browser()
	{
		
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(priority = 1)
	public void facebookUername() throws IOException 
	{
		WebElement username = driver.findElement(By.id("email"));
		System.out.println("I am in facebookUsername method");
		
		File sourceFile = username.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("./screenShots/username.png"));// this line will store the empty username textbox an store it in screenShots folder with username.png name
		
		username.sendKeys("Yogini"); 
		File sourceFile2 = username.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile2, new File("./screenShots/usernameInput.png")); //store username image with input field and give name as usernameInput.png. this image will be stored in screenShots folder.
	}
	
	@Test (priority = 2)
	public void facebookPassword() throws IOException, InterruptedException
	{
		WebElement password = driver.findElement(By.id("pass"));
		File pswdsourceFile = password.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pswdsourceFile, new File("./screenShots/emptypasswordField.png")); //screenshot of password field before any input
		Thread.sleep(1000);
		
		password.sendKeys("Yogini");
		File pswdsourceFile2 = password.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pswdsourceFile2, new File("./screenShots/passwordFieldInput.png"));//screenshot of password field after input field
		
		Thread.sleep(2000);
	}
	
	@Test (priority = 3)
	public void loginButton() throws IOException
	{
		WebElement button = driver.findElement(By.name("login"));
		button.click();
		File buttonsource = button.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(buttonsource, new File("./screenShots/button.png"));
	}
	
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	
	/*@Test
	public void facebookPassword() throws IOException
	{
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("Yogini");
		File sourceFile = password.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("./screenShots/FBpassword.png"));
		
	}
	@Test
	public void loginButton() throws IOException
	{
		WebElement button = driver.findElement(By.id("loginbutton"));
		button.click(); //wrong id value
		File sourceFile = button.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("./screenShots/button.png"));
		
	}*/
	
	
}	

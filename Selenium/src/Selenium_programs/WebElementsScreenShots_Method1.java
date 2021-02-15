package Selenium_programs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//There is also TestNG class in TestNG Package where I've created program to take screenshots of webElement and whole screen. take a look it in package.

public class WebElementsScreenShots_Method1 {

	public static void main(String[] args) throws IOException
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.indeed.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //this line means it will wait for 30 second before throwing an exception error if any
		
		driver.findElement(By.linkText("Sign in")).click();
		
		WebElement username = driver.findElement(By.id("login-email-input"));
		WebElement password = driver.findElement(By.id("login-password-input"));
		WebElement button = driver.findElement(By.xpath("//*[@id=\"login-submit-button\"]"));
		
		
		username.sendKeys("yogini2413@gmail.com");
		password.sendKeys("Magnus@123");
		
		takeElementScreenshot(username,"username");  //taking screenshot 
		takeElementScreenshot(password, "password");  //taking screenshot
		takeElementScreenshot(button, "button");  //clicking singIn button
		
		driver.close();
	}
	
	public static void takeElementScreenshot(WebElement element, String fileName) throws IOException
	{
		File pswdsourceFile = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pswdsourceFile, new File("./Selenium/"+fileName+".png")); //created folder named Selenium in project and added three screenshots to it.
		                                                                              //username.png, password.png, button.png
		
	}	

}



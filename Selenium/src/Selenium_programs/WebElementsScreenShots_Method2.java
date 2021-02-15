package Selenium_programs;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElementsScreenShots_Method2
{

	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
	driver =new ChromeDriver(); 
	driver.manage().window().maximize();
	
	
	driver.get("https://www.dice.com/");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//ul/li[3]/a[@id=\"navbarDropdown-11\"]")).click();
	driver.findElement(By.xpath("//div/a[1][contains(text(),'Login')]")).click();
	
	WebElement email = driver.findElement(By.id("email"));
	WebElement password = driver.findElement(By.id("password"));
	WebElement signInbutton = driver.findElement(By.xpath("//div/button[contains(text(),'Sign In')]"));
	
	email.sendKeys("yogini2413@gmail.com");
	password.sendKeys("Magnus@123");
	
	
	takeElementScreenshot(email,"email"); //taking screenshot after entring username
	takeElementScreenshot(password,"password");  //taking screenshot after entering password
	Thread.sleep(2000);  
	 
	signInbutton.click();  //clicked signIn button
	TakesScreenshot homepage = ((TakesScreenshot)driver);  //now taking whole webpage screenshot after logging in to dice
	File homepage1 = homepage.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(homepage1, new File("./Selenium/homepage.png"));
	
	driver.close();
	}
	
	public static void takeElementScreenshot(WebElement element, String fileName) throws IOException //created method, this method is used for
	{																		//any webelement screenshot you want it for.  
		TakesScreenshot scrshot = ((TakesScreenshot)element);
		File srcFile = scrshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./Selenium/"+fileName+".png"));
		
	}
	//signInbutton.click();
	
		/*TakesScreenshot  scrshot =  ((TakesScreenshot) driver); //TakesScreenshot is an interface, you can't create object of interface, so we haveto create like this. typecast it.
		File srcFile = scrshot.getScreenshotAs(OutputType.FILE); //it will keep in memory and store it in file called srcFile. 
		
		FileUtils.copyFile(srcFile, new File("./screenShots/homefacebook.png")); //because the folder is in this project, I hav user ./foldername/imagename
		System.out.println("Screenshot captured");                           //homefacebook screen shot is in the screenshots folder.
	//	driver.close();
		*/
}





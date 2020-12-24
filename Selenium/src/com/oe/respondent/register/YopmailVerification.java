package com.oe.respondent.register;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class YopmailVerification {
	
	WebDriver driver;
    
	public void invokeBrowser()
	{
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
		//	driver.get("https://dev.opinioneconomy.io/login");
			driver.get("http://www.yopmail.com/en/");
			yop_login();
		//	admin_login();
			Thread.sleep(3000);
			//admin_logout();
		   } 
		catch (Exception e) {
			e.printStackTrace();
			}
			
	}
	public void yop_login() throws InterruptedException
	{
		driver.findElement(By.id("login")).sendKeys("devca5");
		driver.findElement(By.className("sbut")).click();
		System.out.println("Previous line executed");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Welcome to OEB Platform")).click();
		System.out.println("Welcome to OEB did not execute");
		
		Thread.sleep(3000);
		//System.out.println("Previous line executed");
		driver.findElement(By.linkText("Please click here to verify your email")).click();
		//driver.findElement(By.className("lmfd").className("lms").name("Welcome to OEB Platform")).click();
		//driver.findElement(By.linkText("click here to verify your email")).click();
		//driver.findElement(By.xpath("//html//body//div//button[@class='m'][@id='m8']//button[@class='um']//button[@class='lms'][@type='Welcome to OEB Platform']")).click();
		
		//driver.findElement(By.className("m")).click();
		//driver.findElement(By.id("m3")).click();
		
		
		//driver.findlink(By.linkText("click here to verify your email")).click();
				
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		driver.findElement(By.linkText("nofollow")).click();
		
	}
	private RemoteWebElement findlink(By linkText) {
		// TODO Auto-generated method stub
		return null;
	}
	/*public void admin_login()
	{
	 try {
		driver.findElement(By.id("email")).sendKeys("oebadmin@yopmail.com");
		 driver.findElement(By.id("password")).sendKeys("oeb@1234");
		 Thread.sleep(3000);    //sleeps for 3 seconds before next line executes
		 driver.findElement(By.className("btn-wrapper")).click();
		 
		 	} catch (InterruptedException e) {
		e.printStackTrace();
		 	}
	 
	}
	public void admin_logout()
	{
		driver.findElement(By.className("user-name")).click();
		driver.findElement(By.ByLinkText.linkText("Logout")).click();
	}*/
	
public static void main(String[] args)
{
		
		YopmailVerification obj = new YopmailVerification();
		obj.invokeBrowser();
			
	}

}

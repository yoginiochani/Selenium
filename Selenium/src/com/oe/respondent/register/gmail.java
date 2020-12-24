package com.oe.respondent.register;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class gmail {
	
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
			
		
			driver.get("https://accounts.google.com/ServiceLogin/identifier?hl=en&passive=true&continue=https%3A%2F%2Fwww.google.com%2F&flowName=GlifWebSignIn&flowEntry=AddSession");
			gmail_login();
		
			Thread.sleep(3000);
		
		   } 
		catch (Exception e) {
			e.printStackTrace();
			}
			
	}
	public void gmail_login() throws InterruptedException
	{
		driver.findElement(By.id("identifierId")).sendKeys("yoginiochani@gmail.com");
		//driver.findElement(By.className("VfPpkd-Jh9lGc")).click();
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click(); //this line will click on next button
		//driver.get("1234");
		
		//System.out.println("Previous line executed");
		//Thread.sleep(3000);
		//driver.findElement(By.linkText("Welcome to OEB Platform")).click();
		
	}	
			
public static void main(String[] args)
{
		
		gmail obj = new gmail();
		obj.invokeBrowser();
			
	}

}

package Selenium_programs;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserNavigationCommands {
	WebDriver driver; //created object of the webdriver
	public void invokeBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	public void google() throws InterruptedException
	{
		//driver.get("https://google.com");
		driver.navigate().to("https://google.com"); //this line can also be used to get to google page.
													//by using this line, it holds the history of your navigation
		Thread.sleep(2000);
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		System.out.println("The title of the webpage is " + title);
		System.out.println("The url is " + url);
	    driver.findElement(By.linkText("Images")).click();	//<a> tag refers that its link and linktext is the name of the link.
	    Thread.sleep(2000);
	    System.out.println(driver.getTitle());
	    Thread.sleep(2000);
	    driver.navigate().back(); //this line will take one step back and go back to google page.
	    Thread.sleep(2000);
	    driver.navigate().forward();// this will go forward
	    Thread.sleep(2000);
	    driver.navigate().refresh(); //this will refresh the page
	   // driver.close(); //it will close the current window.
	    //driver.quit(); //quit means it will close all the windows.
	}   
	
	
	public void amazon() throws InterruptedException
	{
		driver.navigate().to("https://www.amazon.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Gift Cards")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		String title = driver.getTitle();
		System.out.println("The title of the webpage is: " +title);
		driver.navigate().refresh();
		
		//Amazon India
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Mobiles")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().forward();
		Thread.sleep(2000);
		String titleName = driver.getTitle();
		System.out.println("Now the new title of amazon is:" +titleName);
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		browserNavigationCommands obj = new browserNavigationCommands(); //name of java class to create object.
		obj.invokeBrowser();   //using object to call invokeBrowser() method
		obj.google();
		obj.amazon();	
	}

}

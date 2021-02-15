package Selenium_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class keyboardKeysActions {
	WebDriver driver;

	public void invokeBrowser()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
	driver =new ChromeDriver(); 
	}
	
	public void enterFromKeyboard()
	{
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Automation");
		//below two lines will click on the enter button from keyboard.
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		
		//driver.close();
	}
	
	public void copyAndPaste() throws InterruptedException
	{
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]")).click();   //this line will get the element location on google page.
		Actions action = new Actions(driver);
		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).perform();  //this line will perform control-A. select all action
		Thread.sleep(2000);
		action.sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();  //this line will copy everything that is selected
		Thread.sleep(1000);
		driver.findElement(By.name("q")).click();  //this line will click on search box
		Thread.sleep(2000);
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();  //this line will paste everything in search box
		
	}

	public static void main(String[] args) throws InterruptedException
	{
	keyboardKeysActions obj = new keyboardKeysActions();	
	obj.invokeBrowser();
	obj.enterFromKeyboard();
	obj.copyAndPaste();
	}

}

package Selenium_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mouseOver {
	WebDriver driver;

	void invokeBrowser()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
	driver =new ChromeDriver(); 
	}

	
	public void google_search() throws InterruptedException
	{
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Way2automation");
		Thread.sleep(2000);
		
		driver.findElement(By.name("btnK")).click();
		//WebDriverWait wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/div/cite[contains(text(),'www.way2automation.com')]"))).click();
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3/span")).click();
	}
	
	public void way2Automation() throws InterruptedException
	{
		WebElement apiTesting = driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[4]/a[contains(text(),'API Testing')]"));
		Actions action = new Actions(driver);
		action.moveToElement(apiTesting).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[4]/ul/li[5]/a")).click();
		driver.close();
		
		
	}
	public static void main(String[] args) throws InterruptedException
	{

		mouseOver object = new mouseOver();
		object.invokeBrowser();
		object.google_search();
		object.way2Automation();
		
 }
}

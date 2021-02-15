package moneyGaming;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Selenium_programs.chromeBrowser;

public class userRegistration 
{
	WebDriver driver; 
	public void invokeBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://moneygaming.qa.gameaccount.com/");
		driver.findElement(By.xpath("//div[@class='login_links']/a[2]")).click();
		
		
		driver.findElement(By.xpath("//select[@class='title required']")).click();  
		driver.findElement(By.xpath("//select[@class='title required']/option[2]")).click();
		driver.findElement(By.id("forename")).sendKeys("Scott");
		driver.findElement(By.name("map(lastName)")).sendKeys("Joseph");
		

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)",""); 
		

		WebElement checkbox= driver.findElement(By.xpath("//fieldset//input[3][@id='checkbox']"));
		checkbox.click();
		if(checkbox.isSelected())
			System.out.println(" checkbox is selected");

		driver.findElement(By.id("form")).click(); 
		System.out.println("clicked on join button");

		Thread.sleep(2000);
		WebElement message1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/fieldset[1]/label[5]"));
		
		//WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div[3]/form/fieldset[1]/label[5]"));
		if(message1.isEnabled())
		{
			System.out.println(message1.getText() +"' appears under the date of birth textbox");
		}
		//driver.close();


	}

	public static void main(String[] args) throws InterruptedException
	{
		userRegistration obj = new userRegistration();
		obj.invokeBrowser();  
	}

}

package Selenium_programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task4_enable_disable_button {
WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("file:///C:/Users/tilak/Desktop/Magnus%20Details/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //this line means it will wait for 30 second before throwing an exception error if any
		
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		   js.executeScript("window.scrollBy(0,800)",""); //this line scrolled down bit
		   Thread.sleep(2000);

WebElement button = driver.findElement(By.xpath("//div[@id='test-4-div']/button[1]"));
if(button.isEnabled())
{
System.out.println("The first button is enabled");
}
else
{
	System.out.println("The first button is not enabled");
}

WebElement secondbutton = driver.findElement(By.xpath("//div[@id='test-4-div']/button[2]"));
		if(!secondbutton.isEnabled())
		{
		System.out.println("The second button is not enabled");
		}
		else
		{
			System.out.println("The second button is not enabled");
		}


	}

}

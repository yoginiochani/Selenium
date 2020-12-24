package Selenium_programs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 
{
WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("file:///C:/Users/tilak/Desktop/Magnus%20Details/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //this line means it will wait for 30 second before throwing an exception error if any
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		   js.executeScript("window.scrollBy(0,300)",""); //this line scrolled down bit
		   Thread.sleep(2000);

		
		List<WebElement> listnums = driver.findElements(By.xpath("//ul[@class='list-group']/li"));
		int size = listnums.size();
		if(size ==3)
		{
			System.out.println("The size of list is:  " +size);	
			for(WebElement x:listnums)
			{
				System.out.println(x.getText());		
			}
			
		}
		else
		{
			System.out.println("The size of list is not three");
		}	
		WebElement sec =driver.findElement(By.xpath("//ul[@class='list-group']/li[2]"));
		System.out.println(sec.getText());
		System.out.println("***********************");
		
		String six = driver.findElement(By.xpath("//ul/li/span[contains(text(),'6')]")).getText();
		System.out.println(six);  //checking if the value printed is 6 or not.
		int value= 6; //fixed value of integer
		int numm = Integer.parseInt(six); //converting string "six" to integer value
		if(value == numm)  // checking if the actual value is same as expected value which is 6.
		{
			System.out.println("The badge value matches with expected value which is 6.");	
		}
		else
		{System.out.println("The badge value does not matches with expected value which is 6.");}
		
	}

}

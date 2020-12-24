package Selenium_programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task3_dropDown {
	WebDriver drive;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("file:///C:/Users/tilak/Desktop/Magnus%20Details/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //this line means it will wait for 30 second before throwing an exception error if any
		
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		   js.executeScript("window.scrollBy(0,600)",""); //this line scrolled down bit
		   Thread.sleep(2000);

		   String drop = driver.findElement(By.id("dropdownMenuButton")).getText();
		   String option = "Option 1";
		   if(drop.equals(option)) //checking if actual result matches with expected result or not
		   {
			   System.out.println("The first option matches which is Option1");
		   }
		   else
		   {System.out.println("noooo");
		   }
		   
		   WebElement clickOn = driver.findElement(By.id("dropdownMenuButton")); //clicked on option button
		   clickOn.click();
		   Thread.sleep(1000);
		   driver.findElement(By.xpath("//div[@class='dropdown-menu show']/a[3]")).click(); //clicked on option3 from dropdown
		   
	}

}

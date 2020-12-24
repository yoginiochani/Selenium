package Selenium_programs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class task5_isButtonVisibleYet {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("file:///C:/Users/tilak/Desktop/Magnus%20Details/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS); //this line means it will wait for 30 second before throwing an exception error if any
		
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		   js.executeScript("window.scrollBy(0,1000)",""); //this line scrolled down bit
		   Thread.sleep(1000);
		   
		   List<WebElement> buttons = driver.findElements(By.tagName("button")); //finding all the buttons
		   System.out.println("Total buttons on webpage are: " + buttons.size()); //printing total number of buttons on webpage
		   Thread.sleep(2000);
		   for(WebElement x : buttons) 
		   {
			   System.out.println("button["+x+ "]  " +x.getText()); //printing all the names of button
		   }
		   Thread.sleep(1000);
		   WebDriverWait wait = new WebDriverWait(driver,20);
		   WebElement button5; //webelement variable
		   button5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"test5-button\"]")));
		   button5.click();
		  
		   Thread.sleep(2000);
		   if(!button5.isEnabled())  //to check if the button is not disabled or not after clicking on it first.
		   {
			   System.out.println("The button is now disabled");
		   }
		   
	}

}

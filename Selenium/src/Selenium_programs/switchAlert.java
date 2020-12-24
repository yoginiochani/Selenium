package Selenium_programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchAlert {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //this line means it will wait for 30 second before throwing an exception error if any
		
		driver.findElement(By.name("submit")).click();
		
		Alert text = driver.switchTo().alert(); //Alert object is created. "text"
				text.getText();
		System.out.println(text);
		text.accept();   //this line will click on first pop up "okay" button
		Thread.sleep(2000);
		text.accept();  //this line will click on second pop up "Okay" button
		
		driver.findElement(By.name("submit")).click(); //this line clicks on submit button again
		text.dismiss();  //this line clicks on cancel button on pop up window
		System.out.println("clicked on cancel button on pop up window");
		
		Thread.sleep(2000);
		driver.findElement(By.name("res")).click();  //this line will click on reset button
		System.out.println("clicked on reset button on main window");
		
		
	}

}

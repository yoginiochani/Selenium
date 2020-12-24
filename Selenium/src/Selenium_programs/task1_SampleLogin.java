package Selenium_programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task1_SampleLogin {
WebDriver drive;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("file:///C:/Users/tilak/Desktop/Magnus%20Details/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //this line means it will wait for 30 second before throwing an exception error if any
		
		WebElement username = driver.findElement(By.id("inputEmail"));
		if(username.isDisplayed())
		{
			System.out.println("Username input filed is displayed in webpage");
		}
		username.sendKeys("niharika@yopmail.com");
		
		WebElement password = driver.findElement(By.id("inputPassword"));
		if(password.isDisplayed())
		{
			System.out.println("Password input filed is displayed in webpage");	
		}
		password.sendKeys("niharika1234");
		
		Thread.sleep(2000);
		WebElement signIn = driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']"));
				if(signIn.isDisplayed())
				{
					System.out.println("SignIn button is displayed in webpage");
				}
				signIn.click();

	}

}

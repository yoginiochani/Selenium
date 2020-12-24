//This program is opening different links(term, policies, and privacy) from facebook site and opening in different tab.
package Selenium_programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchToWindowsFacebook {

	WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //this line means it will wait for 30 second before throwing an exception error if any
		
		driver.findElement(By.linkText("Create New Account")).click();
		
		String mainWindow = driver.getWindowHandle();  //this line will get the windowid of opened window.
		System.out.println("The window ID of opened window is:   " +mainWindow);
		
		driver.findElement(By.xpath("//a[@href= '/legal/terms/update']")).click();
		String termId = driver.getWindowHandle();
		System.out.println("The term link window id is:        "+termId);
		
		driver.switchTo().window(mainWindow);
		driver.findElement(By.xpath("//a[@href= '/about/privacy/update']")).click();
		String privacyId = driver.getWindowHandle();
		System.out.println("The privacy link window id is:    "+privacyId);
		
		driver.switchTo().window(mainWindow);
		driver.findElement(By.xpath("//a[@id='cookie-use-link']")).click();
		String cookiesId = driver.getWindowHandle();
		System.out.println("The privacy link window id is:    "+cookiesId);

		driver.switchTo().window(mainWindow);
		driver.close();
	}

}

package Selenium_programs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchToWindowAmazon {
	WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Ftag%3Dhymsabk-20%26hvadid%3D78477767666207%26hvqmt%3De%26hvbmt%3Dbe%26hvdev%3Dc%26ref%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //this line means it will wait for 30 second before throwing an exception error if any
		
		String mainWindow = driver.getWindowHandle();  //this line will get the windowid of opened window.
		
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[4]/div[2]/a[1]")).click(); //clicks on condition of use link
		
		driver.switchTo().window(mainWindow);
		
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[4]/div[2]/a[2]")).click(); //clicks on Privacy Notice link
		
		driver.switchTo().window(mainWindow);
		
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div[4]/div[2]/a[3]")).click(); //clicks on Help link
		
		driver.switchTo().window(mainWindow);
		
		
	}

}

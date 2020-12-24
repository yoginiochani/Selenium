package Selenium_programs;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromeBrowser {
	WebDriver driver; //created object of the web driver
	public void invokeBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://google.com");
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println("The current url is " + url);
		System.out.println("The title of the application is " +title);
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		chromeBrowser obj = new chromeBrowser(); //name of java class to create object.
		obj.invokeBrowser();   //using object to call invokeBrowser() method
			
	}

}

package TestNG;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class mortgagePaymentCalculator 
{
	static String baseUrl;
	static WebDriver  driver;
 	Actions action = new Actions(driver);
	
 	public static void main(String[] args) throws InterruptedException
	{
		//String website = "https://www.usbank.com/home-loans/mortgage/mortgage-calculators.html";
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		baseUrl = "https://www.usbank.com/home-loans/mortgage/mortgage-calculators.html";
		driver.get(baseUrl);
		WebElement mpc = driver.findElement(By.linkText("Mortgage payment calculator"));
		mpc.click();
		Thread.sleep(2000);
		try
		{
		WebElement cal = driver.findElement(By.name("Global_HomeAppraisedValue"));
		cal.click();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		Thread.sleep(1000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)",""); //this line scrolled down bit
		Thread.sleep(2000);
		driver.switchTo().frame(0);//switched to frame because next element is located within frame. pheww
		driver.findElement(By.xpath("//div[@id = 'rg1']/div[contains(text(), '15-year fixed')]")).click();
		
		System.out.println("it clicked");
	}
}
	
	
	
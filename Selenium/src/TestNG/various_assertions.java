package TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class various_assertions {

	WebDriver driver;
	
	
@BeforeTest
 public void setup()
 {
	System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
	  driver =new ChromeDriver(); 
	  WebElement url = null;
	  driver.navigate().to("https://www.google.com/");
	  driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 }

@Test (priority = 0)
public void validateTitle()
{
  String ExpectedTitle = "Google";
  String ActualTitle =driver.getTitle();
  
  Assert.assertEquals(ExpectedTitle, ActualTitle);
   System.out.println("The title is validated and test case is passed");	
}

@Test (priority = 1)
public void About_Link()
{
	
	WebElement Aboutlink = driver.findElement(By.xpath("//div[@id=\"gb\"]/div/a[1]"));
	
	Assert.assertEquals(true, Aboutlink.isDisplayed());
	System.out.println("The link 'About' is displayed on google page");
	
	Assert.assertEquals(true, Aboutlink.isEnabled());
	System.out.println("The link 'About' is enabled");
	
	Aboutlink.click();
	
}

@Test (priority = 2)
void header() throws InterruptedException
{
	WebElement header = driver.findElement(By.xpath("//*[@id=\"module-anchor-statement-mission-statement\"]/div/h1"));
	System.out.println("I am in header method");
	System.out.println(header.getText());
	Thread.sleep(1000);
	driver.navigate().back();
}

@Test (priority = 3)
void StoreLink()
{
	WebElement store = driver.findElement(By.xpath("//div[contains(@id, 'gb')]/div/a[2]"));
	Assert.assertEquals(true, store.isDisplayed());
	Assert.assertEquals(true, store.isEnabled());
	System.out.println("The store link is displayed and clickable");
	store.click();
}

@Test (priority = 4)
void totalLinksInStore()
{
	List <WebElement>  alllinktags = driver.findElements(By.tagName("a"));
	System.out.println("The links on this pages are " + alllinktags.size());
	for(WebElement x:alllinktags)
		System.out.println(x.getText());
}

}

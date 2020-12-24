package Selenium_programs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class allLinksTextboxesButtons {
WebDriver driver;
void invokeBrowser()
{
System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
driver =new ChromeDriver(); 
}
void amazon()
{
	driver.navigate().to("https://www.amazon.in/");
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
}
void searchiphone() throws InterruptedException
{
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	Thread.sleep(2000);
	driver.findElement(By.id("nav-search-submit-text")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("New Apple iPhone 11 (64GB) - Black")).click();
	System.out.println(driver.getCurrentUrl());
	
}
void alllinks()
{
	List <WebElement>  alllinktags = driver.findElements(By.tagName("a")); //findElements not findElement
	System.out.println("Total links on current webpage are: " +alllinktags.size());
	for(WebElement x: alllinktags)
		System.out.println(x.getText());
	
}
void textboxes()
{
	System.out.println("****************************");
	List<WebElement> textbox = driver.findElements(By.tagName("input"));
	System.out.println("Total textboxes in current webpage are: " +textbox.size());
	
	
}
int buttons()
{
	List<WebElement> buttons = driver.findElements(By.tagName("button"));
	System.out.println("***************************");
	for (WebElement z: buttons)
		System.out.println(z.getText());
	return  buttons.size();
	
}
void images() throws InterruptedException
{
	System.out.println("***************************");
	List<WebElement> totalimages = driver.findElements(By.tagName("img"));
	System.out.println("Total images on current web page are:  " +totalimages.size());
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//span[@class = 'nav-line-2 nav-short-width']")).click();
	driver.close();
}
void login()
{
	driver.navigate().back();
	driver.findElement(By.xpath("//span[@class = 'nav-line-2 nav-short-width']")).click(); //this is working but on wrong page.
}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		allLinksTextboxesButtons object = new allLinksTextboxesButtons();
		object.invokeBrowser();
		object.amazon();
		object.searchiphone();
		object.alllinks();		
		object.textboxes();
		int totbuttons = object.buttons(); 
		System.out.println("Total buttons on current webpage are:  " +totbuttons);
		
		object.images();
		//Thread.sleep(3000);
		
		//object.login();
			
	}
	
		
	

}

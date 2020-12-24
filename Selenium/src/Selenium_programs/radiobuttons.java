package Selenium_programs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class radiobuttons {
WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement newacct = driver.findElement(By.id("u_0_2"));
		newacct.click();
		Thread.sleep(2000);
		
		//commented lines of code is to check all the radio button and select one by one in for loop.
		List <WebElement> lists = driver.findElements(By.name("sex"));
		for(WebElement alllists: lists)
		{
			if(!alllists.isSelected())//if radio button is not selected
				{
					alllists.click(); //then select.
					System.out.println("selected");
					Thread.sleep(1000);
				}
		}
		Thread.sleep(2000);
		
		lists.get(1).click(); //this line selected second radio button which is "Male" button 
		Thread.sleep(2000);
		//now amazon checkboxes
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Washing Machines");
		Thread.sleep(2000);
		driver.findElement(By.id("nav-search-submit-text")).click();
		Thread.sleep(2000);
		//WebElement checks = driver.findElement(By.xpath("//*[@id='p_89/Samsung']"));
		
		
		
		List <WebElement> checkboxes = driver.findElements(By.className("a-spacing-micro"));
		int count = checkboxes.size();
		System.out.println(count);
		
		//below two lines clicks on Samsung checkbox
		WebElement samsung = driver.findElement(By.xpath("//ul/li[@id='p_89/Samsung']/span/a/div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']"));//clicked on samsung checkbox yesssss
		samsung.click();
		
		Thread.sleep(2000);
		WebElement ifb = driver.findElement(By.xpath("//ul/li[@id='p_89/IFB']/span/a/div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']"));//clicked on samsung checkbox yesssss
		ifb.click();
		
		Thread.sleep(2000);
		WebElement lg = driver.findElement(By.xpath("//ul/li[@id='p_89/LG']/span/a/div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']"));//clicked on samsung checkbox yesssss
		lg.click();
		
		Thread.sleep(2000);
		WebElement Whirlpool = driver.findElement(By.xpath("//ul/li[@id='p_89/Whirlpool']/span/a/div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']"));//clicked on samsung checkbox yesssss
		Whirlpool.click();
	    Thread.sleep(2000);
	    WebElement haier = driver.findElement(By.xpath("//ul/li[6]/span/a/div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']"));//clicked on samsung checkbox yesssss
	    haier.click();
	    System.out.println("good till here");
	     WebElement godrej = driver.findElement(By.xpath("//ul/li[7]/span/a/div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']"));//clicked on samsung checkbox yesssss
	    godrej.click();
	    //if(Whirlpool.isSelected());
	    //System.out.println("Yes");
	    
	    
	}
		
	  
	}
	
		
		




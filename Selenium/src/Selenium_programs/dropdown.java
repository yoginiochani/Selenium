package Selenium_programs;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdown {
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/selectmenu");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,600)",""); //this line scrolled down bit
		  Thread.sleep(2000);
		  System.out.println("it scrolled");
		
		//lines 23 to 31 are only for first drop down box.
		driver.switchTo().frame(0);
	    WebElement firstdrop = driver.findElement(By.xpath("//span[contains(text(),'Medium')]"));//first clicks on text box.
	    firstdrop.click();
	    Thread.sleep(2000);
		List<WebElement> speedlevel = driver.findElements(By.xpath("//ul[@id='speed-menu']/li"));//second, each options are in
																	//contained in unordered list and then in list.so its separate xpath for options.
		for (WebElement speed: speedlevel) // for loop is to print all the options from that dropdown box
		System.out.println(speed.getText());
		speedlevel.get(3).click(); //getting third option.
		
		System.out.println("**********Printing all the options from second dropdown menu next**************");
		
		WebElement seconddrop = driver.findElement(By.xpath("//fieldset//span[@id ='files-button' ]//span[contains(text(), 'jQuery.js')]"));//first clicks on text box.
		seconddrop.click();
		Thread.sleep(1000);
		List<WebElement> querylist = driver.findElements(By.xpath("//div/ul[@id = 'files-menu']/li"));
		for (WebElement qlist: querylist)
		{
			System.out.println(qlist.getText());
		}
		//querylist.get(4).click();
		System.out.println("************************");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/span[3]")).click();
		WebElement thirddrop = driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/span[3]/span[contains(text(), '2')]"));
		if(thirddrop.isDisplayed())
		{System.out.println("element is there");
		}
		else
		{System.out.println("not there");
		}
		thirddrop.click();
		
		
		//thirddrop.click();
		//Thread.sleep(2000);
		//List<WebElement> nums = driver.findElements(By.xpath("//ul[@id='number-menu']/li"));
		//for(WebElement x:nums)
			//System.out.println(x.getText());
		


	}

}

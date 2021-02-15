package Selenium_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSliderElement {
	
	WebDriver driver;

	public void invokeBrowser()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
	driver =new ChromeDriver(); 
	}
	
	public void jquery()
	{
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		
		Actions action = new Actions(driver);
		//action.dragAndDropBy(slider, 400, 0).perform(); //this will go slider 400pixle
		
		//if you want slider to be in middle, then do the next step.
		WebElement mainslider = driver.findElement(By.id("slider"));  //this is the mainslider id
		//now, do this step
		int width = mainslider.getSize().width/2;  //this line will get the slider size and get size in middle by dividing by 2 and put it in width 
		//now pass the width in x-axis
		action.dragAndDropBy(slider, width, 0).perform();
		
		driver.close();
		
		
	}
	
	

public static void main(String[] args)
{
	TestSliderElement obj = new TestSliderElement();
	obj.invokeBrowser();
	obj.jquery();
}
}

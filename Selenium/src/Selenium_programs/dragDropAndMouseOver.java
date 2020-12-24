package Selenium_programs;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class dragDropAndMouseOver {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		Actions control = new Actions(driver);   //this class is import for drag and drop action. and created object of Actions class.
		driver.switchTo().frame(0);
		
		WebElement drag = driver.findElement(By.xpath("//div/p[contains(text(),'Drag me to my target')]"));  //this is the xpath for drag box
		WebElement drop = driver.findElement(By.xpath("//div/p[contains(text(),'Drop here')]"));
		
		control.moveToElement(drag).clickAndHold(drag).moveToElement(drop).release(drag).build().perform();
	    
		System.out.println("****************Drag and Drop Worked*********************");
		System.out.println("****************Next line of code is hoover over elements and perform action without clicking*********************");
		Thread.sleep(2000);
	    driver.get("https://jqueryui.com/menu/");
	    Thread.sleep(2000);
	    
	    
	    
	    WebElement music = driver.findElement(By.xpath("//div[contains(text(),'Music')]"));
	    //control.moveToElement(music);
	    //control.click().build().perform();
	    Thread.sleep(2000);
	    WebElement rock = driver.findElement(By.xpath("//div[contains(text(),'Rock')]"));
	    //control.moveToElement(rock);
	    //control.click().build().perform();
	    Thread.sleep(2000);
	    WebElement alternative = driver.findElement(By.xpath("//div[contains(text(),'Alternative')]"));
	    //control.moveToElement(alternative);
	    //control.click().build().perform();
	    control.moveToElement(music).click().moveToElement(rock).click().moveToElement(alternative).click().build().perform();
	    
	    
	    
		
	}

}

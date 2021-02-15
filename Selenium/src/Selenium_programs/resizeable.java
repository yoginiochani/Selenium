package Selenium_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//import com.sun.java.swing.plaf.windows.resources.windows;

public class resizeable {

	
		WebDriver driver;

		void invokeBrowser()
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		driver =new ChromeDriver(); 
		}
		public void resizeableElement() throws InterruptedException
		{
			driver.get("https://jqueryui.com/resizable/");
			driver.manage().window().maximize();
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,300)",""); //this line scrolled down bit
			
			Thread.sleep(2000);
			
			driver.switchTo().frame(0); //had to switch to frame because below element is located within frame.
			
			WebElement resizable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
			System.out.println(resizable.isDisplayed());
			
			Actions action = new Actions(driver);
			action.dragAndDropBy(resizable, 400, 200).perform();  
			
		}
		
		public void newWindowsize() throws InterruptedException
		{
			driver.get("https://www.google.com");
			Dimension size = driver.manage().window().getSize();
			System.out.println(size);
			//driver.manage().window().setSize(size);
		    driver.manage().window().setPosition(new Point(200, -800));
		    Thread.sleep(1000);
		    driver.manage().window().setPosition(new Point(100, -600));
		    Thread.sleep(1000);
		    driver.manage().window().setPosition(new Point(300, -500));
		    Thread.sleep(1000);
		    driver.manage().window().setPosition(new Point(400, -400));
		    Thread.sleep(1000);
		    driver.manage().window().setPosition(new Point(500, -200));

			
			
			
		}


	public static void main(String[] args) throws InterruptedException {
		resizeable obj = new resizeable();
		obj.invokeBrowser();
		obj.resizeableElement();
		obj.newWindowsize();
		obj.newWindowsize();
	}

}

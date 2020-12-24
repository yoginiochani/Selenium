package Selenium_programs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollWindow {
WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.ebay.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,300)",""); //this line scrolled down bit
	   Thread.sleep(2000);
	   try
	   {
	   js.executeScript("window.scroll(300,0)","");//this line went back up same
	   }
	   catch(Exception e)
	   {
	   System.out.println(e);
	   }
	   
	   Thread.sleep(3000);
	   //lines 23 to 28 is for: scroll down to specific element using xpath of element.
	   WebElement buy = driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul/li[1]/h3/a"));
	   if(buy.isDisplayed()); //checking if buy element is there on webpage or not.
	   System.out.println("buy element is there");
	   Thread.sleep(2000);
	   js.executeScript("arguments[0].scrollIntoView();",buy); //this line scrolls to link named "buy" on webpage. 
	   
	   
	   
	   
	   Thread.sleep(2000);
	   
	   WebElement tdydeal = driver.findElement(By.partialLinkText("Today's Deals – All With Free Shipping"));
	   //tdydeal.click(); //this line will click on partial link text which is mentioned in above line
	 // js.executeScript("argments[0].scrollIntoView();",tdydeal);
	  System.out.println(tdydeal.getText()); //getting text of the partial link
	  String tagname = tdydeal.getTagName(); //getting tagname which is "<a>
	  System.out.println(tdydeal.getAttribute(tagname));  //this line prints pull
	   
	  // Thread.sleep(5000);
	   //To scroll all the way down
	   //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	    
	    
		
		

	}

}

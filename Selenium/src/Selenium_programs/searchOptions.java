package Selenium_programs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchOptions {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.ebay.com/");
		driver.manage().window().maximize();
		Thread.sleep(500);
		
		 WebElement flwr = driver.findElement(By.id("gh-ac"));
		 flwr.click();
		 Thread.sleep(500);
		 flwr.sendKeys("phone");
		Thread.sleep(1000);
         		
		List <WebElement> suggestions = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));//this line will get all the suggestion
																								//starting with word "phone"
		Thread.sleep(2000);
		for(WebElement x : suggestions)   //for loop is printing all the suggestion
		{
			System.out.println(x.getText());

		}
			System.out.println("printed all the suggestions");
			System.out.println();
			flwr.clear();

			//searching next item in search box
			flwr.sendKeys("flowers");
			Thread.sleep(1000);
			List <WebElement> suggestions2 = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
			System.out.println(suggestions2.size());  //printing total number of suggestion
			for(WebElement sugs: suggestions2)  //printing all the suggestion starting with word 'flower"
			{
				System.out.println(sugs.getText());
			}
			//suggestions2.get(4).click();  //clicked on fourth suggestion
			
			flwr.clear();
			flwr.sendKeys("l46165165dfdskjflkjdjd6561df");
			driver.findElement(By.id("gh-btn")).click();
			Thread.sleep(500);
			WebElement result = driver.findElement(By.xpath("//div/h3[contains(text(),'No exact matches found')]"));
			System.out.println(result.getText() );
			
			driver.close();

	}

}

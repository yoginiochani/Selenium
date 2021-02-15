package Selenium_programs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class SliderToCalcualteEMI 
{

	static WebDriver driver;
	
	@Test
	public static void calculate_EMI()throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		driver =new ChromeDriver();
		
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		
		driver.findElement(By.xpath("//ul/li[3][@id = \"car-loan\"]/a[contains(text(), 'Car Loan')]")).click();
		
		WebElement Car_Loan_Amount = driver.findElement(By.xpath("//div[@id = \"loanamountslider\"]/span"));
		action.dragAndDropBy(Car_Loan_Amount,192,0).build().perform();
		
		
		WebElement Interest_Rate = driver.findElement(By.xpath("//div[@id=\"loaninterestslider\"]/span"));
		action.dragAndDropBy(Interest_Rate,-109,0).build().perform();
		
		Thread.sleep(2000);
		WebElement Loan_Tenure =	driver.findElement(By.xpath("//div[@id =\"loantermslider\"]/span"));
		action.dragAndDropBy(Loan_Tenure,180,0).build().perform();
		
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,300)",""); //this line scrolled down bit
		   Thread.sleep(2000);
		
		WebElement EMI_Amount_Element = driver.findElement(By.xpath("//div[@id=\"emiamount\"]/p/span"));
		
		String EMI_Amount = EMI_Amount_Element.getText(); //getting the amount and converting it to string.
		
		Assert.assertEquals("16,601", EMI_Amount);
		System.out.println("The test case executed");
		
		
	}

}

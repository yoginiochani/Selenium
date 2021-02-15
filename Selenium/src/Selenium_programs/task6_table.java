package Selenium_programs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class task6_table {
	WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("file:///C:/Users/tilak/Desktop/Magnus%20Details/index.html");  //this line will open html page which is located in this path
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //this line means it will wait for 30 second before throwing an exception error if any
		
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		   js.executeScript("window.scrollBy(0,1400)",""); //this line scrolled down bit
		   Thread.sleep(2000);
		  
		   //header row
		  List<WebElement> headrow = driver.findElements(By.xpath("//table[@class='table table-bordered table-dark']/thead/tr"));
		   int rowsize = headrow.size();
		  System.out.println("The size of the first row is:  "+rowsize);
		  
		  //header column
		  List<WebElement> headcolmn = driver.findElements(By.xpath("//table[@class='table table-bordered table-dark']/thead/tr/th"));
		  int colmnsize = headcolmn.size();
		  System.out.println("The size of the columns are: "+colmnsize);
		  
		  for(int i = 1; i <=rowsize; i++)  //for loop for row
		  {
			  for(int j =1;j<=colmnsize;j++ ) //for loop for column
			  {
				  WebElement data = driver.findElement(By.xpath("//table[@class='table table-bordered table-dark']/thead/tr["+i+"]/th["+j+"]"));//storing values of row and column in webelement data
				  System.out.print(data.getText()+"    "); //printing values of rows and column
			  }
		  }
		  
		  System.out.println();
		  System.out.println();
		  
		  //body row
		  List<WebElement> bodyrow = driver.findElements(By.xpath("//tbody/tr"));
		  int bodyrowsize = bodyrow.size();
		  System.out.println("The rows in body are:  " +bodyrowsize);
		  
		  //body column
		  List<WebElement> bodycolmn = driver.findElements(By.xpath("//tbody/tr/td"));
		  int bodycolumnsize = bodycolmn.size();
		  System.out.println("The columns in body are:   " +bodycolumnsize);
		  
		  //now printing data from body from row and columns
		  
		  for(int p = 1; p<=bodyrowsize; p++) //p = 3 since there are three 3 rows
		  {
			  for(int r = 1; r<=bodycolumnsize; r++) //r = 9, since there are 9 values in 
			  {
				  WebElement datavalues = driver.findElement(By.xpath("//tbody/tr["+p+"]/td["+r+"]")); 
				  System.out.println(datavalues.getText());
				  System.out.print("    ");
				 
			  }
			  System.out.println();
		  }
		  
	}

}

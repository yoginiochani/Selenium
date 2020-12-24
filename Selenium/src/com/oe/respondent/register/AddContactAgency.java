package com.oe.respondent.register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

import com.sun.jdi.Value;

public class AddContactAgency{
	
	//@Junit
	WebDriver driver;
	
    
	public void invokeBrowser()
	{
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://dev.opinioneconomy.io/login");
			admin_login();
			Thread.sleep(3000);
			linkTextCA();
			Thread.sleep(9000);
			linkTextaddcontactagency();
			fillCAForm();
			selectcompanysize();
			selectcountryname();
			//selectadmin();
			Thread.sleep(8000);
			admin_logout();
			driver.get("http://www.yopmail.com/en/");
			yop_login();
			//driver.close();
		//	linkTextInvite();
			//driver.findElement(By.ByLinkText.linkText("INVITE")).click();
			
		   } 
		catch (Exception e) {
			e.printStackTrace();
			}
			
	}

	public void admin_login()
	{
	 try {
		driver.findElement(By.id("email")).sendKeys("oebadmin@yopmail.com");
		 driver.findElement(By.id("password")).sendKeys("oeb@1234");
		 Thread.sleep(3000);    //sleeps for 3 seconds before next line executes
		 driver.findElement(By.className("btn-wrapper")).click();
		 
		 	} catch (InterruptedException e) {
		e.printStackTrace();
		 	}
	 
	}
	public void linkTextCA()
	{
		
		//driver.findElement(By.linkText("SURVEY AGENCIES")).get(0).getText();
		driver.findElement(By.ByLinkText.linkText("CONTACT AGENCIES")).click();
		//driver.findElement(By.linkText("ADD SURVEY AGENCY")).click();
	}
		
	public void linkTextaddcontactagency() 
	{
		
		//driver.findElement(By.linkText("ADD SURVEY AGENCY")).click();
		//driver.findElement(By.className("top-button pull-right")).click();
		//driver.findElement(By.ByLinkText.linkText("CONTACT AGENCIES")).click();
		//driver.findElement(By.ByLinkText.linkText("INACTIVE")).click();
		driver.findElement(By.xpath("//html//body//div//app-root//div//app-navigation//app-oe-contactagency//div//div//div//button[@class='oeb-btn oeb-btn-primary text-uppercase'][@type='button']")).click();

		/*
		 * 
		 * <button _ngcontent-c19="" class="oeb-btn oeb-btn-primary text-uppercase" type="button">Add SURVEY AGENCY </button>
		 * 
		WebElement parentElement = driver.findElement(By.className("button"));
		WebElement childElement = parentElement.findElement(By.id("submit"));
		childElement.submit();
		 */
		
	}
	public void fillCAForm()
	{
		driver.findElement(By.id("email")).sendKeys("devautoca9@yopmail.com");
		driver.findElement(By.className("form-group").name("firstName")).sendKeys("James");
		driver.findElement(By.className("form-group").name("lastName")).sendKeys("Bond");
		driver.findElement(By.className("form-group").name("companyname")).sendKeys("devautoca");
		//driver.findElement(By.className("form-group").className("selectpicker form-control ng-untouched ng-pristine ng-invalid").name("size")).sendKeys("ng-reflect-value");
	}
	public void selectcompanysize() throws InterruptedException
	{
		WebElement companysize = driver.findElement(By.name("size"));
		Select company_size = new Select(companysize);
		company_size.selectByValue("4");      //it will select 50-100 employees because value "4" = 50-100
		Thread.sleep(3000);
		company_size.selectByVisibleText("100-500 Employees");   //This will select 100-500 employee size
		
	}
	
	public void selectcountryname() throws InterruptedException
	{
	  WebElement countryname =driver.findElement(By.name("country"));
	  Select country_name = new Select(countryname);
	  country_name.selectByVisibleText("bermuda"); //This will select Bermuda as country
	  driver.findElement(By.className("form-group").name("password")).sendKeys("devCA1@1234");
	  driver.findElement(By.className("form-group").name("confirmPassword")).sendKeys("devCA1@1234");
	 
	  
	  //Thread.sleep(2000);
	 // driver.findElement(By.ByLinkText.linkText("ADD CONTACT AGENCIES")).click();
	  
	  driver.findElement(By.className("modal-body")).click(); //This line will click outside of field text box
	  
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//html//body//modal-container//div//div//div//form//button[@class='oeb-btn oeb-btn-primary btn-full text-uppercase'][@type='submit']")).click();
	  
	  
	}
	/*public void selectadmin()
	{
		driver.findElement(By.className("caret")).click(); 
		
	}*/
	public void admin_logout()
	{
		driver.findElement(By.className("user-name")).click();
		driver.findElement(By.ByLinkText.linkText("Logout")).click();
	}
	
	/*public void linkTextInvite()
	{
		driver.findElement(By.ByLinkText.linkText("INVITE")).click();

	}*/
	public void yop_login()
	{
		driver.findElement(By.id("login")).sendKeys("devautoca9");
		driver.findElement(By.className("sbut")).click();
		//driver.findElement(By.className("lmfd")).click();
		driver.findElement(By.className("lmf").name("Welcome to OEB Platform")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.linkText("nofollow")).click();
		
	}
public static void main(String[] args) {
		
		AddContactAgency obj = new AddContactAgency();
		obj.invokeBrowser();
		
			
	}

}

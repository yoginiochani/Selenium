package com.oe.respondent.register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class InviteRespondent{
	
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
			
			driver.get("https://uat.opinioneconomy.io/login");
			ca_login();
			Thread.sleep(2000);
			linkRespondent();
	//		linkTextSA();
			Thread.sleep(5000);
		//	linkTextaddsurveyagency();
			//fillSAForm();
		//	linkTextInvite();
			//driver.findElement(By.ByLinkText.linkText("INVITE")).click();
			
		   } 
		catch (Exception e) {
			e.printStackTrace();
			}
			
	}

	public void ca_login()
	{
	 try {
		driver.findElement(By.id("email")).sendKeys("nuatca@yopmail.com");
		 driver.findElement(By.id("password")).sendKeys("nuatca@1234");
		 Thread.sleep(5000);    //sleeps for 3 seconds before next line executes
		 driver.findElement(By.className("btn-wrapper")).click();
		 
		 	} catch (InterruptedException e) {
		e.printStackTrace();
		 	}
	 
	}
	public void linkRespondent()
	{
		
		//driver.findElement(By.className("a.nav-link").linkText("/ContactAgency/Respondents")).click();
		//driver.findElement(By.ByLinkText.linkText("Respondents")).click();
		
	}
	/*public void linkTextSA()
	{
		
		//driver.findElement(By.linkText("SURVEY AGENCIES")).get(0).getText();
		driver.findElement(By.ByLinkText.linkText("SURVEY AGENCIES")).click();
		//driver.findElement(By.linkText("ADD SURVEY AGENCY")).click();
	}
	public void linkTextaddsurveyagency() 
	{
		
		//driver.findElement(By.linkText("ADD SURVEY AGENCY")).click();
		//driver.findElement(By.className("top-button pull-right")).click();
		//driver.findElement(By.ByLinkText.linkText("CONTACT AGENCIES")).click();
		//driver.findElement(By.ByLinkText.linkText("INACTIVE")).click();
		driver.findElement(By.xpath("//html//body//div//app-root//div//app-navigation//app-oe-surveyagency//div//div//div//div/button[@class='oeb-btn oeb-btn-primary text-uppercase'][@type='button']")).click();

		/*
		 * 
		 * <button _ngcontent-c19="" class="oeb-btn oeb-btn-primary text-uppercase" type="button">Add SURVEY AGENCY </button>
		 * 
		WebElement parentElement = driver.findElement(By.className("button"));
		WebElement childElement = parentElement.findElement(By.id("submit"));
		childElement.submit();
		 */
		

	/*public void fillSAForm()
	{
		driver.findElement(By.id("email")).sendKeys("devSA1@yopmail.com");
		driver.findElement(By.className("form-group").name("firstname")).sendKeys("James");
		driver.findElement(By.className("form-group").name("lastname")).sendKeys("Bond");
		//driver.findElement(By.id("firstname")).sendKeys("James");
	}
	/*public void linkTextInvite()
	{
		driver.findElement(By.ByLinkText.linkText("INVITE")).click();

	}*/
	
public static void main(String[] args) {
		
		InviteRespondent obj = new InviteRespondent();
		obj.invokeBrowser();
			
	}

}

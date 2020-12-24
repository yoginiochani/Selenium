package Selenium_programs;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class validateTitle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver(); 
		
		//driver.get("https://www.facebook.com/"); this line or below can be used to get to facebook app
		driver.navigate().to("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		String actualTitle;
		String expectedTitle = "Facebook - Log In or Sign Up";
		
		actualTitle =driver.getTitle();
		System.out.println("The title of the webpage is " +actualTitle);
	
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Test Passed");
			
		}
		else
			System.out.println("Title is not equal and test failed");
		
           //next lines of code is to check if the element is present in webpage or not. element email checking.
		
		WebElement emailele = driver.findElement(By.id("email")); //checking if email element is present or not.
		boolean result = emailele.isDisplayed();
		System.out.println("Element email is present or not: True or False?   "+result); //result is either true or false.
		System.out.println("-------------------------");
		Dimension dim = emailele.getSize(); //to get the dimension of the email text box. import Dimension from selenium, not java util
		System.out.println("The dimension of the email text box is " + dim.height +"  " +dim.width);
		Point locationPoint = emailele.getLocation();
		System.out.println("The cordinate x and y of email is: " +locationPoint.x + " and " + locationPoint.y);
		
		System.out.println("-------------------------");
		WebElement button = driver.findElement(By.name("login")); //checking if login button is there on webpage or not.
		boolean buttonResult = button.isDisplayed();
		System.out.println("Login button is displayed or not?  " +buttonResult); //result is true or false
		
		String classAttr = emailele.getAttribute("class");
		System.out.println("class attribute of email textbox is: " +classAttr);
		
		WebElement pswd = driver.findElement(By.id("pass"));//checking password element by id name
		boolean pswdresult = pswd.isDisplayed();//storing result in pswdresult as true or false
		System.out.println("The password button is displayed or not?  :" +pswdresult);//printing pswdresult
		String classAttrOfPswd= pswd.getAttribute("class"); //storing class attribute or value of pswd field
		System.out.println("The class attribute of password is:  "+classAttrOfPswd); //printing class attribute of pswd
		Dimension pswddim = pswd.getSize();
		System.out.println("password dimension is " + pswddim);
		
		//if (buttonResult ==true)
		
			driver.findElement(By.name("email")).sendKeys("456546846");
			String atr = emailele.getAttribute("value");
			System.out.println(atr); //printing email value which is 456546846
			String bordercolor= emailele.getCssValue("border-color");
			System.out.println("bordercolor is:   " + bordercolor);
			//driver.navigate().back();
		
		 System.out.println("-----------------------------");
		
		WebElement cookieAtt = driver.findElement(By.linkText("Cookies"));
		String cookievalue = cookieAtt.getText();
		String cookievalue2 = cookieAtt.getTagName(); //this will give the tagname which is: a
		System.out.println("cookie linktext value is:  " +cookievalue);
		System.out.println("cookie tagname is: " +cookievalue2);
		
		
		String text = cookieAtt.getCssValue("Cursor");
		System.out.println("CSS value of cookie pointer is:  " +text);
		
		
		//next lines of code is to get all the elements in webpage using <a> tagname
		//tagnames: <head><body><h><p><input><button><div><img><li><a>...etc
		
		List <WebElement>  alllinktags = driver.findElements(By.tagName("a")); //findElements not findElement
		System.out.println("There are total of " + alllinktags.size() + " links on the page");
		
		for (WebElement x : alllinktags) //this line will take all the link one by one into x
				System.out.println(x.getText());  //this line will print all the link tagname
		
		System.out.println("-------------");
		List <WebElement>  allbutton = driver.findElements(By.tagName("button")); //findElements not findElement
		System.out.println("Total button on the page are: " + allbutton.size());
		for(WebElement y :allbutton)
			System.out.println(y.getText());
		
		//to get current url;
		System.out.println("The current url is " + driver.getCurrentUrl());
		
	}

}

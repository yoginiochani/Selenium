package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class priorityTestCases_And_Assertion {
WebDriver driver;

@BeforeTest
void launchFacebook() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
	  driver =new ChromeDriver(); 
	  driver.get("https://www.facebook.com");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
}
@Test(priority = 0)  //priority 0, 1, 2, 3.etc.. means that which test will execute first.
void validateTitle()
{
	String ExpectedTitle = "Facebook - Log In or Sign Up";
	String ActualTitle =driver.getTitle();
	Assert.assertEquals(ActualTitle, ExpectedTitle);
	System.out.println("Firt test is executed");
	
}
@Test(priority = 1) //test will get execute second
void validateEmail()
{
	WebElement email = driver.findElement(By.id("email"));
	Assert.assertEquals(true, email.isDisplayed());
	System.out.println("Second test is executed");
}
@Test(priority =2)
void validatePassword()
{
	WebElement password = driver.findElement(By.id("pass"));
	Assert.assertEquals(true, password.isDisplayed());//
	System.out.println("Third test is executed");
}
@Test(priority =3)
void validateLogInButton()
{
	WebElement loginButton = driver.findElement(By.xpath("//div/button[@type='submit']")); 
	Assert.assertEquals(true, loginButton.isDisplayed()); //this line test if login button is displayed or not. instead of writing if else statement
	System.out.println("Fourth test is executed");
}

@Test(priority = 4, enabled = false) //if you enabled = false, then it means this test will not execute
void forgotPassword()
{
	WebElement forgotpswd = driver.findElement(By.xpath("//div/a[text()='Forgot Password?']"));
	Assert.assertEquals(true, forgotpswd.isDisplayed());
	System.out.println("forgot password link is displayed");
}
@AfterTest
void closeBrowser()
{
	System.out.println("Web application Facebook is closed now.");
	driver.close();
	
}

}

package moneyGamingTesting;

//package testMethods;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import moneyGamingTesting.HomePage;
import moneyGamingTesting.RegistrationPage;
import moneyGamingTesting.InitializeDriver;
import moneyGamingTesting.PropertiesConfig;

public class MoneyGamingTest {
	
	@Test
	public void moneyGamingTest() throws IOException{
		
		PropertiesConfig pc=new PropertiesConfig();
		Properties p=pc.getProerty();
		String title=p.getProperty("title");
		String firstName=p.getProperty("firstName");
		String lastName=p.getProperty("lastName");
		InitializeDriver id=new InitializeDriver();		
		
		WebDriver driver=id.getDriver();		
		driver.get("https://moneygaming.qa.gameaccount.com/");
		
		HomePage hp=new HomePage(driver);
		hp.clickOnJoinNow();
		RegistrationPage rp=new RegistrationPage(driver);
		rp.selectTitle(title);
	    rp.setFirstName(firstName);
		rp.setLastName(lastName);
		rp.selectTermsAndConditions();
		rp.click_JoinNow();
		String error_text=rp.getErrorMessage();
		Assert.assertEquals(error_text, "This field is required");
		driver.close();
		
	}
	public static void main(String[] args) throws InterruptedException, IOException
			{
		MoneyGamingTest obj = new MoneyGamingTest();
		obj.moneyGamingTest();
		//obj.moneyGamingTest();
			}

}


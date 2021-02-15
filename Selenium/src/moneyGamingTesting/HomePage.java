package moneyGamingTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;

	private final By link_JoinNow=By.xpath("//a[@class='newUser green']");
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}

	
	public void clickOnJoinNow(){
		driver.findElement(link_JoinNow).click();
	}

	

}

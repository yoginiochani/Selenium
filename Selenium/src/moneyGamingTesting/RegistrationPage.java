package moneyGamingTesting;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage  {
	WebDriver driver;
	private final By select_title = By.id("title");
	private final By text_firstName= By.id("forename");
	private final By text_lastName= By.name("map(lastName)");
	private final By chkbox_terms= By.name("map(terms)");
	private final By btn_JoinNow=By.xpath("//input[@alt='Join Now']");
	private final By label_dob_error=By.xpath("//label[@for='dob' and @class='error']");
	
	public RegistrationPage(WebDriver driver){
		this.driver=driver;
	}

	public void selectTitle(String title){
		WebElement element_title=driver.findElement(select_title);
		Select select_title= new Select(element_title);
		select_title.selectByValue("Mr");
	}
	
	public void setFirstName(String firstName){
		driver.findElement(text_firstName).sendKeys(firstName);
	}
	
	public void setLastName(String lastName){
		driver.findElement(text_lastName).sendKeys(lastName);
	}
	
	public void selectTermsAndConditions(){
		driver.findElement(chkbox_terms).click();
	}
	
	public void click_JoinNow(){
		driver.findElement(btn_JoinNow).click();
	}
	
	public String getErrorMessage(){
		return driver.findElement(label_dob_error).getText();
	}

}

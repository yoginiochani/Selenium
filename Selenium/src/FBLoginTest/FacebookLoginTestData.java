package FBLoginTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FacebookLoginTestData {
//This program is to get testdata for login fields for facebook page using excel spreadsheet. 
	//read test data from excelsheet
	
	public String getData( int rownum, int colnum) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		
		System.out.println("before going in workbook");
		String filepath = System.getProperty(("user.dir")+"\\src\\FBLoginTest\\facebookLoginData.xlsx");
		File f = new File(filepath);
		Workbook wb = WorkbookFactory.create(new FileInputStream(f));
		Sheet sh1 = wb.getSheet("testdata");
		//CellType ctype = sh1.getRow(rownum).getCell(colnum).getCellType();
		String val= sh1.getRow(rownum).getCell(colnum).getStringCellValue();
		System.out.print(val + "    ");
		return val;
		
	}
	
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Yogini\\chromedriver\\chromedriver.exe"); //location of browser in local drive
		WebDriver driver = new ChromeDriver(); 
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().to("https://facebook.com"); //this line can also be used to get to google page.
		//by using this line, it holds the history of your navigation
		Thread.sleep(2000);

		FacebookLoginTestData obj = new FacebookLoginTestData();
		String username;
		String password;
		
		username = obj.getData(0, 0); // getting data from xls file in row 0 and column 0
		Thread.sleep(1000);
		password = obj.getData(0, 1);  //row 0, column 1 
		
		driver.findElement(By.xpath("//div/input[@id = 'email']")).sendKeys(username);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/input[@id = 'pass']")).sendKeys(password);
		

	}

}

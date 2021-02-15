package TestNG;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class elementsScreenshotsFileNames {
	
	public static void FileNames(WebDriver driver, String elementScreenShotName)
	{
		try {
		TakesScreenshot  scrshot =  ((TakesScreenshot) driver); //TakesScreenshot is an interface, you can't create object of interface, so we haveto create like this. typecast it.
		File srcFile = scrshot.getScreenshotAs(OutputType.FILE); //it will keep in memory and store it in file called srcFile. 
		FileUtils.copyFile(srcFile, new File("./screenShots/"+elementScreenShotName+".png")); //this will put screenshots in given fileName "screenshotName" which I am passing as string argument
		//System.out.println("Screenshot taken of failure test case");
		}
		catch (Exception e)
		{
			System.out.println("The exception is " +e.getMessage());
		} 
		
	}


}

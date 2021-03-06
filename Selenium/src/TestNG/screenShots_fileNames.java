package TestNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShots_fileNames {

	
	public static void captureScreenshots(WebDriver driver, String screenshotName)
	{
		try {
		TakesScreenshot  scrshot =  ((TakesScreenshot) driver); //TakesScreenshot is an interface, you can't create object of interface, so we haveto create like this. typecast it.
		File srcFile = scrshot.getScreenshotAs(OutputType.FILE); //it will keep in memory and store it in file called srcFile. 
		FileUtils.copyFile(srcFile, new File("./screenShots/"+screenshotName+".png")); //this will put screenshots in given fileName "screenshotName" which I am passing as string argument
		System.out.println("Screenshot taken");
		}
		catch (Exception e)
		{
			System.out.println("The exception is " +e.getMessage());
		} 
		
	}
}

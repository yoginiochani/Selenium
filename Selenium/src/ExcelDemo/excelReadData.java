package ExcelDemo;

//import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
//import java.io.Reader;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class excelReadData {

	
	public static void  main(String[] args) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		//File f = new File("C:\\Yogini\\eclipse.workspace\\Selenium\\src\\ExcelDemo\\excelReadData.xlsx"); //location of the xlsx file
		  File f = new File("C:\\Users\\tilak\\git\\Selenium\\Selenium\\src\\ExcelDemo\\excelReadData.xlsx");
		//FileReader fr = new FileReader(f);
		//BufferedReader reader = new BufferedReader(fr);
		FileInputStream fs = new FileInputStream(f);   //when you are reading data from excel
		XSSFWorkbook workbook = new XSSFWorkbook(fs);    // 
		XSSFSheet sheet = workbook.getSheet("students");
		
		
		int cellcount = sheet.getLastRowNum();   //getting the count of row numbers
		System.out.println("Total filled rows in sheet are:" + cellcount);
		System.out.println();
		
		int columncount = sheet.getColumnWidth(1);  
		System.out.println("Total columns in sheet are:" + columncount);
		System.out.println();
		
		int colmcount = sheet.getPhysicalNumberOfRows();
		System.out.println("Total filled columns are: " + colmcount);
		System.out.println();
		
		for(int i = 0 ; i <=sheet.getLastRowNum(); i++)
		{
			for(int j = 0; j<sheet.getPhysicalNumberOfRows(); j++)
			{
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data + "      ");
				
				}
			System.out.println();
	
		}
		workbook.close();
		
		
	}

	
}

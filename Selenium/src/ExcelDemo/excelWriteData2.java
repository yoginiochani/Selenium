package ExcelDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class excelWriteData2 {

	//public static void main(String[] args) throws IOException
	
	@Test  
	public void write() throws IOException
	 {
		XSSFWorkbook workbook = new XSSFWorkbook();  //this line to to create workbook
		
		XSSFSheet sheet3 = workbook.createSheet("third"); //creating first sheet in workbook
		Row row0 = sheet3.createRow(0);
		Cell cellA = row0.createCell(0);
		Cell cellB = row0.createCell(1);
		cellA.setCellValue("first cell");
		cellB.setCellValue("second cell");
		
		XSSFSheet sheet4 = workbook.createSheet("fourth");   //creating second sheet in workbook named "fourth"
		Row row00 = sheet4.createRow(0);
		Cell cellAA = row00.createCell(0);
		Cell cellBB = row00.createCell(1);
		cellAA.setCellValue(456);
		cellBB.setCellValue(0154);
		
		
		XSSFSheet sheet2 = workbook.createSheet("Fifth");  //creating third sheet named "Fifth and using for loop to create random numbers for 10 rows and 5 columns
		for(int row = 0; row <=10; row++)
		{
			Row roww = sheet2.createRow(row);  //this line will create 10 rows in loop
			for(int column = 0; column <=6; column++)   
			{
				Cell CellAAA = roww.createCell(column); //this line will create 5 columns columns 
				CellAAA.setCellValue((int)(Math.random()*100));  //this line will enter the values in cellAAA.
				
			}
		}
		
		
		//Connection Stream
		File f = new File("C:\\Yogini\\eclipse.workspace\\Selenium\\src\\ExcelDemo\\excelWriteData2.xlsx"); //path to locate file
		FileOutputStream fo= new FileOutputStream(f);     //this line is used so user can write to file.
		workbook.write(fo);
		fo.close();        
		workbook.close();             //close the workbook after code is executed.
		System.out.println("file created without any problem");
		
		

	}

}

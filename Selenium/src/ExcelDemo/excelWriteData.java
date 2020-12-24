package ExcelDemo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelWriteData {

	
	public static void main(String[] args) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();  //creating workbook in excel, XSSF is called so it will support both file extension. xls and xlsx
		XSSFSheet Sheet1 = workbook.createSheet("Student_Information");  //creating first sheet in workbook named "Student Information
		XSSFSheet Sheet2 = workbook.createSheet("Teacher_Salary"); //creating second sheet named "Teacher_Salary" in workbook
	    Row row1 = Sheet1.createRow(0);   //creating first row in sheet
	    Row row2 = Sheet1.createRow(1); //creating second row in first sheet
	    
	    Cell cell1 = row1.createCell(0);   //creating many columns called cell in sheet. total of 6 columns which different title.
	    Cell cell2 = row1.createCell(1);
	    Cell cell3 = row1.createCell(2);
	    Cell cell4 = row1.createCell(3);
	    Cell cell5 = row1.createCell(4);
	    Cell cell6 = row1.createCell(5);
	    Cell cell7 = row1.createCell(6);
	    
	    Cell cellA = row2.createCell(0);   //creating many columns called cell in sheet. total of 6 columns which different title.
	    Cell cellB = row2.createCell(1);
	    Cell cellC = row2.createCell(2);
	    Cell cellD = row2.createCell(3);
	    Cell cellE = row2.createCell(4);
	    Cell cellF = row2.createCell(5);
	    Cell cellG = row2.createCell(6);
	    //Now, assigning value to each cell in string.
	    
	    cell1.setCellValue("First Name");
	    cell2.setCellValue("Last Name");
	    cell3.setCellValue("Phone Number");
	    cell4.setCellValue("Address");
	    cell5.setCellValue("School Name");
	    cell6.setCellValue("Grade Level");
	    cell7.setCellValue("Homeroom");
	    
	    cellA.setCellValue(456);
	    cellB.setCellValue(144);
	    cellC.setCellValue(00);
	    cellD.setCellValue(156);
	    cellE.setCellValue(586);
	    cellF.setCellValue(470);
	    cellG.setCellValue(111);
	        
		String filePath = System.getProperty("user.dir")+ "\\src\\ExcelDemo\\excelWriteData.xlsx";  //creating excel file named excelWriteData
		File file = new File(filePath);  //creating file path
		FileOutputStream fos = new FileOutputStream(file);  
		
		workbook.write(fos);   //write in workbook
		
		int rowcount = row1.getRowNum();
		int cellcount = row1.getPhysicalNumberOfCells();  
		System.out.println("File created");
		System.out.println("Total rows are: " +rowcount);
		System.out.println("Total cell/column are " +cellcount);
		System.out.println("Rows are: " +row2.getRowNum());
		System.out.println("Total cell are in row2 are:" + row2.getPhysicalNumberOfCells());

		workbook.close();
	}
}

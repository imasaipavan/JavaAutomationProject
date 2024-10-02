package CodePractise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class WriteDataFromExcel {
	
	
	@Test
	public void readData() throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"/lib/Excel/Blank1.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Sheet1");
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Name");
		row1.createCell(1).setCellValue("Age");
		row1.createCell(2).setCellValue("Weight");
		
		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Sai");
		row2.createCell(1).setCellValue(25);
		row2.createCell(2).setCellValue(95);
		
		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("Mani");
		row3.createCell(1).setCellValue(29);
		row3.createCell(2).setCellValue(75);
		book.write(file);
		book.close();
		file.close();
		
		FileInputStream file1 = new FileInputStream(System.getProperty("user.dir")+"/lib/Excel/Blank1.xlsx");
		XSSFWorkbook book1 = new XSSFWorkbook(file1);
		XSSFSheet sheet1 = book.getSheet("Sheet1");
		int rows= sheet1.getLastRowNum();
		int cols= sheet1.getRow(0).getLastCellNum();
		System.out.println("total rows are: "+rows+" and total columns are:"+cols);
		for(int i=0;i<=rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print(sheet.getRow(i).getCell(j).toString()+"  ");
			}
			System.out.println();
		}
		book1.close();
		file1.close();
	}
	
	
	
}

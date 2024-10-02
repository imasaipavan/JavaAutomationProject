package CodePractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;


public class ReadDataFromExcel {
	
	
	@Test
	public void readData() throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/lib/Excel/Blank1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("Sheet1");
		int rows= sheet.getLastRowNum();
		int cols= sheet.getRow(0).getLastCellNum();
		System.out.println("total rows are: "+rows+" and total columns are:"+cols);
		
		for(int i=0;i<=rows;i++) {
			for(int j=0;j<cols;j++) {
				System.out.print(sheet.getRow(i).getCell(j).toString()+"  ");
			}
			System.out.println();
		}
		book.close();
		file.close();
	}
	
	
	
}

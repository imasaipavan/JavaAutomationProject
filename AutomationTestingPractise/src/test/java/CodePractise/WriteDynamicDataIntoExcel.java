package CodePractise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDynamicDataIntoExcel {
	
	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"/lib/Excel/DynamicData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Sheet1");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter rows: ");
		int rows = sc.nextInt();
		System.out.println("Enter columns: ");
		int cols = sc.nextInt();
//		XSSFRow rows = sheet.getRow(0);
//		XSSFCell cols = rows.createCell(0);
		for(int i=0;i<=rows;i++) {
			for(int j=0;j<cols;j++) {
				XSSFRow trows = sheet.createRow(i);
				XSSFCell tcols = trows.createCell(j);
				tcols.setCellValue(sc.next());
			}
		}
		
		book.write(file);
		book.close();
		file.close();
		System.out.println("File created");
		
		
	}

}

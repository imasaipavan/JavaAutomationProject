package CodePractise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static FileInputStream fileInput;
	public static FileOutputStream fileOutput;
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String path, String sheetName) throws IOException {
		fileInput = new FileInputStream(path);
		book = new XSSFWorkbook(fileInput);
		sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		book.close();
		fileInput.close();
		return rowCount;
	}
	
	public static int getColCount(String path, String sheetName, int rowValue) throws IOException {
		fileInput = new FileInputStream(path);
		book = new XSSFWorkbook(fileInput);
		sheet = book.getSheet(sheetName);
		int colCount =sheet.getRow(rowValue).getLastCellNum();
		book.close();
		fileInput.close();
		return colCount;
	}
	
	public static String getCellData(String path, String sheetName, int rowValue, int cellValue) throws IOException {
		fileInput = new FileInputStream(path);
		book = new XSSFWorkbook(fileInput);
		sheet = book.getSheet(sheetName);
		XSSFCell cell =sheet.getRow(rowValue).getCell(cellValue);
		String cellData= cell.toString();
		book.close();
		fileInput.close();
		return cellData;
	}
	
	public static void setCellData(String path, String sheetName, int rowValue, int colValue, String cellValue) throws IOException {
		fileInput = new FileInputStream(path);
		book = new XSSFWorkbook(fileInput);
		sheet = book.getSheet(sheetName);
		sheet.getRow(rowValue).createCell(colValue).setCellValue(cellValue);
		fileOutput = new FileOutputStream(path);
		book.write(fileOutput);
		book.close();
		fileInput.close();
		fileOutput.close();
	
	}
}

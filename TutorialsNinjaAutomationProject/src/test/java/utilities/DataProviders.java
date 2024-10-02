package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name ="logindata")
	public String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir")+"/lib/Excel/UserLoginCreds.xlsx";
		ExcelUtils excel = new ExcelUtils(path);
		int trows = excel.getRowCount("Sheet1");
		int tcols = excel.getColCount("Sheet1",1);
		
		String logindata[][]= new String [trows][tcols];
		
		for(int i=1; i<=trows;i++) {
			for(int j=0;j<tcols;j++) {
				logindata[i-1][j]=excel.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
		
	}

}

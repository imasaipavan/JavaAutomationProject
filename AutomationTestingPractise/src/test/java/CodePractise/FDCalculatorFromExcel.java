package CodePractise;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FDCalculatorFromExcel {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
					"/lib/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			String file = System.getProperty("user.dir")+"/lib/Excel/PDCalculator.xlsx";
			int rows=ExcelUtils.getRowCount(file, "Sheet1");
			// read data from excel
			for(int i=1;i<=rows;i++) {
				String principle =ExcelUtils.getCellData(file, "Sheet1", i, 0);
				String roi =ExcelUtils.getCellData(file, "Sheet1", i, 1);
				String period =ExcelUtils.getCellData(file, "Sheet1", i, 2);
				String expValu=ExcelUtils.getCellData(file, "Sheet1", i, 3);
				
				  // Convert to double and cast to int
		        int number = (int) Double.parseDouble(principle);
		        int number2 = (int) Double.parseDouble(roi);
		        int number3 = (int) Double.parseDouble(period);
		        
		        // Convert back to string if needed
		        String principleResult = String.valueOf(number);
		        String roiResult = String.valueOf(number2);
		        String periodResult = String.valueOf(number3);
				
				//get data and pass to app
				driver.findElement(By.id("principal")).sendKeys(principleResult);
				driver.findElement(By.id("interest")).sendKeys(roiResult);
				driver.findElement(By.id("tenure")).sendKeys(periodResult);
				// Use JavascriptExecutor to click the element
	            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	            WebElement ele1 = driver.findElement(By.xpath("//*[@onclick='return getfdMatVal(this);']"));
	            // Execute JavaScript to click the element
	            jsExecutor.executeScript("arguments[0].click();", ele1);
				
				
						
				String actValue= driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
						
				WebElement ele2 = driver.findElement(By.xpath("(//div[@class='CTR PT15']//a)[2]"));
				jsExecutor.executeScript("arguments[0].click();", ele2);
						
				System.out.println(expValu);
				System.out.println(actValue);
				if(Double.parseDouble(expValu)==Double.parseDouble(actValue)) {
					System.out.println("Correct value came");
				}else {
					System.out.println("Wrong value came");
				}
				
				
				
			}
	}

}

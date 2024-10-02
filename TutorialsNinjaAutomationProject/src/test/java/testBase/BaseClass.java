package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public FileInputStream file;
	public Properties prop;
	
	@Parameters({"os","browserName"})
	@BeforeTest
	public void setUp(String os, String browserName) throws IOException
	{
		logger = LogManager.getLogger(this.getClass());
		file = new FileInputStream("H:\\SAI PAVAN\\AutomationTestingProject\\TutorialsNinjaAutomationProject\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(file);
		if(browserName.equalsIgnoreCase("chrome")) 
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/lib/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		} else if(browserName.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/lib/Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/lib/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appURL"));
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	public String randomStrin() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	public String randomNum() {
		return RandomStringUtils.randomNumeric(10);
	}
	public String randomPass() {
		return RandomStringUtils.randomAlphanumeric(7);
	}
	
	public String captureScreenshot(String name) {
		String timestamp = new SimpleDateFormat("HH.mm.dd.MM.yyyy").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String targetPath =System.getProperty("user.dir")+"/Screenshots/"+name+timestamp+".png";
		File des = new File(targetPath);
		src.renameTo(des);
		return targetPath;
	}
}

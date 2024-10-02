package CodePractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	public static WebDriver driver;
	public TakesScreenshot ts;
	File src;
	File des;
	Properties prop;
	FileInputStream file;
	
	@BeforeTest
	public void setUp() throws IOException {
		prop = new Properties();
		file = new FileInputStream(new File(System.getProperty("user.dir")
				+"/src/test/java/CodePractise/Config.properties"));
		prop.load(file);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
				"/lib/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}

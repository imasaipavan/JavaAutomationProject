package CodePractise;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
				"/lib/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Test(dataProvider = "dp")
	public void login(String name, String pass) throws InterruptedException {
		WebElement email = driver.findElement(By.id("input-email"));
		email.clear();
		email.sendKeys(name);
		WebElement password=driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
	}
	
	@DataProvider(name="dp")
	public Object[][] data() {
		Object [][] obj = {{"saipavan@gmail.com","abcd1"},
				{"saipavanavm@gmail.com","password2"},
				{"pavan@gmail.com","password3"}};
		return obj;
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}

package CodePractise;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ITestLisenersDemo {
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
	
	@Test(priority = 0)
	public void login() throws InterruptedException {
		WebElement email = driver.findElement(By.id("input-email"));
		email.clear();
		email.sendKeys("asaipavan333@gmail.com");
		WebElement password=driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("qafox@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		String expTitle = driver.getTitle();
		Assert.assertEquals(expTitle, "My Account");
	}
	
	@Test(priority = 1)
	public void loginWithInvalidCred() throws InterruptedException {
		WebElement email = driver.findElement(By.id("input-email"));
		email.clear();
		email.sendKeys("saipavan333@gmail.com");
		WebElement password=driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("qafox@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		String expTitle = driver.getTitle();
		Assert.assertEquals(expTitle, "My Account");
	}
	
	@Test(priority = 2)
	public void skipFunction() throws InterruptedException {
		WebElement email = driver.findElement(By.id("input-email"));
		email.clear();
		email.sendKeys("saipavan333@gmail.com");
		WebElement password=driver.findElement(By.id("input-password"));
		password.clear();
		password.sendKeys("qafox@123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		 throw new SkipException("Skipping this test because the condition is true.");
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}


}

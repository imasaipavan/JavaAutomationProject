package CodePractise;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProjectLaunchDemo {
	public static WebDriver driver;
	@BeforeTest
	public void setUp() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
				"/lib/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Test(priority = 0)
	public void login() throws InterruptedException {
		WebElement myAccount = driver.findElement(By.xpath("(//span[@class='hidden-xs hidden-sm hidden-md'])[3]"));
		myAccount.click();
		Thread.sleep(2000);
		WebElement register=driver.findElement(By.xpath("(//a[@href='https://tutorialsninja.com/demo/index.php?route=account/register'])[1]"));
		register.click();
		Thread.sleep(2000);
		driver.findElement(By.id("input-firstname")).sendKeys("sai");
		driver.findElement(By.id("input-lastname")).sendKeys("sai");
		driver.findElement(By.id("input-email")).sendKeys("sai@yopmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("sai@123");
		driver.findElement(By.id("input-confirm")).sendKeys("sai@123");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		
		String expTitle = driver.getTitle();
		Assert.assertEquals(expTitle, "Your Account Has Been Created!");
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}

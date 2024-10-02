package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class RegistrationTest extends BaseClass{
	
	@Test
	public void login() throws InterruptedException {
		try {
		HomePage home = new HomePage(driver);
		logger.info("*** Test cases started ***");
		home.clickMyAccount();
		logger.info("*** Clicked My Account ***");
		home.clickRegister();
		logger.info("*** Clicked Register button ***");
		
		RegistrationPage reg = new RegistrationPage(driver);
		reg.enterfirstName(randomStrin().toUpperCase());
		logger.info("*** Entered First Name ***");
		reg.enterlastName(randomStrin().toUpperCase());
		logger.info("*** Entered Last Name ***");
		reg.enteremail(randomStrin()+"@gmaail.com");
		logger.info("*** Entered Email ***");
		reg.enterphonenumber(randomNum());
		logger.info("*** Entered phone number ***");
		String password = randomPass();
		reg.enterpassword(password);
		logger.info("*** Entered password ***");
		reg.enterconfPassword(password);
		logger.info("*** Entered confirm password ***");
		reg.clickcheckbox();
		logger.info("*** Clicked checkbox ***");
		reg.clickContinue();
		logger.info("*** Click Continue button ***");
		Thread.sleep(2000);
		
		String expTitle = driver.getTitle();
		Assert.assertEquals(expTitle, "Your Account Has Been Created!s");
	}
	catch(Exception e) {
		logger.error("Test failed");
		logger.debug("Debug logs..");
	}
	}
	
}

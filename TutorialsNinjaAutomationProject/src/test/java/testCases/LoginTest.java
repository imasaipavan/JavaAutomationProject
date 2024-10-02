package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass{
	
	@Test
	public void login() throws InterruptedException {
		try {
		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		home.clickLogin();
		
		LoginPage login = new LoginPage(driver);
		login.enteremail(prop.getProperty("user1"));
		login.enterpassword(prop.getProperty("user1password"));
		login.clickContinue();
		MyAccountPage myAcc = new MyAccountPage(driver);
		if(myAcc.checkEditYourAccInfo()==true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
	}
	catch(Exception e) {
		logger.error("Test failed");
		logger.debug("Debug logs..");
	}
	}
	
}

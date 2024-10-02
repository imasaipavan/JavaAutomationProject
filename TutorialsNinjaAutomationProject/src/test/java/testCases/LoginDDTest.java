package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class LoginDDTest extends BaseClass{
	
	@Test(dataProvider = "logindata", dataProviderClass=DataProviders.class)
	public void login(String userName, String userPassword, String expValue) throws InterruptedException {
		try {
		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		home.clickLogin();
		
		LoginPage login = new LoginPage(driver);
		login.enteremail(userName);
		login.enterpassword(userPassword);
		login.clickContinue();
		
		/*
		String invalidusermsg="Warning: No match for E-Mail Address and/or Password.";
		String actmsg = home.getinvalidusermsg();
		MyAccountPage myAcc = new MyAccountPage(driver);
		if(myAcc.myAccountlink()==true) {
			Assert.assertTrue(myAcc.myAccountlink());
			myAcc.clicklogout();
			System.out.println("user can login with "+expValue+" credentials is passed");
		}else if(actmsg==invalidusermsg){
			System.out.println("user can't login with "+expValue+" credentials is passed");
		}
		*/
		
		
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
}

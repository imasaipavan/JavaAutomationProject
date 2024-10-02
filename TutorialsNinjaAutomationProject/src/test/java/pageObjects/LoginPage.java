package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-email")
	WebElement txtuseremail;
	
	@FindBy(id="input-password")
	WebElement txtuserpassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnlogin;
	
	@FindBy(xpath="(//a[@href='https://tutorialsninja.com/demo/index.php?route=account/forgotten'])[1]")
	WebElement btnforgotPassword;
	
	
	public void enteremail(String email) {
		txtuseremail.sendKeys(email);
	}
	
	public void enterpassword(String password) {
		txtuserpassword.sendKeys(password);
	}
	
	public void clickContinue() {
		btnlogin.click();
	}
	

}

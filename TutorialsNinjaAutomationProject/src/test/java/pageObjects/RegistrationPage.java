package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-firstname")
	WebElement txtfirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtlastName;
	
	@FindBy(id="input-email")
	WebElement txtemail;
	
	@FindBy(id="input-telephone")
	WebElement txtphone;
	
	@FindBy(id="input-password")
	WebElement txtpassword;
	
	@FindBy(id="input-confirm")
	WebElement txtconfirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btncontinue;
	
	@FindBy(xpath="//*[@id='content']//h1")
	WebElement successmg;
	
	public void enterfirstName(String fstName) {
		txtfirstName.sendKeys(fstName);
	}
	public void enterlastName(String lstName) {
		txtlastName.sendKeys(lstName);
	}
	public void enteremail(String email) {
		txtemail.sendKeys(email);
	}
	public void enterphonenumber(String phone) {
		txtphone.sendKeys(phone);
	}
	public void enterpassword(String password) {
		txtpassword.sendKeys(password);
	}
	public void enterconfPassword(String confPassword) {
		txtconfirmPassword.sendKeys(confPassword);
	}
	public void clickcheckbox() {
		checkbox.click();
	}
	public void clickContinue() {
		btncontinue.click();
	}
	
	public String successMsg() {
		return successmg.getText();
	}

}

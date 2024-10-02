package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="(//span[@class='hidden-xs hidden-sm hidden-md'])[3]")
	WebElement btnmyAccount;
	
	@FindBy(xpath="//a[@href='https://tutorialsninja.com/demo/index.php?route=account/register']")
	WebElement register;
	
	@FindBy(xpath="//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']")
	WebElement login;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']//i")
	WebElement invalidusermsg;
	
	public void clickMyAccount() {
		btnmyAccount.click();
	}
	
	public void clickRegister() {
		register.click();
	}
	public void clickLogin() {
		login.click();
	}
	
	public String getinvalidusermsg() {
		return invalidusermsg.getText();
	}
	
	
	

}

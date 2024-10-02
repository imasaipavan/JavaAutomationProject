package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="(//a[@href='https://tutorialsninja.com/demo/index.php?route=account/logout'])[2]")
	WebElement btnlogout;
	
	@FindBy(xpath="(//*[@id='content']//h2)[1]")
	WebElement txtmyAccount;
	
	@FindBy(xpath="(//a[@href='https://tutorialsninja.com/demo/index.php?route=account/edit'])[1]")
	WebElement linkeditYourAccInfo;
	
	public boolean checkEditYourAccInfo() {
		return linkeditYourAccInfo.isDisplayed();
	}
	
	public boolean myAccountlink() {
		return txtmyAccount.isDisplayed();
	}
	
	public void clicklogout() {
		btnlogout.click();
	}

}

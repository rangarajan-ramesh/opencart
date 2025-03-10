package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccount extends BaseClass {

	public  MyAccount (WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='list-group-item' and text()='Logout']")
	WebElement Logout;
	public void Logout() {
		Logout.click();	}
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement MyAccount;
public boolean MyAccountisdispalyed() {
	try{
		return MyAccount.isDisplayed();
	}
	catch(Exception E) {
		return false;
	}
}
}

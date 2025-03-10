package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor 
        super(driver);
		
	}
	@FindBy(xpath="//a[@title='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement Login;
	
	public void clickyAccount() {
		MyAccount.click();
	}
	
	public void clickMyRegister() {
		Register.click();
	}
	
	public void clickLogin() {
		Login.click();
	}
}

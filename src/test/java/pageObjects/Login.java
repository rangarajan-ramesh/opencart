package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseTest;

public class Login extends BaseClass {

	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	public void emailtext(String email) {
		Email.sendKeys(email);
	}
	
	public void passtext(String pass) {
		password.sendKeys(pass);
	}
	public void btnclick() {
		loginbutton.click();
	}

}

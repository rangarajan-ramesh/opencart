package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BaseClass {

	public RegisterPage (WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id=\"input-firstname\"]")
    WebElement FirstName;
	
	@FindBy(xpath="//input[@id=\"input-lastname\"]")
    WebElement LastName;
	
	@FindBy(xpath="//input[@id=\"input-email\"]")
	WebElement Email;
	
	@FindBy(xpath="//input[@id=\"input-telephone\"]")
	WebElement phone;
	
	@FindBy(xpath="//input[@id=\"input-password\"]")
	WebElement password;
	
	@FindBy(xpath="//input[@id=\"input-confirm\"]")
	WebElement confirmpassword;
	
	@FindBy(xpath="//*[text()='Yes']")
	WebElement YesRadioButton;
	
	@FindBy(xpath="//*[text()='No']")
	WebElement NoRadioButton;
	
	@FindBy(xpath="//*[@type='checkbox']")
	WebElement CheckBox;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement successmsg;
	
	public void FirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	public void LastName(String lname) {
		LastName.sendKeys(lname);
	}
	public void phone(String mobile) {
		phone.sendKeys(mobile);
	}
	public void password(String pass) {
		password.sendKeys(pass);
	}
	public void confirmpassword(String confpass) {
		confirmpassword.sendKeys(confpass);
	}
	public void YesButton() {
		YesRadioButton.click();;
	}
	public void NoButton() {
		NoRadioButton.click();;
	}
	public void CheckBox() {
		CheckBox.click();;
	}
	public void Email(String email) {
		Email.sendKeys(email);
	}
	public void submit() {
		submit.click();
	}
	
	public String confirmmsg() {
		try{
			return successmsg.getText();
		}
		catch(Exception E){
			return E.getMessage();
		}
	}

}

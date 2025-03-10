package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.MyAccount;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC003_Login_DDT extends BaseTest {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void Login_DDT(String Email, String Password, String exp){
		logger.info("Test has Started");
	     HomePage hp = new HomePage(driver);
	     hp.clickyAccount();
	     hp.clickLogin();
	     Login lp = new Login(driver);
	     lp.emailtext(Email);
	     lp.passtext(Password);
	     lp.btnclick();
	     MyAccount ma = new MyAccount(driver);
	    	 boolean result = ma.MyAccountisdispalyed();
	    
	    	 if(exp.equalsIgnoreCase("Valid")) {
	    		 if(result ==true) {
	    			 ma.Logout();
	    			 Assert.assertTrue(true);
	    		 }
	    		 else {
	    			 
	    			 Assert.assertTrue(false);
	    		 }
	    	 }
	    	 if(exp.equalsIgnoreCase("Invalid")) {
	    		 if(result==true) {
	    			 ma.Logout();
	    			 Assert.assertTrue(false);
	    		 }
	    		 else {
	    			 Assert.assertTrue(true);
	    		 }
	    	 }
	     
		}
	}



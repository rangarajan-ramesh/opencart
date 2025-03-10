package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.MyAccount;
import testBase.BaseTest;

public class TC002 extends BaseTest {
    @Test 
	public void VerifyLogin() {
	 
     logger.info("Test has Started");
     HomePage hp = new HomePage(driver);
     hp.clickyAccount();
     hp.clickLogin();
     Login lp = new Login(driver);
     lp.emailtext(p.getProperty("Email"));
     lp.passtext(p.getProperty("Password"));
     lp.btnclick();
     logger.info("Test has procced through Login Page");
     MyAccount ma = new MyAccount(driver);
     try {
    	 boolean result = ma.MyAccountisdispalyed();
    	 Assert.assertTrue(result);
     }
     catch (Exception E) {
    	 Assert.assertTrue(false);
     }

}
}

package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseTest;

public class TC001 extends BaseTest {
 


//public WebDriver driver;
   
  
   @Test
	public void RegisterPage() {
	    logger.info("Test has Started");
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		BaseTest bp = new BaseTest();
		hp.clickyAccount();
		hp.clickMyRegister();
		logger.info("Test has opened Register Page");
		rp.FirstName(bp.RandomString());
		rp.LastName(bp.RandomString());
		rp.Email(bp.RandomString()+"@gmail.com");
		rp.phone(bp.RandomNumbers());
		String Pass = bp.AlphaNumeric();
		rp.password(Pass);
		rp.confirmpassword(Pass);
		rp.YesButton();
		rp.CheckBox();
		rp.submit();
	    String resultMsg = rp.confirmmsg();
	    //Assert.assertEquals(resultMsg, "Your Account Has Been Created!");
	    //logger.info("Test has successfully finished");
	    
	    if(resultMsg.equals("Your Account Has Been Created!")) {
	    	
	    	Assert.assertTrue(true);
	    	logger.info("Test Has Passed");
	    	
	    }
	    
	    else {
	    	logger.debug("Debug");
	    
	    	Assert.assertTrue(false);
	    	
	    }
	}

}

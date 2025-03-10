package testBase;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.net.URL;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	   public static WebDriver driver;
	   public Logger logger;
	   public Properties p;
	   @SuppressWarnings("deprecation")
	@BeforeClass
	   @Parameters("Browser")
	   public void Startup(String br) throws IOException{
		   FileReader file = new FileReader("./src//test//resources//config.properties");
		     p = new Properties();
		     p.load(file);
		    logger= LogManager.getLogger(this.getClass());
		    //br.toLowerCase();
		    
		    if(p.getProperty("env").equalsIgnoreCase("Remote")) {
		    	DesiredCapabilities cap = new DesiredCapabilities();
		    	
		    	cap.setPlatform(Platform.WIN10);
		    	if(br.equalsIgnoreCase("chrome")) {
		    		cap.setBrowserName("chrome");
		    	}
		    	else if(br.equalsIgnoreCase("edge")) {
		    		cap.setBrowserName("MicrosoftEdge");
		    	}
		    	else {
		    		System.out.println("No Matching Browser");
		    		return;
		    	}
		    	
		    	driver = new RemoteWebDriver(new URL ("http://localhost:4444/wd/hub"), cap);
		    }
		    if(p.getProperty("env").equalsIgnoreCase("local")) {
		    	
		   
		    switch(br.toLowerCase()) {
		    case "chrome": driver = new ChromeDriver();break;
		    case "edge": driver = new EdgeDriver();break;
		    case "firefox": driver = new FirefoxDriver();break;
		    default: System.out.println("Invalide Browser Name"); return;
		    }
		    }
		    //driver = new ChromeDriver();
		    driver.get(p.getProperty("URL"));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    driver.manage().window().maximize();
		    } 
	
	  @AfterClass
	  public void teardown() {
			driver.quit();
		}  
	  
	  public String RandomString() {
		  @SuppressWarnings("deprecation")
		String RandomString =RandomStringUtils.randomAlphabetic(5);
		 return RandomString;
	  }
	  
	  public String RandomNumbers() {
		  @SuppressWarnings("deprecation")
		String RandomNumber =RandomStringUtils.randomNumeric(5);
		 return RandomNumber;
	  }
	  
	  public String AlphaNumeric() {
		  String AlphaNumeric = RandomStringUtils.randomAlphanumeric(8);
		  return AlphaNumeric+"@";
	  }
	  
	  public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}

}

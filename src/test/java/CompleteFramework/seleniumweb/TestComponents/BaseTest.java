package CompleteFramework.seleniumweb.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import CompleteFramework.seleniumweb.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
  public WebDriver driver;
  public LandingPage landingPage;
	

	
  public WebDriver InitializeDriver() throws IOException {

	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream(
	            System.getProperty("user.dir")+"//src//main//resources//GlobalData.properties");

	    prop.load(fis);

	    String browsername = prop.getProperty("browser");

	    if(browsername.equalsIgnoreCase("chrome")) {
 
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	    }

	    return driver;
	}
	
  @BeforeMethod
	public LandingPage  LaunchApplication() throws IOException {
		 driver=InitializeDriver();
			landingPage = new LandingPage(driver);
			landingPage.goTo();
			return landingPage;
		
	


	

	
	}    
  @AfterMethod
         public void Teardown() {
        	 driver.close();
         }
  
  public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
  {
      TakesScreenshot ts = (TakesScreenshot) driver;

      File source = ts.getScreenshotAs(OutputType.FILE);

      String filePath = System.getProperty("user.dir")
              + "//reports//" + testCaseName + ".png";
      System.out.println(filePath);
      FileUtils.copyFile(source, new File(filePath));

      return filePath;
  }
	

	}

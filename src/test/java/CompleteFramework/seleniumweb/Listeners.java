package CompleteFramework.seleniumweb;

import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
import java.lang.reflect.Field;
import org.openqa.selenium.WebDriver;

import CompleteFramework.seleniumweb.TestComponents.BaseTest;

public class Listeners extends BaseTest implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		 System.out.println("FAILED TEST : " + result.getName());
		 
		 WebDriver driver = null;
		 
		    try {
		        driver = (WebDriver) result.getTestClass()
		                .getRealClass()
		                .getField("driver")
		                .get(result.getInstance());
		    }
		    catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		 
		 System.out.println("Driver value = " + driver);
		 
		
		 
		 try {
			 
			 getScreenshot(result.getName(), driver);
			    
		 }
		 catch (IOException e) {
		     e.printStackTrace();
		 }

	}

}

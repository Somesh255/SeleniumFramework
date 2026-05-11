package CompleteFramework.seleniumweb;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CompleteFramework.seleniumweb.PageObjects.CartPage;
import CompleteFramework.seleniumweb.PageObjects.CheckoutPage;
import CompleteFramework.seleniumweb.PageObjects.ConfirmationPage;
import CompleteFramework.seleniumweb.PageObjects.LandingPage;
import CompleteFramework.seleniumweb.PageObjects.ProductCataloguePage;
import CompleteFramework.seleniumweb.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {
	
//	@FindBy(className="toast-bottom-right")
//	WebElement LoginError;

	@Test
	public void SubmitOrders() throws IOException {

//		String ProductName = "ZARA COAT 3";
//		String CountryName = "India";
		

	
		
		
	

		ProductCataloguePage productCataloguePage = landingPage.LoginApplication("somesh@gmail.com", "Wolverine@12345");
		
	Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email or password.");
		
		
	

		
	}
}
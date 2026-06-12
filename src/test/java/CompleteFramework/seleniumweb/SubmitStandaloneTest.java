package CompleteFramework.seleniumweb;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import CompleteFramework.seleniumweb.PageObjects.CartPage;
import CompleteFramework.seleniumweb.PageObjects.CheckoutPage;
import CompleteFramework.seleniumweb.PageObjects.ConfirmationPage;
import CompleteFramework.seleniumweb.PageObjects.LandingPage;
import CompleteFramework.seleniumweb.PageObjects.ProductCataloguePage;
import CompleteFramework.seleniumweb.TestComponents.BaseTest;

@Listeners(CompleteFramework.seleniumweb.Listeners.class)
public class SubmitStandaloneTest extends BaseTest {

	@Test
	public void SubmitOrders() throws IOException {

		String ProductName = "ZARA COAT 3";
		String CountryName = "India";

	

		ProductCataloguePage productCataloguePage = landingPage.LoginApplication("somesh@gmail.com", "Wolverine@1");

		List<WebElement> products = productCataloguePage.getProductList();

		productCataloguePage.AddProductToCart(ProductName);

		CartPage cartpage = productCataloguePage.goToCartPage();

		Boolean match = cartpage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(match);

		cartpage.javascriptexecutor();

		CheckoutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.SelectCountry(CountryName);

		ConfirmationPage confirmationpage = checkoutpage.SubmitOrder();

		String ConfirmMessage = confirmationpage.getconfirmationmessage();
		System.out.println(ConfirmMessage);
		Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		
	}
}
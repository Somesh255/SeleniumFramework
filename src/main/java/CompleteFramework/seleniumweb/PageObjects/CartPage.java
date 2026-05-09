package CompleteFramework.seleniumweb.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import CompleteFramework.seleniumweb.AbstractComp.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@class='cartSection']/h3")
	List<WebElement> CartProduct;
	
	
	@FindBy(css=".totalRow button")
	WebElement Checkoutele;
	
	public CartPage(WebDriver driver)
	{     
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	public Boolean VerifyProductDisplay(String ProductName) {
		Boolean match= CartProduct.stream().anyMatch(CartProducts ->CartProducts.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	

	
	public CheckoutPage goToCheckout() {
	Checkoutele.click();
	return new CheckoutPage(driver);
	}



public void javascriptexecutor()
{
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1100)");
}
	
}	
	
	
	
	
	
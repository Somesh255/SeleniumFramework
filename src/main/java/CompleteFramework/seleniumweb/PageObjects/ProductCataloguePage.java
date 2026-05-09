package CompleteFramework.seleniumweb.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CompleteFramework.seleniumweb.AbstractComp.AbstractComponents;

public class ProductCataloguePage extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCataloguePage(WebDriver driver)
	{     
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> Products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
	By ProductsBy= By.cssSelector(".mb-3");
	By AddToCart= By.cssSelector(".card-body button:last-of-type");
	By ToastMessage=By.cssSelector("#toast-container");
	
	public  List<WebElement> getProductList()
	{
		WaitforElementToAppear(ProductsBy);
		return Products;
		
		
		
		
		
	}
	
	
	public WebElement getProductByName(String ProductName)
	{
		WebElement prod =getProductList().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	
	public void AddProductToCart(String ProductName)
	{
		
		WebElement Prod = getProductByName(ProductName);
		Prod.findElement(AddToCart).click();
		WaitforElementToAppear(ToastMessage);
		WaitforElementToDisappear(spinner);
	}
	
}

	
	
	
	
	
	
	
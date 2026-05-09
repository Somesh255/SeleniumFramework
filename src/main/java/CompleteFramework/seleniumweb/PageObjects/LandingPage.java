package CompleteFramework.seleniumweb.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CompleteFramework.seleniumweb.AbstractComp.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	

	@FindBy(id="login")
	WebElement LoginButton;
	
	
	@FindBy(css="[class*='flyInOut']")
	WebElement ErrorMessage;
	
	
	public ProductCataloguePage LoginApplication(String email,String Password)
	{
		useremail.sendKeys(email);
		passwordEle.sendKeys(Password);
		LoginButton.click();
		ProductCataloguePage ProductCataloguePage= new ProductCataloguePage(driver);
		return ProductCataloguePage;
	}
	
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
		
	}
}

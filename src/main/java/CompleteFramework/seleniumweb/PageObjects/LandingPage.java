package CompleteFramework.seleniumweb.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	
//*	@FindBy(css="[class*='flyInOut']")
//*	WebElement ErrorMessage;
	
	By errorMessage = By.cssSelector(".toast-message");

	@FindBy(css=".toast-message")
	WebElement LoginErrorMessage;
	
	@FindBy(className="forgot-password-link")
	WebElement forgotPasswordLink;
	
	
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
	
	


	public String getErrorMessage()
	{
		WaitforElementToAppear(errorMessage);
	    return LoginErrorMessage.getText();
	}
	


public ForgotPasswordPage ForgotPassword() {

    forgotPasswordLink.click();

    return new ForgotPasswordPage(driver);

}
}

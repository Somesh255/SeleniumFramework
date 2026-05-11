package CompleteFramework.seleniumweb.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CompleteFramework.seleniumweb.AbstractComp.AbstractComponents;

public class ForgotPasswordPage {
	
	
	WebDriver driver;

	public ForgotPasswordPage(WebDriver driver)
	{
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@type='email']")
	WebElement ForgetPassEmail;
	
@FindBy(id="userPassword")
WebElement ResetEmailAddress;


@FindBy(id="confirmPassword")
WebElement ResetConfirmAddress;

@FindBy(xpath="//button[@type='submit']")
WebElement NewPasswordButton;

	
  
	 public void ResetPasswordPage(String Email, String Password, String ConfirmEmail) {
		 
		 ForgetPassEmail.sendKeys(Email);
		 ResetEmailAddress.sendKeys(Password);
		 ResetConfirmAddress.sendKeys(ConfirmEmail);
		 NewPasswordButton.click();
		 

	 }
	 
}
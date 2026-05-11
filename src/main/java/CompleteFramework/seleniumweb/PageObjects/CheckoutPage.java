package CompleteFramework.seleniumweb.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CompleteFramework.seleniumweb.AbstractComp.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	
	WebDriver driver;
	
	
	
	public CheckoutPage(WebDriver driver)
	{     
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	



         @FindBy(xpath="//*[@placeholder='Select Country']")
         WebElement country;
         
         
         @FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
         WebElement Selectcountry;
         
         
         @FindBy(css=".action__submit")
         WebElement Submit;
         
         By results=By.cssSelector(".ta-results");
         
         
         public void SelectCountry(String CountryName)
         {
        	 
        	    
             Actions act= new Actions(driver);
             act.sendKeys(country, CountryName).build().perform();
             WaitforElementToAppear(results);
             Selectcountry.click();
            
             
        	 
         }
         
         public ConfirmationPage SubmitOrder() {

        	    JavascriptExecutor js = (JavascriptExecutor) driver;
        	    js.executeScript("window.scrollBy(0,1300)");

        	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        	    wait.until(ExpectedConditions.elementToBeClickable(Submit));

        	    Submit.click();

        	    return new ConfirmationPage(driver);
        	}
         
         
         
         
         
         
	
}	



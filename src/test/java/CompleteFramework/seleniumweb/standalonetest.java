package CompleteFramework.seleniumweb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CompleteFramework.seleniumweb.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class standalonetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ProductName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("somesh@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Wolverine@1");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.cssSelector(".mb-3")));
		
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
	
		WebElement prod =products.stream().filter(product -> product.findElement(By.cssSelector("b"))
		.getText().equals(ProductName)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.cssSelector("#toast-container")));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(
		     //   By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List <WebElement>CartProduct=driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		Boolean match= CartProduct.stream().anyMatch(CartProducts ->CartProducts.getText().equalsIgnoreCase(ProductName));
        Assert.assertTrue(match);
        
    	JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)");
        driver.findElement(By.cssSelector(".totalRow button")).click();
        
        Actions act= new Actions(driver);
        act.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "India").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        
        driver.findElement(By.cssSelector(".action__submit")).click();
        
       String ConfirmMessage= driver.findElement(By.cssSelector(".hero-primary")).getText();
      Assert.assertTrue(ConfirmMessage.equalsIgnoreCase("Thankyou for the order."));
       
      driver.close();
	}

}

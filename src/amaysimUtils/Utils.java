package amaysimUtils;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Utils{
	

WebDriver driver;
WebDriverWait wait;
	
	
	public Utils(WebDriver _driver, WebDriverWait _wait){
		
		
	 driver = _driver;
	 wait = _wait;
		
	}	
	
	
	public void waitUntilOverviewPageDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='ama-page-heading']")));
	}
	
	
	public void waitUntilLoadingIsFinished()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajax_loading' and @style='display: none;']")));
	
	}
	
	public void waitUntilLoadingIsFinishedRefresh()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajax_loading' and @style='display:none']")));
	}
	
	public void waitUntilModalNotDisplayed()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='reveal-modal-bg' and @style='display: none;']")));
	}	
	
	
	public void scrollDownToElement(By elementlocator)
	{
		driver.findElement(elementlocator).sendKeys(Keys.PAGE_DOWN);
			
	}
	
	public void MoveToElement(WebElement element)
	{	
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		// actions.click();
		actions.perform();
	}
	
	






 }

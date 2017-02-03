package amaysimPageActions;



import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;




public class WorkflowNavigationActions{
	

WebDriver driver;
WebDriverWait wait;
	
	
	public WorkflowNavigationActions(WebDriver _driver, WebDriverWait _wait){
		
		
	 driver = _driver;
	 wait = _wait;
		
	}
	

	public void goToAmaysimHomePage()
	{
		driver.get("https://www.amaysim.com.au"); 
	}
	
	public void closeSIMActivationPopup()
	{
		driver.findElement(By.linkText("×")).click();		
	}
	
	
	public void closeSuccessMessagePopup()
	{		
		driver.findElement(By.xpath("//div[@data-popup-type='success']//a[@class='close-reveal-modal']")).click();
	}



 }

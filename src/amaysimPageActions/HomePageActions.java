package amaysimPageActions;






import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;




public class HomePageActions{
	

WebDriver driver;
WebDriverWait wait;
	
	
	public HomePageActions(WebDriver _driver, WebDriverWait _wait){
		
		
	 driver = _driver;
	 wait = _wait;
		
	}
	
	public void clickLoginLink()
	{
		driver.findElement(By.linkText("Login")).click();	 
	}
	
	



 }

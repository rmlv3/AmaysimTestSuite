package amaysimPageActions;



import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;



public class OverviewActions{
	

WebDriver driver;
WebDriverWait wait;
	
	
	public OverviewActions(WebDriver _driver, WebDriverWait _wait){
		
		
	 driver = _driver;
	 wait = _wait;
		
	}
	
	
	public void clickMySettingsLink()
	{
		
		driver.findElement(By.xpath("//*[@id='menu_list']/li[9]")).click();
	}
	






 }

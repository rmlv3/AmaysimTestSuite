package amaysimPageAssertions;



import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;




public class LoginAssertions{
	

WebDriver driver;
WebDriverWait wait;
	
	
	public LoginAssertions(WebDriver _driver, WebDriverWait _wait){
		
		
	 driver = _driver;
	 wait = _wait;
		
	}
	
	
	
	public void assertLoginValidationMessage(String message)
	{
		 Assert.assertEquals("Validation Message was not triggered",message,driver.findElement(By.xpath("//*[@id='new_my_amaysim2_user_session']/div[2]/div[5]/div")).getText());
	}
	
	
	







 }

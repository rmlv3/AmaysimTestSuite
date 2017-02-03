package amaysimPageActions;






import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;




public class LoginActions{
	

WebDriver driver;
WebDriverWait wait;
	
	
	public LoginActions(WebDriver _driver, WebDriverWait _wait){
		
		
	 driver = _driver;
	 wait = _wait;
		
	}
	
	public void inputAmaysimNumber(String number)
	{
		driver.findElement(By.id("my_amaysim2_user_session_login")).sendKeys(number);		 
	}
	
	public void inputPassword(String password)
	{
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(By.id("login_button")).click();
	}
	




 }

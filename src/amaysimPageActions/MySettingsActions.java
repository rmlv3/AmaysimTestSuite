package amaysimPageActions;





import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;




public class MySettingsActions{
	

WebDriver driver;
WebDriverWait wait;
	
	
	public MySettingsActions(WebDriver _driver, WebDriverWait _wait){
		
		
	 driver = _driver;
	 wait = _wait;
		
	}
	
	
	public void clickEditSIMNicknameLink()
	{
		driver.findElement(By.id("edit_settings_phone_label")).click();
	}
	

	public void inputSIMNickname(String nickName)
	{
		driver.findElement(By.id("my_amaysim2_setting_phone_label")).clear();
		driver.findElement(By.id("my_amaysim2_setting_phone_label")).sendKeys(nickName);	
	}
	
	public void clickEditRechargePINLink()
	{
		driver.findElement(By.id("edit_settings_recharge_pin")).click();
	}
	
	public void inputRechargePIN(String rechargePIN)
	{
		driver.findElement(By.id("my_amaysim2_setting_topup_pw")).clear();
		driver.findElement(By.id("my_amaysim2_setting_topup_pw")).sendKeys(rechargePIN);
	}
	
	public void clickCallerIdCheckBox()
	{
		driver.findElement(By.xpath("//label[@for='my_amaysim2_setting_caller_id_out']")).click();
		
	}
	
	public void clickEditCallForwardingLink()
	{
	driver.findElement(By.id("edit_settings_call_forwarding")).click();
	}
	
	public void clickConfirmButton()
	{
		driver.findElement(By.linkText("Confirm")).click();	
		
	}
	
	public void clickYesAllowCallForwardingRadioButton()
	{
		driver.findElement(By.xpath("//div[@id='settings_call_forwarding']//span[text()='Yes']")).click();
		}
	
	public void clickNoAllowCallForwardingRadioButton()
	{
		driver.findElement(By.xpath("//div[@id='settings_call_forwarding']//span[text()='No']")).click();
		}
	
	public void inputForwardCallsTo(String auNumber)
	{
		driver.findElement(By.id("my_amaysim2_setting_call_divert_number")).clear();
		driver.findElement(By.id("my_amaysim2_setting_call_divert_number")).sendKeys(auNumber+"\n");	
	}
	
	public void ClickSaveButton()
	{
		driver.findElement(By.name("commit")).click();
	}













 }

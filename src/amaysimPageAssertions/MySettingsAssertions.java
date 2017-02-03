package amaysimPageAssertions;



import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;




public class MySettingsAssertions{
	

WebDriver driver;
WebDriverWait wait;
	
	
	public MySettingsAssertions(WebDriver _driver, WebDriverWait _wait){
		
		
	 driver = _driver;
	 wait = _wait;
		
	}
	
	
	
	public void assertMySettingsPageDisplayed(String errorMessage)
	{
		Assert.assertEquals(errorMessage,"My Settings",driver.findElement(By.xpath("//h1[@class='ama-page-heading']")).getText());
	}
	
	public void assertSIMNameEdited(String expectedSIMName)
	{
		Assert.assertEquals("Failed to Edit SIM Nickname",expectedSIMName,driver.findElement(By.xpath("//div[@id='settings_sim_nickname']/div/div[1]/div/div[2]")).getText());
	}
	
	public void assertRechargePINFormatValidationMessageDsiplayed()
	{
		Assert.assertEquals("Pin Validation Message did not display correctly","Please enter a 4-digit top-up PIN number.",driver.findElement(By.xpath("//*[@id='edit_settings_topup_password']/div[2]/div/small")).getText());
	}
	
	public void assertRechargePINEdited(String expectedPIN)
	{
		Assert.assertEquals("Failed to Edit Pin",expectedPIN,driver.findElement(By.xpath("//*[@id='settings_recharge_pin']/div/div/div[1]/div/div[2]")).getText());
	}
	
	
	public void assertSuccessfullyUpdatedSIMSettingsPopupDisplayed()
	{
		Assert.assertEquals("Success Message not displayed","We have successfully updated your SIM settings.",driver.findElement(By.xpath("//div[@data-popup-type='success']//p")).getText());
	}
	
	public void assertConfirmationPopupDisplayed(String message)
	{
		Assert.assertTrue("Confirmation Message not displayed correctly", driver.findElement(By.xpath("//div[@class='form_confirm_popup reveal-modal padding-none open']//p")).getText().contains(message));
		
	}
	
	public void assertForwardCallsToFieldHidden()
	{
	Assert.assertEquals("Forward Calls To field not hidden","display: none;",driver.findElement(By.id("settings_divert_number")).getAttribute("style"));	
	}


	public void assertForwardCallsToFieldDisplayed()
	{
	Assert.assertEquals("Forward Calls To field not displayed","display: block;",driver.findElement(By.id("settings_divert_number")).getAttribute("style"));
	}

	public void assertAustralianNumberFormatValidationMessageDisplayed()
	{
	Assert.assertEquals("Australian Number Format Validation Message did not display correctly","Please enter your phone number in the following format: 0412 345 678 or 02 1234 5678",driver.findElement(By.xpath("//*[@id='settings_divert_number']/span")).getText());    
	}
	
	public void assertCallForwardingEnabled(String auNumber)
	{
	Assert.assertTrue("Australian Number not Reflected",driver.findElement(By.xpath("//div[@id='settings_call_forwarding']")).getText().contains(auNumber));
	Assert.assertTrue("Call forwarding did not enable",driver.findElement(By.xpath("//div[@id='settings_call_forwarding']")).getText().contains("Yes"));
	}







 }

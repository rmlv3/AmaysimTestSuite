package amaysimPageAssertions;





import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class OverviewAssertions{
	

WebDriver driver;
WebDriverWait wait;
	
	
	public OverviewAssertions(WebDriver _driver, WebDriverWait _wait){
		
		
	 driver = _driver;
	 wait = _wait;
		
	}
	
	
	
	public void assertOverviewPageDisplayed(String errorMessage)
	{
		 Assert.assertEquals(errorMessage,"Overview",driver.findElement(By.xpath("//h1[@class='ama-page-heading']")).getText());
	}
	
	
	



public void MySettings_TC_002_ViewMySettings() {

	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='menu_list']/li[9]/a")));
	driver.get(driver.findElement(By.xpath("//*[@id='menu_list']/li[9]/a")).getAttribute("href"));
	//Check if we are in the My Settings Page by asserting the My Settings header
	Assert.assertEquals("Failed to Go To My Settings","My Settings",driver.findElement(By.xpath("//h1[@class='ama-page-heading']")).getText());


}


public void MySettings_TC_003_EditSimNickname() {
	
	

	
	driver.findElement(By.id("edit_settings_phone_label")).click();
	//Wait until the loading counter disappears
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajax_loading' and @style='display: none;']")));
	
	
	driver.findElement(By.id("my_amaysim2_setting_phone_label")).clear();
	driver.findElement(By.id("my_amaysim2_setting_phone_label")).sendKeys("Test Sim Name Edited");	
	driver.findElement(By.name("commit")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajax_loading' and @style='display: none;']")));
	//Check if the change in the sim nickname is reflected after save
	Assert.assertEquals("Failed to Edit SIM Nickname","Test Sim Name Edited",driver.findElement(By.xpath("//div[@id='settings_sim_nickname']/div/div[1]/div/div[2]")).getText());


}

public void MySettings_TC_004_EditRechargePin() {
	
	
	driver.findElement(By.id("edit_settings_recharge_pin")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajax_loading' and @style='display: none;']")));
	driver.findElement(By.id("my_amaysim2_setting_topup_pw")).clear();
	driver.findElement(By.id("my_amaysim2_setting_topup_pw")).sendKeys("aaaa");
	driver.findElement(By.name("commit")).click();
	//Check if the Pin validation Message displays after inputting invalid Pin
	Assert.assertEquals("Pin Validation Message did not display correctly","Please enter a 4-digit top-up PIN number.",driver.findElement(By.xpath("//*[@id='edit_settings_topup_password']/div[2]/div/small")).getText());
	
	
	driver.findElement(By.id("my_amaysim2_setting_topup_pw")).clear();
	driver.findElement(By.id("my_amaysim2_setting_topup_pw")).sendKeys("1337");	
	driver.findElement(By.name("commit")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajax_loading' and @style='display: none;']")));
	//Check if the change in the pin is reflected after save
	Assert.assertEquals("Failed to Edit Pin","1337",driver.findElement(By.xpath("//*[@id='settings_recharge_pin']/div/div/div[1]/div/div[2]")).getText());


}

public void MySettings_TC_005_EditCallerId() {
	
	
	
	driver.findElement(By.xpath("//label[@for='my_amaysim2_setting_caller_id_out']")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajax_loading' and @style='display: none;']")));	
	//Check if the Success popup is displayed
	Assert.assertEquals("Success Message not displayed correctly","We have successfully updated your SIM settings.",driver.findElement(By.xpath("//div[@data-popup-type='success']//p")).getText());

	driver.findElement(By.xpath("//div[@data-popup-type='success']//a[@class='close-reveal-modal']")).click();
}

public void MySettings_TC_006_EditCallForwarding() throws InterruptedException {
	
	Thread.sleep(3000);
	//Scroll down to the Call forwarding Section
	driver.findElement(By.id("edit_settings_call_forwarding")).sendKeys(Keys.PAGE_DOWN);
	driver.findElement(By.id("edit_settings_call_forwarding")).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajax_loading' and @style='display: none;']")));	
	//Check if the Activate Call forwarding popup is displayed
	Assert.assertTrue("Confirmation Message not displayed correctly", driver.findElement(By.xpath("//div[@class='form_confirm_popup reveal-modal padding-none open']//p")).getText().contains("Would you like to continue?"));
	
	driver.findElement(By.linkText("Confirm")).click();	
	driver.findElement(By.id("my_amaysim2_setting_call_divert_number")).sendKeys(Keys.PAGE_DOWN);	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='settings_call_forwarding']//span[text()='No']")).click();
	//Check if the Phone Number field is hidden when no is clicked
	Assert.assertEquals("Forward Calls To field not hidden","display: none;",driver.findElement(By.id("settings_divert_number")).getAttribute("style"));
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='settings_call_forwarding']//span[text()='Yes']")).click();
	//Check if the Phone Number field is displayed when yes is clicked
	Assert.assertEquals("Forward Calls To field not showed","display: block;",driver.findElement(By.id("settings_divert_number")).getAttribute("style"));
	
	Thread.sleep(3000);	
	driver.findElement(By.id("my_amaysim2_setting_call_divert_number")).clear();
	driver.findElement(By.id("my_amaysim2_setting_call_divert_number")).sendKeys("aaaaaaaaaaa\n");	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajax_loading' and @style='display: none;']")));	
    //Check if the Phone Number Validation is displayed when inputting invalid number
	Assert.assertEquals("Australian Number Format Validation Message did not display correctly","Please enter your phone number in the following format: 0412 345 678 or 02 1234 5678",driver.findElement(By.xpath("//*[@id='settings_divert_number']/span")).getText());
    
    Thread.sleep(3000);	
	driver.findElement(By.id("my_amaysim2_setting_call_divert_number")).clear();
	driver.findElement(By.id("my_amaysim2_setting_call_divert_number")).sendKeys("0412345678\n");	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajax_loading' and @style='display: none;']")));	
	Thread.sleep(3000);
	//Check if the Success popup is displayed
	Assert.assertEquals("Success Message not displayed correctly","We have successfully updated your SIM settings.",driver.findElement(By.xpath("//div[@data-popup-type='success']//p")).getText());

	driver.findElement(By.xpath("//div[@data-popup-type='success']//a[@class='close-reveal-modal']")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("edit_settings_call_forwarding")).sendKeys(Keys.PAGE_DOWN);
	//Check if the Phone Number is reflected and the status is changed to Yes
	Assert.assertTrue("Australian Number not Reflected",driver.findElement(By.xpath("//div[@id='settings_call_forwarding']")).getText().contains("0412345678"));
	Assert.assertTrue("Call forwarding did not enable",driver.findElement(By.xpath("//div[@id='settings_call_forwarding']")).getText().contains("Yes"));
	
	


}



 }

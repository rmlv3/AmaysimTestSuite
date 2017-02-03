package myAmaysimTestSuite;






import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import amaysimPageActions.HomePageActions;
import amaysimPageActions.LoginActions;
import amaysimPageActions.MySettingsActions;
import amaysimPageActions.OverviewActions;
import amaysimPageActions.WorkflowNavigationActions;
import amaysimPageAssertions.MySettingsAssertions;
import amaysimPageAssertions.OverviewAssertions;
import amaysimUtils.Utils;




public class MySettingsScenarios{
	

WebDriver driver;
WebDriverWait wait;

LoginActions loginActions;
HomePageActions homePageActions;
OverviewActions overviewActions;
MySettingsActions mySettingsActions;
WorkflowNavigationActions workflowNavigationActions;

MySettingsAssertions mySettingsAssertions;
OverviewAssertions overviewAssertions;

Utils utils;


	
	public MySettingsScenarios(WebDriver _driver, WebDriverWait _wait){
		
		loginActions = new LoginActions(_driver, _wait);
		homePageActions = new HomePageActions(_driver, _wait);
		overviewActions = new OverviewActions(_driver, _wait);
		mySettingsActions =new MySettingsActions(_driver, _wait);
		workflowNavigationActions = new WorkflowNavigationActions(_driver, _wait);
		
		mySettingsAssertions = new MySettingsAssertions(_driver, _wait);
		overviewAssertions = new OverviewAssertions(_driver, _wait);
		
		utils = new Utils(_driver, _wait);
		
	 driver = _driver;
	 wait = _wait;
		
	}
public void signIn(String number, String password) 
{	
	
 workflowNavigationActions.goToAmaysimHomePage();
 homePageActions.clickLoginLink();
 loginActions.inputAmaysimNumber(number);
 loginActions.inputPassword(password);
 loginActions.clickLoginButton();
 utils.waitUntilOverviewPageDisplayed();
 workflowNavigationActions.closeSIMActivationPopup();
 
 
 
}

//Pre-requisite-already signed in
public void viewMySettings()throws InterruptedException {	
	utils.waitUntilModalNotDisplayed();
	overviewActions.clickMySettingsLink();
	utils.waitUntilLoadingIsFinishedRefresh();
}

//Pre-requisite-already in the My Settings Page
public void editSIMNickname(String nickname) {
	

	mySettingsActions.clickEditSIMNicknameLink();
	utils.waitUntilLoadingIsFinished();
	
	mySettingsActions.inputSIMNickname(nickname);
	mySettingsActions.ClickSaveButton();
	utils.waitUntilLoadingIsFinished();
	

}

//Pre-requisite-already in the My Settings Page
public void editRechargePin(String rechargePIN) {
	
	
	mySettingsActions.clickEditRechargePINLink();
	utils.waitUntilLoadingIsFinished();
	mySettingsActions.inputRechargePIN(rechargePIN);
	mySettingsActions.ClickSaveButton();
	utils.waitUntilLoadingIsFinished();
}

//Pre-requisite-already in the My Settings Page
public void editCallerId()
{
	mySettingsActions.clickCallerIdCheckBox();
	utils.waitUntilLoadingIsFinished();
	
}

public void editCallForwarding(String auNumber)throws InterruptedException {
	
	Thread.sleep(2000);
	utils.scrollDownToElement(By.id("edit_settings_call_forwarding"));
	mySettingsActions.clickEditCallForwardingLink();
	utils.waitUntilLoadingIsFinished();	
	//Check if the Activate Call forwarding popup is displayed
	mySettingsAssertions.assertConfirmationPopupDisplayed("You can forward calls to any Australian number.");
	
	mySettingsActions.clickConfirmButton();
	Thread.sleep(2000);
	utils.scrollDownToElement(By.id("my_amaysim2_setting_call_divert_number"));
	
	Thread.sleep(2000);
	mySettingsActions.clickNoAllowCallForwardingRadioButton();
	//Check if the Phone Number field is hidden when no is clicked
	mySettingsAssertions.assertForwardCallsToFieldHidden();
	
	Thread.sleep(2000);
	mySettingsActions.clickYesAllowCallForwardingRadioButton();
	//Check if the Phone Number field is displayed when yes is clicked
	mySettingsAssertions.assertForwardCallsToFieldDisplayed();
	
	
	mySettingsActions.inputForwardCallsTo("aaaaaaa\n");
	utils.waitUntilLoadingIsFinished();
	//Check if the Phone Number Validation is displayed when inputting invalid number
	mySettingsAssertions.assertAustralianNumberFormatValidationMessageDisplayed();
    
		
	mySettingsActions.inputForwardCallsTo(auNumber+"\n");
	utils.waitUntilLoadingIsFinished();	
	Thread.sleep(1000);
	//Check if the Success popup is displayed
	mySettingsAssertions.assertSuccessfullyUpdatedSIMSettingsPopupDisplayed();
	
	workflowNavigationActions.closeSIMActivationPopup();	
	utils.scrollDownToElement(By.id("edit_settings_call_forwarding"));
		

}



 }

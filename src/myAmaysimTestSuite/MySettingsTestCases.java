package myAmaysimTestSuite;



import org.junit.*;
import org.junit.runners.MethodSorters;

import org.junit.FixMethodOrder;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

import amaysimPageAssertions.LoginAssertions;
import amaysimPageAssertions.MySettingsAssertions;
import amaysimPageAssertions.OverviewAssertions;
import myAmaysimTestSuite.Logging;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MySettingsTestCases{
	
	 WebDriver driver;
	 WebDriverWait wait;
	 MySettingsScenarios scenarios;
	 LoginAssertions loginAssertions;
	 MySettingsAssertions mySettingsAssertions;
	 OverviewAssertions overviewAssertions;	
	
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void starting(Description description) {
		      Logging.startTestCase(description.getMethodName());		    
		    }		  
		protected void finished(Description description) {			
		      Logging.endTestCase(description.getMethodName());		    
		    }		
		protected void failed(Throwable e, Description description) {
	      Logging.error("FAILED - Message: " + e.getMessage());	    
	    }
	 };

	

@Before
public  void setUp() {
	 //System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
	 //FirefoxProfile firefoxProfile = new FirefoxProfile();
	 //firefoxProfile.setPreference("reader.parse-on-load.enabled",false);	 
	 //driver = new FirefoxDriver(firefoxProfile);
	 
	 //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
	 System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
	 driver = new  ChromeDriver();
	 wait = new WebDriverWait(driver, 20);
	 driver.manage().window().maximize();	
	 
	 scenarios = new MySettingsScenarios(driver, wait);
	 overviewAssertions = new OverviewAssertions(driver, wait);
	 mySettingsAssertions = new MySettingsAssertions(driver, wait);
	 loginAssertions = new LoginAssertions(driver, wait);
	 
}



@Test
public void MySettings_TC_001_SignIn() {
try{
	scenarios.signIn("0468827174","theHoff34");
	overviewAssertions.assertOverviewPageDisplayed("Login Failed");
	Logging.info("PASSED");
}catch(Exception e){
	Logging.error(e.getMessage());
}

}

@Test
public void MySettings_TC_002_ViewMySettings() {
try{
	scenarios.signIn("0468827174","theHoff34");
	scenarios.viewMySettings();
	mySettingsAssertions.assertMySettingsPageDisplayed("My Setting Page not displayed");
	Logging.info("PASSED");
}catch(Exception e){
	Logging.error(e.getMessage());
}
}

@Test
public void MySettings_TC_003_EditSimNickName() {
try{
	scenarios.signIn("0468827174","theHoff34");
	scenarios.viewMySettings();
	scenarios.editSIMNickname("SIM Nickname Edited");
	mySettingsAssertions.assertSIMNameEdited("SIM Nickname Edited");
	Logging.info("PASSED");
}catch(Exception e){
	Logging.error(e.getMessage());
}
}


@Test
public void MySettings_TC_004_1_EditRechargePinInvalid() {
try{
	scenarios.signIn("0468827174","theHoff34");
	scenarios.viewMySettings();
	scenarios.editRechargePin("aaaaaa");
 	mySettingsAssertions.assertRechargePINFormatValidationMessageDsiplayed();
 	Logging.info("PASSED");
}catch(Exception e){
	Logging.error(e.getMessage());
}
}

@Test
public void MySettings_TC_004_2_EditRechargePinValid() {
try{
	scenarios.signIn("0468827174","theHoff34");
	scenarios.viewMySettings();
	scenarios.editRechargePin("1337");
	mySettingsAssertions.assertRechargePINEdited("1337");
 Logging.info("PASSED");
}catch(Exception e){
	Logging.error(e.getMessage());
}
}


@Test
public void MySettings_TC_005_ActivateDeactivateCallerId() {
try{
	scenarios.signIn("0468827174","theHoff34");
	scenarios.viewMySettings();
	scenarios.editCallerId();
	mySettingsAssertions.assertSuccessfullyUpdatedSIMSettingsPopupDisplayed();
	Logging.info("PASSED");
}catch(Exception e){
	Logging.error(e.getMessage());
}
}

@Test
public void MySettings_TC_006_EditCallForwarding() {
try{
	scenarios.signIn("0468827174","theHoff34");
	scenarios.viewMySettings();
	scenarios.editCallForwarding("0412345678");
	mySettingsAssertions.assertCallForwardingEnabled("0412345678");
	Logging.info("PASSED");
}catch(Exception e){
	Logging.error(e.getMessage());
}
}

@After
public void afterTest() {
	 driver.quit();

}

 }

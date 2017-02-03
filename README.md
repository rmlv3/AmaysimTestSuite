# AmaysimTestSuite
# MyAmasimTestsuite

*****************Amaysim My Settings Test Suite README***************


Purpose:
Amaysim Test Suite created for the Amaysim assessment as part of the recruitment process.

Objectives:
Create a simple automation suite that exercises one of the most basic functions of MyAmaysim: managing setting.

How to run:

Pre-requisite: Please install latest version of chrome browser



1. Extract the zip File into a directory(it includes the test suite Jar file
	and a folder containing the browser driver, make sure they are in the same directory)
2. Open a command prompt
3. Cd to the the directory where the Jar file and the driver folder is extracted
4. Execute the Jar file with the command: "java -jar AmaysimTestSuite.jar"
5. Wait for the test to execute
6. Results and logs are generated in the same directory named logfile.log


Test Cases Included:

1) MySettings_TC_001_SignIn 		- Sign to Users Amaysim Dashboard
				  		@Checks if the user has succesfully logged in

2) MySettings_TC_002_ViewMySettings 	- Go to the Users My Settings Page
						@Checks if user could go to the my settings page

3) MySettings_TC_003_EditSimNickname 	- Edit the Sim Nickname
						@Checks if the user could edit the nick name
						@Checks if the change is reflected after save 

4) MySettings_TC_004_1_EditRechargePinInvalid 	- Edit the Recharge Pin with Invalid value
						@Checks if the user could edit the recharge pin
						@Checks the validation Message if invalid Pin is inputted
						
   MySettings_TC_004_2_EditRechargePinValid 	- Edit the Recharge Pin with Valid value
						@Checks if the user could edit the recharge pin
						@Checks the validation Message if invalid Pin is inputted
						

5)MySettings_TC_005_EditCallerId 	- Edit the users Caller Id
						@Checks if the user could turn the Caller Id on and Off
						@Checks if the the Success popup is displayed
		
6)MySettings_TC_006_EditCallForwarding 	- Edit the users Call forwarding
						@Checks if the user could turn the CAll Forwarding on and Off
						@Checks the interface by clicking Yes or No if the phone number
						 field is displayed or vise versa
						@Checks the validation message when inputting invalid phone number
						@Checks if the the Success popup is displayed
						@Checks if the change is reflected after save



	

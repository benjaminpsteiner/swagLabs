
@regression
Feature: Login 

	Scenario: Success 
	When the user logins with standard credentials
	Then we verify the home page
	
	Scenario: Fail
	When the user logins with ivalid credentials
	Then we verify that a login error occurs
	
	Scenario: Locked Out
	When the user logins with locked out credentials
	Then we verify that a locked out error occurs
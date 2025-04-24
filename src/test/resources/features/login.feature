Feature: Login 

	@regression
	Scenario: Success 
	When the user logins with standard credentials
	Then we verify the home page
	
	@regression
	Scenario: Fail
	When the user logins with ivalid credentials
	Then we verify that a login error occurs
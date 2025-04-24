Feature: Login 

	@smoke
	Scenario: Success 
	When the user logins with standard credentials
	Then we verify the home page
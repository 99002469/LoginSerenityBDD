Feature: Verify the login page for API 


Login API for invalid credentials 
@Security  
Scenario Outline: Verify the login API for invalid credentials
 	Given User prepares request body using <RequestBody> for Login API
    When User makes POST request on Login API
    Then Status code for Security API returns <status_code>
    And Error code for Security API returns <error_code>
    And Error description for Security API returns <error_desc>
 	Examples: 
        |Test description			    |RequestBody					 	|status_code|error_code |error_desc									  |
        |Test with invalid email format |LoginWithInvalidEmailFormat.json	|400		|9007		|Please provide valid email address			  |
        |Test with invalid password	    |LoginWithInvalidPassword.json	 	|401		|9001		|Unauthorized access	 					  |
        |Test with Unregistered email   |LoginWithUnregisteredEmail.json 	|401		|9001		|Unauthorized access						  |
        |Test with blank email		    |LoginWithBlankEmail.json			|400		|1001		|User name or password cannot be null or empty|
        |Test with blank password	    |LoginWithBlankPassword.json		|400		|1001		|User name or password cannot be null or empty|
        |Test without credentials	    |LoginWithoutCredentials.json	 	|400		|1001		|User name or password cannot be null or empty|
        |Test without email attribute   |LoginWithoutEmailAttribute.json 	|400		|1001		|User name or password cannot be null or empty|
        |Test without password attribute|LoginWithoutPasswordAttribute.json |400		|1001		|User name or password cannot be null or empty|

#Use Scenario Outline       
@Security
Scenario: Verify the Login API With valid credentials 
	Given The user provides a request body for login 
	When User makes POST request on Login API
	Then Status code for Security API returns 200
    And Succesful login return a message "Login successful"
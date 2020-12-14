Feature: Verify the Logout feature of the API
	
Scenario Outline: Verify the logout with invalid Authorization
	Given User has a User id <user_id> token id <token_id> from the lgoin
	When User makes a DELETE request for invalid LogOff
	Then Status code for Security Log off API returns <status_code>
	And Error code for Security Log off API returns <error_code>
    And Error description for Security Log off API returns <error_desc>
    
    Examples:
    |Test Description									|user_id			|token_id			|status_code  |error_code	|error_desc								 |
	|Logout with invalid Authorizaion and valid userID	|UserId.txt			|InvalidTokenId.txt |401		  |9001			|Unauthorized access					 |
	|Logout with invalid Authorizaion and invalid userID|InvalidUserId.txt	|InvalidTokenId.txt |400		  |9010			|Please enter valid GUID				 |
	|Logout with invalid Authorizaion and blank userID	|BlankUserId.txt	|InvalidTokenId.txt |404		  |||
		
Scenario Outline: Verify the login with Blank Authorzation 
	Given User has a User id <user_id> token id <token_id> from the lgoin
	When User makes a DELETE request for invalid LogOff
	Then Status code for Security Log off API returns <status_code>
	And Error code for Security Log off API returns <error_code>
    And Error description for Security Log off API returns <error_desc>
    
    Examples:
    |Test Description									|user_id			|token_id				|status_code  |error_code	|error_desc								 |
	|Logout with blank Authorizaion and valid userID	|UserId.txt			|BlankAuthorization.txt |401		  |9001			|Unauthorized access					 |
	|Logout with blank Authorizaion and invalid userID	|InvalidUserId.txt	|BlankAuthorization.txt |400		  |9010			|Please enter valid GUID				 |
	|Logout with blank Authorizaion and blank userID	|BlankUserId.txt	|BlankAuthorization.txt |404		  |||
    
Scenario Outline: Verify the login with Expired Authorization
	Given User has a User id <user_id> token id <token_id> from the lgoin
	When User makes a DELETE request for invalid LogOff
	Then Status code for Security Log off API returns <status_code>
	And Error code for Security Log off API returns <error_code>
    And Error description for Security Log off API returns <error_desc>
    
   Examples:
    |Test Description									|user_id			|token_id			|status_code  |error_code	|error_desc								 |
	|Logout with Expired Authorizaion and valid userID	|UserId.txt			|ExpiredTokenId.txt |401		  |9001			|Unauthorized access					 |
	|Logout with Expired Authorizaion and invalid userID|InvalidUserId.txt	|ExpiredTokenId.txt |400		  |9010			|Please enter valid GUID				 |
	|Logout with Expired Authorizaion and blank userID	|BlankUserId.txt	|ExpiredTokenId.txt |404		  |||
	

Scenario Outline: Verify the login with invalid UserId
	Given User has a User id <user_id> token id <token_id> from the lgoin
	When User makes a DELETE request for invalid LogOff
	Then Status code for Security Log off API returns <status_code>
	And Error code for Security Log off API returns <error_code>
    And Error description for Security Log off API returns <error_desc>
    
Examples:
    |Test Description									|user_id			|token_id			|status_code  |error_code	|error_desc								 |
	|Logout with invalid User id and valid Authorization|InvalidUserId.txt	|TokenId.txt		|400		  |9010			|Please enter valid GUID				 |
  
@Security
Scenario: Successful Logoff from the API
	Given User has a login id from the login
	And User has a token id from the lgoin
	When User makes a DELETE request for LogOff
	Then Status code for Security logoff API returns 200
	And Succesful logoff return a message "Log off successful" 
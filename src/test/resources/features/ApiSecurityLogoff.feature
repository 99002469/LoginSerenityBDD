Feature: Verify the Logout feature of the API

@API	
Scenario Outline: Verify the logout with invalid Authorization
	When User makes a DELETE request for LogOff using <user_id> and <token_id>
	Then Status code for Security API returns <status_code>
    And Error code for Security API returns <error_code>
    And Error description for Security API returns <error_desc>
    
    Examples:
    |Test Description						|user_id		|token_id           |status_code  |error_code	|error_desc								 |
	|Logout with invalid Authorizaion and valid userID	|UserId.txt		|InvalidTokenId.txt |401	  |9001		|Unauthorized access					 |
	|Logout with invalid Authorizaion and invalid userID	|InvalidUserId.txt	|InvalidTokenId.txt |400	  |9010		|Please enter valid GUID				 |
	
@API		
Scenario Outline: Verify the login with Blank Authorzation 
	When User makes a DELETE request for LogOff using <user_id> and <token_id>
	Then Status code for Security API returns <status_code>
    And Error code for Security API returns <error_code>
    And Error description for Security API returns <error_desc>
    Examples:
    |Test Description						|user_id		|token_id		|status_code  	|error_code	|error_desc								 |
	|Logout with blank Authorizaion and valid userID	|UserId.txt		|BlankAuthorization.txt |401		|9009		|Security token must not be null or empty|
	|Logout with blank Authorizaion and invalid userID	|InvalidUserId.txt	|BlankAuthorization.txt |401		|9009		|Security token must not be null or empty|
	
@API    
Scenario Outline: Verify the login with Expired Authorization
	When User makes a DELETE request for LogOff using <user_id> and <token_id>
	Then Status code for Security API returns <status_code>
    And Error code for Security API returns <error_code>
    And Error description for Security API returns <error_desc>
    
   Examples:
    	|Test Description					|user_id		|token_id		|status_code 	  |error_code	|error_desc								 |
	|Logout with Expired Authorizaion and valid userID	|UserId.txt		|ExpiredTokenId.txt 	|401		  |9001		|Unauthorized access					 |
	|Logout with Expired Authorizaion and invalid userID	|InvalidUserId.txt	|ExpiredTokenId.txt 	|400		  |9010		|Please enter valid GUID				 |
	
	
@API
Scenario Outline: Verify the login with invalid UserId
	When User makes a DELETE request for LogOff using <user_id> and <token_id>
	Then Status code for Security API returns <status_code>
    And Error code for Security API returns <error_code>
    And Error description for Security API returns <error_desc>
    
Examples:
    	|Test Description					|user_id			|token_id		|status_code  	|error_code	|error_desc								 |
	|Logout with invalid User id and valid Authorization	|InvalidUserId.txt		|TokenId.txt		|400		|9010		|Please enter valid GUID				 |

@API
Scenario Outline: Verify the logout with Blank UserID
	When User makes a DELETE request for LogOff using <user_id> and <token_id>
	Then Status code for Security API returns <status_code>
 Examples:
    |Test Description					|user_id		|token_id		|status_code  |
    |Logout with invalid Authorizaion and blank userID	|BlankUserId.txt	|InvalidTokenId.txt	|404	  |
    |Logout with blank Authorizaion and blank userID	|BlankUserId.txt	|BlankAuthorization.txt |404	  |
    |Logout with Expired Authorizaion and blank userID	|BlankUserId.txt	|ExpiredTokenId.txt 	|404	  |
    
@API @Security
Scenario Outline: Successful Logoff from the API
	When User makes a DELETE request for LogOff using <user_id> and <token_id>
	Then Status code for Security API returns <status_code>
	And Succesful Logout return a message <successMsg>
	
	Examples:
	|Test Description					|user_id   |token_id   |status_code| successMsg		|
	|Logout with Valid User id and Valid Authorization	|UserId.txt|TokenId.txt|200        | Log off successful |
	
	
	
	

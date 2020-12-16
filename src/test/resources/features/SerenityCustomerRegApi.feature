Feature: Registering a customer

Scenario Outline: Verify the login with invalid Authorization token 
#	Given The user prepares a <RequestBody> for <authorization> registering the customer
	When User makes a POST request on the Customer Registration using <customerName> <contactName> <phoneNumber> <emailId> <contactMethod> <additionalInfo> and <authorization>
	Then Status code for Site API returns <status_code>
	And Error code for Site API returns <error_code>
	And Error description for Site API returns <error_desc>
	
	Examples: 
	|Test description			  	 					|customerName |contactName   |phoneNumber  |emailId         |contactMethod  |additionalInfo             |authorization				|status_code|error_code |error_desc   							  |
	|Verify registration with invalid Authorization 	|TesterCust1  | TesterCust   | 123456789   |some@random.com |Others         |Copy to testcust@eaton.com |InvalidTokenId.txt			|401		|9001		|Unauthorized access					  |
	|Verify registration with Blank Authorization 		|TesterCust1  | TesterCust   | 123456789   |some@random.com |Others         |Copy to testcust@eaton.com |BlankAuthorization.txt		|401		|9009		|Security token must not be null or empty |	
	|Verify registration with Expired Authorization		|TesterCust1  | TesterCust   | 123456789   |some@random.com |Others         |Copy to testcust@eaton.com |ExpiredTokenId.txt			|401		|9001		|Unauthorized access				  	  |

Scenario Outline: Verify the blank/invalid scenarios to register a customer
	
#	Given The user prepares a <RequestBody> for <authorization> registering the customer
	When User makes a POST request on the Customer Registration using <customerName> <contactName> <phoneNumber> <emailId> <contactMethod> <additionalInfo> and <authorization>
	Then Status code for Site API returns <status_code>
	And Error code for Site API returns <error_code>
	And Error description for Site API returns <error_desc>
 
	Examples: 
	|Test description			   	 						|customerName | contactName  | phoneNumber | emailId         | contactMethod | additionalInfo             |authorization|status_code|error_code |error_desc     							|
	|Verify Registration with Blank Customer Name  			|             | TesterCust   | 123456789   | some@random.com | Others        | Copy to testcust@eaton.com |TokenId.txt	|400   		|9008		|Input parameters cannot be null or empty	|
	|Verify Resitration with Blank Contact Name 	 		| TesterCust1 |              | 123456789   | some@random.com | Others        | Copy to testcust@eaton.com |TokenId.txt	|400   	 	|9008		|Input parameters cannot be null or empty	|
	|Verify Registration with Blank Contact Number			| TesterCust1 | TesterCust   |             | some@random.com | Others        | Copy to testcust@eaton.com |TokenId.txt	|400		|9008		|Input parameters cannot be null or empty	|
	|Verify Registration with Blank Contact Email 	 		| TesterCust1 | TesterCust   | 123456789   |                 | Others        | Copy to testcust@eaton.com |TokenId.txt	|400    	|9008		|Input parameters cannot be null or empty	|
	|Verify Registration With Blank Contact Method			| TesterCust1 | TesterCust   | 123456789   | some@random.com |               | Copy to testcust@eaton.com |TokenId.txt	|400    	|9008		|Input parameters cannot be null or empty	|
	|Verify Registration with Invalid Contact Email			| TesterCust1 |              | 123456789   | invalidEmail	 | Others        | Copy to testcust@eaton.com |TokenId.txt	|400		|9007		|Please provide valid email address			|
	|Verify Registration with Blank Credentials				|          	  |              |             |                 |               |                            |TokenId.txt	|400		|9008		|Input parameters cannot be null or empty	|	
	
	
	
	
	
	
	
	
	
	
	
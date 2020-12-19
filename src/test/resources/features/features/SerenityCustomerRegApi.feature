Feature: Registering a customer

Scenario Outline: Verify the login with invalid Authorization token 
	Given The user prepares a <RequestBody> for <authorization> registering the customer
	When User makes a POST request on the Customer Registration using <RequestBody> and <authorization>
	Then Status code for Site API returns <status_code>
	And Error code for Site API returns <error_code>
	And Error description for Site API returns <error_desc>
	
	Examples: 
	|Test description			  	 					|RequestBody				|authorization				|status_code|error_code |error_desc   							  |
	|Verify registration with invalid Authorization 	|ValidCustomerDetails.json	|InvalidTokenId.txt			|401		|9001		|Unauthorized access					  |
	|Verify registration with Blank Authorization 		|ValidCustomerDetails.json	|BlankAuthorization.txt		|401		|9009		|Security token must not be null or empty |	
	|Verify registration with Expired Authorization		|ValidCustomerDetails.json	|ExpiredTokenId.txt			|401		|9001		|Unauthorized access				  	  |

Scenario Outline: Verify the blank/invalid scenarios to register a customer
	
	Given The user prepares a <RequestBody> for <authorization> registering the customer
	When User makes a POST request on the Customer Registration using <RequestBody> and <authorization>
	Then Status code for Site API returns <status_code>
	And Error code for Site API returns <error_code>
	And Error description for Site API returns <error_desc>
 
	Examples: 
	|Test description			   	 						|RequestBody					|authorization	|status_code|error_code |error_desc     							|
	|Verify Registration with Blank Customer Name  			|BlankCustomerName.json			|TokenId.txt	|400   		|9008		|Input parameters cannot be null or empty	|
	|Verify Resitration with Blank Contact Name 	 		|BlankContactName.json			|TokenId.txt	|400   	 	|9008		|Input parameters cannot be null or empty	|
	|Verify Registration with Blank Contact Number			|BlankContactNumber.json		|TokenId.txt	|400		|9008		|Input parameters cannot be null or empty	|
	|Verify Registration with Blank Contact Email 	 		|BlankContactEmail.json			|TokenId.txt	|400    	|9008		|Input parameters cannot be null or empty	|
	|Verify Registration With Blank Contact Method			|BlnakContactMethod.json		|TokenId.txt	|400    	|9008		|Input parameters cannot be null or empty	|
	|Verify Registration with Invalid Contact Email			|InvalidConatactEmail.json		|TokenId.txt	|400		|9007		|Please provide valid email address			|
	|Verify Registration with Blank Credentials				|BlankCredentials.json			|TokenId.txt	|400		|9008		|Input parameters cannot be null or empty	|	
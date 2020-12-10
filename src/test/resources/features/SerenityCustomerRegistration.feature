Feature: Registering a customer

Scenario Outline: Verify the login with invalid Authorization token 
	Given The user prepares a <RequestBody> for registering the customer
	And User has the invalid <authorization> authorization token of the login
	When User makes a POST request on the Customer Registration
	Then Status code for Site API returns <status_code>
	And Error code for Site API returns <error_code>
	And Error description for Site API returns <error_desc>
	
	Examples: 
	|Test description			  	 					|RequestBody				|authorization				|status_code|error_code |error_desc   							  |
	|Verify registration with invalid Authorization 	|ValidCustomerDetails.json	|Invalidauthorization.json  |401		|9001		|Unauthorized access					  |
	|Verify registration with Blank Authorization 		|ValidCustomerDetails.json	|							|401		|9001		|Security token must not be null or empty |	
	|Verify registration with Expired Authorization		|ValidCustomerDetails.json	|ExpiredAuthorization.json	|401		|9001		|Unauthorized access				  	  |

Scenario Outline: Verify the blank/invalid scenarios to register a customer
	
	Given The user prepares a <RequestBody> for registering the customer 
	And User has the valid authorization token of the login
	When User makes a POST request on the Customer Registration
	Then Status code for Site API returns <status_code>
	And Error code for Site API returns <error_code>
	And Error description for Site API returns <error_desc>
 
	Examples: 
	|Test description			   	 						|RequestBody					|status_code|error_code |error_desc     |
	|Verify Registration with Blank Customer Name  			|BlankCustomerName.json			|400   		|9008		|Input parameters cannot be null or empty	|
	|Verify Resitration with Blank Contact Name 	 		|BlankContactName.json			|400   	 	|9008		|Input parameters cannot be null or empty	|
	|Verify Registration with Blank Contact Number			|BlankContactNumber.json		|400		|9008		|Input parameters cannot be null or empty	|
	|Verify Registration with Blank Contact Email 	 		|BlankContactEmail.json			|400    	|9008		|Input parameters cannot be null or empty	|
	|Verify Registration With Blank Contact Method			|BlnakContactMethod.json		|400    	|9008		|Input parameters cannot be null or empty	|
	|Verify Registration with Invalid Contact Email			|InvalidConatactEmail.json		|401		|9001		|Invalid email format						|
	|Verify Registration with Invalid Contact Email			|BlankCredentials.json			|400		|9008		|Input parameters cannot be null or empty	|					
 

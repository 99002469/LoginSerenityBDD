Feature: Customer Registration 

#@UI @CustomerRegistration
#Scenario Outline: Verify the Customer registration with blank credentials
#	Given FADR Home page is open on Browser
#	And Authorized user selects the Factory Reset from the menu
#	When User Navigates to the Customer Registration
#	Then Customer registration page is open
#	When Enter the Details of the customer "<CustName>" add "<ContactName>" add "<ContactPhone>" add "<ContactEmail>"
#	And Select the Contact Method from the DropDown "<ContactMethod>"
#	And Fill the Additional Info "<AdditionalInfo>"
#	Then Submit button should be disabled
#	And Error Message "<ErrorMessage>" is displayed
#	
#	Examples:
#	|Test description			   	 						|CustName	  | ContactName  |ContactPhone |ContactEmail     |ContactMethod	|AdditionalInfo	            |ErrorMessage							|
#	|Verify Registration with Blank Customer Name  			|             | TesterCust   | 123456789   | some@random.com |Other		 	|Copy to testcust@eaton.com |Customer name is required				|
#	|Verify Resitration with Blank Contact Name 	 		| TesterCust1 |              | 123456789   | some@random.com |Other 		|Copy to testcust@eaton.com |Contact name is required				|
#	|Verify Registration with Blank Contact Number			| TesterCust1 | TesterCust   |             | some@random.com |Other			|Copy to testcust@eaton.com |Phone number is required				|
#	|Verify Registration with Blank Contact Email 	 		| TesterCust1 | TesterCust   | 123456789   |                 |Other			|Copy to testcust@eaton.com |E-mail is required						|
#	|Verify Registration With Blank Contact Method			| TesterCust1 | TesterCust   | 123456789   | some@random.com |Other			|Copy to testcust@eaton.com |Approved contact method is required	|	
#
#@UI @CustomerRegistration	
#Scenario Outline: Verify the Customer registration with invalid credentials
#
#	Given FADR Home page is open on Browser
#	And Authorized user selects the Factory Reset from the menu
#	When User Navigates to the Customer Registration
#	Then Customer registration page is open
#	When Enter the Details of the customer "<CustName>" add "<ContactName>" add "<ContactPhone>" add "<ContactEmail>"
#	And Select the Contact Method from the DropDown "<ContactMethod>"
#	And Fill the Additional Info "<AdditionalInfo>"
#	Then Submit button should be disabled
#	And Error Message "<ErrorMessage>" is displayed
#	
#	Examples:
#	|Test description			   	 								|CustName	  | ContactName  |ContactPhone |ContactEmail     |ContactMethod	|AdditionalInfo	             |ErrorMessage							|
#	|Verify Registration with Invalid Contact Email 	 			| TesterCust1 | TesterCust   | 123456789   | invalidEmail    |Other			|Copy to testcust@eaton.com  |Please enter a valid email			|
#	|Verify Registration with Invalid Contact Number (Alphabets)	| TesterCust1 | TesterCust   | abcddef     | some@random.com |Other			| Copy to testcust@eaton.com |Please enter valid phone number		|
#	|Verify Registration with Invalid Contact Number (Alphanumeric)	| TesterCust1 | TesterCust   | abcd1234    | some@random.com |Other			| Copy to testcust@eaton.com |Please enter valid phone number		|
#	|Verify Registration with Invalid Contact Number(Spaces between)| TesterCust1 | TesterCust   | 1234 6554   | some@random.com |Other			| Copy to testcust@eaton.com |Please enter valid phone number		|
#	|Verify Registration with Invalid Contact Number(Special char)	| TesterCust1 | TesterCust   | #$5644@44   | some@random.com |Other			| Copy to testcust@eaton.com |Please enter valid phone number		|

@UI @CustomerRegistration @Last
Scenario Outline: Verify the Reset Button on Customer Registration page
	Given FADR Home page is open on Browser
	And Authorized user selects the Factory Reset from the menu
	When User Navigates to the Customer Registration
	Then Customer registration page is open
	When Enter the Details of the customer "<CustName>" add "<ContactName>" add "<ContactPhone>" add "<ContactEmail>"
	And Select the Contact Method from the DropDown "<ContactMethod>"
	And Fill the Additional Info "<AdditionalInfo>"
	And Error Message "<ErrorMessage>" is displayed
	When User Clicks on the Reset Button
	Then Data Entered Should be cleared
	
	Examples:
	|Test description			   	 								|CustName	  | ContactName  |ContactPhone |ContactEmail     |ContactMethod	|AdditionalInfo	             |ErrorMessage							|
	|Verify Reset button with valid details entered 	 			| TesterCust1 | TesterCust   | 1234 6789   | some@random.com |Other			|Copy to testcust@eaton.com  |Please enter valid phone number		|
	|Verify Reset button with invalid details entered				| TesterCust1 | TesterCust   | 234534448   | invalidEmail    |Other			|Copy to testcust@eaton.com  |Please enter a valid email			|
	
#@UI @CustomerRegistration	
#Scenario Outline: Verify the Customer registration entering Characters more than feild limits
#	Given FADR Home page is open on Browser
#	And Authorized user selects the Factory Reset from the menu
#	When User Navigates to the Customer Registration
#	Then Customer registration page is open
#	When Enter the Details of the customer "<CustName>" add "<ContactName>" add "<ContactPhone>" add "<ContactEmail>"
#	Then Input feild should not accept the chracters more than field for "<CustName>" and "<ContactPhone>"
#	Then Submit button should be disabled
#	
#	Examples:
#	|Test description			   	 								|CustName	  		 					| ContactName  	|ContactPhone 			|ContactEmail     |
#	|Verify the Customer Name feild with more than 256 characters	| ThisStringGeneratesMoreThan256Chars 	| TesterCust   	| 123456789123456789 	| some@random.com |
#	|Verify the Contact Phone feild with more than 16 numbers		| TesterCust1		 					| TesterCust   	| 123456789123456789    | some@random.com |
	
	
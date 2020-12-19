Feature: Customer Registration 

@SuccessfulLogin
Scenario: Validating the Login with valid credentials

	 Given The login page is open on the browser
	 When Enter the user name "fadr_support_admin@eaton.com"
	 And Enter the Password "Form7@22"
	 Then Login button should be Enabled
	 When click on login button
	 Then Navigate to the FADR Home page

@CustomerRegistration
Scenario Outline: Verify the Customer registration with blank credentials
	Given FADR Home page is open on Browser
	And Authorized user selects the Factory Reset from the menu
	When User Navigates to the Customer Registration
	Then Customer registration page is open
	When Enter the Details of the customer "<CustName>" "<ContactName>" "<ContactPhone>" "<ContactEmail>"
	And Select the Contact Method from the DropDown "<ContactMethod>"
	And Fill the Additional Info "<AdditionalInfo>"
	Then Submit button should be disabled
	And Error Message "<ErrorMessage>" is displayed
	
	Examples:
	|Test description			   	 						|CustName	  | ContactName  |ContactPhone |ContactEmail     | additionalInfo             |ErrorMessage							|
	|Verify Registration with Blank Customer Name  			|             | TesterCust   | 123456789   | some@random.com | Copy to testcust@eaton.com |Customer name is required			|
	|Verify Resitration with Blank Contact Name 	 		| TesterCust1 |              | 123456789   | some@random.com | Copy to testcust@eaton.com |Contact name is required				|
	|Verify Registration with Blank Contact Number			| TesterCust1 | TesterCust   |             | some@random.com | Copy to testcust@eaton.com |Phone number is required				|
	|Verify Registration with Blank Contact Email 	 		| TesterCust1 | TesterCust   | 123456789   |                 | Copy to testcust@eaton.com |E-mail is required					|
	|Verify Registration With Blank Contact Method			| TesterCust1 | TesterCust   | 123456789   | some@random.com | Copy to testcust@eaton.com |Approved contact method is required	|
	|Verify Registration with Blank Credentials				|          	  |              |             |                 |                            |Customer name is required 			|	

@CustomerRegistration	
Scenario Outline: Verify the Customer registration with invalid credentials

	Given FADR Home page is open on Browser
	And Authorized user selects the Factory Reset from the menu
	When User Navigates to the Customer Registration
	Then Customer registration page is open
	When Enter the Details of the customer "<CustName>" "<ContactName>" "<ContactPhone>" "<ContactEmail>"
	And Select the Contact Method from the DropDown "<ContactMethod>"
	And Fill the Additional Info "<AdditionalInfo>"
	Then Submit button should be disabled
	And Error Message "<ErrorMessage>" is displayed
	
	Examples:
	|Test description			   	 								|CustName	  | ContactName  |ContactPhone |ContactEmail     | additionalInfo             |ErrorMessage							|
	|Verify Registration with Invalid Contact Email 	 			| TesterCust1 | TesterCust   | 123456789   | invalidEmail    | Copy to testcust@eaton.com |Please enter a valid email			|
	|Verify Registration with Invalid Contact Number (Alphabets)	| TesterCust1 | TesterCust   | abcddef     | some@random.com | Copy to testcust@eaton.com |Please enter valid phone number		|
	|Verify Registration with Invalid Contact Number (Alphanumeric)	| TesterCust1 | TesterCust   | abcd1234    | some@random.com | Copy to testcust@eaton.com |Please enter valid phone number		|
	|Verify Registration with Invalid Contact Number(Spaces between)| TesterCust1 | TesterCust   | 1234 6554   | some@random.com | Copy to testcust@eaton.com |Please enter valid phone number		|
	|Verify Registration with Invalid Contact Number(Special char)	| TesterCust1 | TesterCust   | #$5644@44   | some@random.com | Copy to testcust@eaton.com |Please enter valid phone number		|

@CustomerRegistration
Scenario Outline: Verify the Reset Button on Customer Registration page
	Given FADR Home page is open on Browser
	And Authorized user selects the Factory Reset from the menu
	When User Navigates to the Customer Registration
	Then Customer registration page is open
	When Enter the Details of the customer "<CustName>" "<ContactName>" "<ContactPhone>" "<ContactEmail>"
	And Select the Contact Method from the DropDown "<ContactMethod>"
	And Fill the Additional Info "<AdditionalInfo>"
	Then Submit button should be Enabled
	And Error Message "<ErrorMessage>" is displayed
	When User Clicks on the Reset Button
	Then Data Entered Should be cleared
	And Any error Messages Displayed are also cleared
	
	Examples:
	|Test description			   	 								|CustName	  | ContactName  |ContactPhone |ContactEmail     | additionalInfo             |ErrorMessage							|
	|Verify Reset button with valid details entered 	 			| TesterCust1 | TesterCust   | 123456789   | some@random.com | Copy to testcust@eaton.com |Please enter a valid email			|
	|Verify Reset button with invalid details entered				| TesterCust1 | TesterCust   | 2345 3444   | invalidEmail    | Copy to testcust@eaton.com |Please enter valid phone number		|
	
@CustomerRegistration	
Scenario Outline: Verify the Customer registration entering Characters more than feild limits
	iven FADR Home page is open on Browser
	And Authorized user selects the Factory Reset from the menu
	When User Navigates to the Customer Registration
	Then Customer registration page is open
	When Enter the Details of the customer "<CustName>" "<ContactName>" "<ContactPhone>" "<ContactEmail>"
	Then Input feild should not accept the chracters more than field for "<CustName>" and "<ContactPhone>"
	Then Submit button should be disabled
	
	Examples:
	|Test description			   	 								|CustName	  		 					| ContactName  	|ContactPhone 			|ContactEmail     |
	|Verify the Customer Name feild with more than 256 characters	| ThisStringGeneratesMoreThan256Chars 	| TesterCust   	| 123456789   			| some@random.com |
	|Verify the Contact Phone feild with more than 16 numbers		| TesterCust1		 					| TesterCust   	| 123456789123456789    | some@random.com |
	
	
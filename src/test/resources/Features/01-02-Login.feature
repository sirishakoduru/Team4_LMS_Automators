Feature: Login  Page login Verification

Background: Admin gives the correct LMS portal URL
Given Admin Gives the valid LMS portal URL
Then Admin should land on the LMS poral

@Login_20
Scenario: Validate login with valid data in all field
Given Admin is on login Page
When Admin enter valid data in all field and clicks login button 
Then Admin should land on home page 

@Login_21
Scenario Outline: Validate login with invalid data
Given Admin is on login Page
When Admin enter invalid data with "<sheetname>" and "<TestCase>" and clicks login button 
Then Error message "Invalid username and password Please try again"
Examples:
|sheetname |TestCase |
|Login|InvalidCredentials|

@Login_22
Scenario Outline: Validate login credentials with null user name
Given Admin is on login Page
When Admin enter value from "<sheetname>" and "<TestCase>" only in password and clicks login button  
Then Error message "Please enter your user name"
Examples:
|sheetname |TestCase |
|Login|NullUsername|

@Login_23
Scenario Outline: Validate login credentials with null password
Given Admin is on login Page
When Admin enter value from "<sheetname>" and "<TestCase>" only in user name and clicks login button 
Then Error message" Please enter your password "
Examples:
|sheetname |TestCase |
|Login|NullPassword|

@Login_24
Scenario: verify login button action through keyboard
Given Admin is on login Page
When Admin enter valid credentials  and clicks login button through keyboard 
Then Admin should land on home page

@Login_25
Scenario: verify login button action through mouse
Given Admin is on login Page
When Admin enter valid credentials  and clicks login button through mouse
Then Admin should land on home page
#

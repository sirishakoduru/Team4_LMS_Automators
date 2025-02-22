Feature: Login  Page Verification

@Login_01
Scenario: Verify Admin is able to land on login page
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should land on the login page

@Login_02
Scenario: Verify Admin is able to land on home page with invalid URL
Given The browser is open
When Admin gives the invalid LMS portal URL
Then Admin should receive application error

@Login_03
Scenario: Verify for broken link
Given The browser is open
When Admin gives the correct LMS portal URL
Then HTTP response >= 400. Then the link is broken

@Login_04
Scenario: Verify the text spelling in the page 
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see correct spellings in all fields 

@Login_05
Scenario: Verify application name
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see  LMS - Learning Management System

@Login_06
Scenario: Verify company name
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see company name below the app name

@Login_07
Scenario: Validate sign in content
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see "Please login to LMS application"

@Login_08
Scenario: Verify text field is present
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see two text field

@Login_09
Scenario: Verify text on the first field
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should "User" in the first text field

@Login_10
Scenario: Verify dropdown is present
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see one dropdown

@Login_11
Scenario: Verify asterisk next to USER text
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see asterisk mark symbol next to text for mandatory fields

@Login_12
Scenario: Verify text on the second field
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should "Password" in the second text field

@Login_13
Scenario: Verify asterisk mark symbol next to password text
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see asterisk mark symbol next to password text

@Login_14
Scenario: Verify placeholder in dropdown to select role
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see "Select the role" placeholder in dropdown

@Login_15
Scenario: Verify dropdown option to select role
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see "Admin, Staff, Student" options in dropdown

@Login_16
Scenario: Verify the alignment input field for the login
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see input field on the centre of the page

@Login_17
Scenario: verify Login button is present
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see login button 

@Login_18
Scenario: Verify input descriptive text in user field
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see user in gray color

@Login_19
Scenario: Verify input descriptive text in password field
Given The browser is open
When Admin gives the correct LMS portal URL
Then Admin should see password in gray color

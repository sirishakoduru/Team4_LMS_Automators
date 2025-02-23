@logout
Feature: Validation on Logout button
#Background
#Scenario: validate the logoutpage
#Given Admin is logged into the application
@TCValidatelogout
Scenario: Verify logout function
Given Admin is in home page
When Admin clicks on the logout in the menu bar
Then Admin should be redirected to login page
@TCValidateBack
Scenario: Verify logout function
Given Admin is in home page
When Admin clicks  browser back button
Then Admin should receive error message
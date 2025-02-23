Feature: Program Page Verification

Background: Admin is on Home Page
Given Admin is logged in to LMS Portal

#1 Navigation
Scenario: Verify that Admin is able to navigate to Program page
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should be navigated to Program page

#2 Menu Bar
Scenario: Verify Logout displayed in menu bar
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see Logout in menu bar

#3 Menu Bar
Scenario: Verify heading in menu bar
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see the heading "LMS - Learning Management System"

#4 Menu Bar
Scenario: Verify other pages name displayed in menu bar
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see the page names as in order

#5 Menu Bar
Scenario: Verify other pages name displayed in menu bar
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see sub menu in menu bar as "Add New Program"

#6 Verify heading in manage program
Scenario: Verify heading in manage program
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see the heading "Manage Program"

#7 Verify heading in manage program
Scenario: Verify view details of program
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should able to see Program name, description, and status for each program

#8 Verify heading in manage program
Scenario: Verify the Multiple Delete button state 
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see a Delete button in left top is disabled

#9 Verify heading in manage program
Scenario: Verify the Search button 
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see Search bar with text as "Search..."

#10 Verify heading in manage program
@LastScenario
Scenario: Verify checkbox default state beside Program Name column header 
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete

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

#6 Manage Program Page validation
Scenario: Verify heading in manage program
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see the heading "Manage Program"

#7 Manage Program Page validation
Scenario: Verify view details of program
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should able to see Program name, description, and status for each program

#8 Manage Program Page validation
Scenario: Verify the Multiple Delete button state 
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see a Delete button in left top is disabled

#9 Manage Program Page validation
Scenario: Verify the Search button 
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see Search bar with text as "Search..."

#10 Manage Program Page validation
Scenario: Verify column header name of data table 
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete

#11 Manage Program Page validation
Scenario: Verify checkbox default state beside Program Name column header 
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see checkbox default state as unchecked beside Program Name column header

#12 Manage Program Page validation
Scenario: Verify checkboxes default state beside each Program names in the data table  
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see check box default state as unchecked on the left side in all rows against program name 

#13 Manage Program Page validation
Scenario: Verify Sort icon in manage program 
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 

#14 Manage Program Page validation
Scenario: Verify edit and delete icon in manage program 
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see the Edit and Delete buttons on each row of the data table

#15 Manage Program Page validation
Scenario: Verify pagination icons below data table in manage program
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.

#16 Manage Program Page validation
Scenario: Verify footer message in manage program
Given Admin is on home page after Login
When Admin clicks program on the navigation bar
Then Admin should see the footer as "In total there are z programs".

#17 Menu bar - Program - Add New Program
Scenario: Verify add New Program 
Given Admin is on Program page
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see pop up window for program details


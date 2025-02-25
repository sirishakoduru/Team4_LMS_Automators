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

#18 Menu bar - Program - Add New Program
Scenario: Verify title of the pop up windowm 
Given Admin is on Program page
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see window title as "Program Details"

#19 Menu bar - Program - Add New Program
Scenario: Verify mandatory fields with red asterisk mark 
Given Admin is on Program page
When Admin clicks on "Add New Program" under the "Program" menu bar
Then Admin should see red  asterisk mark  beside mandatory field "Name"

#20 Menu bar - Program - Add New Program
Scenario: Verify empty form submission 
Given Admin is on Program details form
When Admin clicks save button without entering mandatory 
Then Admin gets error message 

#21 Menu bar - Program - Add New Program
Scenario: Verify cancel button 
Given Admin is on Program details form
When Admin clicks Cancel button
Then Admin can see Program Details form disappears  

#22 Menu bar - Program - Add New Program
Scenario: Verify enter program name 
Given Admin is on Program details form
When Admin enters the Name in the text box
Then Admin can see the text entered 

#23 Menu bar - Program - Add New Program
Scenario: Verify enter description 
Given Admin is on Program details form
When Admin enters the Description in text box
Then Admin can see the text entered in description box

#24 Menu bar - Program - Add New Program
Scenario: Verify select Status 
Given Admin is on Program details form
When Admin selects the status of the program by clicking on the radio buttonx
Then Admin can see status selected  

#25 Menu bar - Program - Add New Program
Scenario: Verify Admin is able to save the program details
Given Admin is on Program details form
When Admin enter valid details for mandatory fields and Click on save button
Then Admin gets message 'Successful Program created'  

#26 Menu bar - Program - Add New Program
Scenario: Verify cancel program details
Given Admin is on Program details form
When Admin Click on cancel button
Then Admin can see program details form disappear

#27 Menu bar - Program - Add New Program
Scenario: Verify added Program is created
Given Admin is on Program page
When Admin searches with newly created "Program Name"
Then Records of the newly created  "Program Name" is displayed and match the data entered

#28 Menu bar - Program - Add New Program
Scenario: Verify close window with "X" 
Given Admin is on Program details form
When Admin Click on close button
Then Admin can see program details form disappear

#54 Manage Program - Sorting Program
Scenario Outline: Verify sorting of  Program name in Ascending order/Descending order
Given Admin is on Program page
When Admin clicks on Arrow next to program Name
Then Admin see the Program Name is sorted in "<SortingOrder>" ascending or descending order

Examples:
| SortingOrder |
| ascending    |
| descending   |

#55 Manage Program Description - Sorting Program
Scenario Outline: Verify sorting of  Program Description in Ascending order/Descending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to program Description
    Then Admin see the Program Description is sorted in "<SortingOrder>" ascending or descending order

    Examples:
      | SortingOrder |
      | ascending    |
      | descending   |

#56 Manage Program status - Sorting Program
Scenario Outline: Verify sorting of  Program status in Ascending order/Descending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to program status
    Then Admin see the Program Status is sorted in "<SortingOrder>" ascending or descending order

    Examples:
      | SortingOrder |
      | ascending    |
      | descending   |

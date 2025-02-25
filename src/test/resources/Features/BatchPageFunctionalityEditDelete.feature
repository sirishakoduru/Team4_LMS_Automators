@tag
Feature: Batch page navigation
  I want to use this template for my feature file

Background: Admin successfully logged-in to LMS Portal
Given Admin Gives the valid LMS portal URL
And Admin is on login Page
When Admin enter valid data in all field and clicks login button
Then Admin should land on home page

@Batch_SubMenu
Scenario: Verify sub menu displayed in batch menu bar
When Admin clicks "Batch" on the navigation bar
Then Admin should see sub menu in menu bar as "Add New Batch"

@Display_BatchDetails_Popup
Scenario: Validate Admin able to click on the Add new Batch Option
Given Admin is on the Batch Page
When Admin clicks on "Add New batch" under the "batch" menu bar
Then Admin should see the Batch details pop up window

@Edit_Batch_Details_Popup
Scenario: Validate Edit icon feature in any row
Given Admin is on the Batch Page
When Admin clicks the edit icon
Then Admin should see the Batch details pop up window

@Edit_ProgName_Disabled
Scenario: Validate Program name is disabled
Given Admin is on the Batch Page
When Admin clicks the edit icon
Then Admin should see Program name value field is disabled for editing

@Edit_BatchName_Disabled
Scenario: Validate batch name is disabled
Given Admin is on the Batch Page
When Admin clicks the edit icon
Then Admin should see batch name value field is disabled for editing

@Validate_Edit_Description_No_Of_Classes
Scenario Outline: Validate editing description and No. of classes fields with invalid data in the pop up
Given Admin is on the Batch Details Page
When Admin Updates any fields with invalid Description <Description> and No_Of_Classes <No_of_classes> and click save button
Then Admin should get a error message under the respective field

Examples:
|Description	|	No_of_classes	| 
|!@#					|	$%^						|
|    					|								|
|	@#$						|	4							|

@SearchBox_Functionality
Scenario: validate search box functionality
Given Admin is on the Batch Details Page
When Admin enters the batch name in the search text box
Then Admin should see the filtered batches in the data table

@Validate_Save_Button
Scenario: validate save button in Batch details pop up
Given Admin is on the Batch Details Page
When Admin enters the valid data to all the mandatory fields and click save button
Then Admin should get a successful message for editing the batch

@Validate_Cancel_Button
Scenario: validate cancel button in Batch details pop up
Given Admin is on the Batch Details Page
When Admin enters the valid data to all the mandatory fields and click Cancel button

@Delete_Icon
Scenario: validate delete Icon on any row
Given Admin is on the Batch Details Page
When Admin clicks the delete Icon on any row
Then Admin should see the confirm alert box with yes and no button

@No_Delete_Popup
Scenario: validate no button on the confirm alert box
Given Admin is on the Batch Details Page
When Admin clicks on the delete icon and click no button
Then Admin should see the alert box closed and the batch is not deleted

@Close_Delete_Popup
Scenario: validate close Icon on the alert box
Given Admin is on the Batch Details Page
When Admin clicks on the delete icon close icon
Then Admin should see the alert box closed 

@Yes_Delete_Popup
Scenario: Validate yes button on the confirm alert box
Given Admin is on the Batch Details Page
When Admin clicks on the delete icon and click yes button
Then Admin should see the successful message and the batch should be deleted

@Single_Row_Delete_With_Checkbox
Scenario: Validate single row delete with checkbox
Given Admin is on the Batch Details Page
When Admin check checkbox and clicks on the delete icon under the Manage batch header
Then The respective row in the table should be deleted

@Multiple_Row_Delete
Scenario: Validate multiple row delete with checkbox
Given Admin is on the Batch Details Page
When Admin clicks multiple checkbox and click on the delete icon under the Manage batch header
Then The respective row in the table should be deleted


@Next_Page_Link
Scenario: Validate next page link
Given Admin is on the Batch Details Page
When Admin clicks next page link on the data table
Then Admin should see the Next enabled link

@Last_Page_Link
Scenario: validate last page link
Given Admin is on the Batch Details Page
When Admin clicks last page link on the data table
Then Admin should see the last page link with next page link disabled on the table 

@Previous_Page_Link
Scenario: validate the previous page link
Given Admin is on the Batch Details Page
When Admin clicks previous page link on the data table
Then Admin should see the previous page on the table

@First_Page_Link
Scenario: validate the first page link
Given Admin is on the Batch Details Page
When Admin clicks first page link on the data table
Then Admin should see the very first page on the data table


@Logout_Option
Scenario: Validate logout option in the header is visible and enabled from the batch page
Given Admin is on the Batch Details Page
When Admin clicks on the logout button
Then Admin should see the Login screen Page




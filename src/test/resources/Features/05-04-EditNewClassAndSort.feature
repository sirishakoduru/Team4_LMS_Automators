Feature: Edit New class and Sort Class details

Background: Admin is on the Manage Class page after login
Given Admin is on the home Page after login the LMS portal
When Admin clicks the Class Navigation bar in the Header 
Then Admin should land Manage Class page

@EditNewClass_01
Scenario: Validate row level edit icon
Given Admin is on the Manage Class page
When Admin clicks on the edit icon 
Then A new pop up with class details appears  

@EditNewClass_02
Scenario: Check disabled  batch name
Given Admin is on the Manage Class page
When Admin clicks on the edit icon 
Then Admin should see batch name field is disabled  

@EditNewClass_03
Scenario: Check disabled class topic
Given Admin is on the Manage Class page
When Admin clicks on the edit icon 
Then Admin should see class topic field is disabled 

@EditNewClass_04
Scenario: Check if the fields are updated with valid data
Given Admin is on the Edit Class Popup window
When Update the fields with valid data and click save 
Then Admin gets message "class details updated Successfully " and see the updated values in data table  

@EditNewClass_05
Scenario: Check if the fields are updated with invalid values
Given Admin is on the Edit Class Popup window
When Update the fields with invalid values and click save
Then Admin should get Error message 

@EditNewClass_06
Scenario: Check if the mandatory fields are updated with valid data
Given Admin is on the Edit Class Popup window
When Update the mandatory fields with valid values and click save
Then Admin gets message "Class details updated Successfully " and see the updated values in data table

@EditNewClass_07
Scenario: Check if the optional fields are updated with valid data
Given Admin is on the Edit Class Popup window
When Update the optional fields with valid values and click save
Then Admin gets message "Class details updated Successfully " and see the updated values in data table

@EditNewClass_08
Scenario: Validate invalid values in the text fields
Given Admin is on the Edit Class Popup window
When Admin enters only numbers or special char in the text fields
Then Admin should get Error message 

@EditNewClass_09
Scenario: Validate Cancel button on Edit popup
Given Admin is on the Edit Class Popup window
When Admin clicks Cancel button on edit popup
Then Admin can see the class details popup disappears and can see nothing changed for particular Class 

@SortBatch_01
Scenario: Sort Class by Batch name
Given Admin is on the Manage Class page
When Admin clicks on the Batchname sort icon
Then Admin should see Class details are sorted by Batch Name

@SortClassTopic_02
Scenario: Sort Class by Class Topic
Given Admin is on the Manage Class page
When Admin clicks on the Class topic sort icon
Then Admin should see Class details are sorted by Class Topic

@SortClassDescription_03
Scenario: Sort Class by Class Description
Given Admin is on the Manage Class page
When Admin clicks on the Class description  sort icon
Then Admin should see Class details are sorted by Class Description

@SortStatus_04
Scenario: Sort Class by Status
Given Admin is on the Manage Class page
When Admin clicks on the Status sort icon
Then Admin should see Class details are sorted by Status

@SortClassDate_05
Scenario: Sort Class by Class date
Given Admin is on the Manage Class page
When Admin clicks on the Class Date sort icon
Then Admin should see Class details are sorted by Class Date

@SortStaffname_06
Scenario: Sort Class by staff name
Given Admin is on the Manage Class page
When Admin clicks on the Staff Name sort icon
Then Admin should see Class details are sorted by Staff name
@tag
Feature: Batch page navigation
  I want to use this template for my feature file

Background: Admin successfully logged-in to LMS Portal
Given Admin Gives the valid LMS portal URL
And Admin is on login Page
When Admin enter valid data in all field and clicks login button
Then Admin should land on home page

@Validate_All_Fields
Scenario: Validate all the fields exist in pop up 
Given Admin is on the Batch Details Pop Up WIndow
When Admin checks all the fields are enabled
Then The pop up should include the mandetory fields

@Validate_Batchname_Prefix
Scenario: Validate batchname prefix selected program name
Given Admin is on the Batch Details Pop Up WIndow
When Admin selects program name present in the dropdown
Then Admin should see selected program name in the batch name prefix box

@Invalid_BatchNumber
Scenario: Validate batch name suffix box should accept only numbers
Given Admin is on the Batch Details Pop Up WIndow
When Admin enters alphabets in batch name suffix box
Then Admin should get error message below the text box of respective field

@Batchname_Prefix_NotEditable
Scenario: Validate batch name prefix box is not editable
Given Admin is on the Batch Details Pop Up WIndow
When Admin enters alphabets in batch name prefix box
Then Admin should see empty text box

@Missing_Field
Scenario: validate input data missing for mandatory fields
Given Admin is on the Batch Details Pop Up WIndow
When Admin leaves blank one of the mandatory fields
Then Admin should get a error message on the respective mandatory field

@Validate_Close_Button
Scenario: validate close icon on the batch details pop up
Given Admin is on the Batch Details Pop Up WIndow
When Admin clicks on the close icon
Then batch details pop up closes

@Validate_Cancel_Button
Scenario: validate cancel button in Batch details pop up
Given Admin is on the Batch Details Pop Up WIndow
When Admin enters the valid data to all the mandatory fields and click cancel button 
Then Admin can see the batch details popup closes without creating any batch

@Positive_AddBatch_Click_Save
Scenario: Validate input data only for mandatory fields
Given Admin is on the Batch Details Pop Up WIndow
When Admin enters the data only to the mandatory fields and clicks save button
Then Admin should get a successful message


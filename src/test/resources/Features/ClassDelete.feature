Feature: Delete Class Validation

#Background
#Admin is on the Manage Class page after login

@TCValidatesearchbatchname
Scenario: Validate row level delete icon
Given Admin is on the Manage class page
When Admin clicks the delete icon.
Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion

@TCYes
Scenario: Click Yes on deletion window
When Admin clicks yes option
Then Admin gets a message "Successful Class Deleted" alert and do not see that Class in the data table

@TCNo
Scenario: Click No on deletion window
When Admin clicks  No option
Then Admin can see the deletion alert disappears without deleting

@TCX
Scenario: Validate Close(X) icon on Confirm Deletion alert
When Admin clicks on close button
Then Admin can see the deletion alert disappears without any changes
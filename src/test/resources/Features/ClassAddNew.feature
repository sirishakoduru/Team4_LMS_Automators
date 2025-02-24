Feature: Class Page Validation

Background
When Admin clicks the Class Navigation bar in the Header
Then Admin should land on the Manage class page

@TCValidateclasspopup
Scenario: Validate Class Details Popup window
When Admin clicks a add new class under the class menu bar.
Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

@TCValidateclasspopup
Scenario: Validate Class Details Popup window
When Admin clicks a add new class under the class menu bar.
Then Admin should see few input fields and their respective text boxes in the class details window
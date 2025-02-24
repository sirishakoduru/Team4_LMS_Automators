Feature: Class Page Validation

Background
Scenario: Validating the class manage page
When Admin clicks the Class Navigation bar in the Header
Then Admin should land on the Manage class page

@TCValidateTitle
Scenario: Validating the Title in the Manage class page
When Admin clicks the Class Navigation bar in the Header
Then Admin should see the "LMS-Learning Management System" Title

@TCValidateHeader
Scenario: Validating the Title in the Manage class page
When Admin clicks the Class Navigation bar in the Header
Then Admin should see the "Manage Class" Header

@TCValidateSearch
Scenario: Validating Search bar in class page
When Admin clicks the Class Navigation bar in the Header
Then Admin should see the Search Bar in Manage class page

@TCTableHeaders
Scenario: Validating the data table headers in the class page
When Admin clicks the Class Navigation bar in the Header
Then Admin should see the datatable heading like Batchname,class topic,class description,status,class Date,staff name,Edit/Delete

@TCValidatetextpagination
Scenario: Validating the text and pagination icon in the classpage
When Admin clicks the Class Navigation bar in the Header
Then Admin should see the " showing x to y of  z entries" and enabled pagination controls under the data table

@TCValidateSorticon
Scenario: Validate the sort icon of all the field in datatable
When Admin clicks the Class Navigation bar in the Header
Then Admin should see the Sort icon of all the field in the datatable.

@TCValidateDeletebutton
Scenario: Validating the Delete button under the Manage class 
When Admin clicks the Class Navigation bar in the Header
Then Admin should see the Delete button under the Manage class page header.

@TCValidatenoofclasses
Scenario: Validate the total no of classes in manage class page
When Admin clicks the Class Navigation bar in the Header
Then Admin should see Total no of classes in below of the data table.

@TCClasslink
Scenario: Class link on navigation bar
Given Admin clicks the Class Navigation bar in the Header
When Admin clicks on Class link on Manage Class page
Then Admin is redirected to class page

@TCotherpage
Scenario: Class link to other page on navigation bar
Given Admin clicks the Class Navigation bar in the Header
When Admin clicks on any page link on Manage Class page
Then Admin is redirected to which page link they clicked

@TClogoutlink
Scenario: Logout link on navigation bar
Given Admin clicks the Class Navigation bar in the Header
When Admin clicks on Logout link on Manage class page
Then Admin is redirected to Login page



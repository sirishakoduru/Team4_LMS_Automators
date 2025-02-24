Feature: Class Page Validation

Background
Then Admin is on the Manage Class page after login

@TCValidatesearchbatchname
Scenario: Search class by Batch Name
Given Admin is on the Manage class page
When Admin enter the Batch Name in search textbox.
Then Admin should see Class details are searched by Batch Name

@TCValidatesearchclasstopic
Scenario: Search class by Class topic
Given Admin is on the Manage class page
When Admin enter the Class topic in search textbox
Then Admin should see Class details are searched by Class topic

@TCValidatesearchstaffname
Scenario: Search class by Staff Name
Given Admin is on the Manage class page
When Admin enter the Staff Name in search textbox
Then Admin should see Class details are searched by Staff name

Scenario Outline: Search class by Value
When Admin enter the "<field>" "<value>" in search textbox
Then Admin should see Class details are searched by given fields
Examples: 
|field||value|
|Batch Name||Python101|
|Class Topic||ch2|
|Staff Name||Kevin Thomas|

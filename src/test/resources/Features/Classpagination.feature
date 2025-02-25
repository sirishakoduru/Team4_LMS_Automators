Feature: Pagination Validation

Background:
Then Admin should land on the Manage class page

@TCValidatenext
Scenario: Verify Next page link(>)
Given Admin is on the Manage class page
When Admin clicks Next page link on the class table 
Then Admin should see the next page record on the table  with Pagination has next active link enabled

@TCValidatelast
Scenario: Verify Last page link(>>)
Given Admin is on the Manage class page
When Admin clicks Last page link
Then Admin should see the last page record on the table with Next page link are disabled

@TCValidatefirst
Scenario: Verify First page link(<)
Given Admin is on the Manage class page
When Admin clicks First page link
Then Admin should see the previous page record on the table with pagination has previous page link enabled

@TCValidatestart
Scenario: Verify Start page link(<<)
Given Admin is on the Manage class page 
When Admin clicks Start page link
Then Admin should see the very first page record on the table with Previous page link are disabled
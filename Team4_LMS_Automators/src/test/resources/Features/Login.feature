Feature: Login  Page Verification

Background: Admin gives the correct LMS portal URL
Given Admin Gives the valid LMS portal URL
Then Admin should land on the LMS poral

Scenario: Validate login with valid credentials
Given Admin is on login Page
When Admin enter valid data in all field and clicks login button
Then Admin should land on dashboard page
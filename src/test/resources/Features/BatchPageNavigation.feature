
@tag
Feature: Batch page navigation
  I want to use this template for my feature file

Background: Admin successfully logged-in to LMS Portal
Given Admin Gives the valid LMS portal URL
When Admin enter valid credentials  and clicks login button
Then Admin should land on dashboard page

@Batch_Menu_Click
Scenario: Admin click Batch Menu
When Admin Clicks on the Batch menu from the header
Then Admin should be in the Manage Batch Page







@timesheets
Feature: This is to get the pending timesheet
Scenario Outline: This is to verify the pending timesheet
Given the user is on homepage
And the user clicks on the time option from the menu
And user enters the name as "John Smith"
And clicks on search button
Then user should se  the message "<message>"
Examples:
|message|
|No Timesheet Found|
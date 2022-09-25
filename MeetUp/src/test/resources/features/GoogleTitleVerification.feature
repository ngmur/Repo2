
Feature: Basic Verification
  @smoke
Scenario: Google Title Verification
When the user navigates to google
And the user searches for"apple"
Then verify "flower" is in the title of the page
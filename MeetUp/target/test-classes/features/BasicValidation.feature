Feature: MeetUp app validation

  Scenario: To validate title of the page
  Given User navigates to the https://www.meetup.com web page
  When User is navigated to the web page
  Then Title of the web page should be displayed as "Meetup - We are what we do"

  Scenario: To validate URL of the page
   Given User navigates to the https://www.meetup.com web page
    When User is navigated to the web page
    Then Url of the web page should be displayed as www.meetup.com web page




Feature:
  Scenario: Sign up button is displayed validation
    Given User should navigate to https://www.meetup.com
    When When user navigates to the web-page
    Then Sign up button should be dispalyed on the right corner of the web-page

  Scenario: Login button  is displayed validation
    Given User should navigate to https://www.meetup.com
    When When user navigates to the web-page
    Then Login button should be dispalyed on the right corner of the web-page


  Scenario: Join Meetup button  is displayed validation
    Given User should navigate to https://www.meetup.com
    And User should scroll down on the web page
    When When user scrolls down
    Then User should be able to see Join Meetup button

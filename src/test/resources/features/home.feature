Feature: Acceptance testing to validate the Home
page text

  @Homepagetext
  Scenario: Navigate to homepage and validate the Home page text
    Given The user is on "England" page
    When the user navigate back to the Home page
    Then validate the Home page text "Top Stories"
    

  
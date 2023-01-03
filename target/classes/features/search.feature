Feature: Acceptance testing to validate the Navigation bar text
  in search page


  @Searchpagetext
  Scenario: Validate navigation bar text
    Given the user is on the home page
    When the user clicks on search icon
    And search for "England"
    And choose England from topics
    Then verify the navigation bar text as "England"
    

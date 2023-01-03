Feature: Acceptance testing to validate the video page text
  and scroll down to verify the Copyright text

		@Videopagetext
  	Scenario: Validate video page text
    Given the BBC News App is launched and at the homepage
    When the user clicks on video tab
    Then the video page text should be "BBC News Channel (UK Only)"
    And scroll down to verify the text "Copyright © 2018 BBC"
		  
    
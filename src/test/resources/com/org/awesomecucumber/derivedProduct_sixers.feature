Feature: Derived product 2 home page slides functionality

  Scenario: To validate the count of slides, title and duration of each slide
    Given I'm on the derived product one sixers home page
    When I count the number of slides present on the page
    Then Validate the title of each slide against the expected data in file "slides.json"
    And Validate the duration of each slide against the expected data


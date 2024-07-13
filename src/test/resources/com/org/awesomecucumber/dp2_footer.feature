Feature: Home page footer section

  Scenario: To Find all the hyperlinks, store in a file and report the duplicate
    Given I'm on the Bulls HomePage
    When I find all the hyperlinks and add it to CSV file
    Then Validate if any duplicate hyperlinks are present and report in csv


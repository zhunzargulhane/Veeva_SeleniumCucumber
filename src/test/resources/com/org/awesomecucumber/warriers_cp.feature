Feature: Core Product to check new and features page

  #@videoFeeds
  Scenario: To count the total number of video feeds and feeds on page with day>=3
    Given I'm on the core product home page
    When I hover to the menu and click on News and features
    Then I count the number of video feeds
    And I count the feeds those are present in the page greater than equal to 3 days


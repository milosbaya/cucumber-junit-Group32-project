@sm

Feature: As a store manager I should be able to click Grid Settings button


  Scenario:
    Given User is on VyTrack homepage
    And User clicks on Fleet
    And User clicks on Vehicles under Fleet dropdown
    And the Store manager is on Vehicle page
    When the Store manager sees Grid Settings is on the right side of the Reset button and on the right side of the page
    Then the Store manager should be able to click Grid Settings button
    And the Store manager sees "Name", "Sort", "Show"

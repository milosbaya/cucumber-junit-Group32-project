
 @td
Feature: As a user I should be able to click Grid Settings button

  @B26G32-84 @B26G32-85
  Scenario: As a Truck driver I should be able to click a Grid Settings
    Given User is on VyTrack homepage
    And User clicks on Fleet
    And User clicks on Vehicles under Fleet dropdown
    And the Truck driver is on Vehicle page
    When the Truck driver sees Grid Settings is on the right side of the Reset button and on the right side of the page
    Then the Truck driver should be able to click Grid Settings button
    And the Truck driver sees "NAME", "SORT", "SHOW"



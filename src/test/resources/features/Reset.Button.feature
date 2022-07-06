
@Wip10
Feature: As a User I should be able to click reset button

  Users: store manager, sales manager truck driver

  Background:
    Given User is on VyTrack homepage
    And User clicks on Fleet
    And User clicks on Vehicles under Fleet dropdown

  Scenario: User see the title of the page " All-Car-Entities-System-Car-Entities-System"

    Then user see title of page as "All - Car - Entities - System - Car - Entities - System"

  Scenario: User should be able to click Grid settings

    When User sees Grid settings on the right side of the page
    And User click Grid setting
    Then User see section with "Grid Settings" heading

  Scenario: User should be able to select Id from grid setting

    When User click Grid setting
    And User click on Id from checkbox
    And  User click Grid setting
    Then User see id column on vehicle page

  Scenario: User is able to do reset

    When User click Grid setting
    And User click on Id from checkbox
    Then User see id column on vehicle page
    And  User click Grid setting
    When User clicks the reset button
    Then Id checkbox is unselected
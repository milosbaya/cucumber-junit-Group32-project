@vytrack_resfresh_btn @B26G32-60 @B26G32-61
Feature: Vytrack app Refresh button feature

  User story:As a user when I am on Vytrack => Fleet => Vehicles, I should be able to see Export Grid dropdown, Refresh, Reset and Grid Settings Buttons

  Accounts are: truck driver, store manager, sales manager

  Background:
    Given the user is on Vytrack homepage
    When the user clicks on Fleet dropdown
    Then the user clicks on Vehicles under fleet dropdown

  @vehicles_page_truck_driver
  Scenario: Truck driver is able to access Vehicles page

    Then the truck driver sees the title of the page "Car - Entities - System - Car - Entities - System"

  @refresh_button_truck_driver
  Scenario: Truck driver is able to click Refresh button
    When the driver sees Refresh button on the left side of Reset button
    Then the truck driver should be able to click Refresh button
    And the truck driver should see refreshing element is present on the page

  @vehicles_page_store_manager
Scenario: Store manager is able to access Vehicles page
    Then the store manager sees the title of the page "All - Car - Entities - System - Car - Entities - System"

  @refresh_button_store_manager
  Scenario: Store manager is able to click Refresh button
    When the store manager sees Refresh button on the left side of Reset button
    Then the store manager should be able to click Refresh button
    And the store manager should see refreshing element is present on the page

  @vehicles_page_sales_manager  @B26G32-74 @B26G32-75
  Scenario: Sales manager is able to access Vehicles page
    Then the Sales manager sees the title of the page "All - Car - Entities - System - Car - Entities - System"

    @refresh_button_sales_manager  @B26G32-74 @B26G32-75
  Scenario: Sales manager is able to click Refresh button
    When the sales manager sees Refresh button on the left side of Reset button
    Then the sales manager should be able to click Refresh button
    And the sales manager should see refreshing element is present on the page

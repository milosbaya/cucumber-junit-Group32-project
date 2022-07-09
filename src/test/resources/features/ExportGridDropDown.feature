Feature: Export grid dropdown button should be clickable
User story:User should be able to click export grid button and see dropdown options
	@B26G32-76
	Scenario: User clicks export grid dropdown
		Given the user is on Vytrack homepage
		When the user clicks on Vehicles under Fleet module dropdown
		And the user is on Vehicles page
		Then user should be able to click Export Grid dropdown
		And the user sees CSV and XLSX options on the dropdown menu
		And the Export Grid dropdown is on the left of the page

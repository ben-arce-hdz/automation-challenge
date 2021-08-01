@products
Feature: Scenarios from Products Page
	This feature validates some scenarios about products page.
	
Background:
	Given 	User navigates to SauceDemo site
	When 	I login with "standard_user" and "secret_sauce"
		
	Scenario: Sort Products by Price(low to high)
		Then 	User sorts the products by "Price (low to high)"
		And 	Validate products are sorted correctly
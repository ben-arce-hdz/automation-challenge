@products @regression
Feature: Scenarios from Products Page
	This feature validates some scenarios about products page.
	
Background: User is Logged In
	 Given 	I login with "standard_user" and "secret_sauce"
		
	Scenario: Sort Products by Price(low to high)
		When 	User sorts the products by "Price (low to high)"
		And 	Validate products are sorted correctly
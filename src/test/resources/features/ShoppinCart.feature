@shopping
Feature: Scenarios from Shopping Cart Page
	This feature validates some scenarios about shopping cart page.
	
Background:
	Given 	User navigates to SauceDemo site
	When 	I login with "standard_user" and "secret_sauce"
		
	Scenario: Sort Products by Price(low to high)
		Then User adds the following items to the cart
			|	Sauce Labs Backpack	|
			|	Sauce Labs Onesie	|
		Then User navigates to Shoppin cart page	
		And Validate products are displayed in shopping cart
			|	Sauce Labs Backpack	|
			|	Sauce Labs Onesie	|
@purchase
Feature: Scenarios about purchase
	
Background:
	Given 	User navigates to SauceDemo site
	When 	I login with "standard_user" and "secret_sauce"
		
	Scenario: Sort Products by Price(low to high)
		Then User adds the following items to the cart
			|	Sauce Labs Backpack	|
			|	Sauce Labs Onesie	|
		Then User navigates to Shoppin cart page
		And click on checkout
		Then User complete the form "user1", "lastname", "63195"
		And User finishes the purchase
		And Complete page should be displayed	
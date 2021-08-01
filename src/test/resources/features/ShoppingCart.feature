@shopping @regression
Feature: Scenarios from Shopping Cart Page
	This feature validates some scenarios about shopping cart page.
	
	Background: User is Logged In
	 Given 	I login with "standard_user" and "secret_sauce"
		
	Scenario: Add multiple items to the shopping cart.
		When User adds the following items to the cart
			|	Sauce Labs Backpack				|
			|	Sauce Labs Onesie					|
			|	Sauce Labs Fleece Jacket	|
		Then User navigates to Shoppin cart page	
		And Validate products are displayed in shopping cart
			|	Sauce Labs Backpack				|
			|	Sauce Labs Onesie					|
			|	Sauce Labs Fleece Jacket	|
	
	Scenario: Add the specific product "Sauce Labs Onesie" to the shopping cart.
		When User adds the following items to the cart
			|	Sauce Labs Onesie	|
		Then User navigates to Shoppin cart page	
		And Validate products are displayed in shopping cart
			|	Sauce Labs Onesie	|
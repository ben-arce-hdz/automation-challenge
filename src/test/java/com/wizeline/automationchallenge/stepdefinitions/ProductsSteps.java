package com.wizeline.automationchallenge.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class ProductsSteps extends BaseSteps{
		
	@Then("User sorts the products by {string}")
	public void userSortsTheProductsFromLowToHigh(String sortMethod) {
	    productsPage.sortProducts(sortMethod);
	}

	@Then("Validate products are sorted correctly")
	public void validateProductsAreSortedCorrectly() {
		assertThat(productsPage.getProductPriceList()).isSorted();
	}
	
	@Then("User adds the following items to the cart")
	public void userAddsTheFollowingItemsToTheCart(DataTable dataTable) {
	    List<String> productList = dataTable.asList();
	    for (String product : productList) {
			productsPage.addProductToCart(product);
		} 
	}
	
	@Then("User navigates to Shoppin cart page")
	public void userNavigatesToShoppinCartPage() {
	    productsPage.openShoppingCart();
	}
}

package com.wizeline.automationchallenge.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import com.wizeline.automationchallenge.base.BaseSteps;
import com.wizeline.automationchallenge.constants.Constants;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class ShoppingCartSteps extends BaseSteps {

	@Then("Validate products are displayed in shopping cart")
	public void validateProductsAreDisplayedInShoppingCart(DataTable dataTable) {
		for (String expectedProduct : dataTable.asList()) {
			assertThat(shoppingCartPage.getProductNameList()).withFailMessage(Constants.PRODUCTS_NOT_MATCH)
					.contains(expectedProduct);
		}
	}

	@Then("click on checkout")
	public void clickOnCheckout() {
		shoppingCartPage.clickOnCheckOut();
	}
}

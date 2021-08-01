package com.wizeline.automationchallenge.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import com.wizeline.automationchallenge.constants.Constants;
import com.wizeline.automationchallenge.page.CartPage;
import com.wizeline.automationchallenge.page.CheckOutDetailsPage;
import com.wizeline.automationchallenge.page.CheckOutPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class CheckoutSteps extends BaseSteps{
		
	@Autowired
	private CheckOutPage checkOutPage;
	
	@Autowired
	private CheckOutDetailsPage checkOutDetailsPage;

	@Then("User complete the form {string}, {string}, {string}")
	public void userCompleteTheForm(String name, String lastName, String zipCode) {
		checkOutPage.fillOutForm(name, lastName, zipCode);
	}

	@Then("User finishes the purchase")
	public void userFinishesThePurchase() {
		checkOutDetailsPage.clickOnFinish();
	}
}

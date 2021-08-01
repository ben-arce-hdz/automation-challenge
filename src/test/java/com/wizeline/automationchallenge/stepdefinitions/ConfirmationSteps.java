package com.wizeline.automationchallenge.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import com.wizeline.automationchallenge.constants.Constants;
import com.wizeline.automationchallenge.page.CartPage;
import com.wizeline.automationchallenge.page.CheckOutPage;
import com.wizeline.automationchallenge.page.ConfirmationPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class ConfirmationSteps extends BaseSteps{
		
	@Autowired
	private ConfirmationPage confirmationPage;
	
	@Then("Complete page should be displayed")
	public void completePageShouldBeDisplayed() {
		assertThat(confirmationPage.getThankYouMessage()).isEqualTo("THANK YOU FOR YOUR ORDER");
	}
}

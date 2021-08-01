package com.wizeline.automationchallenge.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

import com.wizeline.automationchallenge.base.BaseSteps;
import com.wizeline.automationchallenge.constants.Constants;
import com.wizeline.automationchallenge.page.ConfirmationPage;

import io.cucumber.java.en.Then;

public class ConfirmationSteps extends BaseSteps{
		
	@Autowired
	private ConfirmationPage confirmationPage;
	
	@Then("Complete page should be displayed")
	public void completePageShouldBeDisplayed() {
		assertThat(confirmationPage.getThankYouMessage()).isEqualTo(Constants.THANK_YOU_FOR_YOUR_ORDER);
	}
}

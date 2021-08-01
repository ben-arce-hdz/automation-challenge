package com.wizeline.automationchallenge.stepdefinitions;

import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.wizeline.automationchallenge.page.CartPage;
import com.wizeline.automationchallenge.page.LoginPage;
import com.wizeline.automationchallenge.page.ProductsPage;

public class BaseSteps{

	protected SoftAssertions softAssert = new SoftAssertions();

	@Autowired
	protected LoginPage loginPage;

	@Autowired
	protected ProductsPage productsPage;

	@Autowired
	protected CartPage shoppingCartPage;
}

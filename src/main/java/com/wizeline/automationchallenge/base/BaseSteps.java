package com.wizeline.automationchallenge.base;

import org.springframework.beans.factory.annotation.Autowired;
import com.wizeline.automationchallenge.page.CartPage;
import com.wizeline.automationchallenge.page.LoginPage;
import com.wizeline.automationchallenge.page.ProductsPage;

public abstract class BaseSteps{

	@Autowired
	protected LoginPage loginPage;

	@Autowired
	protected ProductsPage productsPage;

	@Autowired
	protected CartPage shoppingCartPage;
}

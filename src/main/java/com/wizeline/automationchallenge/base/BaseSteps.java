package com.wizeline.automationchallenge.base;

import org.springframework.beans.factory.annotation.Autowired;
import com.wizeline.automationchallenge.page.CartPage;
import com.wizeline.automationchallenge.page.LoginPage;
import com.wizeline.automationchallenge.page.ProductsPage;
import com.wizeline.automationchallenge.page.components.MenuBar;

public abstract class BaseSteps{

	@Autowired
	protected LoginPage loginPage;

	@Autowired
	protected ProductsPage productsPage;

	@Autowired
	protected CartPage shoppingCartPage;
	
	@Autowired
	protected MenuBar menu;
}

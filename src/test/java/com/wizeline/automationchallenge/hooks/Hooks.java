package com.wizeline.automationchallenge.hooks;

import org.springframework.beans.factory.annotation.Autowired;
import com.wizeline.automationchallenge.page.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Autowired
	private LoginPage loginPage;

	@Before()
	public void beforeEachScenario() {
		loginPage.openLoginPage();
	}

	@After
	public void cleanUp() {
		loginPage.close();
	}
}
package com.wizeline.automationchallenge.hooks;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Autowired
	private WebDriver driver;

	@Before()
	public void beforeEachScenario() {
		System.out.println("before");
	}

	@After
	public void cleanUp() {
		//this.driver.quit();
	}
}
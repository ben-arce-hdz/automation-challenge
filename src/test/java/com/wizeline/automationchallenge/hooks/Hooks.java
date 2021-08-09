package com.wizeline.automationchallenge.hooks;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.wizeline.automationchallenge.constants.Constants;
import com.wizeline.automationchallenge.page.LoginPage;
import com.wizeline.automationchallenge.util.ScreenShotUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Autowired
	private LoginPage loginPage;
	
	@Autowired
	private ScreenShotUtil screenShot;

	@Before()
	public void beforeEachScenario() {
		loginPage.openLoginPage();
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			scenario.embed(screenShot.takeScreenShot(), Constants.IMAGE_PNG, scenario.getName());
		}
	}

	@After
	public void cleanUp() {
		loginPage.close();
	}
}
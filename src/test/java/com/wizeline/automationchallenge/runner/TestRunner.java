package com.wizeline.automationchallenge.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = "classpath:features", 
glue = "com.wizeline.automationchallenge", tags= {"@logout"},
plugin = {"pretty", "json:target/cucumber.json" }, 
monochrome = true, snippets = SnippetType.CAMELCASE)
public class TestRunner extends AbstractTestNGCucumberTests {

	/**
	 * This method is used for enabling/disabling Parallel Execution.
	 */
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

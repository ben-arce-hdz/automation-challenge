package com.wizeline.automationchallenge.stepdefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.context.SpringBootTest;

import com.wizeline.automationchallenge.constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest
public class LoginSteps extends BaseSteps{
	
	@Given("User navigates to SauceDemo site")
	public void userNavigatesToSauceDemoSite() {
		loginPage.openLoginPage();
	}
		
	@When("I login with {string} and {string}")
	public void logIn(String username, String password) {
		loginPage.login(username, password);
	}

	@Then("I validate the following behavior {string}")
	public void validateExpectResult(String validation) {
		if(validation.equals(Constants.PRODUCTS_PAGE_WAS_NOT_DISPLAYED)) {
			assertThat(productsPage.isTitleDisplayed()).isTrue().as(Constants.PRODUCTS_PAGE_WAS_NOT_DISPLAYED);
		}else if(validation.equals(Constants.ERROR_MSG_IS_DISPLAYED)) {
			assertThat(loginPage.getErrorMessage()).contains(Constants.ERROR_LOGIN_MESSAGE).as(Constants.ERROR_MSG_DISPLAYED_INCORRECTLY);
		}		
	}	 
}

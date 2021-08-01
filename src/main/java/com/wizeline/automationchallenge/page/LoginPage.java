package com.wizeline.automationchallenge.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import com.wizeline.automationchallenge.annotations.PageObject;
import com.wizeline.automationchallenge.base.BasePage;

@PageObject
public class LoginPage extends BasePage{

	@FindBy(css = "#user-name")
	@CacheLookup
	private WebElement userNameInput;
	
	@FindBy(css = "#password")
	@CacheLookup
	private WebElement passwordInput;
	
	@FindBy(css = "#login-button")
	private WebElement loginButton;
	
	@FindBy(css = "h3[data-test='error']")
	private WebElement errorMessage;
	
	@FindBy(css = ".login_logo")
	private WebElement loginLogo;
	
	public void login(String userName, String password) {
		sendKeys(userNameInput, userName);
		sendKeys(passwordInput, password);
		click(loginButton);
	}
	
	public String getErrorMessage() {
		return getText(errorMessage);
	}
	
	public boolean isLoginLogoDisplayed() {
		return isElementDisplayed(loginLogo);
	}
}

package com.wizeline.automationchallenge.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.wizeline.automationchallenge.base.BasePage;

@Component
public class CheckOutPage extends BasePage{

	@FindBy(css = "#first-name")
	private WebElement firstNameInput;
	
	@FindBy(css = "#last-name")
	private WebElement lastNameInput;
	
	@FindBy(css = "#postal-code")
	private WebElement zipCodeInput;
	
	@FindBy(css = "#continue")
	private WebElement continueButton;
}

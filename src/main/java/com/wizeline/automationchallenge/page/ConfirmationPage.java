package com.wizeline.automationchallenge.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.wizeline.automationchallenge.base.BasePage;

@Component
public class ConfirmationPage extends BasePage{

	@FindBy(css = "#finish")
	private WebElement continueButton;
}

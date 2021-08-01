package com.wizeline.automationchallenge.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.wizeline.automationchallenge.annotations.PageObject;
import com.wizeline.automationchallenge.base.BasePage;

@PageObject
public class ConfirmationPage extends BasePage{

	@FindBy(css = ".complete-header")
	private WebElement thankYouMessage;
	
	public String getThankYouMessage() {
		return getText(thankYouMessage);
	}
}

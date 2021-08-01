package com.wizeline.automationchallenge.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.wizeline.automationchallenge.annotations.PageObject;
import com.wizeline.automationchallenge.base.BasePage;

@PageObject
public class CheckOutDetailsPage extends BasePage{

	@FindBy(css = "#finish")
	private WebElement finishButton;
		
	public void clickOnFinish() {
		click(finishButton);
	}
}

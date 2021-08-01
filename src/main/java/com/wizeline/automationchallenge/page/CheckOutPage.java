package com.wizeline.automationchallenge.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.wizeline.automationchallenge.annotations.PageObject;
import com.wizeline.automationchallenge.base.BasePage;

@PageObject
public class CheckOutPage extends BasePage{

	@FindBy(css = "#first-name")
	private WebElement firstNameInput;
	
	@FindBy(css = "#last-name")
	private WebElement lastNameInput;
	
	@FindBy(css = "#postal-code")
	private WebElement zipCodeInput;
	
	@FindBy(css = "#continue")
	private WebElement continueButton;
		
	public void clickOnContinue() {
		click(continueButton);
	}
	
	public void fillOutForm(String name, String lastName, String zipCode) {
		sendKeys(firstNameInput, name);
		sendKeys(lastNameInput, lastName);
		sendKeys(zipCodeInput, zipCode);
		clickOnContinue();
	}
}

package com.wizeline.automationchallenge.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.wizeline.automationchallenge.base.BasePage;

@Component
public class ProductsPage extends BasePage{

	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuButton;
	
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logOutLink;
	
	@FindBy(css = ".title")
	private WebElement titleMessage;
	
	public boolean isTitleDisplayed() {
		return isElementDisplayed(titleMessage);
	}
}

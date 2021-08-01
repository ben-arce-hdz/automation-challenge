package com.wizeline.automationchallenge.page.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.wizeline.automationchallenge.annotations.PageObject;
import com.wizeline.automationchallenge.base.BasePage;

@PageObject
public class MenuBar extends BasePage{
	
	@FindBy(css = "#react-burger-menu-btn")
	private WebElement burgerMenuButton;
	
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logOutLink;
	
	public void logOut() {
		openMenuBar();
		click(this.logOutLink);
	}
		
	private void openMenuBar() {
		click(this.burgerMenuButton);
	}
}

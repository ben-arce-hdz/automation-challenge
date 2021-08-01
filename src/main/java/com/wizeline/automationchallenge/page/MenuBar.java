package com.wizeline.automationchallenge.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.wizeline.automationchallenge.base.BasePage;

@Component
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

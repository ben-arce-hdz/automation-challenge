package com.wizeline.automationchallenge.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtil {
	private Select select;
	
	public DropDownUtil(WebElement element) {
		select= new Select(element);
	}
	
	public void selectByName(String text) {
		select.selectByVisibleText(text);
	}
	
	public void selectByValue(String value) {
		select.selectByValue(value);;
	}
}

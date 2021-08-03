package com.wizeline.automationchallenge.util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DropDownUtil {
	private Select select;

	public void selectByName(WebElement element, String text) {
		initSelect(element);
		select.selectByVisibleText(text);
	}
	
	public void selectByValue(WebElement element, String value) {
		initSelect(element);
		select.selectByValue(value);
	}
	
	private void initSelect(WebElement element) {
		select= new Select(element);
	}
}

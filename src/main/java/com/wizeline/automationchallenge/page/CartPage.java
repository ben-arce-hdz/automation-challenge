package com.wizeline.automationchallenge.page;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.wizeline.automationchallenge.annotations.PageObject;
import com.wizeline.automationchallenge.base.BasePage;

@PageObject
public class CartPage extends BasePage{

	@FindBy(css = ".cart_list .inventory_item_name")
	private List<WebElement> productNameList;
	
	@FindBy(css = "#checkout")
	private WebElement checkOutButton;
	
	public List<String> getProductNameList(){
		return productNameList.stream()
								.map(WebElement::getText)
								.collect(Collectors.toList());
	}
	
	public void clickOnCheckOut() {
		click(checkOutButton);
	}
}

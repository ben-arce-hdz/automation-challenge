package com.wizeline.automationchallenge.page;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.wizeline.automationchallenge.base.BasePage;

@Component
public class CartPage extends BasePage{

	@FindBy(css = ".cart_list .inventory_item_name")
	private List<WebElement> productNameList;
	
	public List<String> getProductNameList(){
		return productNameList.stream()
				.map(x -> x.getText())
				.collect(Collectors.toList());
	}
}

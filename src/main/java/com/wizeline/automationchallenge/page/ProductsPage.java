package com.wizeline.automationchallenge.page;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.wizeline.automationchallenge.annotations.PageObject;
import com.wizeline.automationchallenge.base.BasePage;

@PageObject
public class ProductsPage extends BasePage{

	private static final String INVENTORY_BUTTON = ".btn_inventory";
	
	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuButton;
	
	@FindBy(css = "#logout_sidebar_link")
	private WebElement logOutLink;
	
	@FindBy(css = ".title")
	private WebElement titleMessage;

	@FindBy(css = ".product_sort_container")
	private WebElement sortProductsSelect;

	@FindBy(css = ".inventory_list .inventory_item_price")
	private List<WebElement> productPriceList;
	
	@FindBy(css = ".inventory_list .inventory_item_description")
	private List<WebElement> productList;
	
	@FindBy(css = ".shopping_cart_link")
	private WebElement shoppingCart;
	
	public boolean isTitleDisplayed() {
		return isElementDisplayed(titleMessage);
	}
	
	public void sortProducts(String sortMethod) {
		selectDropDownItemByText(sortProductsSelect, sortMethod);
	}
	
	public List<Double> getProductPriceList(){
		return productPriceList.stream()
								.map(x -> x.getText().substring(1))
								.map(Double::parseDouble)
								.collect(Collectors.toList());
	}
	
	public void addProductToCart(String productName){
		WebElement element = productList.stream()
								   .filter(x -> x.getText().contains(productName))
								   .findFirst()
								   .orElseThrow();
		element = element.findElement(By.cssSelector(INVENTORY_BUTTON));
		click(element);
	}
	
	public void openShoppingCart() {
		click(shoppingCart);
	}
}

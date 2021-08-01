package com.wizeline.automationchallenge.page;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
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
				.map(x -> Double.parseDouble(x.getText().substring(1)))
				.collect(Collectors.toList());
	}
	
	public void addProductToCart(String productName){
		WebElement el = productList.stream()
								   .filter(x -> x.getText().contains(productName))
								   .findFirst()
								   .orElseThrow();
		el = el.findElement(By.cssSelector(".btn_inventory"));
		click(el);
	}
	
	public void openShoppingCart() {
		click(shoppingCart);
	}
}

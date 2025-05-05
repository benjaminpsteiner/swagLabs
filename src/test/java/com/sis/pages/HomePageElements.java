package com.sis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.utils.CommonMethods;

public class HomePageElements extends CommonMethods {

	@FindBy (className="app_logo")
	public WebElement logo;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	public WebElement atcBackpack;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	public WebElement atcBikeLight;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	public WebElement atcBoltShirt;
	
	@FindBy(id = "shopping_cart_container")
	public WebElement shoppingCart;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	public WebElement shoppingBadge;
	
	@FindBy(xpath ="//*[@id=\"header_container\"]/div[2]/div/span/select")
	public WebElement ddSort;
	
	public HomePageElements() {
		PageFactory.initElements(driver, this);
	}
	
}

package com.sis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.utils.CommonMethods;

public class CartPageElements extends CommonMethods {
	
	@FindBy(id="checkout")
	public WebElement checkOut;
	
	@FindBy(id="remove-sauce-labs-backpack")
	public WebElement remove;
	
	@FindBy(xpath="//div[@class='cart_item']")
	public WebElement cartItem;
	
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	public WebElement cartBadge;
	
	public CartPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	public void removeItem(String productName) {
		
		 String xpath = "//div[@class='cart_item' and .//div[@class='inventory_item_name' and text()='" 
				 		+ productName + "']]//button[contains(text(), 'Remove')]";

		    WebElement removeButton = driver.findElement(By.xpath(xpath));
		    removeButton.click();
	}

}

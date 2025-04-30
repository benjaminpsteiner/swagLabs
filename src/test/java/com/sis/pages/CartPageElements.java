package com.sis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.utils.CommonMethods;

public class CartPageElements extends CommonMethods {
	
	@FindBy(id="checkout")
	public WebElement checkOut;
	
	public CartPageElements() {
		PageFactory.initElements(driver, this);
	}

}

package com.sis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.utils.CommonMethods;

public class CheckOutPageElements extends CommonMethods {
	
	@FindBy(id="first-name")
	public WebElement firstName;
	
	@FindBy(id="last-name")
	public WebElement lastName;
	
	@FindBy(id="postal-code")
	public WebElement postalCode;
	
	@FindBy(id="continue")
	public WebElement continueBtn; 
	
	public CheckOutPageElements() {
		PageFactory.initElements(driver, this);
	}

}

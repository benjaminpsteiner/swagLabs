package com.sis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.utils.CommonMethods;

public class CheckoutPageOverviewPageElements extends CommonMethods {
	
	@FindBy(id="finish")
	public WebElement finish;
	
	@FindBy(xpath="//h2[@class='complete-header']")
	public WebElement thankYou;
	
	public CheckoutPageOverviewPageElements() {
		PageFactory.initElements(driver, this);
	}

}

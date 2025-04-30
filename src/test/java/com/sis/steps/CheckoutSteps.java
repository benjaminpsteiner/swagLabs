package com.sis.steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sis.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CommonMethods {

	@When("adds the backpack to the cart")
	public void adds_the_backpack_to_the_cart() {
		click(homePage.atcBackpack);

	}

	@When("clicks on the cart button")
	public void clicks_on_the_cart_button() {
		click(homePage.shoppingCart);
	}

	@Then("verify the cart url")
	public void verify_the_cart_url() {
		String expected = "https://www.saucedemo.com/cart.html";
		String actual = driver.getCurrentUrl();

		Assert.assertEquals(expected, actual);
	}

	
	@When("sorts the items from lowest to highest")
	public void sorts_the_items_from_lowest_to_highest() {
	    selectDropdown(homePage.ddSort,"Price (low to high)");
	}

	@Then("we verify the lowest to highest")
	public void we_verify_the_lowest_to_highest() {
		
		List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));
		
		List<Double> prices = new ArrayList<>();
		
		for (WebElement el : priceElements) {
		    String priceText = el.getText().replace("$", "");
		    prices.add(Double.parseDouble(priceText));
		}

		// Make a copy and sort it
		List<Double> sortedPrices = new ArrayList<>(prices);
		Collections.sort(sortedPrices);

		// Assert they match
		Assert.assertEquals(prices, sortedPrices);
	    
	}
	
	@When("clicks on the checkout button")
	public void clicks_on_the_checkout_button() {
	    click(cartPage.checkOut);
	}
	
	@When("fills out the checkout overview form")
	public void fills_out_the_checkout_overview_form() {
	  sendText(checkOutPage.firstName,"Kaladin");
	  sendText(checkOutPage.lastName,"Stormblessed");
	  sendText(checkOutPage.postalCode,"1111");
	  click(checkOutPage.continueBtn);
	}
	
	
	@When("clicks on the finish button")
	public void clicks_on_the_finish_button() {
		click(checkOutOverview.finish);
	}
	
	@Then("we verify with Thank you for your order!")
	public void we_verify_with_thank_you_for_your_order() {
	    String actual = checkOutOverview.thankYou.getText();
	    String expected = "Thank you for your order!";
	    
	    Assert.assertEquals(expected, actual);
	}
}

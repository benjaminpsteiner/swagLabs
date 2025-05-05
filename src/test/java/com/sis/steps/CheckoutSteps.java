package com.sis.steps;

import java.time.Duration;
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
		selectDropdown(homePage.ddSort, "Price (low to high)");
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
		sendText(checkOutPage.firstName, "Kaladin");
		sendText(checkOutPage.lastName, "Stormblessed");
		sendText(checkOutPage.postalCode, "1111");
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

	@When("clicks on the delete button")
	public void clicks_on_the_delete_button() {
		click(cartPage.remove);
	}

	@Then("we verifiy the cart is empty")
	public void we_verifiy_the_cart_is_empty() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
		Assert.assertEquals("Cart should be empty", 0, cartItems.size());

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		List<WebElement> badge = driver.findElements(By.className("shopping_cart_badge"));
		Assert.assertEquals(0, badge.size());

	}
	
	@When("click on three products")
	public void click_on_three_products() {
	   click(homePage.atcBackpack);
	   click(homePage.atcBikeLight);
	   click(homePage.atcBoltShirt);
	}
	
	@Then("verify the shopping badge says three")
	public void verify_the_shopping_badge_says_three() {
	   String expected = "3";
	   String actual = homePage.shoppingBadge.getText();
	   
	   Assert.assertEquals(expected, actual);
	}


}

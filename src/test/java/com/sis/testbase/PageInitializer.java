package com.sis.testbase;

import com.sis.pages.CartPageElements;
import com.sis.pages.CheckOutPageElements;
import com.sis.pages.CheckoutPageOverviewPageElements;
import com.sis.pages.HomePageElements;
import com.sis.pages.LoginPageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements loginPage;
	public static HomePageElements homePage;
	public static CartPageElements cartPage;
	public static CheckOutPageElements checkOutPage;
	public static CheckoutPageOverviewPageElements checkOutOverview;

	public static void initialize() {
		loginPage = new LoginPageElements();
		homePage = new HomePageElements();
		cartPage = new CartPageElements();
		checkOutPage = new CheckOutPageElements();
		checkOutOverview = new CheckoutPageOverviewPageElements();
		
	}

}

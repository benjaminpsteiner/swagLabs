package com.sis.testbase;

import com.sis.pages.LoginPageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements loginPage;

	public static void initialize() {
		loginPage = new LoginPageElements();

	}

}

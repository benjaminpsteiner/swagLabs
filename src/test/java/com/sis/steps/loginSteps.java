package com.sis.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sis.utils.CommonMethods;
import com.sis.utils.ConfigsReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps extends CommonMethods {
		
	@When("the user logins with standard credentials")
	public void the_user_logins_with_standard_credentials() {
	  sendText(loginPage.userName, ConfigsReader.getProperty("username"));
	  sendText(loginPage.password, ConfigsReader.getProperty("password"));
	  click(loginPage.submit);
	}

	@Then("we verify the home page")
	public void we_verify_the_home_page() {
		WebElement logo = driver.findElement(By.className("app_logo"));
		
		Assert.assertTrue("Logo is not displayed",logo.isDisplayed());
	  
	}
	
	@When("the user logins with ivalid credentials")
	public void the_user_logins_with_ivalid_credentials() {
	   sendText(loginPage.userName,"Wrong");
	   sendText(loginPage.password,"password");
	   click(loginPage.submit);
	}
	
	@Then("we verify that a login error occurs")
	public void we_verify_that_a_login_error_occurs() {
	    String expected = "Epic sadface: Username and password do not match any user in this service";
	    String actual = loginPage.errorMessage.getText();
	    
	    Assert.assertEquals(expected, actual);
	}

}

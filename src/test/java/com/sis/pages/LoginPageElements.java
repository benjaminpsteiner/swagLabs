package com.sis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.utils.CommonMethods;
import com.sis.utils.ConfigsReader;

public class LoginPageElements extends CommonMethods {
	@FindBy(id="user-name")
	public WebElement userName;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="login-button")
	public WebElement submit;
	
	@FindBy(xpath="//h3[@data-test='error']")
	public WebElement errorMessage;
	
	public LoginPageElements() {
		PageFactory.initElements(driver, this);
	}
	
	public void standardLogin() {
		 sendText(loginPage.userName, ConfigsReader.getProperty("username"));
		 sendText(loginPage.password, ConfigsReader.getProperty("password"));
		 click(loginPage.submit);
	}

}

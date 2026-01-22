package com.yash.automationFramework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yash.automationFramework.base.BasePage;

public class LoginPage extends BasePage {

	private WebDriver driver;

	/* Locators */
	@FindBy(name = "username")
	private WebElement usernameInput;

	@FindBy(name = "password")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	/* Constructor */
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* Actions */

	public void login(String username, String password) {
		waitForVisibility(usernameInput);
		type(usernameInput, username);
		type(passwordInput, password);
		click(loginButton);
	}
}

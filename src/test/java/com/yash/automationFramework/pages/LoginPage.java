package com.yash.automationFramework.pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yash.automationFramework.base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String user, String pass) {
		type(username, user);
		type(password, pass);
		click(loginBtn);

		wait.until(ExpectedConditions.urlContains("dashboard"));
	}

}

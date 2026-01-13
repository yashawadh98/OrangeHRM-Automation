package com.yash.automationFramework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	public void login(String user, String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();

	}

}

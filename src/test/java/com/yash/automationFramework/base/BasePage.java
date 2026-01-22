package com.yash.automationFramework.base;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	private static final int DEFAULT_WAIT_TIME = 15; // 👈 FIX #3 HERE

	public BasePage(WebDriver driver) {
		if (driver == null) {
			throw new RuntimeException("Driver is null. BaseTest setup not executed.");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_TIME));
		PageFactory.initElements(driver, this);
	}

	// ---------- Wait Utilities ----------

	protected void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void click(WebElement element) {
		waitForClick(element);
		element.click();
	}

	protected void type(WebElement element, String value) {
		waitForVisibility(element);
		element.clear();
		element.sendKeys(value);
	}

	public void waitForUrlContains(String text) {
		wait.until(ExpectedConditions.urlContains(text));
	}
}

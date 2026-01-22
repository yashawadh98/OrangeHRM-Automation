package com.yash.automationFramework.pages;

import com.yash.automationFramework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends BasePage {

	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement adminMenu;

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pimMenu;

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	public AdminPage goToAdmin() {
		wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
		return new AdminPage(driver);
	}

	public PimPage goToPim() {
		wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
		wait.until(ExpectedConditions.urlContains("pim"));
		return new PimPage(driver);
	}
}

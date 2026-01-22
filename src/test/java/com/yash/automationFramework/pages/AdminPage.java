package com.yash.automationFramework.pages;

import com.yash.automationFramework.base.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends BasePage {

	/* Page Header */
	@FindBy(xpath = "//h6[text()='Admin']")
	private WebElement adminHeader;

	/* Filters */
	@FindBy(xpath = "//label[text()='Username']/../following-sibling::div/input")
	private WebElement usernameInput;

	@FindBy(xpath = "//label[text()='User Role']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
	private WebElement userRoleDropdown;

	@FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input")
	private WebElement employeeNameInput;

	@FindBy(xpath = "//label[text()='Status']/../following-sibling::div//div[contains(@class,'oxd-select-text')]")
	private WebElement statusDropdown;

	/* Buttons */ @FindBy(xpath = "//button[text()=' Search ']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[text()=' Reset ']")
	private WebElement resetButton;

	@FindBy(xpath = "//button[contains(.,'Add')]")
	private WebElement addButton;

	/* Results */
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
	private WebElement recordsFoundText;

	public AdminPage(WebDriver driver) {
		super(driver);

	}

	// ---------- Validations ----------

	public boolean isAdminPageDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(adminHeader));
		return adminHeader.isDisplayed();
	}

	public boolean isRecordsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(recordsFoundText));
		return recordsFoundText.isDisplayed();
	} // ---------- Actions ---------- public

	public void searchByUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(usernameInput));
		usernameInput.sendKeys(username);
		searchButton.click();
	}

	public void searchByEmployeeName(String employeeName) {
		employeeNameInput.sendKeys(employeeName);
		searchButton.click();
	}

	public void resetSearch() {
		resetButton.click();
	}

	public boolean isAddButtonVisible() {
		wait.until(ExpectedConditions.visibilityOf(addButton));
		return addButton.isDisplayed();
	}

}

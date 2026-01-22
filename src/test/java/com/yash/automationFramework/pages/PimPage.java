package com.yash.automationFramework.pages;

import com.yash.automationFramework.base.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PimPage extends BasePage {

	@FindBy(xpath = "//h6[text()='PIM']")
	private WebElement pimHeader;

	@FindBy(xpath = "//label[text()='Employee Name']/following::input[1]")
	private WebElement employeeNameInput;

	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	private WebElement employeeIdInput;

	@FindBy(xpath = "//button[.=' Search ']")
	private WebElement searchButton;

	@FindBy(xpath = "//button[.=' Reset ']")
	private WebElement resetButton;

	@FindBy(xpath = "//button[.=' Add ']")
	private WebElement addEmployeeButton;

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
	private WebElement recordsFoundText;

	public PimPage(WebDriver driver) {
		super(driver);
	}

	// ---------- Validations ----------

	public boolean isPimPageDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(pimHeader));
		return pimHeader.isDisplayed();
	}

	public boolean isRecordsDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(recordsFoundText));
		return recordsFoundText.isDisplayed();
	}

	public boolean isAddEmployeeButtonVisible() {
		wait.until(ExpectedConditions.visibilityOf(addEmployeeButton));
		return addEmployeeButton.isDisplayed();
	}

	// ---------- Actions ----------

	public void searchByEmployeeName(String name) {
		wait.until(ExpectedConditions.visibilityOf(employeeNameInput)).sendKeys(name);
		searchButton.click();
	}

	public void searchByEmployeeId(String id) {
		wait.until(ExpectedConditions.visibilityOf(employeeIdInput)).sendKeys(id);
		searchButton.click();
	}

	public void resetSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(resetButton)).click();
	}
}

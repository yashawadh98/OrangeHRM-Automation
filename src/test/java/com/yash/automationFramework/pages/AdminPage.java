package com.yash.automationFramework.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	
	WebDriver driver;
    WebDriverWait wait;

    // All Locators of Admin Page
    private By adminMenu = By.xpath("//span[text()='Admin']");

    private By usernameInput = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    private By userRoleDropdown = By.xpath("//label[text()='User Role']/../following-sibling::div");
    private By statusDropdown = By.xpath("//label[text()='Status']/../following-sibling::div");

    private By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private By resetBtn = By.xpath("//button[normalize-space()='Reset']");

    private By resultRows = By.xpath("//div[@class='oxd-table-body']//div[@role='row']");
    private By noRecordsFound = By.xpath("//span[text()='No Records Found']");

    // Constructor for Admin Class
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Admin Page Actions
    public void navigateToAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput))
                .sendKeys(username);
    }

    public void selectUserRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='" + role + "']"))).click();
    }

    public void selectStatus(String status) {
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='" + status + "']"))).click();
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }

    public void clickReset() {
        wait.until(ExpectedConditions.elementToBeClickable(resetBtn)).click();
    }

    // ===== Validations =====
    public boolean isUserDisplayedInResults() {
        List<WebElement> rows = wait
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultRows));
        return rows.size() > 0;
    }

    public boolean isNoRecordMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(noRecordsFound))
                .isDisplayed();
    }
    
    private By adminHeader = By.xpath("//h6[text()='Admin']");

    public boolean isAdminPageDisplayed() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(adminHeader)).isDisplayed();
    }


}

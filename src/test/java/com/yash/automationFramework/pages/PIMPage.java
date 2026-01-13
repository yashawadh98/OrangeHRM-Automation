package com.yash.automationFramework.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class PIMPage {

    WebDriver driver;
    WebDriverWait wait;

    private By pimHeader = By.xpath("//h6[text()='PIM']");
    private By employeeName = By.xpath("//label[text()='Employee Name']/../following-sibling::div//input");
    private By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private By records = By.xpath("//div[@class='oxd-table-body']//div[@role='row']");

    public PIMPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isPIMPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pimHeader)).isDisplayed();
    }

    public void searchEmployee(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName)).sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
    }

    public boolean isEmployeeFound() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(records)).size() > 0;
    }
}

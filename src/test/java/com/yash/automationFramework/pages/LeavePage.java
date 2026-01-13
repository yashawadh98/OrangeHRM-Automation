package com.yash.automationFramework.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class LeavePage {

    WebDriver driver;
    WebDriverWait wait;

    private By leaveHeader = By.xpath("//h6[text()='Leave']");

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLeavePageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(leaveHeader)).isDisplayed();
    }
}

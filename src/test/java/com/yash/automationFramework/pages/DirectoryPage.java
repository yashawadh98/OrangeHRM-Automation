package com.yash.automationFramework.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class DirectoryPage {

    WebDriver driver;
    WebDriverWait wait;

    private By directoryHeader = By.xpath("//h6[text()='Directory']");

    public DirectoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isDirectoryDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(directoryHeader)).isDisplayed();
    }
}

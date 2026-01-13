package com.yash.automationFramework.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class TimePage {

    WebDriver driver;
    WebDriverWait wait;

    private By timeHeader = By.xpath("//h6[text()='Time']");

    public TimePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isTimePageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(timeHeader)).isDisplayed();
    }
}

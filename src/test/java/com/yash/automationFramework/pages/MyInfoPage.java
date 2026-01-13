package com.yash.automationFramework.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class MyInfoPage {

    WebDriver driver;
    WebDriverWait wait;

    private By myInfoHeader = By.xpath("//h6[text()='Personal Details']");

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isMyInfoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(myInfoHeader)).isDisplayed();
    }
}
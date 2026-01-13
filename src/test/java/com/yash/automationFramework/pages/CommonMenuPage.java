package com.yash.automationFramework.pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CommonMenuPage {

    WebDriver driver;
    WebDriverWait wait;

    private By adminMenu = By.xpath("//span[text()='Admin']");
    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By leaveMenu = By.xpath("//span[text()='Leave']");
    private By timeMenu = By.xpath("//span[text()='Time']");
    private By myInfoMenu = By.xpath("//span[text()='My Info']");
    private By directoryMenu = By.xpath("//span[text()='Directory']");

    public CommonMenuPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToAdmin() { wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click(); }
    public void goToPIM() { wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click(); }
    public void goToLeave() { wait.until(ExpectedConditions.elementToBeClickable(leaveMenu)).click(); }
    public void goToTime() { wait.until(ExpectedConditions.elementToBeClickable(timeMenu)).click(); }
    public void goToMyInfo() { wait.until(ExpectedConditions.elementToBeClickable(myInfoMenu)).click(); }
    public void goToDirectory() { wait.until(ExpectedConditions.elementToBeClickable(directoryMenu)).click(); }
}

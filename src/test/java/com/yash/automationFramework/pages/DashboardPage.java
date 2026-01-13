package com.yash.automationFramework.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By dashboardHeader=By.xpath("//h6[text()='Dashboard']");
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public boolean isDashboardDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
	}
	

}

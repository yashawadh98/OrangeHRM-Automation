package com.yash.automationFramework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver() {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		getDriver().manage().window().maximize();
	}
	

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		getDriver().quit();
		driver.remove();
	}

}

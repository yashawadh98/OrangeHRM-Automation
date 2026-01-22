package com.yash.automationFramework.base;




import org.testng.annotations.*;
import com.yash.automationFramework.listeners.TestListener;
import com.yash.automationFramework.pages.LoginPage;


public class BaseTest {

	@BeforeMethod(alwaysRun=true)
	public void setup() {
		DriverFactory.initDriver();
		DriverFactory.getDriver()
			.get("https://opensource-demo.orangehrmlive.com/");

		LoginPage login = new LoginPage(DriverFactory.getDriver());
		login.login("Admin", "admin123");
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}

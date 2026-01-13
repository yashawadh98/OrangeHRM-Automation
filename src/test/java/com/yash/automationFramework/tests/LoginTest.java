package com.yash.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yash.automationFramework.base.BaseTest;
import com.yash.automationFramework.pages.DashboardPage;
import com.yash.automationFramework.pages.LoginPage;
import com.yash.automationFramework.utils.ConfigReader;

public class LoginTest extends BaseTest {

	@Test
	public void verifyValidLogin() {
		LoginPage login = new LoginPage(driver);
		login.login(
				ConfigReader.get("username"),
				ConfigReader.get("password")
		);
		

		DashboardPage dashboard = new DashboardPage(driver);
		Assert.assertTrue(dashboard.isDashboardDisplayed(), "Dashboard is not displayed after login");

	}
}
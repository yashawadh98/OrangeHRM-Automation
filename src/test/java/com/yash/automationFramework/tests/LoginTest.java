package com.yash.automationFramework.tests;

import org.testng.annotations.Test;

import com.yash.automationFramework.base.BaseTest;
import com.yash.automationFramework.base.DriverFactory;
import com.yash.automationFramework.pages.LoginPage;
import com.yash.automationFramework.utils.ConfigReader;

public class LoginTest extends BaseTest {

	@Test
	public void verifyLogin() {
	    LoginPage login = new LoginPage(DriverFactory.getDriver());
	    login.login(
	        ConfigReader.get("username"),
	        ConfigReader.get("password")
	    );
	}
}

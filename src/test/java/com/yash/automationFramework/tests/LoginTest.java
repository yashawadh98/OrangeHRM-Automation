package com.yash.automationFramework.tests;

import org.testng.annotations.Test;
import com.yash.automationFramework.base.*;
import com.yash.automationFramework.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void validLoginTest() {
		LoginPage login = new LoginPage(DriverFactory.getDriver());
		login.login("Admin", "admin123");
	}

}

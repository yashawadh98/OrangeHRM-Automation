package com.yash.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yash.automationFramework.base.*;
import com.yash.automationFramework.pages.*;

public class AdminTest extends BaseTest {

	@Test
	public void verifyAdminPageLoads() {
		AdminPage admin = new DashboardPage(DriverFactory.getDriver()).goToAdmin();
		Assert.assertTrue(admin.isAdminPageDisplayed());
	}

	@Test
	public void verifySearchByUsername() {
		AdminPage admin = new DashboardPage(DriverFactory.getDriver()).goToAdmin();
		admin.searchByUsername("Admin");
		Assert.assertTrue(admin.isRecordsDisplayed());
	}

	@Test
	public void verifyResetFunctionality() {
		AdminPage admin = new DashboardPage(DriverFactory.getDriver()).goToAdmin();
		admin.searchByUsername("Admin");
		admin.resetSearch();
	}

	@Test
	public void verifyAddButtonPresence() {
		AdminPage admin = new DashboardPage(DriverFactory.getDriver()).goToAdmin();
		Assert.assertTrue(admin.isAddButtonVisible());
	}
}
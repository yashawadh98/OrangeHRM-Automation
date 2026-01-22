package com.yash.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yash.automationFramework.base.BaseTest;
import com.yash.automationFramework.base.DriverFactory;
import com.yash.automationFramework.pages.DashboardPage;
import com.yash.automationFramework.pages.LoginPage;
import com.yash.automationFramework.pages.PimPage;

public class PimTest extends BaseTest {

	@BeforeClass
	public void loginOnce() {
		LoginPage login = new LoginPage(DriverFactory.getDriver());
		login.login("Admin", "admin123");
	}

	@Test
	public void verifyPimPageLoads() {
		PimPage pim = new DashboardPage(DriverFactory.getDriver()).goToPim();
		Assert.assertTrue(pim.isPimPageDisplayed());
	}

	@Test
	public void verifySearchByEmployeeName() {
		PimPage pim = new DashboardPage(DriverFactory.getDriver()).goToPim();

		pim.searchByEmployeeName("a");
		Assert.assertTrue(pim.isRecordsDisplayed());
	}

	@Test
	public void verifyResetFunctionality() {
		PimPage pim = new DashboardPage(DriverFactory.getDriver()).goToPim();

		pim.searchByEmployeeId("0295");
		pim.resetSearch();
	}

	@Test
	public void verifyAddEmployeeButton() {
		PimPage pim = new DashboardPage(DriverFactory.getDriver()).goToPim();
		Assert.assertTrue(pim.isAddEmployeeButtonVisible());
	}
}

package com.yash.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.yash.automationFramework.base.BaseTest;
import com.yash.automationFramework.pages.*;
import com.yash.automationFramework.utils.ConfigReader;
import com.yash.automationFramework.utils.ExtentTestManager;

public class SmokeTest extends BaseTest {

    @Test
    public void verifyAllMainModulesAccessible() {

        ExtentTestManager.getTest().info("Smoke Test started");

        // Login
        LoginPage login = new LoginPage(driver);
        ExtentTestManager.getTest().info("Logging into OrangeHRM application");

        login.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDashboardDisplayed(),
                "Dashboard not displayed after login");
        ExtentTestManager.getTest().pass("Login successful and Dashboard displayed");

        CommonMenuPage menu = new CommonMenuPage(driver);

        // Admin
        ExtentTestManager.getTest().info("Navigating to Admin module");
        menu.goToAdmin();

        AdminPage admin = new AdminPage(driver);
        Assert.assertTrue(admin.isAdminPageDisplayed(),
                "Admin page not accessible");
        ExtentTestManager.getTest().pass("Admin module loaded successfully");

        // PIM
        ExtentTestManager.getTest().info("Navigating to PIM module");
        menu.goToPIM();

        PIMPage pim = new PIMPage(driver);
        Assert.assertTrue(pim.isPIMPageDisplayed(),
                "PIM page not accessible");
        ExtentTestManager.getTest().pass("PIM module loaded successfully");

        // Leave
        ExtentTestManager.getTest().info("Navigating to Leave module");
        menu.goToLeave();

        LeavePage leave = new LeavePage(driver);
        Assert.assertTrue(leave.isLeavePageDisplayed(),
                "Leave page not accessible");
        ExtentTestManager.getTest().pass("Leave module loaded successfully");

        // Time
        ExtentTestManager.getTest().info("Navigating to Time module");
        menu.goToTime();

        TimePage time = new TimePage(driver);
        Assert.assertTrue(time.isTimePageDisplayed(),
                "Time page not accessible");
        ExtentTestManager.getTest().pass("Time module loaded successfully");

        // My Info
        ExtentTestManager.getTest().info("Navigating to My Info module");
        menu.goToMyInfo();

        MyInfoPage myInfo = new MyInfoPage(driver);
        Assert.assertTrue(myInfo.isMyInfoDisplayed(),
                "My Info page not accessible");
        ExtentTestManager.getTest().pass("My Info module loaded successfully");

        // Directory
        ExtentTestManager.getTest().info("Navigating to Directory module");
        menu.goToDirectory();

        DirectoryPage directory = new DirectoryPage(driver);
        Assert.assertTrue(directory.isDirectoryDisplayed(),
                "Directory page not accessible");
        ExtentTestManager.getTest().pass("Directory module loaded successfully");

        ExtentTestManager.getTest().info("Smoke Test completed successfully");
    }
}

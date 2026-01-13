package com.yash.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yash.automationFramework.base.BaseTest;
import com.yash.automationFramework.pages.*;

public class LeaveTest extends BaseTest {

    @Test
    public void verifyLeavePageAccess() {

        new LoginPage(driver).login("Admin", "admin123");

        CommonMenuPage menu = new CommonMenuPage(driver);
        menu.goToLeave();

        LeavePage leave = new LeavePage(driver);
        Assert.assertTrue(leave.isLeavePageDisplayed());
    }
}

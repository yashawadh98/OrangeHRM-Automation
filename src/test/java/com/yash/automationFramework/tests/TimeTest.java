package com.yash.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yash.automationFramework.base.BaseTest;
import com.yash.automationFramework.pages.*;

public class TimeTest extends BaseTest {

    @Test
    public void verifyTimePageAccess() {

        new LoginPage(driver).login("Admin", "admin123");

        CommonMenuPage menu = new CommonMenuPage(driver);
        menu.goToTime();

        TimePage time = new TimePage(driver);
        Assert.assertTrue(time.isTimePageDisplayed());
    }
}

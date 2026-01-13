package com.yash.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yash.automationFramework.base.BaseTest;
import com.yash.automationFramework.pages.*;

public class PIMTest extends BaseTest {

    @Test
    public void verifyEmployeeSearch() {

        new LoginPage(driver).login("Admin", "admin123");

        CommonMenuPage menu = new CommonMenuPage(driver);
        menu.goToPIM();

        PIMPage pim = new PIMPage(driver);
        Assert.assertTrue(pim.isPIMPageDisplayed());

        pim.searchEmployee("Paul");
        Assert.assertTrue(pim.isEmployeeFound());
    }
}

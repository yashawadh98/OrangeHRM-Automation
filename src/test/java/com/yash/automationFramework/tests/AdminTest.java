package com.yash.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yash.automationFramework.base.BaseTest;
import com.yash.automationFramework.pages.*;
import com.yash.automationFramework.utils.ConfigReader;

public class AdminTest extends BaseTest {

    @Test
    public void verifyAdminSearchByUsername() {

        new LoginPage(driver).login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        CommonMenuPage menu = new CommonMenuPage(driver);
        menu.goToAdmin();

        AdminPage admin = new AdminPage(driver);
        admin.enterUsername("Admin");
        admin.clickSearch();

        Assert.assertTrue(admin.isUserDisplayedInResults());
    }
}

package com.yash.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yash.automationFramework.base.BaseTest;
import com.yash.automationFramework.pages.*;

public class DirectoryTest extends BaseTest {

    @Test
    public void verifyDirectoryPage() {

        new LoginPage(driver).login("Admin", "admin123");

        CommonMenuPage menu = new CommonMenuPage(driver);
        menu.goToDirectory();

        DirectoryPage directory = new DirectoryPage(driver);
        Assert.assertTrue(directory.isDirectoryDisplayed());
    }
}

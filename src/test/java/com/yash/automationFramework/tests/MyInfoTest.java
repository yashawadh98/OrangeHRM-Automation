package com.yash.automationFramework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.yash.automationFramework.base.BaseTest;
import com.yash.automationFramework.pages.*;

public class MyInfoTest extends BaseTest {

    @Test
    public void verifyMyInfoPage() {

        new LoginPage(driver).login("Admin", "admin123");

        CommonMenuPage menu = new CommonMenuPage(driver);
        menu.goToMyInfo();

        MyInfoPage myInfo = new MyInfoPage(driver);
        Assert.assertTrue(myInfo.isMyInfoDisplayed());
    }
}

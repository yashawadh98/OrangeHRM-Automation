package com.yash.automationFramework.base;




import org.testng.annotations.*;

public class BaseTest {

	@BeforeSuite
    public void globalSetUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver()
            .get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterSuite
    public void globalTearDown() {
        DriverFactory.quitDriver();
    }

}

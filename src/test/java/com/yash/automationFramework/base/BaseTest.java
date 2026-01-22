package com.yash.automationFramework.base;




import org.testng.annotations.*;
import com.yash.automationFramework.listeners.TestListener;

@Listeners(TestListener.class)
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

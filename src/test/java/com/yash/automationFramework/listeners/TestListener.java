package com.yash.automationFramework.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import com.aventstack.extentreports.*;
import com.yash.automationFramework.base.DriverFactory;
import com.yash.automationFramework.utils.*;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private static final Logger log =
        LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest =
            extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
        log.info("STARTED TEST: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
        log.info("PASSED TEST: {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = DriverFactory.getDriver();
        String screenshotPath =
            ScreenshotUtil.capture(driver, result.getMethod().getMethodName());

        test.get().fail(result.getThrowable());
        test.get().addScreenCaptureFromPath(screenshotPath);

        log.error( "FAILED TEST: {}", result.getMethod().getMethodName());
        log.error(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

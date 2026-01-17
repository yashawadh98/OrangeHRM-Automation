package com.yash.automationFramework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.yash.automationFramework.base.DriverFactory;
import com.yash.automationFramework.utils.ExtentManager;
import com.yash.automationFramework.utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(
            ExtentManager.getInstance()
                .createTest(result.getMethod().getMethodName())
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.takeScreenshot(
            DriverFactory.getDriver(),
            result.getMethod().getMethodName()
        );
        test.get().fail(result.getThrowable())
            .addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}


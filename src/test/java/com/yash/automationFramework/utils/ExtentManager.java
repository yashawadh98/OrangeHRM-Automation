package com.yash.automationFramework.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReport() {

        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter(
                    System.getProperty("user.dir") + "/reports/ExtentReport.html");

            spark.config().setReportName("OrangeHRM Automation Report");
            spark.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Application", "OrangeHRM");
            extent.setSystemInfo("Browser", ConfigReader.get("browser"));
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "Yash");
        }
        return extent;
    }
}

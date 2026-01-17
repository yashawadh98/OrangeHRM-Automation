package com.yash.automationFramework.utils;

import java.io.File;
import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String name) {
        String path = "screenshots/" + name + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            org.openqa.selenium.io.FileHandler.copy(src, new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}

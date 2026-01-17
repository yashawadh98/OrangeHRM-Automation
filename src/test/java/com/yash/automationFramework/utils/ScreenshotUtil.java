package com.yash.automationFramework.utils;

import java.io.File;
import org.openqa.selenium.*;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String name) {
        String dir = "screenshots";
        String path = dir + "/" + name + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);

        // ✅ IMPORTANT: Create directory if not exists (Jenkins-safe)
        dest.getParentFile().mkdirs();

        try {
            org.openqa.selenium.io.FileHandler.copy(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}

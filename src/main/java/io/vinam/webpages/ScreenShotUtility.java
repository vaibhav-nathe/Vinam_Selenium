package io.vinam.webpages;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ScreenShotUtility {


    public static void takeScreenShot(WebDriver driver, String fileName) {

        LocalDate date = LocalDate.now();
        String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "output" + File.separator +
                date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        takeScreenShot(driver, filePath, fileName);

    }

    public static void takeScreenShot(WebDriver driver, String filePath, String fileName) {

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        try {
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(filePath + File.separator + fileName);
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void takeScreenShot(WebDriver driver) {
        String fileName = RandomStringUtils.randomAlphabetic(9) + ".jpg";
        takeScreenShot(driver, fileName);

    }
}

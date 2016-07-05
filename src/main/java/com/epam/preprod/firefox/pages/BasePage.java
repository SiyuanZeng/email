package com.epam.preprod.firefox.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Oksana_Nytrebych on 5/24/2016.
 */
public abstract class BasePage {
    protected WebDriver webDriver;


    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    protected void makeScreen(String fileName) {
        File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

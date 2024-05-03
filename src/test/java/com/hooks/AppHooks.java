package com.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import com.baseclass.BaseClass;
import com.utilities.ConfigReader;

import java.io.IOException;
import java.util.Properties;

public class AppHooks {

    private BaseClass baseClass;
    private WebDriver driver;
    private ConfigReader configReader;
    private Properties prop;

    @Before(order = 0)
    public void getReader() throws IOException {
        configReader = new ConfigReader();
        prop = configReader.configReader();
    }

    @Before(order = 1)
    public void launchBrowser() {
        baseClass = new BaseClass();
        driver = baseClass.initializeBrowser();
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }
}
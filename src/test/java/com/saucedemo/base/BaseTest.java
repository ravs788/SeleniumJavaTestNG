package com.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.saucedemo.utilities.ConfigFileReader;
import com.saucedemo.utilities.LoggerUtil;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
    protected static WebDriver _driver;
    protected ConfigFileReader configFileReader;
    protected static String URL;
    protected static String browser; 
	
    @BeforeSuite
    public void setUp() throws InterruptedException {
        
        configFileReader = new ConfigFileReader();
        URL = configFileReader.getURL();
        browser = configFileReader.getBrowser();
        if(browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            _driver = new ChromeDriver();
            LoggerUtil.info("Chrome Browser Launched");
            Thread.sleep(2000);
        }
        else if(browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            _driver = new FirefoxDriver();
            LoggerUtil.info("Firefox Browser Launched");
            Thread.sleep(2000);
        }
        else if(browser.equals("edge"))
        {
            WebDriverManager.iedriver().setup();
            _driver = new EdgeDriver();
            LoggerUtil.info("Edge Browser Launched");
            Thread.sleep(2000);
        }
        else
        {
            WebDriverManager.chromedriver().setup();
            _driver = new ChromeDriver();
            LoggerUtil.info("Deafult Browser Launched");
            Thread.sleep(2000);
        }
            
        _driver.get(URL);
        LoggerUtil.info("URL "+URL+" Launched");
        _driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    @AfterSuite
    public void tearDown() {
        _driver.quit();
    }

}

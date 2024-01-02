package com.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.saucedemo.utilities.ConfigFileReader;
import com.saucedemo.utilities.ElementActions;
import com.saucedemo.utilities.LoggerUtil;
import com.saucedemo.utilities.WaitHandling;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
    protected WebDriver _driver;
    protected ConfigFileReader configFileReader;
    protected LoggerUtil _loggerUtil;
    protected String URL;
    protected String browser; 
    protected int waitTime;
    protected ElementActions elementActions;
    protected WaitHandling waitHandling;
	
    @BeforeClass
    public void setUp(){
        
        configFileReader = new ConfigFileReader();
        waitHandling = new WaitHandling();
        _loggerUtil = new LoggerUtil();
        elementActions = new ElementActions(waitHandling, _loggerUtil);
        URL = configFileReader.getURL();
        browser = configFileReader.getBrowser();
        waitTime = configFileReader.getWaitTime();
        if(browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            _driver = new ChromeDriver(options);
            _loggerUtil.info("Chrome Browser Launched");
        }
        else if(browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            // options.setHeadless(true);
            // options.addArguments("headless");
            _driver = new FirefoxDriver(options);
            
            _loggerUtil.info("Firefox Browser Launched");
        }
        else if(browser.equals("edge"))
        {
            WebDriverManager.iedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("headless");
            _driver = new EdgeDriver(options);
            _loggerUtil.info("Edge Browser Launched");
        }
        else
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            _driver = new ChromeDriver(options);
            _loggerUtil.info("Deafult Browser Launched");
        }
            
        _driver.get(URL);
        _loggerUtil.info("URL "+URL+" Launched");
        _driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        _driver.quit();
    }

}

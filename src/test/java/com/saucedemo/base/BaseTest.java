package com.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.saucedemo.utilities.ConfigFileReader;
import com.saucedemo.utilities.ElementActions;
import com.saucedemo.utilities.LoggerUtil;
import com.saucedemo.utilities.WaitHandling;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
    protected WebDriver driver;
    protected ConfigFileReader configFileReader;
    protected LoggerUtil loggerUtil;
    protected String URL;
    protected String browser; 
    protected int waitTime;
    protected ElementActions elementActions;
    protected WaitHandling waitHandling;
	
    @BeforeClass
    public void setUp(){
        
        configFileReader = new ConfigFileReader();
        waitHandling = new WaitHandling();
        loggerUtil = new LoggerUtil();
        elementActions = new ElementActions(waitHandling, loggerUtil);
        URL = configFileReader.getURL();
        browser = configFileReader.getBrowser();
        waitTime = configFileReader.getWaitTime();
        if(browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
            loggerUtil.info("Chrome Browser Launched");
        }
        else if(browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            // options.setHeadless(true);
            // options.addArguments("headless");
            driver = new FirefoxDriver(options);
            
            loggerUtil.info("Firefox Browser Launched");
        }
        else if(browser.equals("edge"))
        {
            WebDriverManager.iedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("headless");
            driver = new EdgeDriver(options);
            loggerUtil.info("Edge Browser Launched");
        }
        else
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
            loggerUtil.info("Deafult Browser Launched");
        }
            
        driver.get(URL);
        loggerUtil.info("URL "+URL+" Launched");
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}

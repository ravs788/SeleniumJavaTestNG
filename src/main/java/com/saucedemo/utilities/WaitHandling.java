package com.saucedemo.utilities;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHandling {

    private ConfigFileReader configFileReader;
    private int waitTime;
    private int pollingTime;

    public WaitHandling() {
        configFileReader = new ConfigFileReader();
        waitTime = configFileReader.getWaitTime();
        pollingTime = configFileReader.getPollingTime();
    }
    public boolean Wait(WebElement element, String operation)
    {
        ExplicitWait(element, operation);   
        if(operation.equals("isDisplayed"))     
        {    if(element.isDisplayed())
                return true;
            else
            {
                FluentWait(element, operation);
                if(element.isDisplayed())
                    return true;
            }
        }
        else if(operation.equals("isEnabled"))
        {    if(element.isEnabled())
                return true;
            else
            {
                FluentWait(element, operation);
                if(element.isEnabled())
                    return true;
            }
        }
        else if(operation.equals("isSelected"))
        {    if(element.isSelected())
                return true;
            else
            {
                FluentWait(element, operation);
                if(element.isSelected())
                    return true;
            }
        }
        else if(operation.equals("isNotDisplayed"))
        {    if(!element.isDisplayed())
                return true;
            else
            {
                FluentWait(element, operation);
                if(!element.isDisplayed())
                    return true;
            }
        }
        else if(operation.equals("isNotEnabled"))
        {    if(!element.isEnabled())
                return true;
            else
            {
                FluentWait(element, operation);
                if(!element.isEnabled())
                    return true;
            }
        }
        else if(operation.equals("isNotSelected"))
        {    if(!element.isSelected())
                return true;
            else
            {
                FluentWait(element, operation);
                if(!element.isSelected())
                    return true;
            }
        }
        return false;
    }

    public void ExplicitWait(WebElement element, String operation)
    {
        RemoteWebElement remoteElement = (RemoteWebElement)element;
        WebDriver driver = remoteElement.getWrappedDriver();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime) );
        if(operation.equals("isDisplayed"))
            wait.until(d -> element.isDisplayed());
        else if(operation.equals("isEnabled"))
            wait.until(d -> element.isEnabled());
        else if(operation.equals("isSelected"))
            wait.until(d -> element.isSelected());
        else if(operation.equals("isNotDisplayed"))
            wait.until(d -> !element.isDisplayed());
        else if(operation.equals("isNotEnabled"))
            wait.until(d -> !element.isEnabled());
        else if(operation.equals("isNotSelected"))
            wait.until(d -> !element.isSelected());
        else
            wait.until(d -> element.isDisplayed());
    }

    public void FluentWait(WebElement element, String operation)
    {
        RemoteWebElement remoteElement = (RemoteWebElement)element;
        WebDriver driver = remoteElement.getWrappedDriver();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        .withTimeout(Duration.ofSeconds(waitTime))
        .pollingEvery(Duration.ofSeconds(pollingTime))
        .ignoring(NoSuchElementException.class);
        if(operation.equals("isDisplayed"))
            wait.until(d -> element.isDisplayed());
        else if(operation.equals("isEnabled"))
            wait.until(d -> element.isEnabled());
        else if(operation.equals("isSelected"))
            wait.until(d -> element.isSelected());
        else if(operation.equals("isNotDisplayed"))
            wait.until(d -> !element.isDisplayed());
        else if(operation.equals("isNotEnabled"))
            wait.until(d -> !element.isEnabled());
        else if(operation.equals("isNotSelected"))
            wait.until(d -> !element.isSelected());
        else
            wait.until(d -> element.isDisplayed());
        
    }
}

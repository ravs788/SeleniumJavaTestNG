package com.saucedemo.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;

public class ElementActions {

    private WaitHandling waitHandling;
    private LoggerUtil loggerUtil;

    public ElementActions(WaitHandling waitHandling, LoggerUtil loggerUtil) {
        this.waitHandling = waitHandling;
        this.loggerUtil = loggerUtil;
    }

    public void enterData(WebElement element, String data) {
        if(isDisplayed(element) && isEnabled(element))
        {
            clear(element);    
            element.sendKeys(data);
        }

        loggerUtil.info("Entered data: " + data + " in element: " + element.toString());
    }

    public void click(WebElement element) {
        if(isDisplayed(element) && isEnabled(element))
            element.click();

        loggerUtil.info("clicked on element: " + element.toString());
    }

    public String getText(WebElement element) {
        if(isDisplayed(element) && isEnabled(element))
        {
            loggerUtil.info("Text of element: " + element.toString() + " is: " + element.getText());
            return element.getText();
        }
        else
            return "";

    }

    public boolean isDisplayed(WebElement element) {
        waitHandling.Wait(element, "isDisplayed");
        if(element.isDisplayed())
        {
            loggerUtil.info("Element: " + element.toString() + " is displayed");
            return true;
        }
        else
        {
            loggerUtil.error("Element: " + element.toString() + " is not displayed");
            return false;
        }
    }

    public boolean isEnabled(WebElement element) {
        waitHandling.Wait(element, "isEnabled");
        if(element.isEnabled())
        {
            loggerUtil.info("Element: " + element.toString() + " is enabled");
            return true;
        }
        else
        {
            loggerUtil.error("Element: " + element.toString() + " is not enabled");
            return false;
        }
    }

    public void clear(WebElement element) {
        if(isDisplayed(element) && isEnabled(element))
            element.clear();
        
        loggerUtil.info("Cleared element: " + element.toString());
    }

    public boolean areDisplayed(List<WebElement> elements) {
        if(elements.size() > 0) 
        {
            for(WebElement element : elements)
            {
                if(!element.isDisplayed())
                {
                    loggerUtil.error("Element: " + element.toString() + " is not displayed");
                    return false;
                }
                else
                    loggerUtil.info("Element: " + element.toString() + " is displayed");
            }
            return true;
        }
        else
        {
            loggerUtil.error("No elements found");
            return false;
        }
    }
}

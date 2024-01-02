package com.saucedemo.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;

public class ElementActions {

    private WaitHandling _waitHandling;
    private LoggerUtil _loggerUtil;

    public ElementActions(WaitHandling waitHandling, LoggerUtil loggerUtil) {
        _waitHandling = waitHandling;
        _loggerUtil = loggerUtil;
    }

    public void EnterData(WebElement element, String data) {
        if(IsDisplayed(element) && IsEnabled(element))
        {
            Clear(element);    
            element.sendKeys(data);
        }

        _loggerUtil.info("Entered data: " + data + " in element: " + element.toString());
    }

    public void Click(WebElement element) {
        if(IsDisplayed(element) && IsEnabled(element))
            element.click();

        _loggerUtil.info("Clicked on element: " + element.toString());
    }

    public String GetText(WebElement element) {
        if(IsDisplayed(element) && IsEnabled(element))
        {
            _loggerUtil.info("Text of element: " + element.toString() + " is: " + element.getText());
            return element.getText();
        }
        else
            return "";

    }

    public boolean IsDisplayed(WebElement element) {
        _waitHandling.Wait(element, "isDisplayed");
        if(element.isDisplayed())
        {
            _loggerUtil.info("Element: " + element.toString() + " is displayed");
            return true;
        }
        else
        {
            _loggerUtil.error("Element: " + element.toString() + " is not displayed");
            return false;
        }
    }

    public boolean IsEnabled(WebElement element) {
        _waitHandling.Wait(element, "isEnabled");
        if(element.isEnabled())
        {
            _loggerUtil.info("Element: " + element.toString() + " is enabled");
            return true;
        }
        else
        {
            _loggerUtil.error("Element: " + element.toString() + " is not enabled");
            return false;
        }
    }

    public void Clear(WebElement element) {
        if(IsDisplayed(element) && IsEnabled(element))
            element.clear();
        
        _loggerUtil.info("Cleared element: " + element.toString());
    }

    public boolean AreDisplayed(List<WebElement> elements) {
        if(elements.size() > 0) 
        {
            for(WebElement element : elements)
            {
                if(!element.isDisplayed())
                {
                    _loggerUtil.error("Element: " + element.toString() + " is not displayed");
                    return false;
                }
                else
                    _loggerUtil.info("Element: " + element.toString() + " is displayed");
            }
            return true;
        }
        else
        {
            _loggerUtil.error("No elements found");
            return false;
        }
    }
}

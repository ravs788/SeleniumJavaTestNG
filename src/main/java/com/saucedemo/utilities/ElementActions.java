package com.saucedemo.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;

public class ElementActions {
    public static void EnterData(WebElement element, String data) {
        if(ElementActions.IsDisplayed(element) && ElementActions.IsEnabled(element))
        {
            ElementActions.Clear(element);    
            element.sendKeys(data);
        }

        LoggerUtil.info("Entered data: " + data + " in element: " + element.toString());
    }

    public static void Click(WebElement element) {
        if(ElementActions.IsDisplayed(element) && ElementActions.IsEnabled(element))
            element.click();

        LoggerUtil.info("Clicked on element: " + element.toString());
    }

    public  static String GetText(WebElement element) {
        if(ElementActions.IsDisplayed(element) && ElementActions.IsEnabled(element))
        {
            LoggerUtil.info("Text of element: " + element.toString() + " is: " + element.getText());
            return element.getText();
        }
        else
            return "";

    }

    public static boolean IsDisplayed(WebElement element) {
        if(element.isDisplayed())
        {
            LoggerUtil.info("Element: " + element.toString() + " is displayed");
            return true;
        }
        else
        {
            LoggerUtil.error("Element: " + element.toString() + " is not displayed");
            return false;
        }
    }

    public static boolean IsEnabled(WebElement element) {
        if(element.isEnabled())
        {
            LoggerUtil.info("Element: " + element.toString() + " is enabled");
            return true;
        }
        else
        {
            LoggerUtil.error("Element: " + element.toString() + " is not enabled");
            return false;
        }
    }

    public static void Clear(WebElement element) {
        if(ElementActions.IsDisplayed(element) && ElementActions.IsEnabled(element))
            element.clear();
        
        LoggerUtil.info("Cleared element: " + element.toString());
    }

    public static boolean AreDisplayed(List<WebElement> elements) {
        if(elements.size() > 0) 
        {
            for(WebElement element : elements)
            {
                if(!element.isDisplayed())
                {
                    LoggerUtil.error("Element: " + element.toString() + " is not displayed");
                    return false;
                }
                else
                    LoggerUtil.info("Element: " + element.toString() + " is displayed");
            }
            return true;
        }
        else
        {
            LoggerUtil.error("No elements found");
            return false;
        }
    }
}

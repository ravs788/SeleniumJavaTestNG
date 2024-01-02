package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class PaymentsPage {
    private WebDriver _driver;
    private ElementActions _elementActions;


    public PaymentsPage(WebDriver driver, ElementActions elementActions) {
        _driver = driver;
        _elementActions = elementActions;
    }

    By finishButton = By.id("finish");
    
    public void finishOrder() {
        _elementActions.Click(_driver.findElement(finishButton));
    }
}

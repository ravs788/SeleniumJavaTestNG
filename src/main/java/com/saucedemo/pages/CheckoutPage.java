package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;
import com.saucedemo.utilities.LoggerUtil;

public class CheckoutPage {
    private WebDriver _driver;
    private ElementActions _elementActions;

    public CheckoutPage(WebDriver driver, ElementActions elementActions) {
        _driver = driver;
        _elementActions = elementActions;
    }

    By checkoutButton = By.id("checkout");
   
    public void checkout() {
        _elementActions.Click(_driver.findElement(checkoutButton));
    }
}

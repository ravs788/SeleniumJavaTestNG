package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class OrderVerificationPage {
    private WebDriver _driver;
    private ElementActions _elementActions;

    public OrderVerificationPage(WebDriver driver, ElementActions elementActions) {
        _driver = driver;
        _elementActions = elementActions;
    }   

    By verifyOrderSuccessful = By.className("complete-header");
    By backHomeButton = By.id("back-to-products");

    public boolean isOrderSuccessful() {
        return _elementActions.IsDisplayed(_driver.findElement(verifyOrderSuccessful));
    }

    public void backHome() {
        _elementActions.Click(_driver.findElement(backHomeButton));
    }
    
}

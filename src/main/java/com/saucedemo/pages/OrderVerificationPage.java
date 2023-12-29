package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class OrderVerificationPage {
    private WebDriver _driver;

    public OrderVerificationPage(WebDriver driver) {
        _driver = driver;
    }   

    By verifyOrderSuccessful = By.className("complete-header");
    By backHomeButton = By.id("back-to-products");

    public boolean isOrderSuccessful() {
        return ElementActions.IsDisplayed(_driver.findElement(verifyOrderSuccessful));
    }

    public void backHome() {
        ElementActions.Click(_driver.findElement(backHomeButton));
    }
    
}

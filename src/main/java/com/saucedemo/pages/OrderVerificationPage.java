package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderVerificationPage {
    private WebDriver _driver;

    public OrderVerificationPage(WebDriver driver) {
        _driver = driver;
    }   

    By verifyOrderSuccessful = By.className("complete-header");
    By backHomeButton = By.id("back-to-products");

    public boolean isOrderSuccessful() {
        return _driver.findElement(verifyOrderSuccessful).isDisplayed();
    }

    public void backHome() {
        _driver.findElement(backHomeButton).click();
    }
    
}

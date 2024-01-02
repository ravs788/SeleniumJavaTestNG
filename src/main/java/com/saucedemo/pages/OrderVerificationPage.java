package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class OrderVerificationPage {
    private WebDriver driver;
    private ElementActions elementActions;

    public OrderVerificationPage(WebDriver driver, ElementActions elementActions) {
        this.driver = driver;
        this.elementActions = elementActions;
    }   

    By verifyOrderSuccessful = By.className("complete-header");
    By backHomeButton = By.id("back-to-products");

    public boolean isOrderSuccessful() {
        return elementActions.isDisplayed(driver.findElement(verifyOrderSuccessful));
    }

    public void backHome() {
        elementActions.click(driver.findElement(backHomeButton));
    }
    
}

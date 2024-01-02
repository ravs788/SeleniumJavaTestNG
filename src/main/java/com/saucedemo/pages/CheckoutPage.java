package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;
public class CheckoutPage {
    private WebDriver driver;
    private ElementActions elementActions;

    public CheckoutPage(WebDriver driver, ElementActions elementActions) {
        this.driver = driver;
        this.elementActions = elementActions;
    }

    By checkoutButton = By.id("checkout");
   
    public void checkout() {
        elementActions.click(driver.findElement(checkoutButton));
    }
}

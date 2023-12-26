package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver _driver;

    public CheckoutPage(WebDriver driver) {
        _driver = driver;
    }

    By checkoutButton = By.id("checkout");
   
    public void checkout() {
        _driver.findElement(checkoutButton).click();
    }
}

package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentsPage {
    private WebDriver _driver;

    public PaymentsPage(WebDriver driver) {
        _driver = driver;
    }

    By finishButton = By.id("finish");
    
    public void finishOrder() {
        _driver.findElement(finishButton).click();
    }
}

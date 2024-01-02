package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class PaymentsPage {
    private WebDriver driver;
    private ElementActions elementActions;


    public PaymentsPage(WebDriver driver, ElementActions elementActions) {
        this.driver = driver;
        this.elementActions = elementActions;
    }

    By finishButton = By.id("finish");
    
    public void finishOrder() {
        elementActions.click(driver.findElement(finishButton));
    }
}

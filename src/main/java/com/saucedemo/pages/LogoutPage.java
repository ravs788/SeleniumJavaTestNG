package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class LogoutPage {
    private WebDriver _driver;
    private ElementActions _elementActions;


    public LogoutPage(WebDriver driver, ElementActions elementActions) {
        _driver = driver;
        _elementActions = elementActions;
    }

    By menuButton = By.id("react-burger-menu-btn");
    By logoutButton = By.id("logout_sidebar_link");

    public void logout() {
        _elementActions.Click(_driver.findElement(menuButton));
        _elementActions.Click(_driver.findElement(logoutButton));
    }
            
}

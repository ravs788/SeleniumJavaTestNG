package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class LogoutPage {
    private WebDriver driver;
    private ElementActions elementActions;


    public LogoutPage(WebDriver driver, ElementActions elementActions) {
        this.driver = driver;
        this.elementActions = elementActions;
    }

    By menuButton = By.id("react-burger-menu-btn");
    By logoutButton = By.id("logout_sidebar_link");

    public void logout() {
        elementActions.click(driver.findElement(menuButton));
        elementActions.click(driver.findElement(logoutButton));
    }
            
}

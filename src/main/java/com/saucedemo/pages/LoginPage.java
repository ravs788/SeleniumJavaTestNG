package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class LoginPage {

    private WebDriver _driver;
    private ElementActions _elementActions;

    public LoginPage(WebDriver driver, ElementActions elementActions) {
        _driver = driver;
        _elementActions = elementActions;
    }

    public LoginPage() {
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By verifyLoginPage = By.className("login_logo");
    By swagLabsIcon = By.className("app_logo");
    
            
    
    public void login(String userName, String passWord) {
        _elementActions.EnterData(_driver.findElement(username),userName);
        _elementActions.EnterData(_driver.findElement(password),passWord);
        _elementActions.Click(_driver.findElement(loginButton));
    }

    public boolean isLoginSuccessful() {
        return _elementActions.IsDisplayed(_driver.findElement(swagLabsIcon));
    }

    public boolean isLoginPageLaunched() {
        return _elementActions.AreDisplayed(_driver.findElements(verifyLoginPage));
    }

}

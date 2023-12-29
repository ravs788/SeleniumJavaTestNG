package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class LoginPage {

    private WebDriver _driver;
    public LoginPage(WebDriver driver) {
        this._driver = driver;
    }

    public LoginPage() {
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By verifyLoginPage = By.className("login_logo");
    By swagLabsIcon = By.className("app_logo");
    
            
    
    public void login(String userName, String passWord) {
        ElementActions.EnterData(_driver.findElement(username),userName);
        ElementActions.EnterData(_driver.findElement(password),passWord);
        ElementActions.Click(_driver.findElement(loginButton));
    }

    public boolean isLoginSuccessful() {
        return ElementActions.IsDisplayed(_driver.findElement(swagLabsIcon));
    }

    public boolean isLoginPageLaunched() {
        return ElementActions.AreDisplayed(_driver.findElements(verifyLoginPage));
    }

}

package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        _driver.findElement(username).sendKeys(userName);
        _driver.findElement(password).sendKeys(passWord);
        _driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return _driver.findElement(swagLabsIcon).isDisplayed();
    }

    public boolean isLoginPageLaunched() {
        return _driver.findElement(verifyLoginPage).isDisplayed();
    }

}

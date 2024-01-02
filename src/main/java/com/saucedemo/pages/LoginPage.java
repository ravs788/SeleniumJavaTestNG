package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class LoginPage {

    private WebDriver driver;
    private ElementActions elementActions;

    public LoginPage(WebDriver driver, ElementActions elementActions) {
        this.driver = driver;
        this.elementActions = elementActions;
    }

    public LoginPage() {
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By verifyLoginPage = By.className("login_logo");
    By swagLabsIcon = By.className("app_logo");
    
            
    
    public void login(String userName, String passWord) {
        elementActions.enterData(driver.findElement(username),userName);
        elementActions.enterData(driver.findElement(password),passWord);
        elementActions.click(driver.findElement(loginButton));
    }

    public boolean isLoginSuccessful() {
        return elementActions.isDisplayed(driver.findElement(swagLabsIcon));
    }

    public boolean isLoginPageLaunched() {
        return elementActions.areDisplayed(driver.findElements(verifyLoginPage));
    }

}

package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserDetailsPage {
    private WebDriver _driver;

    public UserDetailsPage(WebDriver driver) {
        _driver = driver;
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueButton = By.id("continue");

    public void enterUserDetails(String firstNameData, String lastNameData, String postalCodeData) {
        _driver.findElement(firstName).sendKeys(firstNameData);
        _driver.findElement(lastName).sendKeys(lastNameData);
        _driver.findElement(postalCode).sendKeys(postalCodeData);
        _driver.findElement(continueButton).click();
    }

}

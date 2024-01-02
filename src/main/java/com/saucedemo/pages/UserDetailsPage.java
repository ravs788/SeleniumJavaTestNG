package com.saucedemo.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class UserDetailsPage {
    private WebDriver _driver;
    private ElementActions _elementActions;


    public UserDetailsPage(WebDriver driver, ElementActions elementActions) {
        _driver = driver;
        _elementActions = elementActions;
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueButton = By.id("continue");

    public void enterUserDetails(String firstNameData, String lastNameData, String postalCodeData) {
        _elementActions.EnterData(_driver.findElement(firstName), firstNameData);
        _elementActions.EnterData(_driver.findElement(lastName), lastNameData);
        _elementActions.EnterData(_driver.findElement(postalCode), postalCodeData);
        _elementActions.Click(_driver.findElement(continueButton));
    }
}

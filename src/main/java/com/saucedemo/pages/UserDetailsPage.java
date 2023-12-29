package com.saucedemo.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

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
        ElementActions.EnterData(_driver.findElement(firstName), firstNameData);
        ElementActions.EnterData(_driver.findElement(lastName), lastNameData);
        ElementActions.EnterData(_driver.findElement(postalCode), postalCodeData);
        ElementActions.Click(_driver.findElement(continueButton));
    }
}

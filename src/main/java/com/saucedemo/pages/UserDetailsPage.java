package com.saucedemo.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.utilities.ElementActions;

public class UserDetailsPage {
    private WebDriver driver;
    private ElementActions elementActions;


    public UserDetailsPage(WebDriver driver, ElementActions elementActions) {
        this.driver = driver;
        this.elementActions = elementActions;
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueButton = By.id("continue");

    public void enterUserDetails(String firstNameData, String lastNameData, String postalCodeData) {
        elementActions.enterData(driver.findElement(firstName), firstNameData);
        elementActions.enterData(driver.findElement(lastName), lastNameData);
        elementActions.enterData(driver.findElement(postalCode), postalCodeData);
        elementActions.click(driver.findElement(continueButton));
    }
}

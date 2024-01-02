package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.saucedemo.utilities.ElementActions;

public class HomePage {
    
    private WebDriver _driver;
    private ElementActions _elementActions;

    public HomePage(WebDriver driver, ElementActions elementActions) {
        _driver = driver;
        _elementActions = elementActions;
    }

    By swagLabsIcon = By.className("app_logo");
    By backpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    By backpackRemoveFromCart = By.id("remove-sauce-labs-backpack");
    By boltTShirtAddToCart = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By fleeceJacketAddToCart = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By onesieAddToCart = By.id("add-to-cart-sauce-labs-onesie");
    By tShirtRedAddToCart = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");    
    By bikeLightAddToCart = By.id("add-to-cart-sauce-labs-bike-light");
    By shoppingCart = By.className("shopping_cart_link");

    public boolean isHomePageLaunched() {
        return _driver.findElement(swagLabsIcon).isDisplayed();
    }

    public void addToCart() {
        if(!isHomePageLaunched()) {
            return;
        }
        _elementActions.Click(_driver.findElement(backpackAddToCart));
        _elementActions.Click(_driver.findElement(boltTShirtAddToCart));
        _elementActions.Click(_driver.findElement(fleeceJacketAddToCart));
       
    }

    public void completeShopping() {
        _elementActions.Click(_driver.findElement(shoppingCart));
    }

    public boolean removeFromCart() {
        List<WebElement> removeButtons = _driver.findElements(backpackRemoveFromCart);
        if(_elementActions.AreDisplayed(removeButtons))
        {
            if(_elementActions.IsEnabled(_driver.findElement(backpackRemoveFromCart))) {
                return false;
            }
        }
        else
        {
            _elementActions.Click(_driver.findElement(backpackAddToCart));
            if(_elementActions.IsEnabled(_driver.findElement(backpackRemoveFromCart))) {
                return false;
            }
        }
        return true;
    }

}
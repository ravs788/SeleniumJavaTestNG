package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    
    private WebDriver _driver;

    public HomePage(WebDriver driver) {
        _driver = driver;
    }

    By swagLabsIcon = By.className("app_logo");
    By backpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
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
        if(isHomePageLaunched() == false) {
            return;
        }
        _driver.findElement(backpackAddToCart).click();
        _driver.findElement(boltTShirtAddToCart).click();
        _driver.findElement(fleeceJacketAddToCart).click();
    }

    public void completeShopping() {
        _driver.findElement(shoppingCart).click();
    }

}

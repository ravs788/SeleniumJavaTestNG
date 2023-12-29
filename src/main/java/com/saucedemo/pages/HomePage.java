package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.saucedemo.utilities.ElementActions;

public class HomePage {
    
    private WebDriver _driver;

    public HomePage(WebDriver driver) {
        _driver = driver;
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
        ElementActions.Click(_driver.findElement(backpackAddToCart));
        ElementActions.Click(_driver.findElement(boltTShirtAddToCart));
        ElementActions.Click(_driver.findElement(fleeceJacketAddToCart));
       
    }

    public void completeShopping() {
        ElementActions.Click(_driver.findElement(shoppingCart));
    }

    public boolean removeFromCart() {
        List<WebElement> removeButtons = _driver.findElements(backpackRemoveFromCart);
        if(ElementActions.AreDisplayed(removeButtons))
        {
            if(ElementActions.IsEnabled(_driver.findElement(backpackRemoveFromCart))) {
                return false;
            }
        }
        else
        {
            ElementActions.Click(_driver.findElement(backpackAddToCart));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(ElementActions.IsEnabled(_driver.findElement(backpackRemoveFromCart))) {
                return false;
            }
        }
        return true;
    }

}
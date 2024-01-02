package com.saucedemo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.saucedemo.utilities.ElementActions;

public class HomePage {
    
    private WebDriver driver;
    private ElementActions elementActions;

    public HomePage(WebDriver driver, ElementActions elementActions) {
        this.driver = driver;
        this.elementActions = elementActions;
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
        return driver.findElement(swagLabsIcon).isDisplayed();
    }

    public void addToCart() {
        if(!isHomePageLaunched()) {
            return;
        }
        elementActions.click(driver.findElement(backpackAddToCart));
        elementActions.click(driver.findElement(boltTShirtAddToCart));
        elementActions.click(driver.findElement(fleeceJacketAddToCart));
       
    }

    public void completeShopping() {
        elementActions.click(driver.findElement(shoppingCart));
    }

    public boolean removeFromCart() {
        List<WebElement> removeButtons = driver.findElements(backpackRemoveFromCart);
        if(elementActions.areDisplayed(removeButtons))
        {
            if(elementActions.isEnabled(driver.findElement(backpackRemoveFromCart))) {
                return false;
            }
        }
        else
        {
            elementActions.click(driver.findElement(backpackAddToCart));
            if(elementActions.isEnabled(driver.findElement(backpackRemoveFromCart))) {
                return false;
            }
        }
        return true;
    }

}
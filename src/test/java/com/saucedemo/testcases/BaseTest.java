package com.saucedemo.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    private WebDriver _driver;

    public BaseTest() {
        _driver = null;
    }

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        _driver = new ChromeDriver();
        _driver.get("https://www.saucedemo.com/");
        _driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test
    public void testBaseScenario(){

        WebElement username = _driver.findElement(By.id("user-name"));
        WebElement password = _driver.findElement(By.id("password"));
        WebElement loginButton = _driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        List<WebElement> swagLabsIcon = _driver.findElements(By.className("app_logo"));
        if(swagLabsIcon.size() > 0) {
            WebElement backpackAddToCart = _driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            WebElement boltTShirtAddToCart = _driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
            WebElement fleeceJacketAddToCart = _driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
            WebElement onesieAddToCart = _driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
            WebElement tShirtRedAddToCart = _driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));    
            WebElement bikeLightAddToCart = _driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
            WebElement shoppingCart = _driver.findElement(By.className("shopping_cart_link"));
            
            
            backpackAddToCart.click();
            boltTShirtAddToCart.click();
            fleeceJacketAddToCart.click();

            shoppingCart.click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            WebElement checkoutButton = _driver.findElement(By.id("checkout"));
            checkoutButton.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            WebElement firstName = _driver.findElement(By.id("first-name"));
            WebElement lastName = _driver.findElement(By.id("last-name"));
            WebElement postalCode = _driver.findElement(By.id("postal-code"));
            WebElement continueButton = _driver.findElement(By.id("continue"));

            firstName.sendKeys("Ravi");
            lastName.sendKeys("Kumar");
            postalCode.sendKeys("560037");
            continueButton.click();

            WebElement finishButton = _driver.findElement(By.id("finish"));
            finishButton.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            WebElement verifyOrderSuccessful = _driver.findElement(By.className("complete-header"));
            if(verifyOrderSuccessful.getText().equals("THANK YOU FOR YOUR ORDER")) {
                System.out.println("Order placed successfully");
            } else {
                System.out.println("Order not placed successfully");
            }

            WebElement backHomeButton = _driver.findElement(By.id("back-to-products"));
            backHomeButton.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            WebElement menuButton = _driver.findElement(By.id("react-burger-menu-btn"));
            WebElement logoutButton = _driver.findElement(By.id("logout_sidebar_link"));

            menuButton.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            logoutButton.click();

            WebElement verifyLogoutSuccessful = _driver.findElement(By.className("login_logo"));
            if(verifyLogoutSuccessful.isDisplayed()) {
                System.out.println("Logout successful");
            } else {
                System.out.println("Logout not successful");
            }

        }
    }

    @AfterClass
    public void tearDown() {
        _driver.quit();
    }

}

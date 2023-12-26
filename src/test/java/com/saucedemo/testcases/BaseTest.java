package com.saucedemo.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.LogoutPage;
import com.saucedemo.pages.OrderVerificationPage;
import com.saucedemo.pages.PaymentsPage;
import com.saucedemo.pages.UserDetailsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver _driver;
	LoginPage loginPage;
	HomePage homePage;
	CheckoutPage checkoutPage;
	UserDetailsPage userDetailsPage;
	PaymentsPage paymentsPage;
	OrderVerificationPage orderVerificationPage;
	LogoutPage logoutPage;

    @BeforeSuite
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        _driver = new ChromeDriver();
        _driver.get("https://www.saucedemo.com/");
        _driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    @Test
    public void testBaseScenario(){

        loginPage = new LoginPage(_driver);
        if(loginPage.isLoginPageLaunched()) {
            loginPage.login("standard_user", "secret_sauce");

            homePage = new HomePage(_driver);
            if(homePage.isHomePageLaunched()) {
                homePage.addToCart();
                homePage.completeShopping();

                checkoutPage = new CheckoutPage(_driver);
                checkoutPage.checkout();

                userDetailsPage = new UserDetailsPage(_driver);
                userDetailsPage.enterUserDetails("John", "Doe", "123456");

                paymentsPage = new PaymentsPage(_driver);
                paymentsPage.finishOrder();

                orderVerificationPage = new OrderVerificationPage(_driver);
                if(orderVerificationPage.isOrderSuccessful()) {
                    orderVerificationPage.backHome();
                }

                logoutPage = new LogoutPage(_driver);
                logoutPage.logout();

            }
        }
    }

    @AfterSuite
    public void tearDown() {
        _driver.quit();
    }

}

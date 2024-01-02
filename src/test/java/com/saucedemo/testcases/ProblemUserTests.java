package com.saucedemo.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.LogoutPage;
import com.saucedemo.pages.OrderVerificationPage;
import com.saucedemo.pages.PaymentsPage;
import com.saucedemo.pages.UserDetailsPage;

public class ProblemUserTests extends BaseTest{
	LoginPage loginPage;
	HomePage homePage;
	CheckoutPage checkoutPage;
	UserDetailsPage userDetailsPage;
	PaymentsPage paymentsPage;
	OrderVerificationPage orderVerificationPage;
	LogoutPage logoutPage;

    @Test(priority=0, dataProvider = "data", dataProviderClass = com.saucedemo.utilities.ExcelUtility.class)
    public void loginPU(String username, String password) {
        loginPage = new LoginPage(_driver, elementActions);
        Assert.assertTrue(loginPage.isLoginPageLaunched());
        loginPage.login(username, password);
    }

    @Test(priority=1)
    public void testProblemUser(){
        
        homePage = new HomePage(_driver, elementActions);
        Assert.assertTrue(homePage.isHomePageLaunched());
        Assert.assertEquals(homePage.removeFromCart(), false);

    }

    @Test(priority=2)
    public void logout() {
        logoutPage = new LogoutPage(_driver, elementActions);
        logoutPage.logout();
    }
}

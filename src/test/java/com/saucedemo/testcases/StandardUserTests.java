package com.saucedemo.testcases;

import org.testng.annotations.Test;

import org.testng.Assert;
import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.LogoutPage;
import com.saucedemo.pages.OrderVerificationPage;
import com.saucedemo.pages.PaymentsPage;
import com.saucedemo.pages.UserDetailsPage;

public class StandardUserTests extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;
	CheckoutPage checkoutPage;
	UserDetailsPage userDetailsPage;
	PaymentsPage paymentsPage;
	OrderVerificationPage orderVerificationPage;
	LogoutPage logoutPage;

    @Test(priority=0, dataProvider = "data", dataProviderClass = com.saucedemo.utilities.ExcelUtility.class)
    public void loginSU(String userName, String password, String FirstName, String LastName, String ZipCode) {
        loggerUtil.startTestCase(this.getClass().getSimpleName());
        loginPage = new LoginPage(driver, elementActions);
        Assert.assertTrue(loginPage.isLoginPageLaunched());
        loginPage.login(userName, password);
        
    }

    @Test(priority=1, dataProvider = "data", dataProviderClass = com.saucedemo.utilities.ExcelUtility.class)
    public void testStandardUser(String userName, String password, String FirstName, String LastName, String ZipCode){
        
        homePage = new HomePage(driver, elementActions);
        Assert.assertTrue(homePage.isHomePageLaunched());
        homePage.addToCart();
        homePage.completeShopping();

        checkoutPage = new CheckoutPage(driver, elementActions);
        checkoutPage.checkout();

        userDetailsPage = new UserDetailsPage(driver, elementActions);
        userDetailsPage.enterUserDetails(FirstName, LastName, ZipCode);

        paymentsPage = new PaymentsPage(driver, elementActions);
        paymentsPage.finishOrder();

        orderVerificationPage = new OrderVerificationPage(driver, elementActions);
        Assert.assertTrue(orderVerificationPage.isOrderSuccessful());
        orderVerificationPage.backHome();

    }

    @Test(priority=2)
    public void logout() {
        logoutPage = new LogoutPage(driver, elementActions);
        logoutPage.logout();
        loggerUtil.endTestCase(this.getClass().getSimpleName());
    }


}

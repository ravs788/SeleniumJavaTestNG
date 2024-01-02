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
        _loggerUtil.startTestCase(this.getClass().getSimpleName());
        loginPage = new LoginPage(_driver, elementActions);
        Assert.assertTrue(loginPage.isLoginPageLaunched());
        loginPage.login(userName, password);
        
    }

    @Test(priority=1, dataProvider = "data", dataProviderClass = com.saucedemo.utilities.ExcelUtility.class)
    public void testStandardUser(String userName, String password, String FirstName, String LastName, String ZipCode){
        
        homePage = new HomePage(_driver, elementActions);
        Assert.assertTrue(homePage.isHomePageLaunched());
        homePage.addToCart();
        homePage.completeShopping();

        checkoutPage = new CheckoutPage(_driver, elementActions);
        checkoutPage.checkout();

        userDetailsPage = new UserDetailsPage(_driver, elementActions);
        userDetailsPage.enterUserDetails(FirstName, LastName, ZipCode);

        paymentsPage = new PaymentsPage(_driver, elementActions);
        paymentsPage.finishOrder();

        orderVerificationPage = new OrderVerificationPage(_driver, elementActions);
        Assert.assertTrue(orderVerificationPage.isOrderSuccessful());
        orderVerificationPage.backHome();

    }

    @Test(priority=2)
    public void logout() {
        logoutPage = new LogoutPage(_driver, elementActions);
        logoutPage.logout();
        _loggerUtil.endTestCase(this.getClass().getSimpleName());
    }


}

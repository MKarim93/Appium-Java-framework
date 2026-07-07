package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.basetest.BaseTest;
import com.pages.CheckoutPage;
import com.pages.LoginPage;
import com.pages.ProductsPage;
import com.pages.ShoppingCartPage;
import com.utility.Gestures;

public class EndToEnd extends BaseTest {

	@Test(priority = 1)
	public void endToEndTest() {

		LoginPage loginPage = new LoginPage(driver);

		ProductsPage productPage = new ProductsPage(driver);
		Gestures gestures = new Gestures(driver);
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginBtn();

		productPage.clickProduct("Sauce Labs Backpack");
		gestures.scrollIntoView("new UiSelector().description(\"test-ADD TO CART\")").click();
		productPage.clickShoppingCartBtn();

		shoppingCartPage.clickCheckoutBtn();

		checkoutPage.sendFirstName("testFirstName");
		checkoutPage.sendLastName("testLastName");
		checkoutPage.sendPostalCode("1234");
		checkoutPage.clickContinueBtn();

		gestures.scrollIntoView("new UiSelector().description(\"test-FINISH\")").click();

		Assert.assertTrue(checkoutPage.completeTxtPresent());

	}

}

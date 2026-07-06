package com.testcases;

import org.testng.annotations.Test;

import com.basetest.BaseTest;
import com.pages.LoginPage;

public class EndToEnd extends BaseTest {

	@Test
	public void loginTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginBtn();
	}

}

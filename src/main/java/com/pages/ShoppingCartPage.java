package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ShoppingCartPage {

	private AndroidDriver driver;

	public ShoppingCartPage(AndroidDriver driver) {
		
		this.driver = driver;
	}

	private final By removeBtn = AppiumBy.accessibilityId("test-REMOVE");
	private final By checkoutBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"CHECKOUT\")");

	public void clickCheckoutBtn() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn)).click();
	}

}

package com.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductsPage {
	
	private AndroidDriver driver;
	
	public ProductsPage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	private final By productsTxt = AppiumBy.androidUIAutomator("new UiSelector().text('PRODUCTS')");
	private final By productItems = AppiumBy.androidUIAutomator("new UiSelector().description('test-Item')");

}

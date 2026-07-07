package com.utility;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Gestures {
	
	private AndroidDriver driver;
	
	public Gestures(AndroidDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement scrollIntoView(String uiSelector) {
	    return driver.findElement(AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector().scrollable(true))" +
	            ".scrollIntoView(" + uiSelector + ")"));
	}

}

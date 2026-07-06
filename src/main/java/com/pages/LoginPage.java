package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	
	private AndroidDriver driver;
	
	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
	}
	
	private final By usernameTxtBox = AppiumBy.accessibilityId("test-Username");
	private final By passwordTxtBox = AppiumBy.accessibilityId("test-Password");
	private final By loginBtn = AppiumBy.accessibilityId("test-LOGIN");
	private final By usernameRequiredMessage = AppiumBy.xpath("//*[@text = \"Username is required\"]");
	
	public void enterUsername(String username) {
		driver.findElement(usernameTxtBox).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTxtBox).sendKeys(password);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	
	public String getUsernameRequiredMessage() {
		return driver.findElement(usernameRequiredMessage).getText();
	}

}

package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class CheckoutPage {
	
	private AndroidDriver driver;
	
	public CheckoutPage(AndroidDriver driver) {
		
		this.driver = driver;
	}
	
	private final By firstNameTxtBox = AppiumBy.accessibilityId("test-First Name");
	private final By lastNameTxtBox = AppiumBy.accessibilityId("test-Last Name");
	private final By postalCodeTxtBox = AppiumBy.accessibilityId("test-Zip/Postal Code");
	private final By cancelBtn = AppiumBy.accessibilityId("test-CANCEL");
	private final By continueBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"CONTINUE\")");
	private final By finishBtn = AppiumBy.accessibilityId("test-FINISH");
	private final By completeTxt = AppiumBy.androidUIAutomator("new UiSelector().text(\"CHECKOUT: COMPLETE!\")");
	private final By backHomeBtn = AppiumBy.accessibilityId("test-BACK HOME");
	
	public void sendFirstName(String firstName) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameTxtBox))
	        .sendKeys(firstName);
		
		//driver.findElement(firstNameTxtBox).sendKeys(firstName);
	}
	
	public void sendLastName(String lastName) {
		
		driver.findElement(lastNameTxtBox).sendKeys(lastName);
	}
	
	public void sendPostalCode(String postalCode) {
		
		driver.findElement(postalCodeTxtBox).sendKeys(postalCode);
	}
	
	public void clickContinueBtn() {
		
		driver.findElement(continueBtn).click();
	}
	
	public void clickCancelBtn() {
		
		driver.findElement(cancelBtn).click();
	}
	
	public void clickFinishBtn() {
		
		driver.findElement(finishBtn).click();
	}
	
	public boolean completeTxtPresent() {
		
		return driver.findElement(completeTxt).isDisplayed();
	}
	
	public void clickBackHomeBtn() {
		
		driver.findElement(backHomeBtn).click();
	}

}



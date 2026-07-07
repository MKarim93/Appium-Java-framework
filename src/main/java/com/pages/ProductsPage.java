package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductsPage {

	private AndroidDriver driver;

	public ProductsPage(AndroidDriver driver) {
		this.driver = driver;
	}

	private final By productsTxt = AppiumBy.androidUIAutomator("new UiSelector().text(\"PRODUCTS\")");
	private final By productItems = AppiumBy.androidUIAutomator("new UiSelector().description(\"test-Item\")");
	private final By shoppingCartBtn = AppiumBy.xpath("//*[@content-desc=\"test-Cart\"]");
	private final By addtoCartBtn = AppiumBy.androidUIAutomator("new UiSelector().text(\"ADD TO CART\")");

	public void clickProduct(String productName) {

		List<WebElement> products = driver.findElements(productItems);

		for (WebElement product : products) {

			String name = product.getText();

			if (name.equals(productName)) {

				product.click();

				break;
			}

		}
	}
	
	public void clickShoppingCartBtn() {
		
		driver.findElement(shoppingCartBtn).click();
		
	}

}

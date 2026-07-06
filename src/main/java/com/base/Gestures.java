package com.base;

import java.net.URI;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.ConfigReader;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Gestures {

	public static void main(String[] args) {

		try {

			String appiumUrl = ConfigReader.get("appium.url");

			String appPath = System.getProperty("user.dir") + "/" + ConfigReader.get("app.path");

			UiAutomator2Options options = new UiAutomator2Options()
					.setPlatformName(ConfigReader.get("platformName"))
					.setPlatformVersion(ConfigReader.get("platformVersion"))
					.setDeviceName(ConfigReader.get("deviceName")).setAutomationName(ConfigReader.get("automationName"))
					.setApp(appPath).setAppWaitActivity("*").setAutoGrantPermissions(true);

			if (Boolean.parseBoolean(ConfigReader.get("noReset"))) {
				options.noReset();
			}

			AndroidDriver driver = new AndroidDriver(new URI(appiumUrl).toURL(), options);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			WebElement swagLabsLoginBtn = wait
					.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("test-LOGIN")));

//			Point d = swagLabsLoginBtn.getLocation();
//			int startX = (int) (d.getX());
//			int startY = (int) (d.getY());
//
//			System.out.println("X coordinate is " + startX);
//			System.out.println("Y coordinate is " + startY);
//
//			Dimension d1 = swagLabsLoginBtn.getSize();
//
//			System.out.println("Button Height: " + d1.height);
//			System.out.println("Button Width: " + d1.width);
//			int h1 = (int) (d1.getHeight() * 0.5);
//			int w1 = (int) (d1.getWidth() * 0.5);
//
//			System.out.println("Half of Button Height: " + h1);
//			System.out.println("Half of Button Width: " + w1);
			
			int startX = swagLabsLoginBtn.getRect().getX();
			int startY = swagLabsLoginBtn.getRect().getY();
			
			int height = swagLabsLoginBtn.getRect().getHeight();
			int width = swagLabsLoginBtn.getRect().getWidth();
			
			int h1 = (int) (height * 0.5);
			int w1 = (int) (width * 0.5);

			int centerX = startX + w1;
			int centerY = startY + h1;

			System.out.println("X center coordinate " + centerX);
			System.out.println("Y center coordinate " + centerY);

			driver.quit();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

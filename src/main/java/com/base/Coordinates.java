package com.base;

import java.net.URI;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.ConfigReader;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Coordinates {

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

			Dimension d = driver.manage().window().getSize();
			int startX = (int) (d.getHeight() * 0.5);
			int startY = (int) (d.getWidth() * 0.5);
			int endX = startX;
			int endY = (int) (d.getHeight() * 0.2);
			
			PointerInput swipeUp = new PointerInput(PointerInput.Kind.TOUCH, "swipeUp");
			Sequence sequence = new Sequence(swipeUp, 1);
			sequence.addAction(swipeUp.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 0,startY));

			driver.quit();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}

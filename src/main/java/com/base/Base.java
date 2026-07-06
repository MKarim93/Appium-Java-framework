package com.base;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Base {

	Properties prop = new Properties();

	protected AndroidDriver driver;

	public void launchApp() {
		try {
			prop = new Properties();

			InputStream input = Files
					.newInputStream(Paths.get(System.getProperty("user.dir"), "config", "config.properties"));

			prop.load(input);

			String appiumUrl = prop.getProperty("appium.url");
			String appPath = System.getProperty("user.dir") + "/" + prop.getProperty("app.path");

			UiAutomator2Options options = new UiAutomator2Options()
					.setPlatformName(prop.getProperty("platformName"))
	                .setPlatformVersion(prop.getProperty("platformVersion"))
	                .setDeviceName(prop.getProperty("deviceName"))
	                .setAutomationName(prop.getProperty("automationName"))
	                .setApp(appPath)
	                //.setAppPackage(prop.getProperty("appPackage"))
	                //.setAppActivity(prop.getProperty("appActivity"))
	                .setAppWaitActivity("*")
	                .setAppWaitDuration(Duration.ofSeconds(30))
	                .setNoReset(Boolean.parseBoolean(prop.getProperty("noReset")));

			driver = new AndroidDriver(new URI(appiumUrl).toURL(), options);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("App failed to launch. Driver was not created.", e);
		}
	}

	public void closeApp() {
		if (driver != null) {
			driver.quit();
		}
	}

}

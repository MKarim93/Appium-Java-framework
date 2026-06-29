package basics;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidLaunchCordinate {

	public static void main(String[] args) {

		try {

			String appiumUrl = ConfigReader.get("appium.url");

			String appPath = System.getProperty("user.dir") + "/" + ConfigReader.get("app.path");

			UiAutomator2Options options = new UiAutomator2Options()

					.setApp(appPath)

					.setPlatformName(ConfigReader.get("platformName"))

					.setPlatformVersion(ConfigReader.get("platformVersion"))

					.setDeviceName(ConfigReader.get("deviceName"))

					.setAutomationName(ConfigReader.get("automationName"))

					.setAppPackage(ConfigReader.get("appPackage"))

					.setAppActivity(ConfigReader.get("appActivity"));

			if (Boolean.parseBoolean(ConfigReader.get("noReset"))) {

				options.noReset();
			}

			AndroidDriver driver = new AndroidDriver(new URI(appiumUrl).toURL(), options);

			Thread.sleep(5000);
			
			Point p = driver.manage().window().getPosition();
			System.out.println(p.getX());
			System.out.println(p.getY());
			
			Dimension d = driver.manage().window().getSize();
			System.out.println(d.getHeight());
			System.out.println(d.getWidth());
			
			System.out.println(d.getHeight() * 0.5);
			System.out.println(d.getWidth() * 0.5);

			driver.quit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}

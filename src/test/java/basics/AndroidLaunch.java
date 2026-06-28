package basics;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidLaunch {

	public static void main(String[] args) {

		try {

			Properties prop = new Properties();

			try (InputStream input = Files
					.newInputStream(Paths.get(System.getProperty("user.dir"), "config", "config.properties"))) {

				prop.load(input);
			}

			String appiumUrl = prop.getProperty("appium.url");

			String appPath = System.getProperty("user.dir") + "/" + prop.getProperty("app.path");

			UiAutomator2Options options = new UiAutomator2Options().setApp(appPath);

			AndroidDriver driver = new AndroidDriver(

					new URI(appiumUrl).toURL(), options);

			Thread.sleep(5000);
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

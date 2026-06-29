package config;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop = new Properties();

	static {

		try (InputStream input = Files
				.newInputStream(Paths.get(System.getProperty("user.dir"), "config", "config.properties"))) {
			prop.load(input);
		} catch (Exception e) {

			throw new RuntimeException("Unable to load config.properties", e);
		}
	}

	public static String get(String key) {
		return prop.getProperty(key);
	}

}

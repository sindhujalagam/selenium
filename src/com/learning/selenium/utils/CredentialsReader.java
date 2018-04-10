package com.learning.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Sindhuja
 *
 */

public class CredentialsReader {

	public static String getUsername() {
		return getValue("username");
	}

	public static String getPassword() {
		return getValue("password");
	}

	public static String getUrl() {
		return getValue("url");
	}

	public static String getValue(String key) {
		return getPropertiesFile().getProperty(key);
	}

	private static Properties getPropertiesFile() {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("config/credentials.properties"));
			return prop;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}

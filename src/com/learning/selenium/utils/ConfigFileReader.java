package com.learning.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Sindhuja
 *
 */

public class ConfigFileReader {

	public static String getValue(String key, String fileName) {
		return getPropertiesFile(fileName).getProperty(key);
	}

	private static Properties getPropertiesFile(String fileName) {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("config/" + fileName + ".properties"));
			return prop;
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}

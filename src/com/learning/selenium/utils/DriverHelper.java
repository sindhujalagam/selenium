package com.learning.selenium.utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.learning.selenium.utils.OsCheck.OSType;

public class DriverHelper {

/**
 * @author Sindhuja
 *
 */

	public WebDriver openBrowser() {
		return new ChromeDriver(chromeDriverSetup());
	}

	private String getDriverLocation() {
		OSType os = OsCheck.getOperatingSystemType();
		String driverLocation = null;
		switch (os) {
		case Windows:
			driverLocation = new File("driver/windows/chromedriver.exe").getAbsolutePath();
			break;

		case Linux:
			driverLocation = new File("./driver/linux/chromedriver").getAbsolutePath();
			break;

		case MacOS:
			driverLocation = new File("./driver/mac/chromedriver").getAbsolutePath();
			break;

		default:
			System.out.println("unable to determine OS");
			break;
		}
		return driverLocation;
	}

	private ChromeOptions chromeDriverSetup() {
		System.setProperty("webdriver.chrome.driver", getDriverLocation());

		// To remove message
		// "You are using an unsupported command-line flag: --ignore-certificate-errors.
		// Stability and security will suffer."
		// Add an argument 'test-type'
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-extensions");
		chromeOptions.addArguments("test-type");
		chromeOptions.setCapability("chrome.binary", getDriverLocation());
		return chromeOptions;
	}
}

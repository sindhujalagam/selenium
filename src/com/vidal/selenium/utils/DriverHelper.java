package com.vidal.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverHelper {

/**
 * @author Sindhuja
 *
 */

	public WebDriver openBrowser() {
		return new ChromeDriver(chromeDriverSetup());
	}

	private DesiredCapabilities chromeDriverSetup() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

		// To remove message
		// "You are using an unsupported command-line flag: --ignore-certificate-errors.
		// Stability and security will suffer."
		// Add an argument 'test-type'
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-extensions");
		chromeOptions.addArguments("test-type");
		capabilities.setCapability("chrome.binary", "./driver/chromedriver");
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		return capabilities;
	}
}

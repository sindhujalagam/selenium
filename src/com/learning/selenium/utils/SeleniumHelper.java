package com.learning.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sindhuja
 *
 */

public class SeleniumHelper {

	private final static int MAX_WAIT_TIMEOUT = 120;

	public static void click(WebDriver driver, By locator) {
		waitForElementToBeVisible(driver, locator);
		waitForElementToBeClickable(driver, locator);
		System.out.println("Clicking on element: " + locator.toString());
		driver.findElement(locator).click();
	}

	public static void enterInput(WebDriver driver, By locator, String inputValue) {
		waitForElementToBeVisible(driver, locator);
		System.out.println("Entering text: " + inputValue + " in element: " + locator.toString());
		driver.findElement(locator).sendKeys(inputValue);
	}

	public static void waitForElementToBeVisible(WebDriver driver, By locator) {
		System.out.println("Waiting for the element: " + locator.toString() + " to be visible");
		WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void waitForElementToBeClickable(WebDriver driver, By locator) {
		System.out.println("Waiting for the element: " + locator.toString() + " to be clickable");
		WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}

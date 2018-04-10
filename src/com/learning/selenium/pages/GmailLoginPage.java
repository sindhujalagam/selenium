package com.learning.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learning.selenium.utils.SeleniumHelper;

/**
 * @author Sindhuja
 *
 */

public class GmailLoginPage extends SeleniumHelper {

	private By emailFieldXPath = By.xpath("//input[@type='email']");
	private By nextButtonXPath = By.xpath("//span[contains(text(),'Next')]");
	private By passwordPageusernameId = By.id("profileIdentifier");
	private By passwordFieldXPath = By.xpath("//input[@type='password']");
	private By inboxXPath = By.xpath("//a[contains(@title,'Inbox')]");

	public void enterUsername(WebDriver driver, String username) {
		SeleniumHelper.enterInput(driver, emailFieldXPath, username);
	}

	public void enterPassword(WebDriver driver, String password) {
		waitForElementToBeVisible(driver, passwordPageusernameId);
		SeleniumHelper.enterInput(driver, passwordFieldXPath, password);
	}

	public void waitForLoadingComplete(WebDriver driver) {
	}

	public void searchForUser(WebDriver driver, String username) {
		driver.findElement(By.xpath("//input[contains(@id,'" + username + "')]")).click();
	}

	public void clickNextButton(WebDriver driver) {
		SeleniumHelper.click(driver, nextButtonXPath);
	}

	public String getInboxCount(WebDriver driver) {
		waitForElementToBeVisible(driver, inboxXPath);
		return driver.findElement(inboxXPath).getText();
	}
}

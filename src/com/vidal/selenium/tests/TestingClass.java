package com.vidal.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vidal.selenium.pages.GmailLoginPage;
import com.vidal.selenium.utils.CredentialsReader;
import com.vidal.selenium.utils.DriverHelper;

/**
 * @author Sindhuja
 *
 */

public class TestingClass extends DriverHelper {

	WebDriver driver = null;
	GmailLoginPage glp = new GmailLoginPage();

	@BeforeTest
	public void launchBrowser() {
		System.out.println("opening browser");
		driver  = openBrowser();
		System.out.println("opened browser");
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("closing browser");
		driver.close();
		System.out.println("closed browser");
	}

	@Test
	public void loginToGmail() {
		driver.get(CredentialsReader.getUrl());

		glp.enterUsername(driver, CredentialsReader.getUsername());
		glp.clickNextButton(driver);
		glp.enterPassword(driver, CredentialsReader.getPassword());
		glp.clickNextButton(driver);
		glp.waitForLoadingComplete(driver);
		String inboxCount = glp.getInboxCount(driver);
		System.out.println("inbox count is: " + inboxCount);
		Assert.assertNotNull(inboxCount, "could not get inbox count");
	}

	@Test
	public void getUsername() {
		System.out.println("username is: " + CredentialsReader.getUsername());
	}

	@Test
	public void getPassword() {
		System.out.println("password is: " + CredentialsReader.getPassword());
	}

	@Test
	public void getUrl() {
		System.out.println("url is: " + CredentialsReader.getUrl());
		driver.get(CredentialsReader.getUrl());
	}

	@Test
	public void openGmail() {
		System.out.println("opening gmail");
		driver.get(CredentialsReader.getUrl());
		System.out.println("gmail opened");
	}

	@Test
	public void verifyUsername() {
		String returnString = CredentialsReader.getUsername();
		System.out.println("returnString is: " + returnString);
		Assert.assertEquals(returnString, "test@gmail.com");
	}
}

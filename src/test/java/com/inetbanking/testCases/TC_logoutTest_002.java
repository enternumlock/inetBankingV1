package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LogoutPage;

public class TC_logoutTest_002 extends BaseClass {

	@Test
	public void logoutTest() throws InterruptedException, IOException {

		driver.get(baseURL);
		logger.info("URL Opened");

		LogoutPage lo = new LogoutPage(driver);

		lo.setUserName(username);
		logger.info("Entered username");
		lo.setPassword(password);
		logger.info("Entered password");
		lo.clickLoginBtn();
		logger.info("login btn clicked");
		lo.clickLogoutBtn();
		logger.info("logout btn clicked");

		Thread.sleep(5000);

		driver.switchTo().alert().accept(); // for OK alert window
		
		Thread.sleep(5000);
		
		System.out.println(driver.getTitle());

		if (driver.getTitle().equals("GTPL Bank Home Page")) {
			AssertJUnit.assertTrue(true);
			logger.info("Logout test passed");
		} else {
			// capture the screen shot of failed case
			captureScreen(driver, "logoutTest");
			AssertJUnit.assertTrue(false);
			logger.info("Logout Test Failed");
		}

	}

}

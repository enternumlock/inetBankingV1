package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.LogoutPage;

@Test
public class TC_LoginTest_001 extends BaseClass {
	
	//TC_LoginTest_001 only contain test methods
	
	// setUp() will execute first from BaseClass
	@Test
	public void loginTest() throws IOException {
		// getting the URL from BaseClass
		//driver.get(baseURL);
		logger.info("URL is opened"); // logger object
		
		//creating object from LoginPage class and call driver
		LoginPage lp = new LoginPage(driver);
		
		// call methods from LoginPage class
		lp.setUserName(username); //username from BaseClass
		logger.info("Entered Username");
		lp.setPassword(password); // password from BaseClass
		logger.info("Entered Password");
		lp.clickLoginBtn(); // clicks the login button
		logger.info("Login Button Clicked");
		
		// System.out.println(driver.getTitle());
		// we will check that we get the home title
		// after successful login
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			AssertJUnit.assertTrue(true);
			logger.info("Login test passed");
		}else {
			// capture the screen shot of failed case
			captureScreen(driver, "login Test"); 
			// test case fails
			AssertJUnit.assertTrue(false);
			logger.info("Login Test Failed");
		}
		
		
	}
	
	// tearDown() will execute last

}

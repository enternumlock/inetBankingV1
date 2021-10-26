package com.inetbanking.testCases;

import java.io.IOException;

//import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_004  extends BaseClass{
	
	@Test
	public void AddNewCustomer() throws InterruptedException, IOException {
		// First, we have to login to application, therefore we will create object of LoginPage class
		
		// So we will use TC_LoginTest_001 class to login
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickLoginBtn();
		logger.info("login sucessfull...");
		
		Thread.sleep(3000);
		
		// second, create object of AddNewCustomerPage class
		
		AddCustomerPage Addcust = new AddCustomerPage(driver);
		
		Addcust.clickLinkAddNewCustomer();
		logger.info("Add new Customer link clikcked...");
		
		Addcust.custName("Pavan");
		logger.info("Customer name entered");
		Addcust.custGender("male");
		logger.info("Gender entered");
		Addcust.custdob("10", "21", "1985");
		logger.info("DOB entered");
		
		Thread.sleep(3000);
		
		Addcust.custAddress("INDIA");
		logger.info("address entered");
		Addcust.custCity("HYD");
		logger.info("city entered");
		Addcust.custState("AP");
		logger.info("State entered");
		Addcust.custPinNum("1234567");
		logger.info("Pin number entered");
		Addcust.custTeleNumber("987890091");
		logger.info("Phone number entered");
		
		// for unique email address, generate random email address
		String email = randomString() + "gmail.com";
		Addcust.custEmail(email);
		logger.info("email entered.");
		
		// click submit button
		Addcust.custSubmitBtn();
		logger.info("submit button clicked....");
		
		Thread.sleep(3000);
		
		// now we will do the validation
		logger.info("validation started....");
		
		//boolean res = driver.getPageSource().contains("Customer Registered Successfully!!");
		//logger.info("validation ends.");
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Customer Registered Successfully!!")) {
			Assert.assertTrue(true); //passed TC
			logger.info("Test Passed...");
		}else {
			logger.info("Test case Failed..");
			captureScreen(driver, "AddNewCustomer"); // take screen shot of fail test case
			Assert.assertTrue(false); // fail TC
			//captureScreen(driver, "AddNewCustomer");
		}
	}
	
	/* These methods are moved to BaseClass
	 * create method that generates random string
	public String randomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8); // 8 characters
		return generatedstring;
	}
	
	// Create method to generate random number
	public static String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4); // 4 characters
		return generatedString2;
	}
	*/

}

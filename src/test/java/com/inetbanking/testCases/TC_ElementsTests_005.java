package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LogoPage;

public class TC_ElementsTests_005 extends BaseClass {

	//LogoPage logo = new LogoPage(driver);
	
	@Test
	public void TC_logoText() throws IOException {
		
		driver.get(baseURL);
		logger.info("URL is opened"); // logger object
		LogoPage logo = new LogoPage(driver);
		
		String act = logo.setLogo();
		System.out.println(act);
		
		String expectedTxt = "Demo Site";
		logger.info("expectedTxt");
		
		//String actualText =driver.findElement(By.xpath("//*[@id=\'site-name\']/a")).getText();	
		logger.info("actualText");
		
		if(act.equals(expectedTxt)) {
			Assert.assertTrue(true);
			logger.info("Test Passed"); // logger object
		}else {
			// capture the screen shot of failed case
			logger.info("Test Failed"); // logger object
			captureScreen(driver, "Logo Test");
			Assert.assertTrue(false);
			//logger.info("Test Failed"); // logger object
		}			
	}
	
	@Test
	public void TC_HeaderText() throws IOException {
		
		driver.get(baseURL);
		logger.info("URL is opened"); // logger object
		LogoPage logo = new LogoPage(driver);
		String h1 = logo.setHeaderTxt();
		System.out.println(h1);
		
		String expTxt = "Gtpl Bank 12345";
		logger.info("expectedTxt");
		
		//String actualText =driver.findElement(By.xpath("//*[@id=\'site-name\']/a")).getText();	
		logger.info("actualText");
		
		if(h1.equals(expTxt)) {
			Assert.assertTrue(true);
			logger.info("Test Passed"); // logger object
		}else {
			// capture the screen shot of failed case
			logger.info("Test Failed"); // logger object
			captureScreen(driver, "Header Test");
			Assert.assertTrue(false);
			//logger.info("Test Failed"); // logger object
		}			
	}
}

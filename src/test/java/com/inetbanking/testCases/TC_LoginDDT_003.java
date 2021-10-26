package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_003 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {

		// login page object
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickLoginBtn();
		
		// paused for 3 seconds
		Thread.sleep(3000);
		
		// this is for fail login test case
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept(); //close the alert message box
			driver.switchTo().defaultContent(); // navigate to Home page
			Assert.assertTrue(false);
			logger.warn("Login Failed...");
		}else {
			// this is for Pass login test case
			Assert.assertTrue(true);
			logger.info("Login passed..");
			lp.clickLogout();
			// paused for 3 seconds
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // close logout alert message
			driver.switchTo().defaultContent(); // focus on login page
		}

	}

	//user defined method created to check alert message is present or not
	// we can also put that method in BaseClass too
	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	// this is data provider method
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		// read data from excel file and create two dimensional array
		// HOME DIR =>
		// C:\\Users\\khali\\EclipseWorkspace2021\\Workspace-1\\inetBankingV1\\
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginDatabase.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		// to get data from xsl file, i is rownum
		for (int i = 1; i <= rownum; i++) {
			// j= col number
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}

		}

		return logindata;

	}

}

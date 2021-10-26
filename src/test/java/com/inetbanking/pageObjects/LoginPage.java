package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver localDriver;
	
	public LoginPage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	// for user id
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	// for password
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	// for login button
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	// for login link
	@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
	@CacheLookup
	WebElement linkLogout;
	
	// now write action method
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLoginBtn() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		linkLogout.click();
	}
	

}

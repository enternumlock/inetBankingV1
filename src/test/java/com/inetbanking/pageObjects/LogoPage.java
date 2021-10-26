package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoPage {
	
	WebDriver localDriver;
	
	public LogoPage(WebDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}
	
	// for logo
	@FindBy(xpath ="//*[@id=\'site-name\']/a")
	WebElement logo;
	
	//for header
	@FindBy(xpath="//h2[contains(text(),'Gtpl Bank')]")
	WebElement headerTxt;
	
	// Action methods
	public String setLogo() {
		return logo.getText();
	}
	
	public String setHeaderTxt() {
		return headerTxt.getText();
	}
}

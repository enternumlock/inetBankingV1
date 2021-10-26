package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	// 1.create web driver variable
	WebDriver ldriver;

	// 2.create constructor

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// 3.identify all web element
	
	// for new customer link
	@CacheLookup
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;
	
	// for name field
	@CacheLookup
	@FindBy(how=How.NAME, using="name")
	WebElement txtCustomerName;
	
	//for gender field
	@CacheLookup
	@FindBy(how = How.NAME, using = "rad1")
	WebElement rdGender;
	
	//for age
	@CacheLookup
	@FindBy(how=How.NAME, using="dob")
	WebElement txtdob;

	//for address
	@CacheLookup
	@FindBy(how=How.NAME, using="addr")
	WebElement txtaddress;
	
	//for city
	@CacheLookup
	@FindBy(how=How.NAME, using="city")
	WebElement txtcity;
	
	//for state
	@CacheLookup
	@FindBy(how=How.NAME, using="state")
	WebElement txtstate;
	
	//for pin
	@CacheLookup
	@FindBy(how=How.NAME, using="pinno")
	WebElement txtpinno;
	
	//for Telephone number
	@CacheLookup
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement txttelephoneno;
	
	//for email
	@CacheLookup
	@FindBy(how=How.NAME, using="emailid")
	WebElement txtemailid;
	
	//for password
	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;
	
	// for submit button
	@CacheLookup
	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
	
	// Now Add Action methods
	public void clickLinkAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		rdGender.click();
	}
	
	public void custdob(String month,String day,String year) {
		txtdob.sendKeys(month);
		txtdob.sendKeys(day);
		txtdob.sendKeys(year);
	}
	
	public void custAddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	
	public void custCity(String city) {
		txtcity.sendKeys(city);
	}
	
	public void custState(String state) {
		txtstate.sendKeys(state);
	}
	
	public void custPinNum(String pin) {
		txtpinno.sendKeys(String.valueOf(pin));
	}
	
	public void custTeleNumber(String telephoneNum) {
		txttelephoneno.sendKeys(telephoneNum);
	}
	
	public void custEmail(String email) {
		txtemailid.sendKeys(email);
	}
	
	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custSubmitBtn() {
		btnSubmit.click();
	}
	
}

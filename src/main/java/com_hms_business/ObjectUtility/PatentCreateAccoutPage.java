package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_hms_generic.WebDriverUtility.WebdriverUtility;

public class PatentCreateAccoutPage {
	public WebDriver driver=null;
	public PatentCreateAccoutPage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="full_name")
	private WebElement fullNameTxt;
	
	@FindBy(name="address")
	private WebElement addressTxt;
	
	@FindBy(name="city")
	private WebElement cityTxt;
	
	@FindBy(xpath="//label[contains(text(),'Female')]")
	private WebElement femaleRadioBtn;

	@FindBy(xpath="//label[contains(text(),'Male')]")
	private WebElement maleRadioBtn;
	
	@FindBy(id="email")
	private WebElement emailTxt;
	
	@FindBy(id="password")
	private WebElement passwordTxt;
	
	@FindBy(id="password_again")
	private WebElement passwordAgainTxt;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	@FindBy(xpath="//label[contains(text(),'I agree')]")
	private WebElement iagreeCheckBox;
	
	@FindBy(xpath = "//span[.='All rights reserved']")
	private WebElement reserveHeader;
	
	public WebElement getReserveHeader() {
		return reserveHeader;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFullNameTxt() {
		return fullNameTxt;
	}

	public WebElement getAddressTxt() {
		return addressTxt;
	}

	public WebElement getCityTxt() {
		return cityTxt;
	}

	public WebElement getFemaleRadioBtn() {
		return femaleRadioBtn;
	}

	public WebElement getMaleRadioBtn() {
		return maleRadioBtn;
	}

	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getPasswordAgainTxt() {
		return passwordAgainTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getIagreeCheckBox() {
		return iagreeCheckBox;
	}
	
	public void createAccountTest(String name,String address,String city,String gender,String email,String password)
	{
		getFullNameTxt().sendKeys(name);
		getAddressTxt().sendKeys(address);
		getCityTxt().sendKeys(city);
		  if(gender.trim().contains("Male"))
			{
				getMaleRadioBtn().click();
			}
			else
			{
				getFemaleRadioBtn().click();
			}
		getEmailTxt().sendKeys(email);
		getPasswordTxt().sendKeys(password);
		getPasswordAgainTxt().sendKeys(password);
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.scrollToElementAction(driver, reserveHeader);
		getSubmitBtn().click();
	}
	
}

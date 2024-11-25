package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_hms_generic.WebDriverUtility.WebdriverUtility;

public class CreateDoctorPage {
	public WebDriver driver=null;
	public CreateDoctorPage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name ="Doctorspecialization")
	private WebElement specializationDropDown;
	
	@FindBy(name ="docname")
	private WebElement doctorTxt;
	
	@FindBy(name="clinicaddress")
	private WebElement addressTxt;
	
	@FindBy(name="docfees")
	private WebElement docFeesTxt;
	
	@FindBy(name="doccontact")
	private WebElement docContactNoTxt;
	
	@FindBy(id="docemail")
	private WebElement docEmailTxt;
	
	@FindBy(name="npass")
	private WebElement passwordTxt;
	
	@FindBy(name="cfpass")
	private WebElement confirmPasswordTxt;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	public WebElement getSpecializationDropDown() {
		return specializationDropDown;
	}

	public WebElement getDoctorTxt() {
		return doctorTxt;
	}

	public WebElement getAddressTxt() {
		return addressTxt;
	}

	public WebElement getDocFeesTxt() {
		return docFeesTxt;
	}

	public WebElement getDocContactNoTxt() {
		return docContactNoTxt;
	}

	public WebElement getDocEmailTxt() {
		return docEmailTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getConfirmPasswordTxt() {
		return confirmPasswordTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void createDoctorTest(String specialization,String docName,String address,String fees,String contactNo,String email,String password )
	{
		WebdriverUtility wlib=new WebdriverUtility();
		specializationDropDown.click();
		wlib.select(specializationDropDown, specialization);
		doctorTxt.sendKeys(docName);
		addressTxt.sendKeys(address);
		wlib.scrollToElementAction(driver, docEmailTxt);
		docFeesTxt.sendKeys(fees);
		docContactNoTxt.sendKeys(contactNo);
		docEmailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		confirmPasswordTxt.sendKeys(password);
		submitBtn.click();
		
	}
	
}

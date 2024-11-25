package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_hms_generic.WebDriverUtility.WebdriverUtility;

public class CreatePatientPage {
	public WebDriver driver=null;
	public CreatePatientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name ="patname")
	private WebElement patientNameTxt;
	
	@FindBy(name="patcontact")
	private WebElement patientContactnoTxt;
	
	@FindBy(xpath="//label[contains(text(),'Female')]")
	private WebElement femaleRadioBtn;

	@FindBy(xpath="//label[contains(text(),'Male')]")
	private WebElement maleRadioBtn;
	
	@FindBy(id="patemail")
	private WebElement emailTxt;
	
	@FindBy(name="pataddress")
	private WebElement addressTxt;
	
	@FindBy(name="patage")
	private WebElement ageTxt;
	
	@FindBy(name="medhis")
	private WebElement medicalTxtArea;
	
	@FindBy(id="submit")
	private WebElement submitBtn;
	
	public void addPatientPageTest(String pName,String contactNo,String email,String gender,String address,String age, String medicalHisory )
	{
		WebdriverUtility wlib=new WebdriverUtility();
		patientNameTxt.sendKeys(pName);
		patientContactnoTxt.sendKeys(contactNo);	
		emailTxt.sendKeys(email);
		wlib.scrollToElementAction(driver, submitBtn);
		if(gender.trim().contains("Male"))
		{
			maleRadioBtn.click();
		}
		else
		{
			femaleRadioBtn.click();
		}
		addressTxt.sendKeys(address);
		ageTxt.sendKeys(age);
		medicalTxtArea.sendKeys(medicalHisory);
		wlib.scrollByElement(driver, 0, 800);
		submitBtn.click();
		
	}
	
}

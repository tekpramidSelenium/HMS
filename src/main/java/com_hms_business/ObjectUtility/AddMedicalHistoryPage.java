package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_hms_generic.WebDriverUtility.WebdriverUtility;

public class AddMedicalHistoryPage {

	public WebDriver driver=null;
	public AddMedicalHistoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[.='Add Medical History']")
	private WebElement addMedicalhistoryBtn;
	
	@FindBy(name="bp")
	private WebElement bpTxt;
	
	@FindBy(name="bs")
	private WebElement bsTxt;
	
	@FindBy(name="weight")
	private WebElement wgTxt;
	
	@FindBy(name="temp")
	private WebElement tempTxt;
	
	@FindBy(name="pres")
	private WebElement prescriptionTxtArea;
	
	@FindBy(name="//button[.='Close']")
	private WebElement closeBtn;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	
	public WebElement getAddMedicalhistoryBtn() {
		return addMedicalhistoryBtn;
	}

	public WebElement getBpTxt() {
		return bpTxt;
	}

	public WebElement getBsTxt() {
		return bsTxt;
	}

	public WebElement getWgTxt() {
		return wgTxt;
	}

	public WebElement getTempTxt() {
		return tempTxt;
	}

	public WebElement getPrescriptionTxtArea() {
		return prescriptionTxtArea;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void addMedicalTest(String bp,String bs,String wg,String temp,String prescription)
	{
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.scrollToElementAction(driver, submitBtn);
		bpTxt.sendKeys(bp);
		bsTxt.sendKeys(bs);
		wgTxt.sendKeys(wg);
		tempTxt.sendKeys(temp);
		prescriptionTxtArea.sendKeys(prescription);
		submitBtn.click();
		
		
	}
	
	
}

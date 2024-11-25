package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientPage {

	public WebDriver driver=null;
	public ManagePatientPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[.='Asha123']/following-sibling::td[5]/a[1]")
	private WebElement editIcon;
	
	@FindBy(xpath = "//td[.='Asha123']/following-sibling::td[5]/a[2]")
	private WebElement eyeIcon;
	
	@FindBy(xpath = "//button[.='Add Medical History']")
	private WebElement addMedicalHistoryBtn;
	
	public WebElement getEditIcon() {
		return editIcon;
	}

	public WebElement getEyeIcon() {
		return eyeIcon;
	}

	public WebElement getAddMedicalHistoryBtn() {
		return addMedicalHistoryBtn;
	}
	
	
	
}

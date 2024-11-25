package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorHomePage {
	public WebDriver driver=null;
	public DoctorHomePage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//span[.=' Appointment History '] ")
	private WebElement appointmentHistoryLink;
	
	@FindBy(xpath = "//span[@class='username']")
	private WebElement profileDropdown;
	
	@FindBy(xpath = "//a[contains(.,'Log Out')]")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//span[.=' Patients ']")
	private WebElement patientsDropdown;
	
	@FindBy(xpath = "//span[.=' Add Patient']")
	private WebElement addPatientslink;
	
	@FindBy(xpath = "//span[.=' Manage Patient ']")
	private WebElement managePatientslink;
	
	
	public WebElement getappointmentHistoryLink() {
		return appointmentHistoryLink;
	}

	public WebElement getProfileDropdown() {
		return profileDropdown;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getPatientsDropdown() {
		return patientsDropdown;
	}

	public WebElement getAddPatientslink() {
		return addPatientslink;
	}

	public WebElement getManagePatientslink() {
		return managePatientslink;
	}

	public void logoutPageTest()
	{
		profileDropdown.click();
		logoutBtn.click();
	}
	
}

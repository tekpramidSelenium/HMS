package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientHomePage {
	public WebDriver driver=null;
	public PatientHomePage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//span[.=' Book Appointment ']")
	private WebElement bookAppointmentLink;
	
	@FindBy(xpath = "//span[@class='username']")
	private WebElement profileDropdown;
	
	@FindBy(xpath = "//a[contains(.,'Log Out')]")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement appointmentHistoryLink;
	
	@FindBy(xpath = "//span[.=' Medical History ']")
	private WebElement medicalHistoryLink;
	
	
	public WebElement getMedicalHistoryLink() {
		return medicalHistoryLink;
	}

	public WebElement getAppointmentHistoryLink() {
		return appointmentHistoryLink;
	}

	public WebElement getBookAppointmentLink() {
		return bookAppointmentLink;
	}

	public WebElement getProfileDropdown() {
		return profileDropdown;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public void logoutPageTest()
	{
		profileDropdown.click();
		logoutBtn.click();
	}
	
}

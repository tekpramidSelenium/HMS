package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage {
	public WebDriver driver=null;
	public AdminDashboardPage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[.='Admin | Dashboard']")
    private	WebElement adminDashboardTitle;
	
	@FindBy(xpath = "//span[.=' Doctors ']")
	private WebElement doctorsDropdown;
	
	@FindBy(xpath = "//span[.=' Add Doctor']")
	private WebElement addDoctorLink;
	
	@FindBy(xpath = "//span[.=' Manage Doctors ']")
	private WebElement manageDoctorsLink;
	
	@FindBy(xpath = "//span[@class='username']")
	private WebElement profileDropdown;
	
	@FindBy(xpath = "//a[contains(.,'Log Out')]")
	private WebElement logoutBtn;
	
	public WebElement getAdminDashboardTitle() {
		return adminDashboardTitle;
	}

	public WebElement getDoctorsDropdown() {
		return doctorsDropdown;
	}

	public WebElement getAddDoctorLink() {
		return addDoctorLink;
	}

	public WebElement getManageDoctorsLink() {
		return manageDoctorsLink;
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

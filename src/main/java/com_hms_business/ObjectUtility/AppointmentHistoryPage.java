package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentHistoryPage {
	public WebDriver driver=null;
	public AppointmentHistoryPage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//span[.=' Appointment History '] ")
	private WebElement appointmentHistoryLink;
	
	@FindBy(xpath = "//a[@title='Cancel Appointment']")
	private WebElement  actionLink;
	
	
	public WebElement getAppointmentHistoryLink() {
		return appointmentHistoryLink;
	}


	public WebElement getActionLink() {
		return actionLink;
	}
	
	
	
	
}

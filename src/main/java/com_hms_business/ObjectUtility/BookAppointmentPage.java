package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_hms_generic.WebDriverUtility.JavaUtility;
import com_hms_generic.WebDriverUtility.WebdriverUtility;

public class BookAppointmentPage {
	public WebDriver driver=null;
	public BookAppointmentPage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name ="Doctorspecialization")
	private WebElement specializationDropDown;
	
	@FindBy(name ="doctor")
	private WebElement doctorDropDown;
	
	@FindBy(name ="appdate")
	private WebElement dateTxt;
	
	@FindBy(id ="timepicker1")
	private WebElement timeTxt;
	
	@FindBy(xpath ="//input[@class='bootstrap-timepicker-hour form-control']")
	private WebElement timeHourTd;
	
	@FindBy(xpath ="//input[@class='bootstrap-timepicker-minute form-control']")
	private WebElement timeMinuteTd;
	
	@FindBy(xpath ="//input[@class='bootstrap-timepicker-meridian form-control']")
	private WebElement timeMeridianTd;
	
	@FindBy(name ="submit")
	private WebElement submitBtn;
	
	
	
	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getSpecializationDropDown() {
		return specializationDropDown;
	}

	public WebElement getDoctorDropDown() {
		return doctorDropDown;
	}

	public WebElement getDateTxt() {
		return dateTxt;
	}

	public WebElement getTimeTxt() {
		return timeTxt;
	}

	public WebElement getTimeHourTd() {
		return timeHourTd;
	}

	public WebElement getTimeMinuteTd() {
		return timeMinuteTd;
	}

	public WebElement getTimeMeridianTd() {
		return timeMeridianTd;
	}
	
	public void bookAppointmentPageTest(String specialization,String doctor,String time ) throws InterruptedException
	{   specializationDropDown.click();
	    JavaUtility jlib=new JavaUtility();
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.select(specializationDropDown, specialization);
		doctorDropDown.click();
		wlib.select(doctorDropDown, doctor);
		dateTxt.clear();
		dateTxt.sendKeys(jlib.getRequiredDateYYYYDDMM(3));
		timeTxt.clear();
		timeTxt.sendKeys(time);
//		Thread.sleep(3000);
//		wlib.scrollToElementAction(driver, submitBtn);
		submitBtn.click();
		
	}
	
	
}

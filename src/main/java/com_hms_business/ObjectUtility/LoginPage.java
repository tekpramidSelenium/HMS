package com_hms_business.ObjectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_hms_generic.WebDriverUtility.WebdriverUtility;

public class LoginPage {
	public WebdriverUtility wlib=new WebdriverUtility();
	 public WebDriver driver=null;
	public LoginPage(WebDriver driver)
	{this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h6[.='Doctors login']/following-sibling::a/button")
    private	WebElement doctorClickHereLink;
	
	@FindBy(xpath="//h6[.='Patient Login']/following-sibling::a/button")
	private	WebElement patientClickHereLink;
	
	@FindBy(xpath="//h6[.='Admin Login']/following-sibling::a/button")
	private WebElement adminClickHereLink;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement docUsernameTxt;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement docPasswordTxt;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
	private WebElement docForgotpassLink;
	
	@FindBy(name="submit")
	private WebElement docLoginBtn;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement patientUsernameTxt;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement patientPasswordTxt;
	
	@FindBy(name="submit")
	private WebElement patientLoginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
	private WebElement patientForgotpassLink;
	
	@FindBy(xpath = "//a[contains(text(),'Create an account')]")
	private WebElement patientCreateAccountLink;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement adminUsernameTxt;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement adminPasswordTxt;
	
	@FindBy(name="submit")
	private WebElement adminLoginBtn;
	
	@FindBy(xpath = "//h2[.='Our Key Features']")
	private WebElement featureHeader;

	public WebElement getFeatureHeader() {
		return featureHeader;
	}

	public WebElement getDoctorClickHereLink() {
		return doctorClickHereLink;
	}

	public WebElement getPatientClickHereLink() {
		return patientClickHereLink;
	}

	public WebElement getAdminClickHereLink() {
		return adminClickHereLink;
	}

	public WebElement getDocUsernameTxt() {
		return docUsernameTxt;
	}

	public WebElement getDocPasswordTxt() {
		return docPasswordTxt;
	}

	public WebElement getDocForgotpassLink() {
		return docForgotpassLink;
	}

	public WebElement getDocLoginBtn() {
		return docLoginBtn;
	}

	public WebElement getPatientUsernameTxt() {
		return patientUsernameTxt;
	}

	public WebElement getPatientPasswordTxt() {
		return patientPasswordTxt;
	}

	public WebElement getPatientLoginBtn() {
		return patientLoginBtn;
	}

	public WebElement getPatientForgotpassLink() {
		return patientForgotpassLink;
	}

	public WebElement getPatientCreateAccountLink() {
		return patientCreateAccountLink;
	}

	public WebElement getAdminUsernameTxt() {
		return adminUsernameTxt;
	}

	public WebElement getAdminPasswordTxt() {
		return adminPasswordTxt;
	}

	public WebElement getAdminLoginBtn() {
		return adminLoginBtn;
	}
	
	public void doctorLoginTest(String docUsername, String docPassword)
	{   wlib.scrollToElementAction(driver, featureHeader);
		doctorClickHereLink.click();
		
		wlib.switchtoTabOnTitle(driver,"Doctor Login");
		docUsernameTxt.sendKeys(docUsername);
		docPasswordTxt.sendKeys(docPassword);
		docLoginBtn.click();	
	}
	public void patientLoginTest(String patientUsername, String patientPassword)
	{
		wlib.scrollToElementAction(driver, featureHeader);
		patientClickHereLink.click();
		
		wlib.switchtoTabOnTitle(driver,"User");
		patientUsernameTxt.sendKeys(patientUsername);
		patientPasswordTxt.sendKeys(patientPassword);
		patientLoginBtn.click();	
	}
	public void adminLoginTest(String adminUsername, String adminPassword) throws InterruptedException
	{
		wlib.scrollToElementAction(driver, featureHeader);
		adminClickHereLink.click();
		
		wlib.switchtoTabOnTitle(driver,"Admin-Login");
		adminUsernameTxt.sendKeys(adminUsername);
		Thread.sleep(1000);
		adminPasswordTxt.sendKeys(adminPassword);
		adminLoginBtn.click();	
	}
}

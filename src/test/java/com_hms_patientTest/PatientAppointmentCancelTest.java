package com_hms_patientTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com_hms_business.ObjectUtility.AppointmentHistoryPage;
import com_hms_business.ObjectUtility.BookAppointmentPage;
import com_hms_business.ObjectUtility.DoctorHomePage;
import com_hms_business.ObjectUtility.LoginPage;
import com_hms_business.ObjectUtility.PatientHomePage;
import com_hms_generic.BaseUtility.BaseClass;
import com_hms_generic.WebDriverUtility.UtilityClassObject;
import com_hms_listenerUtility.ListImpclass;
@Listeners(ListImpclass.class)
public class PatientAppointmentCancelTest extends BaseClass{
@Test(groups="regressionTest")
public void bookAppointmentTest() throws Throwable
{
	
	  /* read data from excel file */
	  UtilityClassObject.getTest().log(Status.INFO, "read data from excel file");
	  String patientUn=System.getProperty("PatientUsername",elib.getDatafromExcelfile("Patient", 5, 0)); 
	  String patientPwd=System.getProperty("PatientPassword",elib.getDatafromExcelfile("Patient", 5, 1));
	  String specialization=System.getProperty("DoctorSpecialization",elib.getDatafromExcelfile("Patient", 5, 2));
	  String doctor=System.getProperty("Doctor",elib.getDatafromExcelfile("Patient", 5, 3));
	 // String date=System.getProperty("Date",elib.getDatafromExcelfile("Patient", 5, 4));
	  String time=System.getProperty("Time",elib.getDatafromExcelfile("Patient", 5, 5));
	  
	  /* Login to app */
	  UtilityClassObject.getTest().log(Status.INFO, "Enter patient login credentials");
	  LoginPage lp=new LoginPage(driver);
	  lp.patientLoginTest(patientUn, patientPwd);
	  
	  /*click on book appointment link*/
	  PatientHomePage php=new PatientHomePage(driver);
	  php.getBookAppointmentLink().click();
	  
	  /*enter all details*/
	  BookAppointmentPage bap=new BookAppointmentPage(driver);
	  bap.bookAppointmentPageTest(specialization, doctor, time);
	  System.out.println("donedone done");
	  /*verify the confirm message*/
	  Alert alt = driver.switchTo().alert(); 
	  String act_message=alt.getText();
	  alt.accept();
	  //String act_message=wlib.switchtoAlertAcceptMessage(driver);
	  boolean status=act_message.trim().contains("Your appointment successfully booked");
	  Assert.assertEquals(status, true);
	  
	  /*logout*/
	  php.logoutPageTest();
}
@Test(groups="regressionTest")
public void cancelAppointment() throws Throwable
{
	  /* read data from property file */
	  UtilityClassObject.getTest().log(Status.INFO, "read data from propertyfile");
	  String doctorUn=System.getProperty("DoctorUsername",fu.getDatafromPropertyfile("DoctorUsername")); 
	  String doctorPwd=System.getProperty("DoctorPassword",fu.getDatafromPropertyfile("DoctorPassword"));
	  
	  /* read data from excel file */
	  UtilityClassObject.getTest().log(Status.INFO, "read data from excel file");
	  String patientUn=System.getProperty("PatientUsername",elib.getDatafromExcelfile("Patient", 5, 0)); 
	  String patientPwd=System.getProperty("PatientPassword",elib.getDatafromExcelfile("Patient", 5, 1));
	  
	  /* Login to app */
	  UtilityClassObject.getTest().log(Status.INFO, "Enter patient login credentials");
	  LoginPage lp=new LoginPage(driver);
	  lp.doctorLoginTest(doctorUn, doctorPwd);
	  
	  /*click on appointment history*/
	  DoctorHomePage dhp=new DoctorHomePage(driver);
	  dhp.getappointmentHistoryLink().click();
	  
	  /*Enter all the details*/
	  WebElement ele=driver.findElement(By.xpath("(//td[.='Asha']/following-sibling::td[contains(.,'2024-11-23 / 12:15 PM')]/following-sibling::td[3])[2]"));
	  wlib.scrollToElementAction(driver, ele);
	  ele.click();
	  wlib.switchtoAlertandAccept(driver);
	  String act_message=ele.getText();
	  System.out.println(act_message);
	  boolean status=act_message.trim().contains("Canceled");
	  Assert.assertEquals(status, true);
	  
	  /*logout*/
	  dhp.logoutPageTest();
	  
	  /*Patient login*/
	  UtilityClassObject.getTest().log(Status.INFO, "Enter patient login credentials");
	  lp.patientLoginTest(patientUn, patientPwd);
	  
	  /*click on appointment history*/
	  AppointmentHistoryPage ahp=new AppointmentHistoryPage(driver);
	  ahp.getAppointmentHistoryLink().click();
	  
	  /*verify the canceled appointment*/
	  String act_action=ahp.getActionLink().getText();
	  boolean status1=act_action.trim().contains("Canceled");
	  Assert.assertEquals(status1, true);
	  
	  
	  /*logout*/
	  PatientHomePage php=new PatientHomePage(driver);
	  php.logoutPageTest();
	  
	  
	  
	  
	  
}
}

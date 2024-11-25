package com_hms_doctorTest;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com_hms_business.ObjectUtility.AdminDashboardPage;
import com_hms_business.ObjectUtility.BookAppointmentPage;
import com_hms_business.ObjectUtility.CreateDoctorPage;
import com_hms_business.ObjectUtility.LoginPage;
import com_hms_business.ObjectUtility.PatientHomePage;
import com_hms_generic.BaseUtility.BaseClass;
import com_hms_generic.WebDriverUtility.UtilityClassObject;
import com_hms_listenerUtility.ListImpclass;
@Listeners(ListImpclass.class)
public class CreateDoctorTest extends BaseClass {
@Test(groups="regressionTest")
public void createDoctorTest() throws Throwable
{ 
	  /* read data from property file */
	  UtilityClassObject.getTest().log(Status.INFO, "read data from propertyfile");
	  String adminUn=System.getProperty("AdminUsername",fu.getDatafromPropertyfile("AdminUsername")); 
	  String adminPwd=System.getProperty("AdminPassword",fu.getDatafromPropertyfile("AdminPassword"));
	  String docSpecialize=System.getProperty("docSpecialization",fu.getDatafromPropertyfile("docSpecialization")); 
	  String docName=System.getProperty("docName",fu.getDatafromPropertyfile("docName"));
	  String docAddress=System.getProperty("docAddress",fu.getDatafromPropertyfile("docAddress")); 
	  String docFees=System.getProperty("docFees",fu.getDatafromPropertyfile("docFees"));
	  String docContactno=System.getProperty("docContactno",fu.getDatafromPropertyfile("docContactno"));
	  String docEmail=jlib.getRandomNumber(1000)+System.getProperty("docEmail",fu.getDatafromPropertyfile("docEmail")); 
	  String docPassword=System.getProperty("docPassword",fu.getDatafromPropertyfile("docPassword"));
	  
	  
	  
	  /* Enter the admin details */
	  UtilityClassObject.getTest().log(Status.INFO, "Enter admin login credentials");
	  LoginPage lp=new LoginPage(driver);
	  lp.adminLoginTest(adminUn, adminPwd);
	  
	  /*navigate to Doctor and click on add doctor link*/
	  UtilityClassObject.getTest().log(Status.INFO, "click on add doctor link");
	  AdminDashboardPage adp=new AdminDashboardPage(driver);
	  adp.getDoctorsDropdown().click();
	  adp.getAddDoctorLink().click();
	  
	  /*Enter all details*/
	  UtilityClassObject.getTest().log(Status.INFO, "Enter all details");
	  CreateDoctorPage cdp=new CreateDoctorPage(driver);
	  cdp.createDoctorTest(docSpecialize, docName, docAddress, docFees, docContactno, docEmail, docPassword);
	  
	  /*verify the message*/
	  UtilityClassObject.getTest().log(Status.INFO, "verify the message");
	  Alert alt = driver.switchTo().alert(); 
	  String act_message=alt.getText();
	  alt.accept();
	  //String act_message=wlib.switchtoAlertAcceptMessage(driver);
	  boolean status=act_message.trim().contains("Doctor info added Successfully");
	  Assert.assertEquals(status, true);
	  
	  /*logout*/
	  adp.logoutPageTest();
	  
	  /* read data from excel file */
	  UtilityClassObject.getTest().log(Status.INFO, "read data from excel file");
	  String patientUn=System.getProperty("PatientUsername",elib.getDatafromExcelfile("Patient", 5, 0)); 
	  String patientPwd=System.getProperty("PatientPassword",elib.getDatafromExcelfile("Patient", 5, 1));
      String time=System.getProperty("Time",elib.getDatafromExcelfile("Patient", 5, 5));
	  
	  /* Login to app */
	  UtilityClassObject.getTest().log(Status.INFO, "Enter patient login credentials");
	  lp.patientLoginTest(patientUn, patientPwd);
	  
	  /*click on book appointment link*/
	  PatientHomePage php=new PatientHomePage(driver);
	  php.getBookAppointmentLink().click();
	  
	  /*enter all details*/
	  BookAppointmentPage bap=new BookAppointmentPage(driver);
	  bap.bookAppointmentPageTest(docSpecialize, docName, time);
	  
	  /*verify the confirm message*/
	  Alert alt1 = driver.switchTo().alert(); 
	  String act_message1=alt1.getText();
	  alt1.accept();
	  //String act_message1=wlib.switchtoAlertAcceptMessage(driver);
	  boolean status1=act_message1.trim().contains("Your appointment successfully booked");
	  Assert.assertEquals(status1, true);
	  
	  /*logout*/
	  php.logoutPageTest();
	
}

}

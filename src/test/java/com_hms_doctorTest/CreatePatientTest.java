package com_hms_doctorTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com_hms_business.ObjectUtility.AddMedicalHistoryPage;
import com_hms_business.ObjectUtility.CreatePatientPage;
import com_hms_business.ObjectUtility.DoctorHomePage;
import com_hms_business.ObjectUtility.LoginPage;
import com_hms_business.ObjectUtility.PatientHomePage;
import com_hms_generic.BaseUtility.BaseClass;
import com_hms_generic.WebDriverUtility.UtilityClassObject;
import com_hms_listenerUtility.ListImpclass;
@Listeners(ListImpclass.class)
public class CreatePatientTest extends BaseClass{
@Test(groups="regressionTest")
public void createpatientTest() throws Throwable {
	  /* read data from property file */
	  UtilityClassObject.getTest().log(Status.INFO, "read data from propertyfile");
	  String docUn=System.getProperty("DoctorUsername",fu.getDatafromPropertyfile("DoctorUsername")); 
	  String docPwd=System.getProperty("DoctorPassword",fu.getDatafromPropertyfile("DoctorPassword"));
	  String docName=System.getProperty("docName",fu.getDatafromPropertyfile("docName")); 
	  String patientName=System.getProperty("patientName",fu.getDatafromPropertyfile("patientName"));
	  String patientPassword=System.getProperty("patientPassword",fu.getDatafromPropertyfile("patientPassword"));
	  String patientContactNo=System.getProperty("patientContactNo",fu.getDatafromPropertyfile("patientContactNo"));
	  String patientEmail=System.getProperty("patientEmail",fu.getDatafromPropertyfile("patientEmail"));
	  String patientGender=System.getProperty("patientGender",fu.getDatafromPropertyfile("patientGender"));
	  String patientAge=System.getProperty("patientAge",fu.getDatafromPropertyfile("patientAge"));
	  String patientAddress=System.getProperty("patientAddress",fu.getDatafromPropertyfile("patientAddress"));
	  String patientMedical=System.getProperty("patientMedical",fu.getDatafromPropertyfile("patientMedical"));
	  
	  /*login to application*/
	  LoginPage lp=new LoginPage(driver);
	  lp.doctorLoginTest(docUn, docPwd);
	  
	  
	  /* navigate to add patient page*/
	  UtilityClassObject.getTest().log(Status.INFO, "navigate to add patient page");
	  DoctorHomePage dhp=new DoctorHomePage(driver);
	  dhp.getPatientsDropdown().click();
	  dhp.getAddPatientslink().click();
	  
	  /*enter all the details of patient*/
	  UtilityClassObject.getTest().log(Status.INFO, "enter all the details of patient");
	  CreatePatientPage cpp=new CreatePatientPage(driver);
	  cpp.addPatientPageTest(patientName, patientContactNo, patientEmail, patientGender, patientAddress, patientAge, patientMedical);
	  
	  /*verify msg*/
	  UtilityClassObject.getTest().log(Status.INFO, "verify message");
	  dhp.getPatientsDropdown().click();
	  dhp.getManagePatientslink().click();
	  String act=driver.findElement(By.xpath("//table[@id='sample-table-1']/descendant::tr[last()]/td[contains(.,'"+patientName+"')]")).getText();
	  boolean status=act.contains(patientName);
	  Assert.assertEquals(status, true);
	  
	  /*logout*/
	  dhp.logoutPageTest();
	  
	  /*login to patient*/
	  lp.patientLoginTest(patientEmail, patientPassword);
	  PatientHomePage php=new PatientHomePage(driver);
	  php.getAppointmentHistoryLink().click();
	  
	  /*verify msg*/
	  UtilityClassObject.getTest().log(Status.INFO, "verify message");
	  String act1=driver.findElement(By.xpath("//table[@id='sample-table-1']/descendant::tr[last()]/td[contains(.,'"+docName+"')]")).getText();
	  boolean status1=act1.contains(docName);
	  Assert.assertEquals(status1, true);
}	  
@Test(groups="regressionTest")
public void addMedicalHistoryTest() throws Throwable
{
	/* read data from property file */
	  UtilityClassObject.getTest().log(Status.INFO, "read data from propertyfile");
	  String docUn=System.getProperty("DoctorUsername",fu.getDatafromPropertyfile("DoctorUsername")); 
	  String docPwd=System.getProperty("DoctorPassword",fu.getDatafromPropertyfile("DoctorPassword"));
	  String docName=System.getProperty("docName",fu.getDatafromPropertyfile("docName")); 
	  String patientName=System.getProperty("patientName",fu.getDatafromPropertyfile("patientName"));
	  String patientPassword=System.getProperty("patientPassword",fu.getDatafromPropertyfile("patientPassword"));
	  String bp=System.getProperty("bp",fu.getDatafromPropertyfile("bp"));
	  String patientEmail=System.getProperty("patientEmail",fu.getDatafromPropertyfile("patientEmail"));
	  String bs=System.getProperty("bs",fu.getDatafromPropertyfile("bs"));
	  String wg=System.getProperty("wg",fu.getDatafromPropertyfile("wg"));
	  String temp=System.getProperty("temp",fu.getDatafromPropertyfile("temp"));
	  String prescription=System.getProperty("prescription",fu.getDatafromPropertyfile("prescription"));
	  
	  
	  /*login to application*/
	  LoginPage lp=new LoginPage(driver);
	  lp.doctorLoginTest(docUn, docPwd);
	  
	  
	  /* navigate to manage patient page*/
	  UtilityClassObject.getTest().log(Status.INFO, "navigate to manage patient page");
	  DoctorHomePage dhp=new DoctorHomePage(driver);
	  dhp.getPatientsDropdown().click();
	  dhp.getManagePatientslink().click();
	  wlib.scrollByElement(driver, 0, 1000);
	  WebElement ele=driver.findElement(By.xpath("//table[@id='sample-table-1']/descendant::tr[contains(.,'"+patientName+"')]/td[last()]/child::a[@href='view-patient.php?viewid=92']"));
	  ele.click();
	  
	  AddMedicalHistoryPage amhp=new AddMedicalHistoryPage(driver);
	  amhp.getAddMedicalhistoryBtn().click();
	  amhp.addMedicalTest(bp, bs, wg, temp, prescription);
	  
	  //*verify msg*/
	  UtilityClassObject.getTest().log(Status.INFO, "verify message");
	  String act=wlib.switchtoAlertAcceptMessage(driver);
	  boolean status=act.contains("Medicle history");
	  Assert.assertEquals(status, true);
	
	  
	  /*logout*/
	  dhp.logoutPageTest();
	  
	  /*login to patient*/
	 
	  lp.patientLoginTest(patientEmail,patientPassword);
	  
	  PatientHomePage php=new PatientHomePage(driver);
	  php.getMedicalHistoryLink().click();
	  
	  /*verify msg*/
	  UtilityClassObject.getTest().log(Status.INFO, "verify message");
	  String act1=driver.findElement(By.xpath("//table[@id='datatable']/descendant::tr/td[contains(.,'"+bs+"')]")).getText();
	  boolean status1=act1.contains(docName);
	  Assert.assertEquals(status1, true);
}
}

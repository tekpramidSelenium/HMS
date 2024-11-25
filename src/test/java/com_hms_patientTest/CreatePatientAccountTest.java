package com_hms_patientTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com_hms_business.ObjectUtility.LoginPage;
import com_hms_business.ObjectUtility.PatentCreateAccoutPage;
import com_hms_generic.BaseUtility.BaseClass;
import com_hms_generic.WebDriverUtility.UtilityClassObject;
import com_hms_listenerUtility.ListImpclass;
@Listeners(ListImpclass.class)
public class CreatePatientAccountTest extends BaseClass {
	@Test(groups="smokeTest")
	public void createPatientAccountTest() throws Throwable {
		 /* read data from excel file */
		  UtilityClassObject.getTest().log(Status.INFO, "read data from excel file");
			String name=elib.getDatafromExcelfile("Patient", 1, 0);
			String address=elib.getDatafromExcelfile("Patient", 1, 1);
			String city=elib.getDatafromExcelfile("Patient", 1, 2);
			String gender=elib.getDatafromExcelfile("Patient", 1, 3);
			String email=jlib.getRandomNumber(1000)+elib.getDatafromExcelfile("Patient", 1, 4);
			String password=name+jlib.getRandomNumber(1000);
		  
		  /*navigate to login page*/
		  UtilityClassObject.getTest().log(Status.INFO, "navigate to login page");
		  LoginPage lp=new LoginPage(driver);
		  wlib.scrollToElementAction(driver,lp.getFeatureHeader());
		  lp.getPatientClickHereLink().click();
		  
		  /*switch the window to patient login page and click on create account link */
		  UtilityClassObject.getTest().log(Status.INFO, "switch the window to patient login page");
		  wlib.switchtoTabOnTitle(driver,"User");
		  lp.getPatientCreateAccountLink().click();
		 
		  /*Click on create account link*/
		  UtilityClassObject.getTest().log(Status.INFO, "Enter user details");
		  PatentCreateAccoutPage pca=new PatentCreateAccoutPage(driver);
		  pca.createAccountTest(name, address, city, gender, email, password);
		  
		  /*verify confirm message*/
		  UtilityClassObject.getTest().log(Status.INFO, "Verify the confirm message");
		  String act_message=wlib.switchtoAlertAcceptMessage(driver);
		  System.out.println(act_message);
		  boolean status=act_message.contains("Successfully Registered");
		  Assert.assertEquals(status, true);
		  
		
	}

	  
	  
	  
}

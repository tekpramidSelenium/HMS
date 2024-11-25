package com_hms_adminTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com_hms_business.ObjectUtility.LoginPage;
import com_hms_generic.BaseUtility.BaseClass;
import com_hms_generic.WebDriverUtility.UtilityClassObject;
import com_hms_listenerUtility.ListImpclass;

@Listeners(ListImpclass.class)
public class AdminLoginTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void adminLoginPageTest() throws Throwable { 
		/* read data from property file */
		  UtilityClassObject.getTest().log(Status.INFO, "read data from propertyfile");
		  String un=System.getProperty("AdminUsername",fu.getDatafromPropertyfile("AdminUsername")); 
		  String pwd=System.getProperty("AdminPassword",fu.getDatafromPropertyfile("AdminPassword"));
		  
		  
		  /* Enter the admin details */
		  UtilityClassObject.getTest().log(Status.INFO, "Enter admin login credentials");
		  LoginPage lp=new LoginPage(driver);
		  lp.adminLoginTest(un, pwd);
		 
		/* verify the Admin Dashboard */
		  UtilityClassObject.getTest().log(Status.INFO, "Verify the admin homepage");
		  String act_title=driver.getTitle();
		  boolean status=act_title.contains("Admin");
		  Assert.assertEquals(status, true);
		  

	}
}

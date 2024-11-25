package com_hms_generic.BaseUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com_hms_generic.DataBaseutility.DBUtility;
import com_hms_generic.FileUtility.ExcelUtility;
import com_hms_generic.FileUtility.FileUtility;
import com_hms_generic.WebDriverUtility.JavaUtility;
import com_hms_generic.WebDriverUtility.UtilityClassObject;
import com_hms_generic.WebDriverUtility.WebdriverUtility;

public class BaseClass {
	// Create Object
	public DBUtility dlib = new DBUtility();
	public FileUtility fu = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebdriverUtility wlib = new WebdriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public SoftAssert soft = new SoftAssert();

	@BeforeSuite(alwaysRun = true)
	public void beforsuite() throws SQLException {
		System.out.println("start connect to Db and report configure");

	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() throws SQLException {
		System.out.println("close DB connection and report backup");

	}

	@Parameters("Browser")
	@BeforeClass(alwaysRun = true)
	public void bc(@Optional("chrome") String BROWSER) throws Throwable {

	
		driver = wlib.launchingBrowser(BROWSER);
		System.out.println("launching the browser");

		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		driver = UtilityClassObject.getDriver();
	}

	@AfterClass(alwaysRun = true)
	public void ac() {
		System.out.println("close the browser");
		//driver.quit();
	}

	@BeforeMethod(alwaysRun = true)
	public void bm() throws Throwable {
		System.out.println("login to app");
		String url = System.getProperty("url", fu.getDatafromPropertyfile("URl"));
		driver.manage().window().maximize();
		wlib.waitforpageLoad(driver, 30);
		driver.get(url);
	}

}
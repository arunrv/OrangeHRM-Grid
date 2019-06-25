package com.qsp.ohrm.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qsp.ohrm.page.OrangeHRMLoginPage;
import com.qsp.ohrm.utils.ConfigFileReader;
import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.ExtentReportFactory;
import com.qsp.ohrm.utils.Log;
import com.qsp.ohrm.utils.OrangeHRMUtils;
import com.qsp.ohrm.utils.Screenshots;

public class LoginToHRMTest extends BaseTest {

	OrangeHRMLoginPage olp = null;
	@BeforeClass
	public void setup(){
		driver = DriverUtils.getWebDriver(config.getBrowserType());
		olp = new OrangeHRMLoginPage(driver);
	
	}
	
	@Test
	public void validateLoginTest(){
		Log.startReport("validateLoginTest");
		
		Log.info("launching application");
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		
		Log.info("Entering user name" );
		olp.enterUserName(config.getUserName());
		
		Log.info("Entering password");
		olp.enterPassword(config.getPasswordName());
		
		Log.info("clicking on login button");
		olp.clickOnLoginButton();
	}
	
	
	@Test
	public void validateInvalidUserNameTest(){
		Log.startReport("validateInvalidUserNameTest");
		
		Log.info("launching application");
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		
		Log.info("Entering user name" );
		olp.enterUserName("XXXXXXXXXXX");
		
		Log.info("Entering password");
		olp.enterPassword(config.getPasswordName());
		
		Log.info("clicking on login button");
		olp.clickOnLoginButton();
		
		olp.validateErrorMessage();
	}
	
}

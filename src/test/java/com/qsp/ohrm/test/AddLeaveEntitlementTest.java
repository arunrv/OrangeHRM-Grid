package com.qsp.ohrm.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qsp.ohrm.page.OrangeDashboardPage;
import com.qsp.ohrm.page.OrangeHRMAddLeaveEntitlement;
import com.qsp.ohrm.page.OrangeHRMLoginPage;
import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.Log;
import com.qsp.ohrm.utils.OrangeHRMUtils;

public class AddLeaveEntitlementTest extends BaseTest {
	
	OrangeHRMLoginPage oLoginpage= null;
	OrangeDashboardPage odp = null;
	OrangeHRMAddLeaveEntitlement oAddLeavEnt = null;
	
	@BeforeClass
 	public void preConfig(){
 		Log.startReport("setup");
 		
		driver = DriverUtils.getWebDriver();
		oLoginpage = new OrangeHRMLoginPage(driver);
		odp = new OrangeDashboardPage(driver);
		oAddLeavEnt = new OrangeHRMAddLeaveEntitlement(driver);
 	}
	
	
	@Test(priority=1)
	public void validateLoginTest(){
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		oLoginpage.enterUserName(config.getUserName());
		oLoginpage.enterPassword(config.getPasswordName());
		oLoginpage.clickOnLoginButton();
		Log.pass("Login to Applicaiton Success");
		Log.info("--Completeds Executing Test - validateLoginTest");
 		//Log.endReport("validateLoginTest");
	}
	
	
	@Test(priority=2)
	public void addLeaveEntitlements()
	{
	odp.clickOnLeave();
	odp.clickOnEntitlements();
	odp.clickOnAddEntitlements();
	oAddLeavEnt.EnterEmployee("Qspiders");
	oAddLeavEnt.Entitlement("4");
	oAddLeavEnt.ClickonSave();	
		
	}

}

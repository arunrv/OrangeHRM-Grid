package com.qsp.ohrm.test.admintest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qsp.ohrm.page.OrangeDashboardPage;
import com.qsp.ohrm.page.OrangeHRMAddUserPage;
import com.qsp.ohrm.page.OrangeHRMLoginPage;
import com.qsp.ohrm.test.BaseTest;
import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.Log;
import com.qsp.ohrm.utils.OrangeHRMUtils;

public class AddUser extends BaseTest 
{
	OrangeHRMLoginPage oLoginpage= null;
	OrangeDashboardPage odp = null;
	OrangeHRMAddUserPage Adduserpage=null;
	
	@BeforeClass
 	public void preConfig(){
 		Log.startReport("setup");
 		
		driver = DriverUtils.getWebDriver();
		oLoginpage = new OrangeHRMLoginPage(driver);
		odp = new OrangeDashboardPage(driver);
		Adduserpage=new OrangeHRMAddUserPage(driver);
		
 	}
	@Test(priority=1)
	public void validateLoginTest() throws InterruptedException{
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		Log.pass("Login to Applicaiton Success");
		Log.info("--Completeds Executing Test - validateLoginTest");
 		//Log.endReport("validateLoginTest");
		oLoginpage.loginToOrangeHRM(driver, "Admin", "QSPAdmin1@#");
		Adduserpage.clickadminUseradmin();
		Adduserpage.clickusers();
		Adduserpage.clickAddUser();
		Adduserpage.selectRoleByIndex("byIndex", "1");
		Adduserpage.enterEmployeeName("Rajesh Krishna");
		Adduserpage.enterUserName("Raj1234");
		Adduserpage.selectStatus("byIndex", "0");
		Adduserpage.enterPassword("QSPAdmin1@#");
		Adduserpage.confirmPassword("QSPAdmin1@#");
		Thread.sleep(30000);
		Adduserpage.clickOnSaveUserButton();
		Thread.sleep(25000);
	}
	@Test(priority=2)
	public void searchUsers()
	{
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		Log.pass("Login to Applicaiton Success");
		Log.info("--Completeds Executing Test - validateLoginTest");
		oLoginpage.loginToOrangeHRM(driver, "Admin", "QSPAdmin1@#");
		Adduserpage.clickadminUseradmin();
		Adduserpage.clickusers();
		Adduserpage.enterValueToSearchUser("Raj1234");
		Adduserpage.clickSearchButton();
		Adduserpage.verifyNameisPresent("Raj1234");
	}
	

}

package com.qsp.ohrm.test.admintest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qsp.ohrm.page.OrangeDashboardPage;
import com.qsp.ohrm.page.OrangeHRMAddUserPage;
import com.qsp.ohrm.page.OrangeHRMLoginPage;
import com.qsp.ohrm.page.OrangeHRMUserManagementPage;
import com.qsp.ohrm.test.BaseTest;
import com.qsp.ohrm.utils.ConfigFileReader;
import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.ExtentReportFactory;
import com.qsp.ohrm.utils.Log;
import com.qsp.ohrm.utils.OrangeHRMUtils;
import com.qsp.ohrm.utils.Screenshots;

public class UserManagementTest extends BaseTest {

	OrangeHRMLoginPage loginPage = null;
	OrangeHRMAddUserPage addUserPage =null;
	OrangeHRMUserManagementPage usermPage =null;
	OrangeDashboardPage dashboardPage = null;
	
	String userName = "mynewID";
	@BeforeClass
	public void setup(){
		driver = DriverUtils.getWebDriver(config.getBrowserType());
		loginPage = new OrangeHRMLoginPage(driver);
		usermPage= new OrangeHRMUserManagementPage(driver);
		addUserPage= new OrangeHRMAddUserPage(driver);
		dashboardPage = new OrangeDashboardPage(driver);
	
	}
	
	@Test(priority=1)
	public void AddUserTest() throws InterruptedException{
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		loginPage.loginToOrangeHRM(driver, config.getUserName(), config.getPasswordName());
		usermPage.clickOnUsers();
		usermPage.clickOnAddUser();
		addUserPage.selectUserRoleByText("Admin");
		addUserPage.enterEmployeeName("Employee-A LN-1");
		addUserPage.enterUserName(userName);
		addUserPage.selectStatus("byIndex", "0");
		addUserPage.enterPassword("AArr66!!");
		addUserPage.confirmPassword("AArr66!!");
		addUserPage.clickOnSaveUserButton();
		addUserPage.validateToastMessage();
		dashboardPage.clickOnLogoutLink();
	}

	@Test(priority=3)
	public void DeleteUserTest(){
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		loginPage.loginToOrangeHRM(driver, config.getUserName(), config.getPasswordName());
		usermPage.clickOnUsers();
		usermPage.selectCheckBox(userName);
		usermPage.clickOnDeleteUser();
		usermPage.acceptPopUp();
		addUserPage.validateToastMessage();
		dashboardPage.clickOnLogoutLink();
	}

	@Test(priority=2)
	public void SearchUserTest(){
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		loginPage.loginToOrangeHRM(driver, config.getUserName(), config.getPasswordName());
		usermPage.clickOnUsers();
		usermPage.searchUser(userName);
		usermPage.validateSearchResult(userName);
		dashboardPage.clickOnLogoutLink();
	}


}

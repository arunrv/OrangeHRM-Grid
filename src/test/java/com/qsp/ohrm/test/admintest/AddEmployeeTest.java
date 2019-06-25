
	package com.qsp.ohrm.test.admintest;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	import com.qsp.ohrm.page.OrangeDashboardPage;
import com.qsp.ohrm.page.OrangeHRMAddEmployeePage;
import com.qsp.ohrm.page.OrangeHRMLoginPage;
import com.qsp.ohrm.test.BaseTest;
import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.Log;
import com.qsp.ohrm.utils.OrangeHRMUtils;

	public class AddEmployeeTest extends BaseTest {

		OrangeHRMLoginPage loginPage = null;
		OrangeDashboardPage dashboardPage = null;
		OrangeHRMAddEmployeePage addemployee = null;
		
		String userName = "FinalTest112";
		@BeforeClass
		public void setup(){
			driver = DriverUtils.getWebDriver(config.getBrowserType());
			loginPage = new OrangeHRMLoginPage(driver);
			//usermPage= new OrangeHRMUserManagementPage(driver);
			//addUserPage= new OrangeHRMAddUserPage(driver);
			dashboardPage = new OrangeDashboardPage(driver);
			addemployee = new OrangeHRMAddEmployeePage(driver);
		
		}
		
		@Test(priority=1)
		public void AddEmployeeTest() throws InterruptedException{
			Log.startReport(DriverUtils.getMethodName());
			OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
			loginPage.loginToOrangeHRM(driver, config.getUserName(), config.getPasswordName());
			addemployee.clickonpim();
			addemployee.clickAddEmployee();
			addemployee.Enterfirstname("saritha");
			addemployee.Enterlastname("reddy");
			addemployee.clickonsave();
			
			dashboardPage.clickOnLogoutLink();
		}

	}



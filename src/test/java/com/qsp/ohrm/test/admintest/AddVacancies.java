package com.qsp.ohrm.test.admintest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qsp.ohrm.page.OrangeDashboardPage;
import com.qsp.ohrm.page.OrangeHRMAddUserPage;
import com.qsp.ohrm.page.OrangeHRMLoginPage;
import com.qsp.ohrm.page.RecruitmentPage;
import com.qsp.ohrm.page.VacancyPage;
import com.qsp.ohrm.test.BaseTest;
import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.Log;
import com.qsp.ohrm.utils.OrangeHRMUtils;

public class AddVacancies extends BaseTest
{
	OrangeHRMLoginPage oLoginpage= null;
	OrangeDashboardPage odp = null;
	OrangeHRMAddUserPage Adduserpage=null;
	RecruitmentPage rpage=null;
	VacancyPage vpage=null;
	
	@BeforeClass
 	public void preConfig(){
 		Log.startReport("setup");
 		
		driver = DriverUtils.getWebDriver();
		oLoginpage = new OrangeHRMLoginPage(driver);
		odp = new OrangeDashboardPage(driver);
		Adduserpage=new OrangeHRMAddUserPage(driver);
		rpage=new RecruitmentPage(driver);
		vpage=new VacancyPage(driver);
		
 	}
	@Test(priority=1)
	public void validateLoginTest() throws InterruptedException
	{
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		Log.pass("Login to Applicaiton Success");
		oLoginpage.loginToOrangeHRM(driver, "Admin", "QSPAdmin1@#");
		rpage.clickRecruitment();
		vpage.clickVacancy();
		vpage.clickadd();
		vpage.setHiringMgr("Arun R");
		vpage.setVacancyName("API Testing");
		vpage.selectJobTitle("byIndex", "2");
		vpage.clickSave();
	}
}
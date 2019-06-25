package com.qsp.ohrm.test.admintest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qsp.ohrm.page.OrangeDashboardPage;
import com.qsp.ohrm.page.OrangeHRMAddUserPage;
import com.qsp.ohrm.page.OrangeHRMLoginPage;
import com.qsp.ohrm.page.RecruitmentPage;
import com.qsp.ohrm.test.BaseTest;
import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.Log;
import com.qsp.ohrm.utils.OrangeHRMUtils;

public class AddCandidateTest extends BaseTest
{
	OrangeHRMLoginPage oLoginpage= null;
	OrangeDashboardPage odp = null;
	OrangeHRMAddUserPage Adduserpage=null;
	RecruitmentPage rpage=null;
	
	@BeforeClass
 	public void preConfig(){
 		Log.startReport("setup");
 		
		driver = DriverUtils.getWebDriver();
		oLoginpage = new OrangeHRMLoginPage(driver);
		odp = new OrangeDashboardPage(driver);
		Adduserpage=new OrangeHRMAddUserPage(driver);
		rpage=new RecruitmentPage(driver);
		
 	}
	@Test(priority=1)
	public void validateLoginTest() throws InterruptedException
	{
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver, config.getApplicationUrl());
		Log.pass("Login to Applicaiton Success");
		oLoginpage.loginToOrangeHRM(driver, "Admin", "QSPAdmin1@#");
		rpage.clickRecruitment();
		rpage.clickCandidates();
		rpage.clickAddButton();
		rpage.setFullName("Rajiv");
		rpage.setLastName("Gandhi");
		rpage.setEmail("xyz@gmail.com");
		rpage.uploadResume("C:\\Users\\Arun123\\Desktop\\New Microsoft Office Word Document.docx");
		rpage.clickSave();
	}

}

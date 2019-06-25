package com.qsp.ohrm.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.qsp.ohrm.utils.ConfigFileReader;
import com.qsp.ohrm.utils.ExtentReportFactory;
import com.qsp.ohrm.utils.Log;
import com.qsp.ohrm.utils.Screenshots;

public class BaseTest {

	public static WebDriver driver= null;
	public static ConfigFileReader config = null;
	
	@BeforeSuite
	public void initializeGlobalValues(){
		
		config = new ConfigFileReader();
		Log.configureReport();
		Log.info("Configured Reports object");
	}
	
	@BeforeMethod
	public void printMethod(ITestContext cont){
		System.out.println(cont.getName());
	}
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		Log.info("inside after method from Class : " +testResult.getInstanceName());
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName() + "_"+ ExtentReportFactory.getCurrentDateAndTime());
			Log.info("Path " + path);
			Log.ssPath.add(path);
			Log.attachScreenShot(path);
			Log.info(Thread.getAllStackTraces().toString());
		}
		
		Log.endReport();
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown(){
		driver.close();
		driver = null;
	}
	
	
	@AfterSuite
	public void saveReports(){
		
	}
}

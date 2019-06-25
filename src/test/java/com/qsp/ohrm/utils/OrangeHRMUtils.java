package com.qsp.ohrm.utils;

import org.openqa.selenium.WebDriver;


public class OrangeHRMUtils extends ConfigFileReader {
	/**
	 * @author aravinda
	 * @param url
	 */
	static ConfigFileReader config;
	public static void launchApp(WebDriver driver , String url) {
		Log.info("Launching the applicaiton ..." + url);
		driver.get(url);
		
		Log.info("Application Launched Successfully..");
	}
	public static void launchRemoteApp(WebDriver driver , String url) {
		Log.info("Launching the applicaiton ..." + url);
		driver.navigate().to(url);
		
		Log.info("Application Launched Successfully..");
	}
	
	public static void startTest(WebDriver driver){
		Log.startReport(DriverUtils.getMethodName());
		OrangeHRMUtils.launchApp(driver,config.getApplicationUrl());
		
	}
	
	
	public static void addUser(WebDriver driver){
		
	}
}

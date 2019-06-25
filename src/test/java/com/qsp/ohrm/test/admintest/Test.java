package com.qsp.ohrm.test.admintest;

import org.openqa.selenium.WebDriver;

import com.qsp.ohrm.page.OrangeHRMAddUserPage;

public class Test
{
	static WebDriver driver;
	static OrangeHRMAddUserPage Adduserpage=new OrangeHRMAddUserPage(driver);
	public static void main(String[] args) {
		Adduserpage.verifyNameisPresent("Raj1234");
	}

}

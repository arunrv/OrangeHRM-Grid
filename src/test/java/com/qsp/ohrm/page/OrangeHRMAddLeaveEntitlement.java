package com.qsp.ohrm.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMAddLeaveEntitlement {
	@FindBy(xpath="//input[@class='ac_input inputFormatHint']")
	WebElement empname;
	
	@FindBy(id="entitlements_leave_type")
	WebElement leavetype;
	
	@FindBy(id="period")
	WebElement leaveperiod;
	
	@FindBy(id="entitlements_entitlement")
	WebElement entitlement;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement save;
	
	public void EnterEmployee(String emp)
	{
		empname.sendKeys(emp);
	}
	
	public void Entitlement(String ent)
	{
		entitlement.sendKeys(ent);
	}
	
	public void ClickonSave()
	{
		save.click();
	}
	
	public OrangeHRMAddLeaveEntitlement(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
}	



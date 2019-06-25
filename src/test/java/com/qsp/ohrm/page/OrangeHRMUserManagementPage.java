package com.qsp.ohrm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.Log;

public class OrangeHRMUserManagementPage {

	WebDriver driver;
	@FindBy(id="btnAdd")
	WebElement addUserButton;
	
	@FindBy(id="btnDelete")
	WebElement deleteUserButton;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement adminModule;
	
	@FindBy(id="menu_admin_UserManagement")
	WebElement userManagement;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement users;
	
//	@FindBy(xpath="//tr[td[a[text()='EmpNew1']]]//input")
//	WebElement checkboxForUser;
//	
	@FindBy(id="dialogDeleteBtn")
	WebElement okButtonOnPopUp;
	
	@FindBy(id="searchBtn")
	WebElement searchButton;
	
//	@FindBy(xpath="//tr[td[a[text()='EmpNew']]]")
//	WebElement searchResult;
//	
	@FindBy(id="searchSystemUser_userName")
	WebElement usernameSearchBox;
	
	WebElement getUserElement(String name){
		return driver.findElement(By.xpath(String.format("//tr[td[a[text()='%s']]]",name)));
	}
	
	WebElement getCheckBoxForUser(String name){
		return driver.findElement(By.xpath(String.format("//tr[td[a[text()='%s']]]//input",name)));
	}
	public void validateSearchResult(String name){
		if(getUserElement(name).isDisplayed()){
			Assert.assertTrue(true, "Record found!!");
		}
		else
		{
			Assert.assertFalse(true);
		}
	}
	public void searchUser(String name){
		usernameSearchBox.sendKeys(name);
		searchButton.click();
	}
	public void acceptPopUp(){
		Log.info("Accepring user popup before deleting");
		okButtonOnPopUp.click();
	}
	
	public void selectCheckBox(String name){
		Log.info("Selecting a Checkbox to delete user");
		if(getCheckBoxForUser(name).isSelected()){
			Log.info("Checkbox is already selected...");
			Log.pass("Check box selected");
		}
		else{
			getCheckBoxForUser(name).click();
			Log.pass("Check box selected");
		}
	}
	public void clickOnUsers(){
		Log.info("clicking on users using actions");
		DriverUtils.moveMouse(adminModule);
		DriverUtils.moveMouse(userManagement);
		users.click();
	}
	
	public void clickOnAddUser(){
		Log.info("Clicking on Add user button");
		addUserButton.click();
	}
	
	
	public void clickOnDeleteUser(){
		Log.info("Clicking on delete user button");
		deleteUserButton.click();
	}
	
	
	public OrangeHRMUserManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
}

package com.qsp.ohrm.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminJobTitlePage {
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Admin']")
	private WebElement adminTab;
	
	@FindBy(id="menu_admin_Job")
	private WebElement jobSubTab;
	
   @FindBy(id="menu_admin_viewJobTitleList")
   private WebElement jobTitles;
   
   @FindBy(id="btnAdd")
   private WebElement addButton;
   
   @FindBy(id="jobTitle_jobTitle")
   private WebElement jobTitleTB;
   
   @FindBy(id="btnSave")
   private WebElement saveBtn;
   
   public  AdminJobTitlePage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void adminClick()
   {
	   adminTab.click();
   }
   
   public void mouseHovJob()
   {
	   
	Actions act = new Actions(driver);
	act.moveToElement(jobSubTab).perform();
	}
   
   public void clickJobTitle()
   {
	  jobTitles.click();
   }
   
   public void addClick()
   {
	   addButton.click();
   }
   
   public void enterjobTitle()
   {
	   jobTitleTB.sendKeys("TestEngineer");
   }
   
   public void clickSave()
   {
	   saveBtn.click();
   }
}

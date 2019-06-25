package com.qsp.ohrm.page;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.Log;

public class VacancyPage 
{
	WebDriver driver ; 
	@FindBy(id="menu_recruitment_viewJobVacancy")
	WebElement vacancies;
	
	@FindBy(id="btnAdd")
	WebElement addbtn;
	
	
	@FindBy(id="addJobVacancy_jobTitle")
	WebElement jobtitle;
	
	@FindBy(id="addJobVacancy_name")
	WebElement vacname;
	
	@FindBy(id="addJobVacancy_hiringManager")
	WebElement hiringmanager;
	
	@FindBy(id="btnSave")
	WebElement savebtn;
	
	
	Consumer<WebElement> clickconsumer=we->{
		DriverUtils.getVisibleElement(driver, we);
		DriverUtils.getClickableElement(driver, we);
		we.click();
	};
	BiConsumer<WebElement, String> sendkeyconsumer=(we, name)->{
		DriverUtils.getVisibleElement(driver, we);
		we.sendKeys(name);
	};
	public void clickVacancy()
	{
		Log.info("Click on Vacancy");
		clickconsumer.accept(vacancies);
	}
	public void clickadd()
	{
		Log.info("Click on Candidate");
		clickconsumer.accept(addbtn);
	}
	public void setVacancyName(String Name)
	{
		Log.info("Enter Vacancy Name");
		sendkeyconsumer.accept(vacname, Name);
	}
	public void setHiringMgr(String Name)
	{
		Log.info("Entering Hiring Manager");
		sendkeyconsumer.accept(hiringmanager, Name);
	}
	public void clickSave()
	{
		clickconsumer.accept(savebtn);
	}
	public void selectJobTitle(String type, String value)
	{
		Log.info("selecting the Status" + value);
		DriverUtils.selectDropDownItem(jobtitle, type, value);
	}
	
	public VacancyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
}

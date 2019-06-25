package com.qsp.ohrm.page;

import java.time.Duration;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.qsp.ohrm.utils.DriverUtils;
import com.qsp.ohrm.utils.Log;

public class RecruitmentPage 
{
	WebDriver driver ; 
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	WebElement recruitment;
	
	@FindBy(id="menu_recruitment_viewCandidates")
	WebElement candidate;
	
	@FindBy(id="menu_recruitment_viewJobVacancy")
	WebElement vacancy;
	
	@FindBy(id="btnAdd")
	WebElement addbtn_candidate;
	
	@FindBy(id="addCandidate_firstName")
	WebElement firstname;
	
	@FindBy(id="addCandidate_lastName")
	WebElement lastname;
	
	@FindBy(id="addCandidate_email")
	WebElement email;
	
	@FindBy(id="addCandidate_vacancy")
	WebElement jobvac;
	
	@FindBy(id="addCandidate_resume")
	WebElement resume;
	
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
	public void clickRecruitment()
	{
		Log.info("Click on Recruitment");
		clickconsumer.accept(recruitment);
	}
	public void clickCandidates()
	{
		Log.info("Click on Candidate");
		clickconsumer.accept(candidate);
	}
	public void clickAddButton()
	{
		Log.info("Click on Add Button");
		clickconsumer.accept(addbtn_candidate);
	}
	public void setFullName(String Name)
	{
		Log.info("Entering first name");
		sendkeyconsumer.accept(firstname, Name);
	}
	public void setLastName(String Name)
	{
		Log.info("Entering last name");
		sendkeyconsumer.accept(lastname, Name);
	}
	public void setEmail(String email)
	{
		Log.info("Entering email id");
		sendkeyconsumer.accept(this.email, email);
	}
	public void uploadResume(String path)
	{
		sendkeyconsumer.accept(resume, path);
	}
	public void clickSave()
	{
		clickconsumer.accept(savebtn);
	}
	
	public RecruitmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public void uploadFile(String path)
	{
		sendkeyconsumer.accept(resume, path);
	}

}

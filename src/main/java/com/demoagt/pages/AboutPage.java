package com.demoagt.pages;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoagt.base.DriverScript;

public class AboutPage extends DriverScript {

	// ************************************ Page Elements // ************************************************ //
	
	@FindBy(xpath = "//span[normalize-space()='About']")
	WebElement selectAboutTab;
	@FindBy(xpath = "//span[normalize-space()='Company Overview']")
	WebElement selectCompanyOverview;

	// ************************************ Page Initialization //************************************************ //
	

	public AboutPage() {
		PageFactory.initElements(driver, this);
	}

	// ************************************ Page Actions/ Methods ************************************************//
  
	public void clickAboutTab() {
		selectAboutTab.click();
	
	}
	
	
	public void clickCompanyOverview() {
		
		selectCompanyOverview.click();
	}
	
	
	public String getAboutPageTittle() {
		return driver.getTitle();
	}
	
	
	
	
}

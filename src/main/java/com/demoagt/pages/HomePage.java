package com.demoagt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoagt.base.DriverScript;

public class HomePage extends DriverScript {

	// ************************************ Page Elements // ************************************************ //
    @FindBy(css="li[id*=\"menu-item\"] a") WebElement webLinksList; 
	@FindBy(xpath = "//input[@placeholder='First name *']")
	WebElement textboxFirstName;
	@FindBy(xpath = "//input[@placeholder='Last name *']")
	WebElement textboxLastName;
	@FindBy(css = "input[placeholder='Your mail *']")
	WebElement textboxYourMail;
	@FindBy(xpath = "//input[@placeholder='Phone number *']")
	WebElement textboxPhoneNumber;
	@FindBy(xpath = "//input[@placeholder='Web address *']")
	WebElement textboxWebAddress;
	@FindBy(xpath = "//div[@class=\"nice-select wpcf7-form-control wpcf7-select wpcf7-validates-as-required\"]")
	WebElement dropdownService;
	@FindBy(xpath="(//li[normalize-space()='StartUp Business'])[1]") WebElement dropdownOption;
	@FindBy(css = "textarea[placeholder='Message...']")
	WebElement textboxMessage;

	// ************************************ Page Initialization // ************************************************ //

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// ************************************ Page Actions/ Methods // ************************************************//
	
	
	

	public void enterFirstName(String firstname) {
		textboxFirstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		textboxLastName.sendKeys(lastname);
	}

	public void enterYourMail(String email) {
		textboxYourMail.sendKeys(email);
	}

	public void enterPhoneNumber(String phonenumber) {
		textboxPhoneNumber.sendKeys(phonenumber);
	}

	public void enterWebAddress(String url) {
		textboxWebAddress.sendKeys(url);
	}

	public void enterService() {
		dropdownService.click();

	}

	public void enterDropDownOption() 
	{
		dropdownOption.click();
	}
	public void enterMessage(String message) {
		textboxMessage.sendKeys(message);
	}

	public String getHomePageTittle() {

		return driver.getTitle();

	}

}

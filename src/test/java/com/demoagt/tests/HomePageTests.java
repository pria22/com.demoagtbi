package com.demoagt.tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class HomePageTests extends BaseTest {

	@Test
	public void testHomePageTittle() {
		logger=report.createTest("Validating HomePage Tittle");
		String expected = homepage.getHomePageTittle();
		Assert.assertTrue(expected.contains("Home"));
	}

	@Test
	public void testContactUsFunctions()

	{
		logger=report.createTest("Test Filling Contact Us Form");
		homepage.enterFirstName("Priya");
		logger.pass("entered firstname");
		homepage.enterLastName("Bassi");
		logger.pass("entered lastname");
		homepage.enterYourMail("p.anand2217@gmail.com");
		logger.pass("entered email");
		homepage.enterPhoneNumber("67892000");
		logger.pass("entered mobilenumber");
		homepage.enterWebAddress("http://www.priya.com");
		logger.pass("entered webaddress");
		homepage.enterService();
		logger.pass("entered service");
		homepage.enterDropDownOption();
		logger.pass("entered dropdownoption");
		homepage.enterMessage("Selenium Automation");
		logger.pass("entered message");

	}
	
	@Test
	public void testBrokenLinks() throws MalformedURLException, IOException 
	{
		logger=report.createTest("Checking Broken Links");
		List<WebElement> links = driver.findElements(By.cssSelector("li[id*=\"menu-item\"] a"));
		SoftAssert a = new SoftAssert();
		for(WebElement link:links)
			
		{
			String url = link.getAttribute("href");
		    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with text " +link.getText() + " is broken with code "+respCode);
		}
		
		a.assertAll();
	}
}

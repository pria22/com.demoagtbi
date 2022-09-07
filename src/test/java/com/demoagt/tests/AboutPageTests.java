package com.demoagt.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;





public class AboutPageTests extends BaseTest {

	@Test
	public void selectMenu() throws IOException {
		logger=report.createTest("Using Actions Class");
	             
		aboutpage.clickAboutTab();
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//span[normalize-space()='About']"));
		a.moveToElement(move).build().perform();
		
		aboutpage.clickCompanyOverview();
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType .FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\piaan\\screenshot.png"));

	}

	@Test
	public void getCurrentPageTittle() throws IOException {
		
		logger=report.createTest("Validating AboutPage Tittle");
		String expected = aboutpage.getAboutPageTittle();

		Assert.assertTrue(expected.contains("Company"));
		



	}
}

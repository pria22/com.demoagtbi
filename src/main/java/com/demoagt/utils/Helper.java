package com.demoagt.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.demoagt.base.DriverScript;

public class Helper extends DriverScript {
	
	public static String captureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath="C:\\WORKSPACE\\com.demoagtbi\\reports\\screenshots\\act.png";
		try {
			FileHandler.copy(src,new File(screenshotpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotpath;
	}
	
	
	
	
	
	
	
	public static void sleep()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
	}

}

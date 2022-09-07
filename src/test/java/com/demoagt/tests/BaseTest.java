package com.demoagt.tests;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.demoagt.base.DriverScript;
import com.demoagt.pages.AboutPage;
import com.demoagt.pages.HomePage;
import com.demoagt.utils.Helper;

public class BaseTest extends DriverScript {
	protected static ExtentReports report;
	protected static ExtentTest logger;
	AboutPage aboutpage;
	HomePage homepage;
	
	
	
	
    @BeforeSuite
	public void setReport() {
    	ExtentHtmlReporter extend = new ExtentHtmlReporter("./reports/index.html");
    	report = new ExtentReports();
    	report.attachReporter(extend);
		
	}
	
	@BeforeMethod
	public void setUP() {
		initApplication();
		homepage = new HomePage();
		aboutpage = new AboutPage();
	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				logger.fail("Test Failed", 
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		report.flush();
		Helper.sleep();
        quitDriver();

	}

}

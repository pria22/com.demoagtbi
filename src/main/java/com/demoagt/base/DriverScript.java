package com.demoagt.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverScript {

	public static WebDriver driver;
	Properties prop;

	public DriverScript() {
		try {

			File file = new File("./config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("unable to load properties file: " + e.getMessage());
		}
	}

	public void initApplication() {
		String browser = prop.getProperty("browser");

		if (browser.trim().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./browser/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.trim().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./browser/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.trim().equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./browser/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		else {
			System.out.println("Browser name provided is not supported.Please  check config file");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		getURL();

	}

	public void getURL() {
		String url = prop.getProperty("url");
		driver.get(url);
	}

	public void quitDriver() {
		driver.close();
	}
}

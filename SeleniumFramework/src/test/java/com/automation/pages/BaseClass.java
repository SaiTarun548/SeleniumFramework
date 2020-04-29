package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.automation.utilities.BrowserCall;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Reusable;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();	
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM"+Reusable.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Parameters({"BrowserCall","AppURL"})
	@BeforeClass
	public void setup(String browser, String url) {
		
	//	driver = BrowserCall.startApplication(driver, config.getBrowser(), config.getURL());
		
		driver = BrowserCall.startApplication(driver, browser, url);
	}
	
	
	@AfterClass
	public void teardown() {
		
		BrowserCall.quitBrowser(driver);
	}
	
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		try {
			
		if(result.getStatus() == ITestResult.FAILURE) {
			
					logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Reusable.captureScreenshot(driver)).build());
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Reusable.captureScreenshot(driver)).build());
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(Reusable.captureScreenshot(driver)).build());
		}
	}catch (IOException e) {
		
	System.out.println("Exception occured during screenshot" + e.getMessage());
	}
		report.flush();	
  }
}

package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;


public class LoginTestCRM extends BaseClass {
	
	@Test
	public void loginApp(){
		
		logger = report.createTest("Login to CRM");
		
		System.out.println(driver.getTitle());
		
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		
		logger.info("Starting Application");
		
		loginPage.login(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));	
		
		logger.pass("Login Successful");
	}
	
}


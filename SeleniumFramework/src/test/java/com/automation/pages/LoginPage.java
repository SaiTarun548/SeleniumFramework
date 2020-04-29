package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
		
	@FindBy(name="username") WebElement Uname;
	
	@FindBy(name="password") WebElement passwrd;
	
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;
	
	
	public void login(String username, String pass) {
		Uname.sendKeys(username);
		passwrd.sendKeys(pass);
		loginButton.click();
	}
}

package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserCall {
	
	public static WebDriver startApplication(WebDriver driver, String browsername, String appURL) {
		
		if(browsername.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browsername.equals("FireFox")) {
			
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browsername.equals("IE")) {
			
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("Browser is not supported, please select Chrome/FireFox/IE browser");
		}
		

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		return driver;
	}

	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}
}


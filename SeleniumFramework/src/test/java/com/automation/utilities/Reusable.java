package com.automation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Reusable {

	public static String captureScreenshot(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Screenshotpath = System.getProperty("user.dir")+"\\Screenshot\\"+ getCurrentDateTime() +".png";
		try {
			
			FileHandler.copy(src, new File(""));
			System.out.println("Screenshot Captured");
		
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+ e.getMessage());
		}
		
		return Screenshotpath;
	}
	
	
	public static String getCurrentDateTime() {
		
		DateFormat CSformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date CurrentDate = new Date();
		
		return CSformat.format(CurrentDate);
	}
	
}

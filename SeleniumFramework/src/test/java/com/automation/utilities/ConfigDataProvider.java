package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties property;
	
	
	public ConfigDataProvider() {
		
		File src = new File("./Config/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			property = new Properties();
			property.load(fis);
			
		} catch (Exception e) {
			
			System.out.println("Not able to load config file" + e.getMessage());
		}
	}
	
	
	public String getDataFromConfig(String KeytoSearch) {
		
		return property.getProperty(KeytoSearch);
		
	}
	
	public String getBrowser() {
		
		return property.getProperty("Browser");
	}
	
	public String getURL() {
		
		return property.getProperty("qaURL");
	}
}

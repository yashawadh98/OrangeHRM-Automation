package com.yash.automationFramework.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties;
	
	public static Properties loadProperties() {
		if(properties==null) {
			try {
				FileInputStream fis=new FileInputStream("src/test/resources/config.properties");
				properties=new Properties();
				properties.load(fis);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
	
	public static String get(String key) {
		return loadProperties().getProperty(key);
	}

}

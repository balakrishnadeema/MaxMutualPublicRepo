package com.massmutual.automation.utility;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesFile {
	
	public static String GetProperty(String Key) {
		String ProjectPath = System.getProperty("user.dir");
		String runAgainst = "";
		try {
			String envFilePath = ProjectPath+"src/test/resources/"+runAgainst.toUpperCase()+".properties";
			FileReader reader = new FileReader(envFilePath);
			Properties properties = new Properties();
			properties.load(reader);
			properties.getProperty(Key);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

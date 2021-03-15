package com.massmutual.automation.pagespecificlibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.massmutual.automation.utility.PropertiesFile;
import com.massmutual.automation.utility.utility;

public class LoginImplementation{
	
	WebDriver driver;
	
	By username_input = By.id("username");
	By password_input = By.id("password");
	By sigin_btn = By.id("signin");
	
	public LoginImplementation(WebDriver driver) {
		this.driver = driver;
	}

	public void NavigateTo() {
		try {
			String url = PropertiesFile.GetProperty("URL");
			driver.get(url);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void LoginToApplication() {
		try {
			String username = PropertiesFile.GetProperty("USERNAME");
			String password = PropertiesFile.GetProperty("PASSWORD");
			utility.setText(username_input, username);
			utility.setText(password_input, password);
			utility.click(sigin_btn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

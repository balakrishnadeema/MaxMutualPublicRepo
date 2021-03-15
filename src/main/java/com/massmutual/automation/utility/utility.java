package com.massmutual.automation.utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.massmutual.automation.cucumberRunner.Base;

public class utility extends Base{
	
	public static List<WebElement> findElements(By by){
		try {
			waitUntilElementVisible(by, 10);
			return driver.findElements(by);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void waitUntilElementVisible(By by, int maxTimeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, maxTimeOut);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void click(By by) {
		try {
			waitUntilElementVisible(by, 10);
			WebElement ele = driver.findElement(by);
			ele.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setText(By by, String text) {
		try {
			waitUntilElementVisible(by, 10);
			driver.findElement(by).sendKeys(text);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getText(By by) {
		try {
			waitUntilElementVisible(by, 10);
			return driver.findElement(by).getText();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getText(WebElement ele) {
		try {
			return ele.getText();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

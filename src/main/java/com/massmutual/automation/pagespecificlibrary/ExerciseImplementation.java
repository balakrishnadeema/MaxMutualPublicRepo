package com.massmutual.automation.pagespecificlibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.massmutual.automation.cucumberRunner.Base;
import com.massmutual.automation.utility.RunStatus;
import com.massmutual.automation.utility.utility;

public class ExerciseImplementation {
	
	WebDriver driver;
	
	By value1_label = By.id("lbl_value_1");
	By value1_text = By.id("txt_value_1");
	By value2_label = By.id("lbl_value_2");
	By value2_text = By.id("txt_value_2");
	By value3_label = By.id("lbl_value_3");
	By value3_text = By.id("txt_value_3");
	By value4_label = By.id("lbl_value_4");
	By value4_text =  By.id("txt_value_4");
	By value5_label = By.id("lbl_value_5");
	By value5_text = By.id("txt_value_5");
	By value_total_label = By.id("lbl_ttl_value");
	By value_total_text= By.id("txt_ttl_value");
	By all_labels_by = By.xpath("//*[contains(@id,'lbl_value')]");
	By all_text = By.xpath("//*[contains(@id,'txt_value')]");
	
	public ExerciseImplementation(WebDriver driver) {
		this.driver=driver;
	}
	
	public void verifyRightCountOfValues() {
		List<WebElement> all_labels = new ArrayList<WebElement>();
		List<String> all_label_values = new ArrayList<String>();
		boolean flag=false;
		try {
			all_labels = utility.findElements(all_labels_by);
			
			for(int i=1; i<=all_labels.size(); i++) {
				all_label_values.add(all_labels.get(i).getText());
				if(utility.getText(all_labels.get(i)).equals("Value "+i))
					flag=true;
				else {
					flag=false;
					break;
				}
			}
			if(flag)
				Base.addResult("Verify the right count of values appear", "Verify the right count of values appear", "Right count of values should appear", "Right count of values are appeared: "+all_label_values, RunStatus.PASS);
			else
				Base.addResult("Verify the right count of values appear", "Verify the right count of values appear", "Right count of values should appear", "Right count of values are not appeared: "+all_label_values, RunStatus.FAIL);
		}catch(Exception e) {
			Base.addResult("Verify the right count of values appear", "Verify the right count of values appear", "Right count of values should appear", "Exception has occured: "+e.getMessage(), RunStatus.FAIL);
			e.printStackTrace();
		}
	}

	public void verifyValuesGreaterThanZero() {
		List<WebElement> all_txt_values = new ArrayList<WebElement>();
		try {
			all_txt_values = utility.findElements(all_text);
			
			for(int i=0; i<all_txt_values.size(); i++) {
				Double value = Double.parseDouble(utility.getText(all_txt_values.get(i)).replace("$", ""));
				
				if(value>0)
					Base.addResult("Verify the value: "+value+" is greater than zero", "Verify the value: "+value+" is greater than zero", value+" should be greater than zero", value+" is greater than zero", RunStatus.PASS);
				else
					Base.addResult("Verify the value: "+value+" is greater than zero", "Verify the value: "+value+" is greater than zero", value+" should be greater than zero", value+" is not greater than zero", RunStatus.FAIL);
			}
		}catch(Exception e) {
			Base.addResult("Verify the values are greater than zero", "Verify the values are greater than zero", "Values should be greater than zero", "Exception has occured: "+e.getMessage(), RunStatus.FAIL);
			e.printStackTrace();
		}
	}
	
	public Double sumOfAllValues() {
		List<WebElement> all_txt_values = new ArrayList<WebElement>();
		Double total = 0.0;
		try {
			all_txt_values = utility.findElements(all_text);
			
			for(int i=0; i<all_txt_values.size(); i++) {
				String s = utility.getText(all_txt_values.get(i)).replace("$", "").replace(",", "");
				total = total+Double.parseDouble(s);
			}
			return total;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public void VerifySumOfAllValuesEqualToToalBalance() {
		try {
			Double sumOfAllValues = sumOfAllValues();
			Double totalBalance = Double.parseDouble(utility.getText(value_total_text).replace("$", "").replace(",", ""));
			Base.addResult("Verify Total Balance is matched with sum of all given values", "Verify Total Balance is matched with sum of all given values", "Total balance should match with sum of all values", "Total balance is matched with sum of all values", RunStatus.PASS);
			
			if(sumOfAllValues==totalBalance)
				Base.addResult("Verify Total Balance is matched with sum of all given values", "Verify Total Balance is matched with sum of all given values", "Total balance should match with sum of all values", "Total balance is matched with sum of all values", RunStatus.PASS);
			else
				Base.addResult("Verify Total Balance is matched with sum of all given values", "Verify Total Balance is matched with sum of all given values", "Total balance should match with sum of all values", "Total balance is not matched with sum of all values", RunStatus.FAIL);
		}catch(Exception e) {
			Base.addResult("Verify Total Balance is matched with sum of all given values", "Verify Total Balance is matched with sum of all given values", "Total balance should match with sum of all values", "Exception has occured: "+e.getMessage(), RunStatus.FAIL);
			e.printStackTrace();
		}
	}
	
	public boolean isCurrencyFormat(String value) {
		try{
			value = value.replace("$", "").trim();
			Pattern p = Pattern.compile("^(?:0|[1-9]\\d{0,2}(?:\\,\\d{3})*).\\d{2}$");
			Matcher m = p.matcher(value);
			if(m.matches())
				return true;
			else
				return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void verifyAllValuesFormattedAsCurrrencies() {
		List<WebElement> all_txt_values = new ArrayList<WebElement>();
		try {
			all_txt_values = utility.findElements(all_text);
			for(int i=0; i<all_txt_values.size(); i++) {
				if(isCurrencyFormat(utility.getText(all_txt_values.get(i))))
					Base.addResult("Verify the value "+all_txt_values.get(i).getText()+" is currency formated", "Verify the value "+all_txt_values.get(i).getText()+" is currency formated", all_txt_values.get(i).getText()+" should be currency formated", all_txt_values.get(i).getText()+" is currency formated", RunStatus.PASS);
				else
					Base.addResult("Verify the value "+all_txt_values.get(i).getText()+" is currency formated", "Verify the value "+all_txt_values.get(i).getText()+" is currency formated", all_txt_values.get(i).getText()+" should be currency formated", all_txt_values.get(i).getText()+" is not currency formated", RunStatus.FAIL);
			}
		}catch(Exception e) {
			Base.addResult("Verify the values are currency formated", "Verify the values are currency formated", "Values should be currency formated", "Exception has occured: "+e.getMessage(), RunStatus.FAIL);
			e.printStackTrace();
		}
	}
	
}

package com.massmutual.automation.cucumberRunner;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.runtime.ClassFinder;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;

public class Base {

	public static String SuiteName;
	public static String FeatureName;
	public static String TestName;
	public static String ScenarioName;
	public static String RunAgainst;
	public static String browser;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public static void getDriver() {
		try {
			String ProjectPath = System.getProperty("user.dir");
			if(Base.browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", ProjectPath+"src/test/resources/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if(Base.browser.equals("Firefox")) {
				
			}else
				System.out.println("Specified browser is not found");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	public void RunningOfCukes(String[] argv) {
		byte exitstatus = run(argv, Thread.currentThread().getContextClassLoader());
	}
	
	public static byte run(String[] argv, ClassLoader classLoader) {
		cucumber.runtime.Runtime runtime = null;
		try {
			RuntimeOptions runtimeOptions = new RuntimeOptions(new ArrayList<String>(java.util.Arrays.asList(argv)));
			ResourceLoader resourceLoader = new MultiLoader(classLoader);
			ClassFinder classFinder = new ResourceLoaderClassFinder(resourceLoader, classLoader);
			runtime = new cucumber.runtime.Runtime(resourceLoader, classFinder, classLoader, runtimeOptions);
			runtime.run();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return runtime.exitStatus();
	}
	
	public ExtentReports getCucumberReport() {
		String cucumberReport = System.getProperty("user.dir")+"\\test-output"+SuiteName;
		if(extent == null) {
			extent = new ExtentReports(cucumberReport);
			extent.addSystemInfo("Environment", Base.RunAgainst);
			extent.addSystemInfo("Browser", browser);
			extent.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/etent-config.xml"));
		}
		return extent;
	}
	
	public static void endCucumberTestReport() {
		extent.endTest(extentTest);
		extent.flush();
	}
	
	public static ExtentTest startCucumberTestReport(String testName) {
		extentTest = extent.startTest(testName).assignCategory(TestName);
		return extentTest;
	}
	
	public static void addResult(String testcase, String testdesc, String expected, String actual, byte status) {
		if(status==0) {
			System.out.println("***** Test Step PASSED: "+testcase);
			extentTest.log(LogStatus.FAIL, "<b>TEST CASE:</b>"+testcase+"\n<br><b>DESCRIPTION:</b>"+testdesc+" \n<br><b>Expected:</b>"+expected+"\t\r <b>ACTUAL:</b>"+actual);
		}else {
			System.out.println("***** Test Step FAILED: "+testcase);
			extentTest.log(LogStatus.PASS, "<b>TEST CASE:</b>"+testcase+"\n<br><b>DESCRIPTION:</b>"+testdesc+" \n<br><b>Expected:</b>"+expected+"\t\r <b>ACTUAL:</b>"+actual);
		}
	}
}

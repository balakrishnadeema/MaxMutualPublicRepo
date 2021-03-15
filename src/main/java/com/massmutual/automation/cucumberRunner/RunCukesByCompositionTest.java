package com.massmutual.automation.cucumberRunner;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class RunCukesByCompositionTest extends Base{

	@BeforeSuite
	public void beforeSuite(ITestContext istx) {
		try {
			System.err.println("********************* Before Suite - XML ***********************");
			Base.SuiteName = istx.getSuite().getName();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Parameters({"FeatureName", "RunAgainst", "Browser"})
	@BeforeTest
	public void beforeTest(ITestContext istx, String FeatureName, String RunAgainst, String browser) {
		try {
			System.err.println("********************* Before Test - XML ***********************");
			Base.FeatureName = FeatureName;
			Base.RunAgainst = RunAgainst;
			Base.browser = browser;
			startCucumberTestReport(FeatureName);
			getDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] OptionsSpecification(ITestContext istx) {
		List<String> runParams = new ArrayList<String>();
		try {
			String ProjectPath = System.getProperty("user.dir");
			runParams.add(ProjectPath+"src/main/resources/FeatureFiles/"+Base.FeatureName);
			runParams.add("--glue");
			runParams.add("classpath:com/massmutual/automation/stepdef");
			runParams.add("--glue");
			runParams.add("classpath:com/massmutual/automation/cucumberRunner");
			runParams.add("--plugin");
			runParams.add("json:target/cucumberReport.json");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return runParams.toArray(new String[runParams.size()]);
	}
	
	@Test
	public void runCukes(ITestContext istx) {
		try {
			System.err.println("********************* Test - XML ***********************");
			RunningOfCukes(OptionsSpecification(istx));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void BeforeScenario(Scenario scenario) {
		try {
			System.err.println("********************* Before Scenario - XML ***********************");
			Base.ScenarioName = scenario.getName();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest(ITestContext istx) {
		try {
			System.err.println("********************* After Test - XML ***********************");
			driver.close();
			driver.quit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void afterSuite(ITestContext istx) {
		try {
			System.err.println("********************* After Suite - XML ***********************");
			endCucumberTestReport();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

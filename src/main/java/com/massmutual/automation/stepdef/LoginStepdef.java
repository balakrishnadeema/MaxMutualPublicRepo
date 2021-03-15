package com.massmutual.automation.stepdef;

import com.massmutual.automation.cucumberRunner.Base;
import com.massmutual.automation.pagespecificlibrary.LoginImplementation;

import cucumber.api.java.en.Given;

public class LoginStepdef {

	
	LoginImplementation loginObj = new LoginImplementation(Base.driver);
	
	@Given("^I navigate to the application$")
	public void navigateToApp() {
		loginObj.NavigateTo();
	}
	
	@Given("^I sign to application with valid credentials$")
	public void signToApplication() {
		loginObj.LoginToApplication();
	}
}

package com.massmutual.automation.stepdef;

import com.massmutual.automation.cucumberRunner.Base;
import com.massmutual.automation.pagespecificlibrary.ExerciseImplementation;
import cucumber.api.java.en.Given;

public class ExerciseStepdef {
	
	ExerciseImplementation exerciseObj = new ExerciseImplementation(Base.driver);
	
	@Given("^I verify all values are greater than zero$")
	public void verifyAllValuesGreaterThanZero() {
		exerciseObj.verifyValuesGreaterThanZero();
	}	

	@Given("^I verify the summation of all values equal to the Total Balance$")
	public void verifySumOfAllValuesEqualToTotalBalances() {
		exerciseObj.VerifySumOfAllValuesEqualToToalBalance();
	}
	
	@Given("^I verify all the given values are in Currency Format$")
	public void verifyAllValuesAreCurrencyFormatted() {
		exerciseObj.verifyAllValuesFormattedAsCurrrencies();
	}
	
	@Given("^I verify the right count of vlaues appear$")
	public void verifyTheRightCountOfValues() {
		exerciseObj.verifyRightCountOfValues();;
	}
}

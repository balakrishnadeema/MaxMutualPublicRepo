#########################################################################
#Feature Name         : Exercise 1
#Created By           : Balakrishna Deema
#Modified By          : Balakrishna Deema
#Description          :
##########################################################################
Feature: Exercise1.feature

Scenario: Navigate to Application and login with valid user
	Given I navigate to the application
	When I sign to application with valid credentials
	
Scenario: Verify all given values are greater than zero
	Then I verify all values are greater than zero
	
Scenario: Verify the sum of all values equal to Total Balance
	Then I verify the summation of all values equal to the Total Balance
	
Scenario: Verify the given values are in Currency formated
	Then I verify all the given values are in Currency Format

Scenario: Verify the right count of values appear
	Then I verify the right count of vlaues appear
package com.testng;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.report.extentReport;

public class TripSummary extends SearchTest {
	
public static void String CommonUtils = null;
public static void String TripSummary = prop.getProperty("TripSummary");

	

	public TripSummary(WebDriver driver) {
	
}

	@Test()
	public void Detail(Object Prereq, Object logger, Object extentReport, Object Prereq1) throws InterruptedException {
		
		String testName = "Details";
		
		extentReport = com.report.extentReport.startTest(testName,  testName+" started");
		
		
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = Reporter.getRowTestData(TripSummary, testName);

		String name = testData.get("Name");
		String email = testData.get("EmailID");
		String phone = testData.get("MobileNumber");
		String additionalInfo = testData.get("AdditionalInfo");
		String expectedResult = testData.get("Expected Result").toLowerCase();
		String executionRequired = testData.get("Execution Required").toLowerCase();
		
		
		CommonUtils.logTestData(TripSummary, testName);
		
		
		CommonUtils.toCheckExecutionRequired(executionRequired);
		
		TripSummary tripSummaryPage = new TripSummary(driver);
		
		
		Prereq1.prereqTripSummary();
		logger.info("Prerequirement for trip summary was executed successfully");
		((Reporter) extentReport).log("Prerequirement for trip summary was executed successfully");
		
		TripSummary.enterName(name);
		logger.info(name+" was entered in name field");
		extentReport.log(LogStatus.INFO, name+" was entered in name field");
		
		TripSummary.Email(email);;
		logger.info(email+" was entered in email field");
		extentReport.log(LogStatus.INFO, email+" was entered in email field");
		
		TripSummary.Mobile(phone);;
		logger.info(phone+" Enter mobile number");
		extentReport.log(LogStatus.INFO, phone+" was entered in mobile number field");
		
		TripSummary.enterInfo(additionalInfo);
		logger.info(additionalInfo+" More Info entered");
		extentReport.log(LogStatus.INFO, additionalInfo+" was entered in additionalInfo field");
		
		TripSummary.clickOnButton();
		logger.info("Proceed button on trip summary page was clicked");
		((Reporter) extentReport).log(LogStatus.INFO, "Proceed button on trip summary page was clicked");
		
		String actualResult = driver.findElement(By.xpath("//*[text()=' Verify your mobile number']")).getText().toLowerCase();
		((Object) logger).info(actualResult+" was fetched from the verify otp");
		Reporter.log(actualResult+" was fetched from the verify otp");
		
		Assert.assertTrue(actualResult.contains(expectedResult), "Assertion on the verify otp text");

		
	}

	private static void clickOnButton() {
		// TODO Auto-generated method stub
		
	}

	private static void enterInfo(String additionalInfo) {
		// TODO Auto-generated method stub
		
	}

	private static void enterName(String name) {
		// TODO Auto-generated method stub
		
	}

	private static void Email(String email) {
		// TODO Auto-generated method stub
		
	}

	private static void Mobile(String phone) {
		// TODO Auto-generated method stub
		
	}


}

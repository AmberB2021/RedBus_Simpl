package com.testng;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.report.extentReport;

public class Bushomepage extends BaseTest {

	public void String sheetName = prop.getProperty("Bushomepage");

	@Test()
	public void HomePageLink(Object CommonUtils) {

		String testName = "Bushomepage";

		extentTest = extentReport.startTest(testName, testName + " started");

		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(sheetName, testName);

		String expectedTitle = testData.get("Expected Title");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String desc = testData.get("Description");

		CommonUtils.logTestData(sheetName, testName);

		CommonUtils.toCheckExecutionRequired(executionRequired);

		Bushomepage homePage = new Bushomepage(driver);

		homePage.Bushomepage();
		;
		logger.info("RPool was clicked");
		extentTest.log(LogStatus.INFO, "RPool was clicked");

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Title :" + actualTitle);
		extentTest.log(LogStatus.INFO, "Actual Title : " + actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");
		extentTest.log(LogStatus.INFO, desc);
	}
}

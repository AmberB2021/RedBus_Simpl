package com.testng;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.report.extentReport;

public class Bushomepage extends SearchTest {

	public void String sheetName = prop.getProperty("Bushomepage");

	@Test()
	public void HomePageLink(Object CommonUtils, Object logger, Object extentReport, Object driver) {

		String testName = "Bushomepage";

		extentReport = extentReport.startTest(testName, testName + " started");

		HashMap<String, String> testData = new HashMap<String, String>();
		testData = reader.getRowTestData(Bushomepage, testName);

		String expectedTitle = testData.get("Expected Title");
		String executionRequired = testData.get("Execution Required").toLowerCase();
		String desc = testData.get("Description");

		CommonUtils.logTestData(Bushomepage, testName);

		CommonUtils.ExecutionRequired(executionRequired);

		Bushomepage homePage = new Bushomepage(driver);

		homePage.Bushomepage();
		;
		logger.info("RPool was clicked");
		extentReport.log(LogStatus.INFO, "RPool was clicked");

		String actualTitle = driver.getTitle().toLowerCase();
		logger.info("Title :" + actualTitle);
		extentReport.log(LogStatus.INFO, "Actual Title : " + actualTitle);

		Assert.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()),
				"Assertion on actual and expected title of search page.");
		extentReport.log(LogStatus.INFO, desc);
	}

	public void clickLink() {
		// TODO Auto-generated method stub
		
	}
}

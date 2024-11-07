package org.tyss.flatworld.genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * ListenerImplementationClass implements TestNG's ITestListener interface 
 * to handle events during test execution. It manages the Extent Reports 
 * logging and screenshot capture for test results.
 */
public class ListenerImplementationClass implements ITestListener {

	/**
	 * Invoked when the test context is initialized. Sets up the Extent Reports.
	 * 
	 * @param context The current test context.
	 */
	@Override
	public void onStart(ITestContext context) {
		// Create ExtentSparkReporter to generate the HTML report
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\Execution_Reports\\Suite_Report_"
						+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()).toString() + ".html");

		sparkReporter.config().setDocumentTitle("Test Report");
		sparkReporter.config().setReportName("FlatWorld Automation Suite Report");
		sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);

		// Initialize ExtentReports
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Customer Name", "FlatWorld Solutions.");
		extentReports.setSystemInfo("Environment", "Production");

		// Retrieve browser information from XML configuration
		extentReports.setSystemInfo("User", "Dharshan");

		// Set the ExtentReports instance for future use
		UtilityObjectClass.setExtentReports(extentReports);
	}

	/**
	 * Invoked when a test method starts. Initializes the ExtentTest for the current test.
	 * 
	 * @param result The result of the test.
	 */
	@Override
	public void onTestStart(ITestResult result) {
		UtilityObjectClass.getExtentTest().assignAuthor("Dharshan");
		UtilityObjectClass.getExtentTest().assignCategory("Generic Test Scripts");
	}

	/**
	 * Invoked when a test method succeeds. Logs the success in the Extent Report.
	 * 
	 * @param result The result of the test.
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		UtilityObjectClass.getExtentTest().log(Status.PASS, "Test Passed");
	}

	/**
	 * Invoked when a test method fails. Logs the failure and captures a screenshot.
	 * 
	 * @param result The result of the test.
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		UtilityObjectClass.getExtentTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());
		String screenshotPath = getScreenshotAsBase64(UtilityObjectClass.getDriver());

		try {
			UtilityObjectClass.getExtentTest().addScreenCaptureFromBase64String(screenshotPath);
		} catch (Exception e) {
			UtilityObjectClass.getExtentTest().log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
		}
	}

	/**
	 * Invoked when a test method is skipped. Logs the skip status in the Extent Report.
	 * 
	 * @param result The result of the test.
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		UtilityObjectClass.getExtentTest().log(Status.SKIP, "Test Skipped");
	}

	/**
	 * Invoked after all tests have run. Flushes the Extent Reports and quits the driver.
	 * 
	 * @param context The current test context.
	 */
	@Override
	public void onFinish(ITestContext context) {
		UtilityObjectClass.getExtentReports().flush();
		if (UtilityObjectClass.getDriver() != null) {
			UtilityObjectClass.getDriver().quit();
		}
	}

	/**
	 * Captures a screenshot and returns it as a Base64 encoded string.
	 * 
	 * @param driver The WebDriver instance to capture the screenshot from.
	 * @return Base64 encoded string of the screenshot.
	 */
	public static String getScreenshotAsBase64(WebDriver driver) {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		return takeScreenshot.getScreenshotAs(OutputType.BASE64);
	}

	/**
	 * Converts a string to title case (first letter of each word capitalized).
	 * 
	 * @param input The input string to convert.
	 * @return The converted title case string.
	 */
	public static String convertToTitleCase(String input) {
		StringBuilder titleCase = new StringBuilder();
		boolean nextTitleCase = true;

		for (char c : input.toCharArray()) {
			if (Character.isUpperCase(c)) {
				titleCase.append(" ");
			}
			if (nextTitleCase) {
				c = Character.toTitleCase(c);
				nextTitleCase = false;
			} else {
				c = Character.toLowerCase(c);
			}

			titleCase.append(c);
		}
		return titleCase.toString().trim();
	}
}

package org.tyss.flatworld.genericutility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.tyss.flatworld.workflowutility.WorkflowUtility;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * Base class that sets up common configurations for test execution,
 * such as initializing utilities, setting up the browser, and handling
 * Jira integration for test case management.
 */
public class BaseClass {

	// Utilities for various operations like Excel, file handling, etc.
	public ExcelUtility excelUtility = new ExcelUtility();
	public FileUtility fileUtility = new FileUtility();
	public JavaUtility javaUtility = new JavaUtility();
	public JiraUtility jiraUtility = new JiraUtility();
	public AssertionUtility assertionUtility = new AssertionUtility();
	public RestAssuredUtility restAssuredUtility = new RestAssuredUtility();
	public WebDriverUtility webDriverUtility = new WebDriverUtility();
	public WorkflowUtility workflowUtility = new WorkflowUtility();

	// WebDriver instance for browser interaction
	public WebDriver driver;
	String cycleId;
	String browserName;
	
	@BeforeSuite
	public void configBeforeSuite() {
		// Create a new test cycle in Jira and set it for this test run
		cycleId = jiraUtility.createTestCycle("Cycle_" + javaUtility.getDateAndTimeInSpecifiedFormat("yyyyMMdd_HHmmss"));
		UtilityObjectClass.setCycleId(cycleId);
	}
	
	/**
	 * Configures the test method before executing each test case.
	 * Checks if the test case exists in Jira and logs the execution.
	 */
	@BeforeMethod
	public void configBeforeMethod(ITestResult result) {

		// Add use case to extentReport as ExtentTest
		ExtentTest extentTest = UtilityObjectClass.getExtentReports().createTest(javaUtility.convertToTitleCase(result.getMethod().getMethodName()));
		UtilityObjectClass.setExtentTest(extentTest);

		// Read browser name from property file
		browserName = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "BROWSER_NAME");
		UtilityObjectClass.setBrowserName(browserName);

		// Add Browser info to report
		UtilityObjectClass.getExtentReports().setSystemInfo("Browser Name", browserName);

		// Open the browser
		driver = webDriverUtility.openBrowserWindow(browserName);
		UtilityObjectClass.setDriver(driver);

		// Maximize browser window
		webDriverUtility.maximizeWindow(driver);

		// Navigate to URL
		String url = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "APP_URL");
		webDriverUtility.navigateToUrl(driver, url);

		// Set implicit wait time
		webDriverUtility.setImplicitWait(driver, IConstants.IMPLICIT_WAIT_TIME);

		// Sign in to the application
		String userId = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "APP_USERID");
		String password = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "APP_PASSWORD");
		workflowUtility.signInToApplication(userId, password);

		// Retrieve test case name and check Jira integration
		String testCaseName = result.getMethod().getMethodName();
		String testCaseId = jiraUtility.checkIfTestCaseExists(testCaseName);
		UtilityObjectClass.setTestCaseId(testCaseId);

		// Create a new test case in Jira if it does not exist
		if (testCaseId.isEmpty()) {
			testCaseId = jiraUtility.createTestCase(testCaseName);
		}

		System.out.println("Test Case: " + testCaseName + " execution has been triggered.");
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Executing test case: " + testCaseName);

	}

	/**
	 * Configures actions after each test method is executed.
	 * Updates the test case status in Jira based on the result.
	 */
	@AfterMethod
	public void configAfterMethod(ITestResult result) {
		// Retrieve cycle and test case IDs
		cycleId = UtilityObjectClass.getCycleId();
		String testCaseId = UtilityObjectClass.getTestCaseId();

		// Log the test result to Jira and extent report
		if (result.getStatus() == ITestResult.SUCCESS) {
			jiraUtility.addTestCaseToCycleAndUpdateResults(cycleId, testCaseId, "Pass", testCaseId);
			UtilityObjectClass.getExtentTest().log(Status.PASS, "Test case passed: " + testCaseId);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			jiraUtility.addTestCaseToCycleAndUpdateResults(cycleId, testCaseId, "Fail", testCaseId);
			UtilityObjectClass.getExtentTest().log(Status.FAIL, "Test case failed: " + testCaseId);
		} else if (result.getStatus() == ITestResult.SKIP) {
			jiraUtility.addTestCaseToCycleAndUpdateResults(cycleId, testCaseId, "Skip", testCaseId);
			UtilityObjectClass.getExtentTest().log(Status.SKIP, "Test case skipped: " + testCaseId);
		}

		System.out.println("*********Close Browser*********");
		try {
			if (driver != null) {
				driver.quit();
				UtilityObjectClass.getExtentTest().log(Status.INFO, "Browser closed successfully.");
			}
		} catch (Exception e) {
			UtilityObjectClass.getExtentTest().log(Status.FAIL, "Error while closing the browser: " + e.getMessage());
		}

	}
}

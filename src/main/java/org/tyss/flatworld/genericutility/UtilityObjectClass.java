package org.tyss.flatworld.genericutility;

import org.openqa.selenium.WebDriver;
import org.testng.xml.XmlTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * UtilityObjectClass is a utility class that leverages ThreadLocal variables to handle WebDriver instances,
 * Extent Reports, and other context-specific information like client name, browser name, and test case details
 * in a thread-safe manner. This class ensures that each thread has its own copy of the variables, making it suitable
 * for parallel test execution.
 */
public class UtilityObjectClass {

	// ThreadLocal variables to store WebDriver, XmlTest, ExtentReports, ExtentTest, and test-specific data
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<XmlTest> xmlTest = new ThreadLocal<XmlTest>();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	private static ThreadLocal<ExtentReports> extentReports = new ThreadLocal<ExtentReports>();
	private static ThreadLocal<String> cycleId = new ThreadLocal<String>();
	private static ThreadLocal<String> browserName = new ThreadLocal<String>();
	private static ThreadLocal<String> testCaseId = new ThreadLocal<String>();

	/**
	 * Retrieves the current WebDriver instance for the thread.
	 *
	 * @return WebDriver instance for the current thread.
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}

	/**
	 * Sets the WebDriver instance for the current thread.
	 *
	 * @param actDriver - The WebDriver instance to set.
	 */
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}

	/**
	 * Retrieves the XmlTest instance for the current thread, which holds information
	 * about the TestNG XML configuration.
	 *
	 * @return XmlTest instance for the current thread.
	 */
	public static XmlTest getXmlTest() {
		return xmlTest.get();
	}

	/**
	 * Sets the XmlTest instance for the current thread.
	 *
	 * @param actXmlTest - The XmlTest instance to set.
	 */
	public static void setXmlTest(XmlTest actXmlTest) {
		xmlTest.set(actXmlTest);
	}

	/**
	 * Retrieves the ExtentTest instance for the current thread, used for logging
	 * test execution steps in the Extent Report.
	 *
	 * @return ExtentTest instance for the current thread.
	 */
	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	/**
	 * Sets the ExtentTest instance for the current thread.
	 *
	 * @param actExtentTest - The ExtentTest instance to set.
	 */
	public static void setExtentTest(ExtentTest actExtentTest) {
		extentTest.set(actExtentTest);
	}

	/**
	 * Retrieves the ExtentReports instance for the current thread, which represents
	 * the complete report for the entire test execution.
	 *
	 * @return ExtentReports instance for the current thread.
	 */
	public static ExtentReports getExtentReports() {
		return extentReports.get();
	}

	/**
	 * Sets the ExtentReports instance for the current thread.
	 *
	 * @param actExtentReports - The ExtentReports instance to set.
	 */
	public static void setExtentReports(ExtentReports actExtentReports) {
		extentReports.set(actExtentReports);
	}

	/**
	 * Retrieves the cycle ID for the current thread, typically used for test cycle identification.
	 *
	 * @return The cycle ID for the current thread.
	 */
	public static String getCycleId() {
		return cycleId.get();
	}

	/**
	 * Sets the cycle ID for the current thread.
	 *
	 * @param actCycleId - The cycle ID to set.
	 */
	public static void setCycleId(String actCycleId) {
		cycleId.set(actCycleId);
	}

	/**
	 * Retrieves the browser name for the current thread, which can be useful when running tests
	 * on multiple browsers.
	 *
	 * @return The browser name for the current thread.
	 */
	public static String getBrowserName() {
		return browserName.get();
	}

	/**
	 * Sets the browser name for the current thread.
	 *
	 * @param actBrowserName - The browser name to set.
	 */
	public static void setBrowserName(String actBrowserName) {
		browserName.set(actBrowserName);
	}

	/**
	 * Retrieves the test case ID for the current thread, which helps in tracking individual test cases.
	 *
	 * @return The test case ID for the current thread.
	 */
	public static String getTestCaseId() {
		return testCaseId.get();
	}

	/**
	 * Sets the test case ID for the current thread.
	 *
	 * @param actTestCaseId - The test case ID to set.
	 */
	public static void setTestCaseId(String actTestCaseId) {
		testCaseId.set(actTestCaseId);
	}
}

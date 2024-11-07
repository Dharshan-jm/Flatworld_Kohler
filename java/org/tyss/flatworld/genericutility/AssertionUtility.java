package org.tyss.flatworld.genericutility;

import org.testng.Assert;

/**
 * This Utility class is used to handle various assertions with added logging to the Extent Report.
 * Each assertion logs the result (pass or fail) along with a custom message to the Extent Report.
 */
public class AssertionUtility {

	/**
	 * Asserts that a condition is true.
	 * If the assertion passes, logs a pass message to the Extent Report.
	 * If it fails, logs a fail message with details and throws the assertion error.
	 * 
	 * @param condition - The condition to evaluate.
	 * @param message - The message to display in the report.
	 */
	public void assertTrue(boolean condition, String message) {
		try {
			Assert.assertTrue(condition, message);
			UtilityObjectClass.getExtentTest().pass(message + " - Passed");
		} catch (AssertionError e) {
			UtilityObjectClass.getExtentTest().fail(message + " - Failed. " + e.getMessage());
			throw e;
		}
	}
	
	/**
	 * Asserts that a condition is false.
	 * If the assertion passes, logs a pass message to the Extent Report.
	 * If it fails, logs a fail message with details and throws the assertion error.
	 * 
	 * @param condition - The condition to evaluate.
	 * @param message - The message to display in the report.
	 */
	public void assertFalse(boolean condition, String message) {
		try {
			Assert.assertFalse(condition, message);
			UtilityObjectClass.getExtentTest().pass(message + " - Passed");
		} catch (AssertionError e) {
			UtilityObjectClass.getExtentTest().fail(message + " - Failed. " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Asserts that two objects are equal.
	 * If the assertion passes, logs a pass message to the Extent Report.
	 * If it fails, logs a fail message with expected and actual values and throws the assertion error.
	 * 
	 * @param actual - The actual value.
	 * @param expected - The expected value.
	 * @param message - The message to display in the report.
	 */
	public void assertEquals(Object actual, Object expected, String message) {
		try {
			Assert.assertEquals(actual, expected, message);
			UtilityObjectClass.getExtentTest().pass(message + " - Passed");
		} catch (AssertionError e) {
			UtilityObjectClass.getExtentTest().fail(message + " - Failed. Expected: " + expected + ", but got: " + actual);
			throw e;
		}
	}

	/**
	 * Asserts that two objects are not equal.
	 * If the assertion passes, logs a pass message to the Extent Report.
	 * If it fails, logs a fail message with the actual and expected values and throws the assertion error.
	 * 
	 * @param actual - The actual value.
	 * @param expected - The expected value.
	 * @param message - The message to display in the report.
	 */
	public void assertNotEquals(Object actual, Object expected, String message) {
		try {
			Assert.assertNotEquals(actual, expected, message);
			UtilityObjectClass.getExtentTest().pass(message + " - Passed");
		} catch (AssertionError e) {
			UtilityObjectClass.getExtentTest().fail(message + " - Failed. Expected not to be: " + expected + ", but got: " + actual);
			throw e;
		}
	}

	/**
	 * Asserts that an object is null.
	 * If the assertion passes, logs a pass message to the Extent Report.
	 * If it fails, logs a fail message with the non-null object and throws the assertion error.
	 * 
	 * @param object - The object to check.
	 * @param message - The message to display in the report.
	 */
	public void assertNull(Object object, String message) {
		try {
			Assert.assertNull(object, message);
			UtilityObjectClass.getExtentTest().pass(message + " - Passed");
		} catch (AssertionError e) {
			UtilityObjectClass.getExtentTest().fail(message + " - Failed. Object was expected to be null, but was: " + object);
			throw e;
		}
	}

	/**
	 * Asserts that an object is not null.
	 * If the assertion passes, logs a pass message to the Extent Report.
	 * If it fails, logs a fail message and throws the assertion error.
	 * 
	 * @param object - The object to check.
	 * @param message - The message to display in the report.
	 */
	public void assertNotNull(Object object, String message) {
		try {
			Assert.assertNotNull(object, message);
			UtilityObjectClass.getExtentTest().pass(message + " - Passed");
		} catch (AssertionError e) {
			UtilityObjectClass.getExtentTest().fail(message + " - Failed. Object was expected to be non-null, but was null");
			throw e;
		}
	}

	/**
	 * Asserts that two objects refer to the same object.
	 * If the assertion passes, logs a pass message to the Extent Report.
	 * If it fails, logs a fail message with expected and actual objects and throws the assertion error.
	 * 
	 * @param actual - The actual object.
	 * @param expected - The expected object.
	 * @param message - The message to display in the report.
	 */
	public void assertSame(Object actual, Object expected, String message) {
		try {
			Assert.assertSame(actual, expected, message);
			UtilityObjectClass.getExtentTest().pass(message + " - Passed");
		} catch (AssertionError e) {
			UtilityObjectClass.getExtentTest().fail(message + " - Failed. Objects are not the same. Expected: " + expected + ", but got: " + actual);
			throw e;
		}
	}

	/**
	 * Asserts that two objects do not refer to the same object.
	 * If the assertion passes, logs a pass message to the Extent Report.
	 * If it fails, logs a fail message indicating that the objects are the same and throws the assertion error.
	 * 
	 * @param actual - The actual object.
	 * @param expected - The expected object.
	 * @param message - The message to display in the report.
	 */
	public void assertNotSame(Object actual, Object expected, String message) {
		try {
			Assert.assertNotSame(actual, expected, message);
			UtilityObjectClass.getExtentTest().pass(message + " - Passed");
		} catch (AssertionError e) {
			UtilityObjectClass.getExtentTest().fail(message + " - Failed. Objects are the same. Expected them to be different.");
			throw e;
		}
	}

	/**
	 * Fails a test with a custom message, logging the failure to the Extent Report.
	 * 
	 * @param message - The failure message to display in the report.
	 */
	public void fail(String message) {
		try {
			Assert.fail(message);
		} catch (AssertionError e) {
			UtilityObjectClass.getExtentTest().fail(message + " - Failed intentionally. " + e.getMessage());
			throw e;
		}
	}
}

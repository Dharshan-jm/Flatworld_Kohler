package org.tyss.flatworld.genericutility;

/**
 * This interface contains constant values that are used across the framework.
 * It includes file paths, wait times, and other fixed data to maintain consistency 
 * and avoid hardcoding values in the codebase.
 */
public interface IConstants {

	/**
	 * Path to the properties file containing common configuration data.
	 * This file is used to store global test data and settings.
	 */
	String PROPERTY_FILE_PATH = ".\\src\\test\\resources\\TestDataFiles\\CommonData.properties";

	/**
	 * Path to the Excel file containing specific test data.
	 * This file is used to store scenario-specific test cases and inputs.
	 */
	String EXCEL_FILE_PATH = ".\\src\\test\\resources\\TestDataFiles\\SpecificData.xlsx";

	/**
	 * Default implicit wait time in seconds for locating elements in Selenium.
	 * This is the global timeout period to wait when searching for an element 
	 * before throwing a `NoSuchElementException`.
	 */
	int IMPLICIT_WAIT_TIME = 10;

	/**
	 * Default explicit wait time in seconds for conditions in Selenium.
	 * This is the timeout period for explicit waits to check certain conditions 
	 * (like visibility or clickability) of elements.
	 */
	int EXPLICIT_WAIT_TIME = 10;
}

package org.tyss.flatworld.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This Utility is used to interact with property files
 */
public class FileUtility {

	/**
	 * This method is used to fetch the data from a Property File
	 * @param filePath - Path to the property file
	 * @param key - Key for which value needs to be fetched
	 * @return - Value associated with the given key
	 */
	public String getDataFromPropertyFile(String filePath, String key) {
		Properties properties = new Properties();

		// Try-with-resources to ensure FileInputStream is closed properly
		try (InputStream inputStream = new FileInputStream(filePath)) {
			properties.load(inputStream);
			String value = properties.getProperty(key).trim();

			// Log success message in Extent Report
			UtilityObjectClass.getExtentTest().pass("Successfully fetched value for key '" + key + "' from file: " + filePath);
			return value;

		} catch (FileNotFoundException e) {
			String errorMsg = "File not found: " + filePath;
			UtilityObjectClass.getExtentTest().fail(errorMsg + ". Exception: " + e.getMessage());
			e.printStackTrace();

		} catch (IOException e) {
			String errorMsg = "Error reading file: " + filePath;
			UtilityObjectClass.getExtentTest().fail(errorMsg + ". Exception: " + e.getMessage());
			e.printStackTrace();

		} catch (NullPointerException e) {
			String errorMsg = "Key '" + key + "' not found in file: " + filePath;
			UtilityObjectClass.getExtentTest().fail(errorMsg + ". Exception: " + e.getMessage());
			e.printStackTrace();
		}
		
		// Return null if something went wrong
		return null;
	}
}

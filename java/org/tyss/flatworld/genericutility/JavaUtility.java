package org.tyss.flatworld.genericutility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * This Utility class provides common Java-based utility methods,
 * such as generating random numbers, strings, and fetching system details.
 */
public class JavaUtility {

	/**
	 * This method returns the current date and time in a specified format.
	 * 
	 * @param format - The desired date-time format (e.g., "yyyy-MM-dd HH:mm:ss").
	 * @return The formatted date-time string.
	 */
	public String getDateAndTimeInSpecifiedFormat(String format) {
		String dateTime = new SimpleDateFormat(format).format(new Date()).toString();
		UtilityObjectClass.getExtentTest().info("Fetched current date and time in format: " + format + " -> " + dateTime);
		return dateTime;
	}

	/**
	 * Generates a random number within a specified range.
	 * 
	 * @param range - The upper bound for the random number (exclusive).
	 * @return A random integer from 0 (inclusive) to the specified range (exclusive).
	 */
	public int getRandomNumber(int range) {
		int randomNumber = new Random().nextInt(range);
		UtilityObjectClass.getExtentTest().info("Generated random number within range 0 to " + (range - 1) + " -> " + randomNumber);
		return randomNumber;
	}

	/**
	 * Retrieves the current project directory path.
	 * 
	 * @return The absolute path of the current project directory.
	 */
	public String getCurrentProjectDirectory() {
		String projectDir = System.getProperty("user.dir");
		UtilityObjectClass.getExtentTest().info("Fetched current project directory: " + projectDir);
		return projectDir;
	}

	/**
	 * Generates a random alphanumeric string of a specified length.
	 * 
	 * @param numberOfCharacters - The desired length of the random string.
	 * @return A randomly generated alphanumeric string of length n.
	 */
	public String getRandomAlphaNumericString(int numberOfCharacters) {
		String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(numberOfCharacters);

		for (int i = 0; i < numberOfCharacters; i++) {
			int index = (int) (alphaNumericString.length() * Math.random());
			sb.append(alphaNumericString.charAt(index));
		}

		String randomString = sb.toString();
		UtilityObjectClass.getExtentTest().info("Generated random alphanumeric string of length " + numberOfCharacters + " -> " + randomString);
		return randomString;
	}

	/**
	 * Converts a string to title case (first letter of each word capitalized).
	 * 
	 * @param input The input string to convert.
	 * @return The converted title case string.
	 */
	public String convertToTitleCase(String input) {
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

	/**
	 * Used to get the value from map based on given key
	 * @param map
	 * @param key
	 * @return
	 */
	public String getValueFromTheMap(Map<String, String> map, String key) {
		return map.get(key);
	}
}

package org.tyss.flatworld.genericutility;

import org.json.JSONObject;

import com.aventstack.extentreports.Status;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JiraUtility {

	FileUtility fileUtility = new FileUtility();
	RestAssuredUtility restAssuredUtility = new RestAssuredUtility();

	// Fetching necessary data from property file
	String BASE_URI = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "BASE_URL");
	String PROJECT_KEY = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "PROJECT_KEY");
	String AUTH_TOKEN = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "AUTH_TOKEN");

	/**
	 * Create a new Test Cycle in Jira.
	 *
	 * @param cycleName Name of the cycle to be created
	 * @return The ID of the created test cycle
	 */
	public String createTestCycle(String cycleName) {
		// Creating the JSON request body
		JSONObject requestParams = new JSONObject();
		requestParams.put("projectKey", PROJECT_KEY);
		requestParams.put("name", cycleName);
		requestParams.put("description", "Test Cycle for Flatworld script execution.");

		// Sending the POST request to create a test cycle
		Response response = restAssuredUtility.sendPostRequest(BASE_URI, "testcycles", requestParams, 
				"Content-Type", "application/json", "Authorization", AUTH_TOKEN);

		// Validating the response status code
		boolean result = restAssuredUtility.validateStatusCode(response, 201);

		// Logging the result
		if (result) {
			String cycleId = response.jsonPath().getString("key");
			UtilityObjectClass.getExtentTest().log(Status.PASS, "Test cycle created successfully. Cycle ID: " + cycleId);
			//			System.out.println("Test cycle created with name: " + cycleName + ". Cycle Id: " + cycleId);
			return cycleId;
		} else {
			UtilityObjectClass.getExtentTest().log(Status.FAIL, "Failed to create test cycle. Status code: " + response.getStatusCode());
			System.err.println("Failed to create test cycle. Status code: " + response.getStatusCode());
			//			System.err.println("Response body: " + response.getBody().asString());
			return null;
		}
	}

	/**
	 * Adds a test case to a cycle and updates its execution result.
	 *
	 * @param testCaseName Name of the test case
	 * @param cycleId      The ID of the test cycle
	 * @param testCaseId   The ID of the test case
	 * @param status       The execution status (Pass, Fail, Skip)
	 */
	public void addTestCaseToCycleAndUpdateResults(String cycleId, String testCaseId, String status) {
		// Creating the JSON request body
		JSONObject requestParams = new JSONObject();
		requestParams.put("projectKey", PROJECT_KEY);
		requestParams.put("testCycleKey", cycleId);
		requestParams.put("testCaseKey", testCaseId);
		requestParams.put("statusName", status);

		// Sending the POST request to update the test case status
		Response response = restAssuredUtility.sendPostRequest(BASE_URI, "testexecutions", requestParams, 
				"Content-Type", "application/json", "Authorization", AUTH_TOKEN);

		// Validating the response status code
		boolean result = restAssuredUtility.validateStatusCode(response, 201);

		// Logging the result
		if (result) {
			UtilityObjectClass.getExtentTest().log(Status.PASS, "Test case updated successfully in cycle with status: " + status);
			//			System.out.println("Test Case with Issue Id: " + testCaseId + " added to the Cycle with status: " + status);
		} else {
			UtilityObjectClass.getExtentTest().log(Status.FAIL, "Failed to add test case to cycle. Status code: " + response.getStatusCode());
			System.err.println("Failed to add test case to cycle. Status code: " + response.getStatusCode());
			//			System.err.println("Response body: " + response.getBody().asString());
		}
	}

	/**
	 * Create a new Test Case in Jira.
	 *
	 * @param testCaseName The name of the test case to be created
	 * @return The ID of the created test case
	 */
	public String createTestCase(String testCaseName) {
		String testCaseId = "";

		// Creating the JSON request body
		JSONObject requestParams = new JSONObject();
		requestParams.put("projectKey", PROJECT_KEY);
		requestParams.put("name", testCaseName);

		// Sending the POST request to create a test case
		Response response = restAssuredUtility.sendPostRequest(BASE_URI, "testcases", requestParams, 
				"Content-Type", "application/json", "Authorization", AUTH_TOKEN);

		// Validating the response status code
		boolean result = restAssuredUtility.validateStatusCode(response, 201);

		// Logging the result
		if (result) {
			testCaseId = JsonPath.read(response.asString(), "$.key");
			UtilityObjectClass.getExtentTest().log(Status.PASS, "Test case created successfully. Test Case ID: " + testCaseId);
			//			System.out.println("Test Case is created.");
		} else {
			UtilityObjectClass.getExtentTest().log(Status.FAIL, "Failed to create test case. Status code: " + response.getStatusCode());
			System.err.println("Failed to create test case. Status code: " + response.getStatusCode());
			//			System.err.println("Response body: " + response.getBody().asString());
		}
		return testCaseId;
	}

	/**
	 * Check if a test case exists in Jira.
	 *
	 * @param testCaseName The name of the test case to search
	 * @return The ID of the test case if it exists, or an empty string if it doesn't
	 */
	public String checkIfTestCaseExists(String testCaseName) {
		String tcId = "";

		// Sending the GET request to retrieve existing test cases
		Response response = RestAssured.given().param("projectKey", PROJECT_KEY).header("Authorization", AUTH_TOKEN).when().get("testcases");

		//		Response response = restAssuredUtility.sendGetRequest(BASE_URI, "testcases", 
		//				 "Authorization", AUTH_TOKEN,"projectKey", PROJECT_KEY);

		// Validating the response status code
		boolean result = restAssuredUtility.validateStatusCode(response, 200);

		// Logging the result
		if (result) {
			int tcs = JsonPath.read(response.asString(), "$.values.length()");
			for (int i = 0; i < tcs; i++) {
				String tcName = JsonPath.read(response.asString(), "$.values[" + i + "].name");
				if (tcName.equals(testCaseName)) {
					tcId = JsonPath.read(response.asString(), "$.values[" + i + "].key");
					UtilityObjectClass.getExtentTest().log(Status.PASS, "Test case found with ID: " + tcId);
					break;
				}
			}
		} else {
			UtilityObjectClass.getExtentTest().log(Status.FAIL, "Failed to fetch test cases. Status code: " + response.getStatusCode());
			//			System.err.println("Response body: " + response.getBody().asString());
		}
		return tcId;
	}
}

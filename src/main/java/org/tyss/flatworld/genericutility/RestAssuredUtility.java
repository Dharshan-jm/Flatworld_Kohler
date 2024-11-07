package org.tyss.flatworld.genericutility;

import org.json.JSONObject;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This utility class provides methods for interacting with REST APIs
 * using the Rest Assured library. Each method is designed to be reusable 
 * for different API interactions.
 */
public class RestAssuredUtility {

	/**
	 * Sends a GET request to the specified endpoint with optional headers.
	 *
	 * @param url - The endpoint URL.
	 * @param headers - A map containing the request headers.
	 * @return The response object received from the GET request.
	 */
	public Response sendGetRequest(String baseUri, String endPoint, String... headers) {
		// Set Base URL
		RestAssured.baseURI = baseUri;
		
		// Initialize the RequestSpecification
		RequestSpecification request = RestAssured.given();

		// Log the URL being accessed to Extent Report
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Sending GET request to URL: " + baseUri+endPoint);

		// Validate headers: They must be in pairs (key-value)
		if (headers.length % 2 != 0) {
			throw new IllegalArgumentException("Headers must be in key-value pairs.");
		}

		// Add headers if they are provided
		for (int i = 0; i < headers.length; i += 2) {
			String headerKey = headers[i];
			String headerValue = headers[i + 1];
			request.header(headerKey, headerValue);

			// Log each header being sent to Extent Report
			UtilityObjectClass.getExtentTest().log(Status.INFO, "Header: " + headerKey + " = " + headerValue);
		}

		// Send GET request
		Response response = request.get(endPoint);

		// Log response details
		logResponseDetails(response, "GET");

		return response;
	}

	/**
	 * Send a POST request with dynamic headers using varargs.
	 *
	 * @param url the URL to which the POST request is sent.
	 * @param body the request body (payload) for the POST request.
	 * @param headers a varargs parameter where headers are passed as key-value pairs
	 *                (e.g., "Header1", "Value1", "Header2", "Value2").
	 * @return the Response from the POST request.
	 */
	public Response sendPostRequest(String baseUri, String endPoint, JSONObject body, String... headers) {
		// Set Base URL
		RestAssured.baseURI = baseUri;

		// Initialize the RequestSpecification
		RequestSpecification request = RestAssured.given();

		// Log the URL being accessed and request body to Extent Report
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Sending POST request to URL: " + baseUri+endPoint);
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Request Body: " + body.toString());

		// Validate headers: They must be in pairs (key-value)
		if (headers.length % 2 != 0) {
			throw new IllegalArgumentException("Headers must be in key-value pairs.");
		}

		// Add headers if they are provided
		for (int i = 0; i < headers.length; i += 2) {
			String headerKey = headers[i];
			String headerValue = headers[i + 1];
			request.header(headerKey, headerValue);

			// Log each header being sent to Extent Report
			UtilityObjectClass.getExtentTest().log(Status.INFO, "Header: " + headerKey + " = " + headerValue);
		}

		// Add body to the request
		request.body(body.toString());

		// Send POST request
		Response response = request.post(endPoint);

		// Log response details
		logResponseDetails(response, "POST");

		return response;
	}

	/**
	 * Send a PUT request with dynamic headers using varargs.
	 *
	 * @param url the URL to which the PUT request is sent.
	 * @param body the request body (payload) for the PUT request.
	 * @param headers a varargs parameter where headers are passed as key-value pairs
	 *                (e.g., "Header1", "Value1", "Header2", "Value2").
	 * @return the Response from the PUT request.
	 */
	public Response sendPutRequest(String baseUri, String endPoint, Object body, String... headers) {
		// Set Base URL
		RestAssured.baseURI = baseUri;

		// Initialize the RequestSpecification
		RequestSpecification request = RestAssured.given();

		// Log the URL being accessed and request body to Extent Report
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Sending PUT request to URL: " + baseUri+endPoint);
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Request Body: " + body.toString());

		// Validate headers: They must be in pairs (key-value)
		if (headers.length % 2 != 0) {
			throw new IllegalArgumentException("Headers must be in key-value pairs.");
		}

		// Add headers if they are provided
		for (int i = 0; i < headers.length; i += 2) {
			String headerKey = headers[i];
			String headerValue = headers[i + 1];
			request.header(headerKey, headerValue);

			// Log each header being sent to Extent Report
			UtilityObjectClass.getExtentTest().log(Status.INFO, "Header: " + headerKey + " = " + headerValue);
		}

		// Add body to the request
		request.body(body.toString());

		// Send PUT request
		Response response = request.put(endPoint);

		// Log response details
		logResponseDetails(response, "PUT");

		return response;
	}

	/**
	 * Send a DELETE request with dynamic headers using varargs.
	 *
	 * @param url the URL to which the DELETE request is sent.
	 * @param headers a varargs parameter where headers are passed as key-value pairs
	 *                (e.g., "Header1", "Value1", "Header2", "Value2").
	 * @return the Response from the DELETE request.
	 */
	public Response sendDeleteRequest(String baseUri, String endPoint, String... headers) {
		// Set Base URL
		RestAssured.baseURI = baseUri;

		// Initialize the RequestSpecification
		RequestSpecification request = RestAssured.given();

		// Log the URL being accessed to Extent Report
		UtilityObjectClass.getExtentTest().log(Status.INFO, "Sending DELETE request to URL: " + baseUri+endPoint);

		// Validate headers: They must be in pairs (key-value)
		if (headers.length % 2 != 0) {
			throw new IllegalArgumentException("Headers must be in key-value pairs.");
		}

		// Add headers if they are provided
		for (int i = 0; i < headers.length; i += 2) {
			String headerKey = headers[i];
			String headerValue = headers[i + 1];
			request.header(headerKey, headerValue);

			// Log each header being sent to Extent Report
			UtilityObjectClass.getExtentTest().log(Status.INFO, "Header: " + headerKey + " = " + headerValue);
		}

		// Send DELETE request
		Response response = request.delete(endPoint);

		// Log response details
		logResponseDetails(response, "DELETE");

		return response;
	}

	/**
	 * Validates the response status code and logs the result to the Extent Report.
	 *
	 * @param response - The response object to validate.
	 * @param expectedStatusCode - The expected HTTP status code.
	 */
	public boolean validateStatusCode(Response response, int expectedStatusCode) {
		int actualStatusCode = response.getStatusCode();
		if (actualStatusCode == expectedStatusCode) {
			UtilityObjectClass.getExtentTest().pass("Status Code Validation Passed. Expected: " + expectedStatusCode + ", Actual: " + actualStatusCode);
			return true;
		} else {
			UtilityObjectClass.getExtentTest().fail("Status Code Validation Failed. Expected: " + expectedStatusCode + ", Actual: " + actualStatusCode);
			return false;
		}
	}

	/**
	 * Extracts and returns a value from the JSON response using a JSONPath expression.
	 *
	 * @param response - The response object to extract data from.
	 * @param jsonPath - The JSONPath expression to find the desired value.
	 * @return The extracted value as a String.
	 */
	public String getValueFromJson(Response response, String jsonPath) {
		String value = response.jsonPath().getString(jsonPath);
		UtilityObjectClass.getExtentTest().info("Extracted value using JSONPath '" + jsonPath + "': " + value);
		return value;
	}

	/**
	 * Logs the details of the response (status code, response time, body) to the Extent Report.
	 *
	 * @param response - The response object to log.
	 * @param requestType - The type of request (e.g., GET, POST).
	 */
	private void logResponseDetails(Response response, String requestType) {
		int statusCode = response.getStatusCode();
		long responseTime = response.getTime();
		String responseBody = response.prettyPrint();

		UtilityObjectClass.getExtentTest().info(requestType + " Response Status Code: " + statusCode);
		UtilityObjectClass.getExtentTest().info(requestType + " Response Time: " + responseTime + " ms");
		UtilityObjectClass.getExtentTest().info(requestType + " Response Body: " + responseBody);
	}
}

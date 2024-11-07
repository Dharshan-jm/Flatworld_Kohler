package org.tyss.flatworld.genericutility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This utility class provides common WebDriver actions for interacting with web elements.
 * Each method is designed to be reusable across different test cases, and significant actions 
 * are logged to the Extent Report for better traceability.
 */
public class WebDriverUtility {

	/**
	 * Launches the specified URL in the provided WebDriver.
	 *
	 * @param driver - The WebDriver instance to use.
	 * @param url - The URL to open.
	 */
	public void navigateToUrl(WebDriver driver, String url) {
		try {
			driver.get(url);
			UtilityObjectClass.getExtentTest().info("Launched application with URL: " + url);
		} catch (Exception e) {
			UtilityObjectClass.getExtentTest().fail("Failed to launch application with URL: " + url + ". " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Maximizes the browser window.
	 *
	 * @param driver - The WebDriver instance to use.
	 */
	public void maximizeWindow(WebDriver driver) {
		try {
			driver.manage().window().maximize();
			UtilityObjectClass.getExtentTest().info("Maximized the browser window.");
		} catch (Exception e) {
			UtilityObjectClass.getExtentTest().fail("Failed to maximize the browser window. " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Sets an implicit wait for the provided WebDriver.
	 *
	 * @param driver - The WebDriver instance to use.
	 * @param timeInSeconds - The timeout duration in seconds.
	 */
	public void setImplicitWait(WebDriver driver, int timeInSeconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
			UtilityObjectClass.getExtentTest().info("Set implicit wait to " + timeInSeconds + " seconds.");
		} catch (Exception e) {
			UtilityObjectClass.getExtentTest().fail("Failed to set implicit wait. " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Waits for an element to be visible on the page.
	 *
	 * @param driver - The WebDriver instance to use.
	 * @param element - The WebElement to wait for.
	 * @param timeout - Maximum wait time in seconds.
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(element));
			UtilityObjectClass.getExtentTest().info("Element is visible on the page.");
		} catch (TimeoutException e) {
			UtilityObjectClass.getExtentTest().fail("Element not visible after waiting for " + timeout + " seconds. " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Waits for an element to be clickable on the page.
	 *
	 * @param driver - The WebDriver instance to use.
	 * @param element - The WebElement to wait for.
	 * @param timeout - Maximum wait time in seconds.
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			UtilityObjectClass.getExtentTest().info("Element is clickable.");
		} catch (TimeoutException e) {
			UtilityObjectClass.getExtentTest().fail("Element not clickable after waiting for " + timeout + " seconds. " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Waits for a specified number of seconds (hard wait).
	 *
	 * @param seconds - Number of seconds to wait.
	 */
	public void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
			UtilityObjectClass.getExtentTest().info("Waited for " + seconds + " seconds.");
		} catch (InterruptedException e) {
			UtilityObjectClass.getExtentTest().fail("Interrupted while waiting for " + seconds + " seconds. " + e.getMessage());
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * Takes a screenshot of the current browser window.
	 *
	 * @param driver - The WebDriver instance to use.
	 * @param screenshotName - The name to save the screenshot file.
	 * @return The file path of the saved screenshot.
	 */
	public String takeScreenshot(WebDriver driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
			Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
			Files.copy(source.toPath(), Paths.get(destination));
			UtilityObjectClass.getExtentTest().info("Screenshot taken: " + screenshotName);
			return destination;
		} catch (IOException e) {
			UtilityObjectClass.getExtentTest().fail("Failed to take screenshot: " + screenshotName + ". " + e.getMessage());
			throw new RuntimeException("Failed to take screenshot: " + screenshotName, e);
		}
	}

	/**
	 * Clicks on a WebElement.
	 *
	 * @param element - The WebElement to click.
	 */
	public void clickElement(WebElement element) {
		try {
			element.click();
			UtilityObjectClass.getExtentTest().info("Clicked on element: " + element.toString());
		} catch (Exception e) {
			UtilityObjectClass.getExtentTest().fail("Failed to click on element. " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Sends keys to a WebElement.
	 *
	 * @param element - The WebElement to send keys to.
	 * @param text - The text to enter into the element.
	 */
	public void enterTextIntoElement(WebElement element, String text) {
		try {
			element.clear();
			element.sendKeys(text);
			UtilityObjectClass.getExtentTest().info("Entered text: '" + text + "' into element: " + element.toString());
		} catch (Exception e) {
			UtilityObjectClass.getExtentTest().fail("Failed to enter text: '" + text + "' into element. " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Opens a browser window based on the specified browser name and returns the WebDriver instance.
	 *
	 * @param browserName The name of the browser to open (e.g., "chrome", "firefox", "edge").
	 * @return WebDriver instance for the specified browser.
	 */
	public WebDriver openBrowserWindow(String browserName) {
		WebDriver driver = null;

		try {
			// Initialize WebDriver based on the specified browser
			switch (browserName.toLowerCase()) {
			case "chrome":
				// Set up ChromeDriver using WebDriverManager
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				UtilityObjectClass.getExtentTest().log(Status.INFO, "Chrome browser launched successfully.");
				break;

			case "firefox":
				// Set up FirefoxDriver using WebDriverManager
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				UtilityObjectClass.getExtentTest().log(Status.INFO, "Firefox browser launched successfully.");
				break;

			case "edge":
				// Set up EdgeDriver using WebDriverManager
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				UtilityObjectClass.getExtentTest().log(Status.INFO, "Edge browser launched successfully.");
				break;

			default:
				// Log an error if the browser name is invalid
				UtilityObjectClass.getExtentTest().log(Status.FAIL, "Invalid browser name: " + browserName);
				throw new IllegalArgumentException("Browser not supported: " + browserName);
			}

			// Optional: Maximize the browser window
			driver.manage().window().maximize();
			UtilityObjectClass.getExtentTest().log(Status.INFO, "Browser window maximized.");

		} catch (Exception e) {
			// Log the exception in Extent Report
			UtilityObjectClass.getExtentTest().log(Status.FAIL, "Failed to launch the browser: " + e.getMessage());
			throw e;  // Rethrow the exception for further handling
		}

		// Return the initialized WebDriver instance
		return driver;
	}

	// Method to verify if the current URL contains the expected URL
	public void verifyPageUrlContainsGivenUrl(String expectedUrl) {
		AssertionUtility assertionUtility = new AssertionUtility();
		try {
			// Get the current URL of the page
			String currentUrl = UtilityObjectClass.getDriver().getCurrentUrl();
			assertionUtility.assertTrue(currentUrl.contains(expectedUrl), "Current URL: "+currentUrl+" contains: "+expectedUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

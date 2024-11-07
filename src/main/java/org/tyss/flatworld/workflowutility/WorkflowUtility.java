package org.tyss.flatworld.workflowutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.tyss.flatworld.genericutility.FileUtility;
import org.tyss.flatworld.genericutility.JavaUtility;
import org.tyss.flatworld.genericutility.RestAssuredUtility;
import org.tyss.flatworld.genericutility.UtilityObjectClass;
import org.tyss.flatworld.genericutility.WebDriverUtility;
import org.tyss.flatworld.objectrepository.SignInPage;

public class WorkflowUtility {
	FileUtility fileUtility = new FileUtility();
	JavaUtility javaUtility = new JavaUtility();
	RestAssuredUtility restAssuredUtility = new RestAssuredUtility();
	WebDriverUtility webDriverUtility = new WebDriverUtility();

	public void signInToApplication(String userId, String password) {
		webDriverUtility.waitForSeconds(2);
		webDriverUtility.verifyPageUrlContainsGivenUrl("sign-in");
		SignInPage signInPage = new SignInPage(UtilityObjectClass.getDriver());
		webDriverUtility.enterTextIntoElement(signInPage.getUserIdTextfield(), userId);
		webDriverUtility.enterTextIntoElement(signInPage.getPasswordTextfield(), password);
		webDriverUtility.clickElement(signInPage.getSignInButton());
		webDriverUtility.waitForSeconds(5);
		webDriverUtility.verifyPageUrlContainsGivenUrl("dashboards");
	}

	public void screenSizeReduce() throws InterruptedException {
		Robot robot;
		try {
			robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_MINUS); // Release the '-' key
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}

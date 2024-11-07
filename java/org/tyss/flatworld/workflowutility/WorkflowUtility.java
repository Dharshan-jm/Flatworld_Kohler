package org.tyss.flatworld.workflowutility;

import org.tyss.flatworld.genericutility.FileUtility;
import org.tyss.flatworld.genericutility.JavaUtility;
import org.tyss.flatworld.genericutility.RestAssuredUtility;
import org.tyss.flatworld.genericutility.UtilityObjectClass;
import org.tyss.flatworld.genericutility.WebDriverUtility;
import org.tyss.flatworld.objectrepository.WelcomePage;

public class WorkflowUtility {
	FileUtility fileUtility = new FileUtility();
	JavaUtility javaUtility = new JavaUtility();
	RestAssuredUtility restAssuredUtility = new RestAssuredUtility();
	WebDriverUtility webDriverUtility = new WebDriverUtility();

	public void signInToApplication(String email, String password) {
		WelcomePage welcomePage = new WelcomePage(UtilityObjectClass.getDriver());
		webDriverUtility.enterTextIntoElement(welcomePage.getEmailIdTextfield(), email);
		webDriverUtility.enterTextIntoElement(welcomePage.getPasswordTextfield(), password);
		webDriverUtility.clickElement(welcomePage.getSignInButton());
		
	}
}


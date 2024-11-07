package org.tyss.flatworld.testcases_kohler;

import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.flatworld.genericutility.BaseClass;
import org.tyss.flatworld.genericutility.IConstants;
import org.tyss.flatworld.objectrepository.CurriculumPage;
import org.tyss.flatworld.objectrepository.DashboardPage;
import org.tyss.flatworld.objectrepository.IncentiveAdminHomePage;
import org.tyss.flatworld.objectrepository.KohlerNewPage;
import org.tyss.flatworld.objectrepository.NavigationTitleQuizPage;
import org.tyss.flatworld.objectrepository.PublicUserPage;
import org.tyss.flatworld.objectrepository.TrainingCoursePage;
import org.tyss.flatworld.objectrepository.TrainingPage;

@Listeners(org.tyss.flatworld.genericutility.ListenerImplementationClass.class)
public class TC_02_CompleteCourseAndVerifyPointsAreCreditedTest100Points extends BaseClass {

	@Test
	public void completeCourseAndVerifyPointsAreCredited() throws InterruptedException {

		// Read data from excel
		Map<String, String> testCaseData = excelUtility.getEntireTcDataBasedOnTcId(IConstants.EXCEL_FILE_PATH,
				"Kohler_Testdata", "TC001");

		// Create objects for POM Pages
		DashboardPage dashboardPage = new DashboardPage(driver);
		IncentiveAdminHomePage incentiveAdminHomePage = new IncentiveAdminHomePage(driver);
		PublicUserPage publicUserPage = new PublicUserPage(driver);
		CurriculumPage curriculumPage = new CurriculumPage(driver);
		TrainingPage trainingPage = new TrainingPage(driver);
		TrainingCoursePage trainingCoursePage = new TrainingCoursePage(driver);
		NavigationTitleQuizPage navigationTitleQuizPage = new NavigationTitleQuizPage(driver);
		KohlerNewPage kohlerNewPage = new KohlerNewPage(driver);

		webDriverUtility.clickElement(dashboardPage.getMenuIcon());

		// Click on Incentive admin Panel Link
		webDriverUtility.clickElement(dashboardPage.getInsentiveAdminPanelLink());

		// Verify Page Incentive_Admin_Home_Page url
		webDriverUtility.verifyPageUrlContainsGivenUrl(
				javaUtility.getValueFromTheMap(pageVerificationData, "Incentive_Admin_Home_Page"));

		webDriverUtility.waitForSeconds(2);

		// webDriverUtility.clickElement(dashboardPage.getincentivemenu());

		// Click on Incentive admin Panel Link
		webDriverUtility.clickElement(incentiveAdminHomePage.getUserAdministrationMenu());

		// Click on Incentive public user option
		webDriverUtility.clickElement(incentiveAdminHomePage.getPublicUserOption());

		// Verify Page Public_User_Page url
		webDriverUtility.verifyPageUrlContainsGivenUrl(
				javaUtility.getValueFromTheMap(pageVerificationData, "Public_User_Page"));

		// Click on Incentive add user button
		webDriverUtility.clickElement(publicUserPage.getAddUserButton());


		// Get random number of range 5000
		int randomNumber = javaUtility.getRandomNumber(5000);

		// Enter dynamic inputs into the user fields
		String userId = "User_" + randomNumber;
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"User Id", userId);
		webDriverUtility.enterTextIntoElement(publicUserPage.getUserIdTextfield(), userId);

		String firstName = "Swaraj_" + randomNumber;
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"First Name", firstName);
		webDriverUtility.enterTextIntoElement(publicUserPage.getFirstNameTextfield(), firstName);

		String email = firstName + "@gmail.com";
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"Email", email);
		webDriverUtility.enterTextIntoElement(publicUserPage.getEmailTextfield(), email);

		String lastName = "PT_" + randomNumber;
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"Last Name", lastName);
		webDriverUtility.enterTextIntoElement(publicUserPage.getLastNameTextfield(), lastName);

		String organization = "Org_" + randomNumber;
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"Organization", organization);
		webDriverUtility.enterTextIntoElement(publicUserPage.getOrganizationTextfield(), organization);

		// Select role as user from the picklist
		webDriverUtility.waitForSeconds(2);
		// webDriverUtility.clickElement(publicUserPage.getRoleOrJobTitlePckList());
		webDriverUtility.doubleClickOnElement(publicUserPage.getRoleOrJobTitlePickListOption());

		// Select Account status as Active from the picklist
		webDriverUtility.waitForSeconds(2);
		webDriverUtility.clickOnElementUsingJs(publicUserPage.getAccountStatusPicklist());
		webDriverUtility.clickOnElementUsingJs(publicUserPage
				.getAccountStatusPicklistOption(javaUtility.getValueFromTheMap(testCaseData, "Account Status")));

		// Click on Save button
		webDriverUtility.clickElement(publicUserPage.getSaveButton());

		// Verify toaster message is displayed
		assertionUtility.assertTrue(webDriverUtility.checkElementIsDisplayed(publicUserPage.getAlertToasterMessage()),
				"Data saved successfully.");
		webDriverUtility.waitForSeconds(5);

		// Go to LMS admin Menu
		webDriverUtility.clickElement(dashboardPage.getLMSadmin());
		webDriverUtility.waitForSeconds(2);
		webDriverUtility.clickElement(dashboardPage.getMenuIcon());
		webDriverUtility.waitForSeconds(3);
		webDriverUtility.clickElement(dashboardPage.getLmsAdminPanelMenu());
		webDriverUtility.waitForSeconds(2);

		webDriverUtility.clickElement(curriculumPage.getCurriculumManagerLink());
		webDriverUtility.verifyPageUrlContainsGivenUrl(
				javaUtility.getValueFromTheMap(pageVerificationData, "Curriculum_manager"));
		webDriverUtility.waitForSeconds(2);
		webDriverUtility.clickElement(curriculumPage.getCurriculumManagerAddButton());

		// create cirriculum description
		webDriverUtility.enterTextIntoElement(curriculumPage.getCurriculumManagerDescription(), "Description");
		// create curriculum Name
		String curriculumName = "curriculumName_" + randomNumber;
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"CurriculumName", curriculumName);
		webDriverUtility.enterTextIntoElement(curriculumPage.getCurriculumManagerName(), curriculumName);

		// Save curriculum
		webDriverUtility.moveToElementAndClick(curriculumPage.getCurriculumSaveButton());

		// Verify toaster message is displayed
		assertionUtility.assertTrue(webDriverUtility.checkElementIsDisplayed(publicUserPage.getAlertToasterMessage()),
				"Data saved successfully.");
		webDriverUtility.waitForSeconds(5);

		webDriverUtility.clickElement(curriculumPage.getCurriculumManagerMenuLink());

		// Go to Training Course
		webDriverUtility.clickElement(trainingPage.getTrainingCourseLink());
		webDriverUtility.verifyPageUrlContainsGivenUrl(
				javaUtility.getValueFromTheMap(pageVerificationData, "Training_Courses"));

		webDriverUtility.waitForSeconds(4);
		webDriverUtility.clickElement(trainingPage.getTrainingPageAddButton());
		webDriverUtility.verifyPageUrlContainsGivenUrl(
				javaUtility.getValueFromTheMap(pageVerificationData, "Training-Course-Manager-Add-Edit"));
		// Add Details For Training Course

		String courseId = "courseId" + randomNumber;
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"CourseID", courseId);
		webDriverUtility.enterTextIntoElement(trainingPage.getEditTrainingCourseIdTextFile(), courseId);

		String courseName = "courseName" + randomNumber;
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"CourseName", courseName);
		webDriverUtility.enterTextIntoElement(trainingPage.getEditTrainingCourseNameTextField(), courseName);

		// Select Data From Curriculum Drop Down
		webDriverUtility.moveToElementAndClick(trainingPage.getEditTrainingCurriculumDropdown());
		webDriverUtility.enterTextIntoElement(trainingPage.getCurriculumSearch(), curriculumName);
		webDriverUtility.clickElement(trainingPage.getCurriculumSearchCheckBox());

		// Select Data From Training User
		String userData = firstName + " " + lastName + "_" + userId;
		webDriverUtility.doubleClickOnElement(trainingPage.getTrainingUser());
		webDriverUtility.enterTextIntoElement(trainingPage.getTrainingUserSearch(), userData);
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"UserTraining", userData);

		webDriverUtility.clickElement(trainingPage.getTrainingUserCheckBox());

		// Select StartDate
		String startDate = javaUtility.getDateAndTimeInSpecifiedFormat("MM-dd-yyyy");
		webDriverUtility.enterTextIntoElement(trainingPage.getTrainingStartDate(), startDate);
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"StartDate", startDate);

		// Select EndDate
		String endDate = javaUtility.getRequiredDateAndTimeInSpecifiedFormat(startDate, 2);
		webDriverUtility.enterTextIntoElement(trainingPage.getTrainingStartDate(), startDate);
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"EndDate", endDate);

		// Select Point
		String point = String.valueOf(javaUtility.getRandomNumber(50));
		webDriverUtility.enterTextIntoElement(trainingPage.getTrainingPoint(), point);
		excelUtility.writeDataToCellBasedOnTcIdAndHeader(IConstants.EXCEL_FILE_PATH, "Kohler_Testdata", "TC001",
				"Point", point);

		webDriverUtility.doubleClickOnElement(trainingPage.getTrainingActiveCheckBox());
		webDriverUtility.clickElement(trainingPage.getRequiredCheckBox());
		webDriverUtility.moveToElementAndClick(trainingPage.getTrainingSave());
		// Added Data to Training Course Page

		// Verify toaster message is displayed
		assertionUtility.assertTrue(webDriverUtility.checkElementIsDisplayed(publicUserPage.getAlertToasterMessage()),
				"Data saved successfully.");
		webDriverUtility.waitForSeconds(5);

		// Search Data in Training Page
		webDriverUtility.enterTextIntoElementAndEnter(trainingCoursePage.getTrainingCourseSearch(), userId);
		webDriverUtility.waitForSeconds(3);

		webDriverUtility.clickElement(trainingCoursePage.getTrainingCourseAction());
		webDriverUtility.clickElement(trainingCoursePage.getTrainingCourseEdit());
		webDriverUtility.clickElement(trainingCoursePage.getTrainingCourseAddEdit());

		// Verify toaster message is displayed
		assertionUtility.assertTrue(webDriverUtility.checkElementIsDisplayed(publicUserPage.getAlertToasterMessage()),
				"Data saved successfully.");
		webDriverUtility.waitForSeconds(5);

		// Navigate to Quiz title Page
		webDriverUtility.clickElement(navigationTitleQuizPage.getQuizDropDown());
		webDriverUtility.waitForSeconds(3);
		webDriverUtility.clickElement(navigationTitleQuizPage.getQuizSelectFromDropDown());
		webDriverUtility.waitForSeconds(3);

		webDriverUtility.clickOnElementUsingJs(navigationTitleQuizPage.getQuizeAddSlide());

		if (webDriverUtility.checkElementIsDisplayed(navigationTitleQuizPage.getQuizPassingMark())) {
			if (webDriverUtility.elementIsEnabled(navigationTitleQuizPage.getQuizPassingMark())) {
				webDriverUtility.elementToBeClickAble(navigationTitleQuizPage.getQuizPassingMark());
				webDriverUtility.enterTextIntoElement(navigationTitleQuizPage.getQuizPassingMark(), "50");
				webDriverUtility.enterTextIntoElement(navigationTitleQuizPage.getQuizSuccessMessage(), "Pass");
				webDriverUtility.enterTextIntoElement(navigationTitleQuizPage.getQuizFailMessage(), "Fail");
			}
		}
		webDriverUtility.clickOnElementUsingJs(navigationTitleQuizPage.getQuizAddQuestionButton());
		webDriverUtility.enterTextIntoElement(navigationTitleQuizPage.getQuizAddTestField(), "question Added");

		webDriverUtility.clickElement(navigationTitleQuizPage.getQuizTrueFalseRadioButton());
		webDriverUtility.clickOnElementUsingJs(navigationTitleQuizPage.getQuizTrueCheckBox());

		workflowUtility.screenSizeReduce();

		webDriverUtility.clickOnElementUsingJs(navigationTitleQuizPage.getQuizAddSaveButton());
		webDriverUtility.waitForSeconds(5);
		webDriverUtility.clickOnElementUsingJs(navigationTitleQuizPage.getQuizEditSaveButton());
		webDriverUtility.waitForSeconds(5);

		// Verify toaster message is displayed
		assertionUtility.assertTrue(webDriverUtility.checkElementIsDisplayed(publicUserPage.getAlertToasterMessage()),
				"Data saved successfully.");
		webDriverUtility.waitForSeconds(5);

		webDriverUtility.elementToBeClickAble(navigationTitleQuizPage.getQuizEditCloseButton());
		webDriverUtility.clickElement(navigationTitleQuizPage.getQuizEditCloseButton());
		webDriverUtility.waitForSeconds(5);

		webDriverUtility.clickElement(trainingCoursePage.getTrainingCoursePageSaveButton());
		webDriverUtility.waitForSeconds(3);
		// Quiz added successfully

		// Go to public user page
		webDriverUtility.clickElement(dashboardPage.getMenuIcon());
		webDriverUtility.clickElement(dashboardPage.getInsentiveAdminPanelLink());
		webDriverUtility.clickElement(incentiveAdminHomePage.getUserAdministrationMenu());
		webDriverUtility.clickElement(incentiveAdminHomePage.getPublicUserOption());

		// Navigate to public user search page
		webDriverUtility.enterTextIntoElementAndEnter(publicUserPage.getPublicUserSearchButton(), userId);
		webDriverUtility.clickElement(publicUserPage.getPublicUserApplyButton());
		webDriverUtility.waitForSeconds(2);

		// Go to Impersonate user
		webDriverUtility.clickElement(publicUserPage.getPublicUserActionButton());
		webDriverUtility.clickOnElementUsingJs(publicUserPage.getPublicUserImpersonatebutton());

		// Go to new window
		webDriverUtility.switchTowindow(driver);
		webDriverUtility.waitForSeconds(5);

		webDriverUtility.clickElement(kohlerNewPage.getMenuButton());
		webDriverUtility.waitForSeconds(2);

		// Go to Academy page
		webDriverUtility.clickElement(kohlerNewPage.getAcademyLink());
		webDriverUtility.waitForSeconds(10);

		// Go to curriculum page
		webDriverUtility.clickElement(kohlerNewPage.curriculumNameTest(curriculumName));
		webDriverUtility.clickElement(kohlerNewPage.courseNameTest(courseName));

		// Go to test page
		webDriverUtility.clickElement(kohlerNewPage.getCheckBoxTrue());
		webDriverUtility.clickElement(kohlerNewPage.getTestSubmit());

		// Verify toaster message is displayed
		assertionUtility.assertTrue(webDriverUtility.checkElementIsDisplayed(publicUserPage.getAlertToasterMessage()),
				"Data saved successfully.");
		webDriverUtility.waitForSeconds(5);

	}
}
package org.tyss.flatworld.testcases;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.flatworld.genericutility.BaseClass;
import org.tyss.flatworld.genericutility.IConstants;
import org.tyss.flatworld.objectrepository.CurriculumPage;
import org.tyss.flatworld.objectrepository.DashboardPage;
import org.tyss.flatworld.objectrepository.EditPublicUserPage;
import org.tyss.flatworld.objectrepository.IncentiveAdminHomePage;
import org.tyss.flatworld.objectrepository.KohlerNewPage;
import org.tyss.flatworld.objectrepository.NavigationTitleQuizPage;
import org.tyss.flatworld.objectrepository.ProgramConfigurationPage;
import org.tyss.flatworld.objectrepository.PublicUserPage;
import org.tyss.flatworld.objectrepository.RedeemPage;
import org.tyss.flatworld.objectrepository.TrainingCoursePage;
import org.tyss.flatworld.objectrepository.TrainingPage;
import org.tyss.flatworld.objectrepository.TransactionPage;
import org.tyss.flatworld.workflowutility.WorkflowUtility;

@Listeners(org.tyss.flatworld.genericutility.ListenerImplementationClass.class)
public class TC_12_VerifyObtainLoadCardKohlerRwardsTest extends BaseClass {

	@Test
	public void verifyObtainLoadCardKohlerRwards12() throws InterruptedException, EncryptedDocumentException, IOException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Reporter.log("----LOGIN SUCCESSFULL----", true);

		DashboardPage dashboardpage = new DashboardPage(driver);
		IncentiveAdminHomePage incentivepage = new IncentiveAdminHomePage(driver);
		PublicUserPage publicuserpage = new PublicUserPage(driver);
		CurriculumPage curriculumpage = new CurriculumPage(driver);
		TrainingPage trainingpage = new TrainingPage(driver);
		TrainingCoursePage trainingCoursePage = new TrainingCoursePage(driver);
		NavigationTitleQuizPage navigatetitlepage = new NavigationTitleQuizPage(driver);
		WorkflowUtility workflow = new WorkflowUtility();
		KohlerNewPage kohlernewpage = new KohlerNewPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ProgramConfigurationPage programconfig = new ProgramConfigurationPage(driver);
		EditPublicUserPage editpublic = new EditPublicUserPage(driver);
		RedeemPage redeempage = new RedeemPage(driver);
		TransactionPage transactionpage=new TransactionPage(driver);
		Actions act = new Actions(driver);

		int number = javaUtility.getRandomNumber(4000);
		String userid = "A"+fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "userid") + number;
		String firstname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "firstname");
		String lastname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "lastname");
		String organization = javaUtility.getRandomAlphaNumericString(5);
		String email = javaUtility.getRandomAlphaNumericString(5) + "@gmail.com";
		String userdata = firstname + " " + lastname + "_" + userid;
		String date = javaUtility.getDateAndTimeInSpecifiedFormat("MM-dd-yyyy");
		String reqdate = javaUtility.getRequiredDateAndTimeInSpecifiedFormat("MM-dd-yyyy", 2);
		String point = "200";
		String passingmark="50";
		String successmsg="pass";
		String Failmsg="fail";
		String parentwindowid = driver.getWindowHandle();
		String pdfpath = "C:\\Users\\dhars\\Downloads\\sodapdf-converted.pdf";
		String redeemvalue="131";
		

		dashboardpage.getMenuIcon().click();
		Reporter.log("----MENU ICON HAMBURGER ICON CLICK SUCCESSFULL----", true);

		dashboardpage.getInsentiveAdminPanelLink().click();
		Reporter.log("----INCENTIVE ADMIN HOME PAGE CLICK SUCCESSFULL----", true);
		dashboardpage.getincentivemenu().click();

		incentivepage.getUserAdministrationMenu().click();
		Reporter.log("----USER ADMINISTRATION CLICK SUCCESSFULL----", true);

		incentivepage.getPublicUserOption().click();
		Reporter.log("----PUBLIC USER CLICK OPTION CLICK SUCCESSFULL----", true);

		publicuserpage.getAddUserButton().click();
		Reporter.log("----ADD PUBLIC USER----", true);

		publicuserpage.getUserIdTextfield().sendKeys(userid);
		publicuserpage.getFirstNameTextfield().sendKeys(firstname);
		publicuserpage.getLastNameTextfield().sendKeys(lastname);
		publicuserpage.getEmailTextfield().sendKeys(email);
		publicuserpage.getOrganizationTextfield().sendKeys(organization);

		webDriverUtility.waitForSeconds(2);
		publicuserpage.statusSelection("Active");
		new Actions(driver).doubleClick(publicuserpage.getUserSelect()).perform();

		publicuserpage.getSaveButton().click();
		Reporter.log("----PUBLIC USER ADDED SUCCESSFULLY----", true);

		webDriverUtility.waitForSeconds(2);
		dashboardpage.getLMSadmin().click();
		webDriverUtility.waitForSeconds(3);
		dashboardpage.getMenuIcon().click();
		dashboardpage.getLmsAdminPanelMenu().click();
		Reporter.log("----LMS ADMIN PANEL MENU CLICK SUCCESSFULL----", true);

		curriculumpage.getCurriculumManagerLink().click();
		Reporter.log("---- CURRICULUM MANAGER LINK CLICK SUCCESSFULL----", true);
		webDriverUtility.waitForSeconds(2);
		curriculumpage.getCurriculumManagerAddButton().click();

		Reporter.log("---- CURRICULUM MANAGER ADD CLICK SUCCESSFULL----", true);

		String curriculumname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "curriculumname")
				+ userid;
		String curriculumdescription = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH,
				"curriculumdescription") + javaUtility.getRandomAlphaNumericString(20);
		curriculumpage.getCurriculumManagerDescription().sendKeys(curriculumdescription);
		curriculumpage.getCurriculumManagerName().sendKeys(curriculumname);
		new Actions(driver).moveToElement(curriculumpage.getCurriculumSaveButton()).click().perform();

		Reporter.log("---- CURRICULUM NAME AND DESCRIPTION SUCCESSFULL----", true);

		Reporter.log("---- EXIT FROM CURRICULUM PAGE SUCCESSFULL----", true);
		webDriverUtility.waitForSeconds(5);
		curriculumpage.getCurriculumManagerMenuLink().click();

		Reporter.log("----NAVIGATE TO TRAINING PAGE----", true);
		trainingpage.getTrainingCourseLink().click();
		String courseid = userid + fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "courseid");
		String coursename = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "coursename")
				+ javaUtility.getRandomAlphaNumericString(2);
		webDriverUtility.waitForSeconds(3);
		trainingpage.getTrainingPageAddButton().click();
		trainingpage.getEditTrainingCourseIdTextFile().sendKeys(courseid);
		trainingpage.getEditTrainingCourseNameTextField().sendKeys(coursename);

		act.moveToElement(trainingpage.getEditTrainingCurriculumDropdown()).click().perform();
		trainingpage.getCurriculumSearch().sendKeys(curriculumname, Keys.ENTER);
		trainingpage.getCurriculumSearchCheckBox().click();

		act.doubleClick(trainingpage.getTrainingUser()).perform();
		trainingpage.getTrainingUserSearch().sendKeys(userdata, Keys.ENTER);
		trainingpage.getTrainingUserCheckBox().click();
		trainingpage.getTrainingStartDate().sendKeys(date);
		trainingpage.getTrainingEndDate().sendKeys(reqdate);
		trainingpage.getTrainingPoint().sendKeys(point);
		act.doubleClick(trainingpage.getTrainingActiveCheckBox()).perform();
		trainingpage.getRequiredcheckbox().click();
		act.moveToElement(trainingpage.getTrainingSave()).click().perform();

		Reporter.log("----TRAINING PAGE DATA ADDED SUCCESSFULL----", true);

		Reporter.log("----SEARCH DATA IN TRAINING COURSE PAGE----", true);
		trainingCoursePage.getTrainingCourseSearch().sendKeys(coursename, Keys.ENTER);
		webDriverUtility.waitForSeconds(3);
		trainingCoursePage.getTrainingCourseAction().click();
		trainingCoursePage.getTrainingCourseEdit().click();
		trainingCoursePage.getTrainingCourseAddEdit().click();
		Reporter.log("----SEARCH DATA IN TRAINING COURSE PAGE SUCCESSFULL----", true);

		Reporter.log("----NAVIGATE TO TITLE QUIZ PAGE----", true);

		navigatetitlepage.getQuizDropDown().click();
		webDriverUtility.waitForSeconds(3);
		navigatetitlepage.getQuizSelectFromDropDown().click();
		webDriverUtility.waitForSeconds(3);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js.executeScript("arguments[0].click();", navigatetitlepage.getQuizeAddSlide());

		if (navigatetitlepage.getQuizPassingMark().isDisplayed()) {
			if (navigatetitlepage.getQuizPassingMark().isEnabled()) {
				wait.until(ExpectedConditions.elementToBeClickable(navigatetitlepage.getQuizPassingMark()));
				navigatetitlepage.getQuizPassingMark().sendKeys(passingmark);
				navigatetitlepage.getQuizSuccessMessage().sendKeys(successmsg);
				navigatetitlepage.getQuizFailMessage().sendKeys(Failmsg);
			}
		}
		navigatetitlepage.getQuizAddQuestionButton().click();
		navigatetitlepage.getQuizAddTestField().sendKeys(userid + "_quizQuestionAdded");
		navigatetitlepage.getQuizTrueFalseRadioButton().click();
		js.executeScript("arguments[0].click();", navigatetitlepage.getQuizTrueCheckBox());

		workflow.screenSizeReduce();

		js.executeScript("arguments[0].click();", navigatetitlepage.getQuizAddSaveButton());
		webDriverUtility.waitForSeconds(5);

		js.executeScript("arguments[0].click();", navigatetitlepage.getQuizEditSaveButton());
		webDriverUtility.waitForSeconds(6);
		wait.until(ExpectedConditions.elementToBeClickable(navigatetitlepage.getQuizEditCloseButton()));
		navigatetitlepage.getQuizEditCloseButton().click();

		webDriverUtility.waitForSeconds(5);
		trainingCoursePage.getTrainingCoursePageSaveButton().click();
		webDriverUtility.waitForSeconds(3);
		Reporter.log("----QUIZ ADDED SUCCESSFULL----", true);

		Reporter.log("----NAVIGATE TO PUBLIC USER PAGE----", true);
		dashboardpage.getMenuIcon().click();
		dashboardpage.getInsentiveAdminPanelLink().click();
		incentivepage.getUserAdministrationMenu().click();
		incentivepage.getPublicUserOption().click();

		Reporter.log("----NAVIGATE TO PUBLIC USER PAGE SEARCH----", true);
		publicuserpage.getPublicUserSearchButton().sendKeys(userid, Keys.ENTER);
		publicuserpage.getPublicUserApplyButton().click();
		webDriverUtility.waitForSeconds(2);
		Reporter.log("----NAVIGATE TO IMPERSONATE USER----", true);
		publicuserpage.getPublicUserActionButton().click();
		js.executeScript("arguments[0].click()", publicuserpage.getPublicUserImpersonatebutton());

		Reporter.log("----NAVIGATE TO NEW WINDOW----", true);
		webDriverUtility.switchTowindow(driver);
		webDriverUtility.waitForSeconds(5);
		kohlernewpage.getMenuButton().click();
		webDriverUtility.waitForSeconds(2);
		Reporter.log("----NAVIGATE TO ACADEMY PAGE----", true);
		kohlernewpage.getAcademyLink().click();

		webDriverUtility.waitForSeconds(10);
		Reporter.log("----NAVIGATE TO CURRICULUM PAGE----", true);
		driver.findElement(By.xpath("//h3[text()='" + curriculumname + "']")).click();
		driver.findElement(By.xpath("//h6[text()='" + coursename + "']")).click();
		Reporter.log("----NAVIGATE TO TEST PAGE----", true);
		kohlernewpage.getCheckBoxTrue().click();
		kohlernewpage.getTestSubmit().click();
		Reporter.log("----TEST SUCCESSFULL----", true);
		String successfull = kohlernewpage.getTestSuccessFullMessage().getText();

		Reporter.log("----TEST SUCCESSFULL MESSAGE----" + successfull, true);
		webDriverUtility.waitForSeconds(10);

		// -----------------------------------------------------------------
		kohlernewpage.getUserprofileicon().click();
		kohlernewpage.getUsermyaccount().click();
		webDriverUtility.waitForSeconds(3);
		Reporter.log("----GO TO MANAGE TAX INFORMATION----", true);
		kohlernewpage.getUsermanagetaxinformation().click();
		webDriverUtility.waitForSeconds(3);

		Reporter.log("----SELECT YEAR----", true);
		kohlernewpage.getYeardropdown().click();
		kohlernewpage.getYearselect().click();


		Reporter.log("----UPLOAD FILE----", true);
		kohlernewpage.getChoosefilebutton().sendKeys(pdfpath);

		webDriverUtility.waitForSeconds(3);
		kohlernewpage.getManagetaxinformationsavebutton().click();

		WebDriverWait waitcondition = new WebDriverWait(driver, Duration.ofSeconds(20));
		waitcondition.until(ExpectedConditions.elementToBeClickable(kohlernewpage.getManagetaxinformationclose()));
		kohlernewpage.getManagetaxinformationclose().click();

		Reporter.log("----MANAGE TAX INFORMATION FILE SAVE COMPLETED----", true);

		Reporter.log("----GO TO PARENT WINDOW----", true);
		driver.switchTo().window(parentwindowid);

		Reporter.log("----NAVIGATE TO PROGRAM CONFIGURATION----", true);
		webDriverUtility.waitForSeconds(5);
		dashboardpage.getLMSadmin().click();
		webDriverUtility.waitForSeconds(5);
		dashboardpage.getMenuIcon().click();
		dashboardpage.getInsentiveAdminPanelLink().click();
		webDriverUtility.waitForSeconds(3);
		dashboardpage.getincentivemenu();
		webDriverUtility.waitForSeconds(3);

		act.moveToElement(incentivepage.getProgramconfig()).click().perform();
		incentivepage.getProgramconfig().click();
		webDriverUtility.waitForSeconds(3);

		Reporter.log("----SELECT REQUIRED TAX YES----", true);
		act.moveToElement(programconfig.getTaxrequireradio()).click().perform();
		webDriverUtility.waitForSeconds(3);
		act.moveToElement(programconfig.getSaveconfig()).click().perform();

		Reporter.log("----PROGRAM CONFIGURATION SUCCESSFULL----", true);

		Reporter.log("----NAVIGATE TO PUBLIC USER----", true);
		webDriverUtility.waitForSeconds(5);
		dashboardpage.getLMSadmin().click();
		webDriverUtility.waitForSeconds(5);

		dashboardpage.getMenuIcon().click();
		dashboardpage.getInsentiveAdminPanelLink().click();
		incentivepage.getUserAdministrationMenu().click();
		incentivepage.getPublicUserOption().click();

		publicuserpage.getPublicUserSearchButton().sendKeys(userid, Keys.ENTER);
		publicuserpage.getPublicUserApplyButton().click();
		webDriverUtility.waitForSeconds(2);
		publicuserpage.getPublicUserActionButton().click();

		Reporter.log("----EDIT PUBLIC USER----", true);
		publicuserpage.getPublicuseredit().click();

		act.moveToElement(editpublic.getYearhead()).perform();

		Reporter.log("----SELECT DOCUMENT----", true);
		act.doubleClick(editpublic.getDocumentselect()).perform();

		act.click(editpublic.getVerificationdropdown()).perform();
		editpublic.getVerifiedselect().click();

		editpublic.getSavechange().click();
		Reporter.log("----EDIT USER SAVE SUCCESSFULL----", true);

		publicuserpage.getPublicUserSearchButton().clear();
		publicuserpage.getPublicUserSearchButton().sendKeys(userid, Keys.ENTER);
		publicuserpage.getPublicUserApplyButton().click();
		webDriverUtility.waitForSeconds(2);
		Reporter.log("----NAVIGATE TO IMPERSONATE USER----", true);
		publicuserpage.getPublicUserActionButton().click();
		js.executeScript("arguments[0].click()", publicuserpage.getPublicUserImpersonatebutton());

		Reporter.log("----NAVIGATE TO NEW WINDOW----", true);
		webDriverUtility.switchTowindow(driver);
		webDriverUtility.waitForSeconds(5);
		kohlernewpage.getMenuButton().click();
		webDriverUtility.waitForSeconds(2);
		Reporter.log("----NAVIGATE TO REDEEM PAGE----", true);
		redeempage.getGetRedeem().click();
		webDriverUtility.waitForSeconds(2);
		Reporter.log("----NAVIGATE TO KOHLER GIFT PAGE----,TRUE");
		redeempage.getKohlerRewardsCard().click();

		Reporter.log("----ENTER POINTS----", true);
		
		Reporter.log("ACTUAL POINT-->"+point,true);
		Reporter.log("REDEEM POINT-->"+redeemvalue,true);
		driver.findElement(By.xpath("//div/input[contains(@placeholder,'Enter points')]")).sendKeys(redeemvalue);
        webDriverUtility.waitForSeconds(2);
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();    
        
        Reporter.log("----NAVIGATE TO TRANSACTION----", true);
	
        webDriverUtility.waitForSeconds(10);
        act.moveToElement(kohlernewpage.getMenuButton()).perform();
        kohlernewpage.getMenuButton().click();
        kohlernewpage.getTransactionLink().click();
        
        String pointsOnHold = transactionpage.getPointsOnHold().getText();
        
        Reporter.log("POINTS ON HOLD-->"+pointsOnHold,true);
        driver.findElement(By.xpath("//button[text()='Redemptions']")).click();
        
        String totalpointsdeducted = driver.findElement(By.xpath(
				"(//TR[@role='row']/descendant::TD[normalize-space(@class)='mat-cell cdk-cell mat-tooltip-trigger cdk-column-totalPoints mat-column-totalPoints ng-star-inserted'])[1]"))
				.getText();
		Reporter.log("REDEEMPTION POINTS-->"+totalpointsdeducted, true);
	}
}

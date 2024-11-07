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
import org.tyss.flatworld.objectrepository.IncentiveAdminHomePage;
import org.tyss.flatworld.objectrepository.KohlerNewPage;
import org.tyss.flatworld.objectrepository.NavigationTitleQuizPage;
import org.tyss.flatworld.objectrepository.PublicUserPage;
import org.tyss.flatworld.objectrepository.TrainingCoursePage;
import org.tyss.flatworld.objectrepository.TrainingPage;
import org.tyss.flatworld.objectrepository.TransactionPage;
import org.tyss.flatworld.workflowutility.WorkflowUtility;

@Listeners(org.tyss.flatworld.genericutility.ListenerImplementationClass.class)
public class TC_02_CompleteCourseAndVerifyPointsOnHold100PointsTest extends BaseClass {


	@Test
	public void completeCourseAndVerifyPointsOnHold100Points2() throws  InterruptedException, EncryptedDocumentException, IOException {
        
	    Reporter.log("----LOGIN SUCCESSFULL----", true);
	    
		DashboardPage dashboardpage=new DashboardPage(driver);
		IncentiveAdminHomePage incentivepage=new IncentiveAdminHomePage(driver);
		PublicUserPage publicuserpage=new PublicUserPage(driver);
		CurriculumPage curriculumpage=new CurriculumPage(driver);
		TrainingPage trainingpage=new TrainingPage(driver);
		TrainingCoursePage trainingCoursePage=new TrainingCoursePage(driver);
		NavigationTitleQuizPage navigatetitlepage=new NavigationTitleQuizPage(driver);
		WorkflowUtility workflow=new WorkflowUtility();
		KohlerNewPage kohlernewpage=new KohlerNewPage(driver);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		TransactionPage transactionpage=new TransactionPage(driver);

		int number=javaUtility.getRandomNumber(4000);
		String userid = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "userid")+number;
		String firstname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "firstname");
		String lastname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "lastname");
		String organization=javaUtility.getRandomAlphaNumericString(5);
		String email=javaUtility.getRandomAlphaNumericString(5)+"@gmail.com";
		String userdata=firstname+" "+lastname+"_"+userid;
		String date=javaUtility.getDateAndTimeInSpecifiedFormat("MM-dd-yyyy");
		String reqdate=javaUtility.getRequiredDateAndTimeInSpecifiedFormat("MM-dd-yyyy", 2);
		String  point="100";


		
		
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
		publicuserpage.getTaxcheckbox().click();
		new Actions(driver).doubleClick(driver.findElement(By.xpath("//div[@class='mat-form-field-flex ng-tns-c4-21']"))).perform();
        
		publicuserpage.getSaveButton().click();
		
		Reporter.log("----PUBLIC USER ADDED SUCCESSFULLY----", true);
	
		
		//data to excel
		String path="./folderfolder/Kohler_TestData.xlsx";

		
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
		
		String curriculumname=fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH,"curriculumname")+userid;
		String curriculumdescription=fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH,"curriculumdescription")+javaUtility.getRandomAlphaNumericString(20);
		curriculumpage.getCurriculumManagerDescription().sendKeys(curriculumdescription);
		curriculumpage.getCurriculumManagerName().sendKeys(curriculumname);
		new Actions(driver).moveToElement(curriculumpage.getCurriculumSaveButton()).click().perform();
		
		Reporter.log("---- CURRICULUM NAME AND DESCRIPTION SUCCESSFULL----", true);

        
		Reporter.log("---- EXIT FROM CURRICULUM PAGE SUCCESSFULL----", true);
		webDriverUtility.waitForSeconds(5);
		curriculumpage.getCurriculumManagerMenuLink().click();

		Reporter.log("----NAVIGATE TO TRAINING PAGE----", true);
	
		trainingpage.getTrainingCourseLink().click();
		String courseid=userid+fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "courseid");
		String coursename=fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "coursename")+javaUtility.getRandomAlphaNumericString(2);
		Thread.sleep(3000);
		trainingpage.getTrainingPageAddButton().click();
		trainingpage.getEditTrainingCourseIdTextFile().sendKeys(courseid);
		trainingpage.getEditTrainingCourseNameTextField().sendKeys(coursename);

		Actions act = new Actions(driver);
		act.moveToElement(trainingpage.getEditTrainingCurriculumDropdown()).click().perform();
		trainingpage.getCurriculumSearch().sendKeys(curriculumname,Keys.ENTER);
		trainingpage.getCurriculumSearchCheckBox().click();

		
		new Actions(driver).doubleClick(trainingpage.getTrainingUser()).perform();
		trainingpage.getTrainingUserSearch().sendKeys(userdata,Keys.ENTER);
		trainingpage.getTrainingUserCheckBox().click();
		trainingpage.getTrainingStartDate().sendKeys(date);
		trainingpage.getTrainingEndDate().sendKeys(reqdate);
		trainingpage.getTrainingPoint().sendKeys(point);
		new Actions(driver).doubleClick(trainingpage.getTrainingActiveCheckBox()).perform();
		trainingpage.getRequiredcheckbox().click();
		new Actions(driver).moveToElement(trainingpage.getTrainingSave()).click().perform();
		
		Reporter.log("----TRAINING PAGE DATA ADDED SUCCESSFULL----", true);
		
		Reporter.log("----SEARCH DATA IN TRAINING COURSE PAGE----", true);
		trainingCoursePage.getTrainingCourseSearch().sendKeys(coursename,Keys.ENTER);
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
		
		if(navigatetitlepage.getQuizPassingMark().isDisplayed())
		{
			if(navigatetitlepage.getQuizPassingMark().isEnabled())
			{
				wait.until(ExpectedConditions.elementToBeClickable(navigatetitlepage.getQuizPassingMark()));
				navigatetitlepage.getQuizPassingMark().sendKeys("55");
				navigatetitlepage.getQuizSuccessMessage().sendKeys("added-1");
				navigatetitlepage.getQuizFailMessage().sendKeys("fail");
			}
		}
		navigatetitlepage.getQuizAddQuestionButton().click();
		navigatetitlepage.getQuizAddTestField().sendKeys(userid+"_quizQuestionAdded");
		navigatetitlepage.getQuizTrueFalseRadioButton().click();
		js.executeScript("arguments[0].click();",navigatetitlepage.getQuizTrueCheckBox());

		workflow.screenSizeReduce();

		js.executeScript("arguments[0].click();",navigatetitlepage.getQuizAddSaveButton());
		webDriverUtility.waitForSeconds(5);

		js.executeScript("arguments[0].click();",navigatetitlepage.getQuizEditSaveButton());
		webDriverUtility.waitForSeconds(6);
		wait.until(ExpectedConditions.elementToBeClickable(	navigatetitlepage.getQuizEditCloseButton()));
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
		publicuserpage.getPublicUserSearchButton().sendKeys(userid,Keys.ENTER);     
		publicuserpage.getPublicUserApplyButton().click();
		webDriverUtility.waitForSeconds(2);
		publicuserpage.getPublicUserActionButton().click();
		js.executeScript("arguments[0].click()",publicuserpage.getPublicUserImpersonatebutton());
		
		Reporter.log("----NAVIGATE TO NEW WINDOW----", true);
		webDriverUtility.switchTowindow(driver);
		webDriverUtility.waitForSeconds(5);
		kohlernewpage.getMenuButton().click();
		webDriverUtility.waitForSeconds(2);
		Reporter.log("----NAVIGATE TO ACADEMY PAGE----", true);
		kohlernewpage.getAcademyLink().click();
        
		webDriverUtility.waitForSeconds(10);
		Reporter.log("----NAVIGATE TO CURRICULUM PAGE----", true);
		driver.findElement(By.xpath("//h3[text()='"+curriculumname+"']")).click();
		driver.findElement(By.xpath("//h6[text()='"+coursename+"']")).click();
		Reporter.log("----NAVIGATE TO TEST PAGE----", true);
		kohlernewpage.getCheckBoxTrue().click();
		kohlernewpage.getTestSubmit().click();
		Reporter.log("----TEST SUCCESSFULL----", true);
		String successfull=kohlernewpage.getTestSuccessFullMessage().getText();
		Reporter.log("----TEST SUCCESSFULL MESSAGE----"+successfull, true);
		
		webDriverUtility.waitForSeconds(3);
		kohlernewpage.getMenuButton().click();
		kohlernewpage.getTransactionLink().click();
		
		String pointtext = driver.findElement(By.xpath("//span[contains(@class,'spnPoints inline-flex items-center')]")).getText();
		
		if (pointtext.contains(point)) {
		Reporter.log("---100 POINT CREDITED SUCCESFFULL TEST PASS", true);
		}
		else {
			Reporter.log("---100 POINT NOT CREDITED TEST FAIL", true);	
		}
		
		String pointsOnHold = transactionpage.getPointsOnHold().getText();
		Reporter.log(pointsOnHold + ": POINTS ON HOLD", true);
		
		Reporter.log("----TEST COMPLETED----", true);

		// Verify points are credited
		assertionUtility.assertEquals(pointsOnHold,point+" points  ", "POINTS ARE ADDED");


	}
}
package org.tyss.flatworld.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
import org.tyss.flatworld.objectrepository.PointsCreditManagerPage;
import org.tyss.flatworld.objectrepository.PublicUserPage;
import org.tyss.flatworld.objectrepository.RedeemPage;
import org.tyss.flatworld.objectrepository.TrainingCoursePage;
import org.tyss.flatworld.objectrepository.TrainingPage;
import org.tyss.flatworld.objectrepository.TransactionPage;
import org.tyss.flatworld.workflowutility.WorkflowUtility;
@Listeners(org.tyss.flatworld.genericutility.ListenerImplementationClass.class)
public class TC_22_VerifyInactiveUserPointsCannotRedeemButCanBeCreditedTest extends BaseClass{
	
	@Test
	public void verifyInactiveUserPointsCannotRedeemButCanBeCredited22() throws InterruptedException, EncryptedDocumentException, IOException, AWTException {
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        
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
			PointsCreditManagerPage pointsCreditManagerPage=new PointsCreditManagerPage(driver);
			TransactionPage transactionpage=new TransactionPage(driver);
			RedeemPage redeempage=new RedeemPage(driver);
			JavascriptExecutor js=(JavascriptExecutor) driver;

			int number=javaUtility.getRandomNumber(4000);
			String userid = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "userid")+number;
			String firstname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "firstname");
			String lastname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "lastname");
			String organization=javaUtility.getRandomAlphaNumericString(5);
			String email=javaUtility.getRandomAlphaNumericString(5)+"@gmail.com";
			String userdata=firstname+" "+lastname+"_"+userid;
			String date=javaUtility.getDateAndTimeInSpecifiedFormat("MM-dd-yyyy");
			String reqdate=javaUtility.getRequiredDateAndTimeInSpecifiedFormat("MM-dd-yyyy", 2);
			String  point="200";
			String invoicenumber = "123" + javaUtility.getRandomNumber(10000);
			String skuselect = "24564-PC-FF";
			String redeemvaluegift="4";

			dashboardpage.getMenuIcon().click();
			Reporter.log("----MENU HAMBURGER ICON CLICK SUCCESSFULL----", true);
			
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
			publicuserpage.statusSelection("Inactive");
			publicuserpage.getTaxcheckbox().click();
			new Actions(driver).doubleClick(driver.findElement(By.xpath("//div[@class='mat-form-field-flex ng-tns-c4-21']"))).perform();
	        
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
			
			incentivepage.getPointsCreditManager().click();

			Reporter.log("----CLICK ON ADD CREDIT INVOICE BUTTON----", true);
			pointsCreditManagerPage.getAddCreditInvoiceButton().click();
			pointsCreditManagerPage.getInvoiceDate().sendKeys(javaUtility.getDateAndTimeInSpecifiedFormat("MM-dd-yyyy"));
			pointsCreditManagerPage.getInvoiceNumber().sendKeys(invoicenumber);
			webDriverUtility.waitForSeconds(5);

			pointsCreditManagerPage.getSkudropdown().click();
			webDriverUtility.waitForSeconds(5);
			pointsCreditManagerPage.getSkudropdownsearch().sendKeys(skuselect, Keys.ENTER);
			webDriverUtility.waitForSeconds(5);
			pointsCreditManagerPage.getSkucheckbox().click();

			webDriverUtility.escape();
			webDriverUtility.waitForSeconds(5);
			pointsCreditManagerPage.getUserid().sendKeys(userid);
			pointsCreditManagerPage.getAddCreditPageSaveButton().click();

			Reporter.log("----ADD CREDIT PAGE SAVE SUCCESSFULL----", true);

			webDriverUtility.waitForSeconds(10);
			Reporter.log("----VERIFY IN LIST----", true);
			String invoicenum = pointsCreditManagerPage.getVerifyinvoicenum().getText();
			String totalpoints = pointsCreditManagerPage.getVerifyinvoicepoint().getText();
			Reporter.log("INVOICE NUMBER :" + invoicenum, true);
			Reporter.log("TOTAL POINTS :" + totalpoints, true);

			webDriverUtility.waitForSeconds(10);
			dashboardpage.getLMSadmin().click();
			dashboardpage.getMenuIcon().click();
			dashboardpage.getInsentiveAdminPanelLink().click();
			webDriverUtility.waitForSeconds(3);
			dashboardpage.getincentivemenu().click();
			webDriverUtility.waitForSeconds(3);
			incentivepage.getUserAdministrationMenu().click();
			incentivepage.getPublicUserOption().click();

			Reporter.log("----NAVIGATE TO PUBLIC USER----", true);
			publicuserpage.getPublicUserSearchButton().sendKeys(userid, Keys.ENTER);
			publicuserpage.getPublicUserApplyButton().click();
			webDriverUtility.waitForSeconds(2);
			publicuserpage.getPublicUserActionButton().click();

			Reporter.log("----NAVIGATE TO IMPERSONATE USER----", true);

			js.executeScript("arguments[0].click()", publicuserpage.getPublicUserImpersonatebutton());

			Reporter.log("----SWITCH TO NEW WINDOW----", true);
			webDriverUtility.switchTowindow(driver);
			webDriverUtility.waitForSeconds(5);
			kohlernewpage.getMenuButton().click();
			webDriverUtility.waitForSeconds(2);

			Reporter.log("----NAVIGATE TO TRANSACTION LINK----", true);
			kohlernewpage.getTransactionLink().click();
			webDriverUtility.waitForSeconds(2);

			boolean actualresult = transactionpage.getPoints().isDisplayed();
			Assert.assertEquals(actualresult, true, "POINTS DISPLAYED");

			String actualinvoice = transactionpage.getCaptureinvoice().getText();
			Reporter.log("INVOICE IN TRANSACTION PAGE :" + actualinvoice, true);

			String actualpoints = transactionpage.getPoints().getText();
			Reporter.log("POINTS IN TRANSACTION PAGE :" + actualpoints, true);

			String pointsOnHold = transactionpage.getPointsOnHold().getText();
			Reporter.log("POINTS ON HOLD :" + pointsOnHold, true);
			
			webDriverUtility.waitForSeconds(10);
			
			kohlernewpage.getMenuButton().click();
			webDriverUtility.waitForSeconds(2);
			Reporter.log("----NAVIGATE TO REDEEM PAGE----", true);
			redeempage.getGetRedeem().click();
			webDriverUtility.waitForSeconds(2);
			Reporter.log("----NAVIGATE TO KOHLER GIFT PAGE----,TRUE");
			redeempage.getKohlerRewardsGift().click();

			Reporter.log("----ENTER POINTS----", true);
			
			Reporter.log("ACTUAL POINT-->"+point,true);
			Reporter.log("REDEEM POINT-->"+redeemvaluegift,true);
			driver.findElement(By.xpath("//div/input[contains(@placeholder,'Enter points')]")).sendKeys(redeemvaluegift);
	        webDriverUtility.waitForSeconds(2);
	        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();    
	        
	        Reporter.log("----NAVIGATE TO TRANSACTION----", true);
		
	        webDriverUtility.waitForSeconds(10);
	        act.moveToElement(kohlernewpage.getMenuButton()).perform();
	        kohlernewpage.getMenuButton().click();

			
			
		
	}

}

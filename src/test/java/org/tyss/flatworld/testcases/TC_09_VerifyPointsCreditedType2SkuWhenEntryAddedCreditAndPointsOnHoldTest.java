
package org.tyss.flatworld.testcases;

import java.awt.AWTException;
import java.time.Duration;
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.flatworld.genericutility.BaseClass;
import org.tyss.flatworld.genericutility.IConstants;
import org.tyss.flatworld.objectrepository.DashboardPage;
import org.tyss.flatworld.objectrepository.IncentiveAdminHomePage;
import org.tyss.flatworld.objectrepository.KohlerNewPage;
import org.tyss.flatworld.objectrepository.PointsCreditManagerPage;
import org.tyss.flatworld.objectrepository.PublicUserPage;
import org.tyss.flatworld.objectrepository.TransactionPage;

@Listeners(org.tyss.flatworld.genericutility.ListenerImplementationClass.class)
public class TC_09_VerifyPointsCreditedType2SkuWhenEntryAddedCreditAndPointsOnHoldTest extends BaseClass {
	
	@Test
	public void verifyPointsCreditedType2SkuWhenEntryAddedCreditAndPointsOnHold9() throws InterruptedException, AWTException {
		

		Reporter.log("----LOGIN SUCCESSFULL----", true);

		DashboardPage dashboardpage = new DashboardPage(driver);
		IncentiveAdminHomePage incentivepage = new IncentiveAdminHomePage(driver);
		PublicUserPage publicuserpage = new PublicUserPage(driver);
		KohlerNewPage kohlernewpage = new KohlerNewPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		PointsCreditManagerPage pointsCreditManagerPage = new PointsCreditManagerPage(driver);
		TransactionPage transactionpage = new TransactionPage(driver);

		int number = javaUtility.getRandomNumber(4000);
		String userid = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "userid") + number;
		String firstname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "firstname");
		String lastname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "lastname");
		String organization = javaUtility.getRandomAlphaNumericString(5);
		String email = javaUtility.getRandomAlphaNumericString(5) + "@gmail.com";
		String invoicenumber = "123" + javaUtility.getRandomNumber(10000);

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
		new Actions(driver)
				.doubleClick(driver.findElement(By.xpath("//div[@class='mat-form-field-flex ng-tns-c4-21']")))
				.perform();

		publicuserpage.getSaveButton().click();
		Reporter.log("----PUBLIC USER ADDED SUCCESSFULLY----", true);

		webDriverUtility.waitForSeconds(5);

		Reporter.log("----NAVIGATE TO POINTS CREDIT MANAGER----", true);
		dashboardpage.getincentivemenu().click();
		incentivepage.getPointsCreditManager().click();

		Reporter.log("----CLICK ON ADD CREDIT INVOICE BUTTON----", true);
		pointsCreditManagerPage.getAddCreditInvoiceButton().click();
		pointsCreditManagerPage.getInvoiceDate().sendKeys(javaUtility.getDateAndTimeInSpecifiedFormat("MM-dd-yyyy"));
		pointsCreditManagerPage.getInvoiceNumber().sendKeys(invoicenumber);
		webDriverUtility.waitForSeconds(7);
	    
	    js.executeScript("arguments[0].click();", pointsCreditManagerPage.getSkudropdown());
	    
	    pointsCreditManagerPage.getSkucheckbox().click();
       
	    webDriverUtility.escape();
	 
        webDriverUtility.waitForSeconds(2);
        String skuttotalprice = pointsCreditManagerPage.getSkuTotalPrice().getText();
		String skuttotalpoints = pointsCreditManagerPage.getSkuTotalPoints().getText();
		Reporter.log("----TOTAL PRICE " + skuttotalprice, true);
		Reporter.log("----TOTAL POINTS " + skuttotalpoints, true);
		pointsCreditManagerPage.getUserid().sendKeys(userid); 
        
        String date =  driver.findElement(By.xpath("(//input[contains(@data-mat-calendar,'mat-datepicker')])[6]")).getAttribute("max");
        String elementDate=date.substring(0,10);
        LocalDate currentDate = LocalDate.now();
        
        if (elementDate.contains(currentDate.toString())) {
     
        	Reporter.log("---DATE MATCH--PASS--"+elementDate, true);
		}
        else {
        	Reporter.log("---DATE MATCH--FAIL--", true);
		}
       
        pointsCreditManagerPage.getAddCreditPageSaveButton().click();

		Reporter.log("----ADD CREDIT PAGE SAVE SUCCESSFULL----", true);

		webDriverUtility.waitForSeconds(10);
		dashboardpage.getincentivemenu().click();
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		boolean invoicenum = driver.findElement(By.xpath("//span[contains(text(),'"+invoicenumber+"')]")).isDisplayed();
		Assert.assertEquals(invoicenum, true, "INVOICENUMBER IS DISPLAYED :"+invoicenumber);
		
		String pointsOnHold = transactionpage.getPointsOnHold().getText();
		Reporter.log(pointsOnHold + ": POINTS ON HOLD", true);
		
		Reporter.log("----TEST COMPLETED----", true);
		
		
	}

}

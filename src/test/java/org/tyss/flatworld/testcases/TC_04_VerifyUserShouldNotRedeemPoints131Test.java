package org.tyss.flatworld.testcases;

import java.time.Duration;

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
import org.tyss.flatworld.objectrepository.PublicUserPage;
import org.tyss.flatworld.objectrepository.RedeemPage;

@Listeners(org.tyss.flatworld.genericutility.ListenerImplementationClass.class)
public class TC_04_VerifyUserShouldNotRedeemPoints131Test extends BaseClass{
	
	@Test
	public void verifyUserShouldNotRedeemPoints131Test4() throws InterruptedException {
		
        
	    Reporter.log("----LOGIN SUCCESSFULL----", true);
	    
		DashboardPage dashboardpage=new DashboardPage(driver);
		IncentiveAdminHomePage incentivepage=new IncentiveAdminHomePage(driver);
		PublicUserPage publicuserpage=new PublicUserPage(driver);
		KohlerNewPage kohlernewpage=new KohlerNewPage(driver);
		RedeemPage redeempage=new RedeemPage(driver);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		int number=javaUtility.getRandomNumber(4000);
		String userid = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "userid")+number;
		String firstname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "firstname");
		String lastname = fileUtility.getDataFromPropertyFile(IConstants.PROPERTY_FILE_PATH, "lastname");
		String organization=javaUtility.getRandomAlphaNumericString(5);
		String email=javaUtility.getRandomAlphaNumericString(5)+"@gmail.com";
		String numberValue="131";
		String expecteddata="Available points are '0' or negative, you cannot redeem.";


		
		
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
		new Actions(driver).doubleClick(driver.findElement(By.xpath("//div[@class='mat-form-field-flex ng-tns-c4-21']"))).perform();
		publicuserpage.getSaveButton().click();
	
		Reporter.log("----PUBLIC USER ADDED SUCCESSFULLY----", true);
		
		webDriverUtility.waitForSeconds(5);
	
		Reporter.log("----NAVIGATE TO IMPERSONATE BUTTON----", true);
		publicuserpage.getPublicUserSearchButton().sendKeys(userid,Keys.ENTER);     
		publicuserpage.getPublicUserApplyButton().click();
		webDriverUtility.waitForSeconds(2);
		publicuserpage.getPublicUserActionButton().click();
		js.executeScript("arguments[0].click()",publicuserpage.getPublicUserImpersonatebutton());
		
		Reporter.log("----SWITCH TO NEW WINDOW----", true);
		webDriverUtility.switchTowindow(driver);
		
		kohlernewpage.getMenuButton().click();
		Reporter.log("----NAVIGATE TO REDEEM PAGE----", true);
		redeempage.getGetRedeem().click();
		webDriverUtility.waitForSeconds(2);
		Reporter.log("----NAVIGATE TO KOHLER REWARDS PAGE----,TRUE");
		redeempage.getKohlerRewardsCard().click();
		
		Reporter.log("----ENTER POINTS----", true);
		redeempage.getLoadMyCardNumber().clear();
		redeempage.getLoadMyCardNumber().sendKeys(numberValue);
		redeempage.getRedeemNowButton().click();
		
		
		String actualAlertText = redeempage.getCaptureActualText().getText();
		Reporter.log("----CAPTURED ACTUAL DATA----", true);
	    Reporter.log("Alert message for "+numberValue+" is displayed successfully",true);
	    Reporter.log("----TEST PASS----", true);
	    
	    // verify error message
	    assertionUtility.assertEquals(actualAlertText, expecteddata, "ERROR MESSAGE IS DISPLAYED");
		
	}

}

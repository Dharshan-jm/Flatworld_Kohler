package org.tyss.flatworld.testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.flatworld.genericutility.BaseClass;
import org.tyss.flatworld.objectrepository.DashboardPage;
import org.tyss.flatworld.objectrepository.IncentiveAdminHomePage;
import org.tyss.flatworld.objectrepository.KohlerNewPage;
import org.tyss.flatworld.objectrepository.OrderRedeemptionManagerPage;
import org.tyss.flatworld.objectrepository.PublicUserPage;
import org.tyss.flatworld.objectrepository.TransactionPage;

@Listeners(org.tyss.flatworld.genericutility.ListenerImplementationClass.class)
public class TC_11_VerifyRedeemEntryAddedInOrderRedeemptionTest extends BaseClass {

	@Test
	public void verifyRedeemEntryAddedInOrderRedeemption11() throws InterruptedException {


		Reporter.log("----LOGIN SUCCESSFULL----", true);

		DashboardPage dashboardpage = new DashboardPage(driver);
		IncentiveAdminHomePage incentivepage = new IncentiveAdminHomePage(driver);
		PublicUserPage publicuserpage = new PublicUserPage(driver);
		KohlerNewPage kohlernewpage = new KohlerNewPage(driver);
		OrderRedeemptionManagerPage orderredeem = new OrderRedeemptionManagerPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		TransactionPage transactionpage = new TransactionPage(driver);

		String userid = "egrpublic2";
		String date = javaUtility.getDateAndTimeInSpecifiedFormat("MM-dd-yyyy");
		int ordernumber = javaUtility.getRandomNumber(5000);

		String poNumber = String.valueOf(javaUtility.getRandomNumber(1000));
		String quantity = "5";
		String perPriceQuantity = "5";
		String pointPerQuantity = "7";
		String itemName = javaUtility.getRandomAlphaNumericString(5);
		String vendorName = "vendor" + javaUtility.getRandomAlphaNumericString(5);

		dashboardpage.getMenuIcon().click();
		Reporter.log("----MENU HAMBURGER ICON CLICK SUCCESSFULL----", true);

		dashboardpage.getInsentiveAdminPanelLink().click();
		Reporter.log("----INCENTIVE ADMIN HOME PAGE CLICK SUCCESSFULL----", true);
		dashboardpage.getincentivemenu().click();
		Reporter.log("----INCENTIVE ADMIN HOME PAGE DISPLAYED SUCCESSFULL----", true);
		
		Reporter.log("----NAVIGATE TO ORDER REDEEMPTION MANAGER----", true);
		incentivepage.getOrderredemptionmanager().click();

		Reporter.log("----CLICK ADD SINGLE USER----", true);
		orderredeem.getSingleusersearchadd().click();
		orderredeem.getAddneworderbutton().click();
	
		webDriverUtility.waitForSeconds(5);
		orderredeem.getUsername().sendKeys(userid);
		orderredeem.getOrderdate().sendKeys(date);
		orderredeem.getOrdernumber().sendKeys(String.valueOf(ordernumber));
        
		Reporter.log("----CLICK ADD NEW ITEM----", true);
		orderredeem.getAdditem().click();
		webDriverUtility.waitForSeconds(5);
		orderredeem.getPonumber().sendKeys(poNumber);
		orderredeem.getQuantity().sendKeys(quantity);
		orderredeem.getPrice().sendKeys(perPriceQuantity);
		orderredeem.getPoints().sendKeys(pointPerQuantity);
		orderredeem.getItemname().sendKeys(itemName);
        orderredeem.getVendorname().sendKeys(vendorName);
		webDriverUtility.waitForSeconds(5);
		orderredeem.getStatusselect().click();
		orderredeem.getStatuspending().click();
		orderredeem.getAddeditordersave().click();
		
		Reporter.log("----SUCCESSFULLY ADDED NEW ITEM----", true);
		
		webDriverUtility.waitForSeconds(3);
		orderredeem.getAddnewordersave().click();	 
		Reporter.log("----SUCCESSFULLY ADDED SINGLE USER----", true);
		webDriverUtility.waitForSeconds(5);	    
		
		Reporter.log("----VERIFY USER ID IN REDEMPTION ENTRY LIST----", true);
		String getuserid = driver.findElement(By.xpath("(//td[contains(@role,'cell')])[2]")).getText();
		System.out.println(getuserid);
		if (getuserid.contains(userid)) {
			Reporter.log(userid + "--SAME USERID PRESENT IN ORDER REDEEMPTION ENTRY LIST :" + getuserid, true);
		} else {
			Reporter.log(userid + "--DIFFERENT USERID PRESENT IN ORDER REDEEMPTION ENTRY LIST :" + getuserid, true);
		}
         
		Reporter.log("----NAVIGATE TO PUBLIC USER----", true);
		dashboardpage.getincentivemenu().click();
		incentivepage.getUserAdministrationMenu().click();
		incentivepage.getPublicUserOption().click();
        
		Reporter.log("----SEARCH PUBLIC USER----", true);
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
		Reporter.log("----NAVIGATE TO TRANSACTION LINK----", true);
		kohlernewpage.getTransactionLink().click();
		webDriverUtility.waitForSeconds(3);

		Reporter.log("----NAVIGATE TO REDEEMPTION----", true);
		driver.findElement(By.xpath("//button[text()='Redemptions']")).click();
		webDriverUtility.waitForSeconds(10);

		Reporter.log("----REDEEMPTION CALCULATION----", true);
		String pointsOnHold = transactionpage.getPointsOnHold().getText();

		int pointscal = Integer.valueOf(quantity) * Integer.valueOf(pointPerQuantity);
		Reporter.log("REDEEM POINTS-->" + pointscal, true);
		String val = pointsOnHold;
		String[] div = val.split(" ");
		int originalpoint = Integer.valueOf(div[0]) + pointscal;
		Reporter.log("ORIGINAL POINTS-->" + originalpoint, true);

		int afterredeem = originalpoint - pointscal;
		Reporter.log("AFTER REDEEM CALCULATED POINTS-->"+afterredeem, true);

		Reporter.log("----ACTUAL RESULT REDEEMPTION----", true);
		Reporter.log("ACTUAL POINTS ON HOLD-->" + pointsOnHold, true);

		String totalpointsdeducted = driver.findElement(By.xpath(
				"(//TR[@role='row']/descendant::TD[normalize-space(@class)='mat-cell cdk-cell mat-tooltip-trigger cdk-column-totalPoints mat-column-totalPoints ng-star-inserted'])[1]"))
				.getText();
		Reporter.log("REDEEMPTION POINTS-->"+totalpointsdeducted, true);

		if (pointsOnHold.contains(String.valueOf(afterredeem))) {
			Reporter.log("---PASS----", true);
			Reporter.log(afterredeem + " : BOTH CALULATED AND POINTS ON HOLD POINTS ARE SAME :" + pointsOnHold, true);
		} else {
			Reporter.log("---FAIL----", true);
			Reporter.log(afterredeem + " : BOTH CALULATED AND POINTS ON HOLD POINTS ARE NOT SAME :" + pointsOnHold,
					true);
		}

	}

}

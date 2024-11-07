package org.tyss.flatworld.testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
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
import org.tyss.flatworld.objectrepository.PublicUserPage;
import org.tyss.flatworld.objectrepository.RedeemPage;

@Listeners(org.tyss.flatworld.genericutility.ListenerImplementationClass.class)
public class TC_20_VerifyPointsConversionKohlerRewardCardPageTest extends BaseClass {

	@Test
	public void verifyPointsConversionKohlerRewardCardPage20() throws EncryptedDocumentException, IOException, InterruptedException {


		String userid = "thor1";

		Reporter.log("----LOGIN SUCCESSFULL----", true);

		DashboardPage dashboardpage = new DashboardPage(driver);
		IncentiveAdminHomePage incentivepage = new IncentiveAdminHomePage(driver);
		PublicUserPage publicuserpage = new PublicUserPage(driver);
		KohlerNewPage kohlernewpage = new KohlerNewPage(driver);
		RedeemPage redeempage = new RedeemPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		dashboardpage.getMenuIcon().click();
		Reporter.log("----MENU ICON HAMBURGER ICON CLICK SUCCESSFULL----", true);

		dashboardpage.getInsentiveAdminPanelLink().click();
		Reporter.log("----INCENTIVE ADMIN HOME PAGE CLICK SUCCESSFULL----", true);
		dashboardpage.getincentivemenu().click();

		incentivepage.getUserAdministrationMenu().click();
		Reporter.log("----USER ADMINISTRATION CLICK SUCCESSFULL----", true);

		incentivepage.getPublicUserOption().click();
		Reporter.log("----PUBLIC USER CLICK OPTION CLICK SUCCESSFULL----", true);

		Reporter.log("----NAVIGATE TO PUBLIC USER PAGE SEARCH----", true);
		publicuserpage.getPublicUserSearchButton().sendKeys(userid, Keys.ENTER);
		publicuserpage.getPublicUserApplyButton().click();
		webDriverUtility.waitForSeconds(2);
		Reporter.log("----NAVIGATE TO IMPERSONATE USER----", true);
		publicuserpage.getPublicUserActionButton().click();
		js.executeScript("arguments[0].click()", publicuserpage.getPublicUserImpersonatebutton());

		Reporter.log("----NAVIGATE TO NEW WINDOW----", true);
		webDriverUtility.switchTowindow(driver);
		webDriverUtility.waitForSeconds(10);
		kohlernewpage.getMenuButton().click();
		webDriverUtility.waitForSeconds(5);
		redeempage.getGetRedeem().click();

		Reporter.log("----NAVIGATE TO KOHLER DIRECT GIFT CARD----", true);

		redeempage.getKohlerRewardsGift().click();
		webDriverUtility.waitForSeconds(10);

		String totalAvailablePoint = driver.findElement(By.xpath("(//div[@class='card-header-numbers'])[2]")).getText();
		String valueOfAvailablePoint = driver.findElement(By.xpath("(//div[@class='card-header-numbers'])[3]"))
				.getText();
		Reporter.log("----TOTAL AVAILABLE POINTS----:" + totalAvailablePoint, true);
		Reporter.log("----VALUE AVAILABLE POINTS----:" + valueOfAvailablePoint, true);
		System.out.println(valueOfAvailablePoint);
		int availablePoints = Integer.parseInt(totalAvailablePoint);
		int result = (int) ((availablePoints - 2) / 1.2825);
		System.out.println(result);
		String resultAvailablePoint = String.valueOf(result);
		System.out.println(resultAvailablePoint);

		if (valueOfAvailablePoint.contains(resultAvailablePoint)) {

			Reporter.log("----AFTER CALULATION POINTS----:" + resultAvailablePoint, true);
			Reporter.log("----VALUE AVAILABLE POINTS----:" + valueOfAvailablePoint, true);
			Reporter.log("----TEST PASS----", true);
		} else {
			Reporter.log("----TEST FAIL----", true);
		}

		assertionUtility.assertTrue(valueOfAvailablePoint.contains(resultAvailablePoint), "BOTH POINTS ARE SAME");
	}
}

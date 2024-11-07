package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IncentiveAdminHomePage {
	WebDriver driver;
	@FindBy(xpath = "//div/span[normalize-space(text())='User Administration']") private WebElement userAdministrationMenu;
	@FindBy(xpath = "//div/span[normalize-space(text())='Public User']") private WebElement publicUserOption;
	@FindBy(xpath = "//span[text()=' Points Credit Manager ']") private WebElement pointsCreditManager;
	@FindBy(xpath="//span[contains(text(),'Program Configuration')]")private WebElement programconfig;
	@FindBy(xpath="//span[contains(text(),'Order Redemption Manager')]")private WebElement orderredemptionmanager;
	
	
	public WebElement getOrderredemptionmanager() {
		return orderredemptionmanager;
	}

	public void setOrderredemptionmanager(WebElement orderredemptionmanager) {
		this.orderredemptionmanager = orderredemptionmanager;
	}

	public IncentiveAdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProgramconfig() {
		return programconfig;
	}

	public void setProgramconfig(WebElement programconfig) {
		this.programconfig = programconfig;
	}

	public WebElement getPointsCreditManager() {
		return pointsCreditManager;
	}

	public void setPointsCreditManager(WebElement pointsCreditManager) {
		this.pointsCreditManager = pointsCreditManager;
	}

	public WebElement getUserAdministrationMenu() {
		return userAdministrationMenu;
	}

	public void setUserAdministrationMenu(WebElement userAdministrationMenu) {
		this.userAdministrationMenu = userAdministrationMenu;
	}

	public WebElement getPublicUserOption() {
		return publicUserOption;
	}

	public void setPublicUserOption(WebElement publicUserOption) {
		this.publicUserOption = publicUserOption;
	}

}

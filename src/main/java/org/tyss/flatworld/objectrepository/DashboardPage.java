package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
WebDriver driver;
	
    public DashboardPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
	//menu buttons
	//baseboardmenu button
	@FindBy(xpath = "//span[text()='Menu']")private WebElement menuButton;
	
	@FindBy(xpath ="//span[contains(text(),'Go to LMS Admin')]") private WebElement LMSadmin;
	
	//incentivepagemenu button
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-icon-button mat-button-base ng-star-inserted']")
	private WebElement incentivemenu;
	
	@FindBy(xpath = "//a[normalize-space(text())='LMS Admin Panel']") private WebElement lmsAdminPanelMenu;
	@FindBy(xpath = "//a[@class='nav-link menu-item']") private WebElement incentiveAdminPanelLink;

	
	
	public WebElement getLMSadmin() {
		return LMSadmin;
	}

	public void setLMSadmin(WebElement lMSadmin) {
		LMSadmin = lMSadmin;
	}

	public WebElement getincentivemenu() {
		return incentivemenu;
	}

	public void setincentivemenu(WebElement incentivemenu) {
		this.incentivemenu = incentivemenu;
	}

	public WebElement getMenuIcon() {
		return menuButton;
	}

	public void setMenuIcon(WebElement menuIcon) {
		this.menuButton = menuIcon;
	}

	public WebElement getLmsAdminPanelMenu() {
		return lmsAdminPanelMenu;
	}

	public void setLmsAdminPanelMenu(WebElement lmsAdminPanelMenu) {
		this.lmsAdminPanelMenu = lmsAdminPanelMenu;
	}

	public WebElement getInsentiveAdminPanelLink() {
		return incentiveAdminPanelLink;
	}

	public void setInsentiveAdminPanelLink(WebElement insentiveAdminPanelLink) {
		this.incentiveAdminPanelLink = insentiveAdminPanelLink;
	}

}

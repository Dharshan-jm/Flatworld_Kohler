package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PublicUserPage {
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Add User']") private WebElement addUserButton;
	@FindBy(xpath = "//mat-label[text()='User ID *']/ancestor::div/input") private WebElement userIdTextfield;
	@FindBy(xpath = "//mat-label[text()='Email *']/ancestor::div/input") private WebElement emailTextfield;
	@FindBy(xpath = "//mat-label[text()='First Name *']/ancestor::div/input") private WebElement firstNameTextfield;
	@FindBy(xpath = "//mat-label[text()='Last Name *']/ancestor::div/input") private WebElement lastNameTextfield;
	@FindBy(xpath = "//mat-label[text()='Organization *']/ancestor::div/input") private WebElement organizationTextfield;
	@FindBy(xpath = "//mat-label[text()='Role / Job Title *']/ancestor::div/mat-select") private WebElement roleOrJobTitlePckList;
	@FindBy(xpath = "//mat-label[text()='Role / Job Title *']/ancestor::div/mat-select") private WebElement roleOrJobTitlePickListOption;
	@FindBy(xpath = "//mat-label[text()='Account Status *']/ancestor::div/mat-select") private WebElement accountStatusPicklist;
	@FindBy(xpath = "//button/span[normalize-space(text())='Save']") private WebElement saveButton;
	@FindBy(xpath = "//input[@formcontrolname='search']") private WebElement publicUserSearchButton;
	@FindBy(xpath="//button[text()='Apply']") private WebElement publicUserApplyButton;
	@FindBy(xpath="(//div[contains(text(),'Actions')])[2]") private WebElement publicUserActionButton;
	@FindBy(xpath="//span[contains(text(),'Impersonate User')]/..") private WebElement publicUserImpersonatebutton;
	@FindBy(xpath = "//div[@class='mat-form-field-flex ng-tns-c4-21']") private WebElement userSelect;
	@FindBy(xpath = "//span[contains(text(),'Edit User')]") private WebElement publicuseredit;
	@FindBy(xpath = "//div[@role='alert']") private WebElement alertToasterMessage;
	@FindBy(xpath = "(//span[@class='mat-checkbox-inner-container'])[2]")private WebElement taxcheckbox;  
	public WebElement getTaxcheckbox() {
		return taxcheckbox;
	}

	public void setTaxcheckbox(WebElement taxcheckbox) {
		this.taxcheckbox = taxcheckbox;
	}
	
	public WebElement getPublicuseredit() {
		return publicuseredit;
	}

	public void setPublicuseredit(WebElement publicuseredit) {
		this.publicuseredit = publicuseredit;
	}

	public WebElement getUserSelect() {
		return userSelect;
	}

	public void setUserSelect(WebElement userSelect) {
		this.userSelect = userSelect;
	}

	public WebElement getPublicUserSearchButton() {
		return publicUserSearchButton;
	}

	public void setPublicUserSearchButton(WebElement publicUserSearchButton) {
		this.publicUserSearchButton = publicUserSearchButton;
	}

	public WebElement getPublicUserApplyButton() {
		return publicUserApplyButton;
	}

	public void setPublicUserApplyButton(WebElement publicUserApplyButton) {
		this.publicUserApplyButton = publicUserApplyButton;
	}

	public WebElement getPublicUserActionButton() {
		return publicUserActionButton;
	}

	public void setPublicUserActionButton(WebElement publicUserActionButton) {
		this.publicUserActionButton = publicUserActionButton;
	}

	public WebElement getPublicUserImpersonatebutton() {
		return publicUserImpersonatebutton;
	}

	public void setPublicUserImpersonatebutton(WebElement publicUserImpersonatebutton) {
		this.publicUserImpersonatebutton = publicUserImpersonatebutton;
	}

	public PublicUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccountStatusPicklistOption(String status) {
		return driver.findElement(By.xpath("//mat-label[text()='Account Status *']/ancestor::div/descendant::span[text()='"+status+"']"));
	}
	
	public WebElement getAddUserButton() {
		return addUserButton;
	}

	public void setAddUserButton(WebElement addUserButton) {
		this.addUserButton = addUserButton;
	}

	public WebElement getUserIdTextfield() {
		return userIdTextfield;
	}

	public void setUserIdTextfield(WebElement userIdTextfield) {
		this.userIdTextfield = userIdTextfield;
	}

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public void setEmailTextfield(WebElement emailTextfield) {
		this.emailTextfield = emailTextfield;
	}

	public WebElement getFirstNameTextfield() {
		return firstNameTextfield;
	}

	public void setFirstNameTextfield(WebElement firstNameTextfield) {
		this.firstNameTextfield = firstNameTextfield;
	}

	public WebElement getLastNameTextfield() {
		return lastNameTextfield;
	}

	public void setLastNameTextfield(WebElement lastNameTextfield) {
		this.lastNameTextfield = lastNameTextfield;
	}

	public WebElement getOrganizationTextfield() {
		return organizationTextfield;
	}

	public void setOrganizationTextfield(WebElement organizationTextfield) {
		this.organizationTextfield = organizationTextfield;
	}

	public WebElement getRoleOrJobTitlePckList() {
		return roleOrJobTitlePckList;
	}

	public void setRoleOrJobTitlePckList(WebElement roleOrJobTitlePckList) {
		this.roleOrJobTitlePckList = roleOrJobTitlePckList;
	}

	public WebElement getRoleOrJobTitlePickListOption() {
		return roleOrJobTitlePickListOption;
	}

	public void setRoleOrJobTitlePickListOption(WebElement roleOrJobTitlePickListOption) {
		this.roleOrJobTitlePickListOption = roleOrJobTitlePickListOption;
	}

	public WebElement getAccountStatusPicklist() {
		return accountStatusPicklist;
	}

	public void setAccountStatusPicklist(WebElement accountStatusPicklist) {
		this.accountStatusPicklist = accountStatusPicklist;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(WebElement saveButton) {
		this.saveButton = saveButton;
	}
	
	//business code
	//active status
	public void statusSelection(String status) {
		getAccountStatusPicklist().click();
		getAccountStatusPicklistOption(status).click();
	}
	
	public void roleSelection() {
		getRoleOrJobTitlePckList().click();
		getRoleOrJobTitlePickListOption().sendKeys("User");
	}

	public WebElement getAlertToasterMessage() {
		return alertToasterMessage;
	}

	public void setAlertToasterMessage(WebElement alertToasterMessage) {
		this.alertToasterMessage = alertToasterMessage;
	}
	
	
}

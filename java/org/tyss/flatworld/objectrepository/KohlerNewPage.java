package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KohlerNewPage {
	
	WebDriver driver;
	
	public KohlerNewPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()='Menu']")private WebElement menuButton;
	@FindBy(xpath = "//a[text()='Academy']")private WebElement academyLink;
	@FindBy(xpath="//span[@class='mat-checkbox-inner-container']") private WebElement checkBoxTrue;
	@FindBy(xpath="//a[contains(text(),'Submit')]")private WebElement testSubmit;
	@FindBy(xpath = "//div/div[@class='mb-4']")private WebElement testSuccessFullMessage;
	@FindBy(xpath = "//a[text()='Transactions']")private WebElement transactionLink;
	@FindBy(xpath="(//mat-icon[@role='img'])[1]")private WebElement userprofileicon;
	@FindBy(xpath="//span[contains(text(),'My Account')]")private WebElement usermyaccount;
	@FindBy(xpath="//p[contains(text(),'Manage Tax Infomation')]/../..//button[contains(text(),'Edit')]")private WebElement usermanagetaxinformation;
	@FindBy(xpath="//div[contains(@class,'mat-select-arrow-wrapper ng')]")private WebElement yeardropdown;
	@FindBy(xpath="(//span[contains(text(),'2024')])[2]")private WebElement yearselect;
	@FindBy(xpath="//input[@id='upload-document']")private WebElement choosefilebutton;
	@FindBy(xpath="//span[contains(text(),'Save Changes')]")private WebElement managetaxinformationsavebutton;
	@FindBy(xpath="//mat-icon[contains(text(),'close')]")private WebElement managetaxinformationclose;

	
	public WebElement getTransactionLink() {
		return transactionLink;
	}
	public WebElement getYeardropdown() {
		return yeardropdown;
	}
	public void setYeardropdown(WebElement yeardropdown) {
		this.yeardropdown = yeardropdown;
	}
	public WebElement getYearselect() {
		return yearselect;
	}
	public void setYearselect(WebElement yearselect) {
		this.yearselect = yearselect;
	}
	public WebElement getChoosefilebutton() {
		return choosefilebutton;
	}
	public void setChoosefilebutton(WebElement choosefilebutton) {
		this.choosefilebutton = choosefilebutton;
	}
	public WebElement getManagetaxinformationsavebutton() {
		return managetaxinformationsavebutton;
	}
	public void setManagetaxinformationsavebutton(WebElement managetaxinformationsavebutton) {
		this.managetaxinformationsavebutton = managetaxinformationsavebutton;
	}
	public WebElement getManagetaxinformationclose() {
		return managetaxinformationclose;
	}
	public void setManagetaxinformationclose(WebElement managetaxinformationclose) {
		this.managetaxinformationclose = managetaxinformationclose;
	}
	public WebElement getUserprofileicon() {
		return userprofileicon;
	}
	public void setUserprofileicon(WebElement userprofileicon) {
		this.userprofileicon = userprofileicon;
	}
	public WebElement getUsermyaccount() {
		return usermyaccount;
	}
	public void setUsermyaccount(WebElement usermyaccount) {
		this.usermyaccount = usermyaccount;
	}
	public WebElement getUsermanagetaxinformation() {
		return usermanagetaxinformation;
	}
	public void setUsermanagetaxinformation(WebElement usermanagetaxinformation) {
		this.usermanagetaxinformation = usermanagetaxinformation;
	}
	public void setTransactionLink(WebElement transactionLink) {
		this.transactionLink = transactionLink;
	}
	public WebElement getTestSuccessFullMessage() {
		return testSuccessFullMessage;
	}
	public void setTestSuccessFullMessage(WebElement testSuccessFullMessage) {
		this.testSuccessFullMessage = testSuccessFullMessage;
	}
	public WebElement getCheckBoxTrue() {
		return checkBoxTrue;
	}
	public void setCheckBoxTrue(WebElement checkBoxTrue) {
		this.checkBoxTrue = checkBoxTrue;
	}
	public WebElement getTestSubmit() {
		return testSubmit;
	}
	public void setTestSubmit(WebElement testSubmit) {
		this.testSubmit = testSubmit;
	}
	public WebElement getMenuButton() {
		return menuButton;
	}
	public void setMenuButton(WebElement menuButton) {
		this.menuButton = menuButton;
	}
	public WebElement getAcademyLink() {
		return academyLink;
	}
	public void setAcademyLink(WebElement academyLink) {
		this.academyLink = academyLink;
	}
	
	

	
}

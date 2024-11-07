package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPublicUserPage {

	WebDriver driver;
	
	public EditPublicUserPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "(//mat-label[contains(text(),'Year')])[2]/../..//label")private WebElement yearhead;
	@FindBy(xpath = "(//mat-select[contains(@role,'combobox')])[7]")private WebElement documentselect;
	@FindBy(xpath = "(//mat-select[contains(@role,'combobox')])[8]")private WebElement verificationdropdown;
	@FindBy(xpath = "//span[contains(text(),'Verified')]")private WebElement verifiedselect;
	@FindBy(xpath = "(//span[contains(text(),'Save Changes')])[2]")private WebElement savechange;

	public WebElement getYearhead() {
		return yearhead;
	}
	public void setYearhead(WebElement yearhead) {
		this.yearhead = yearhead;
	}
	public WebElement getDocumentselect() {
		return documentselect;
	}
	public void setDocumentselect(WebElement documentselect) {
		this.documentselect = documentselect;
	}
	public WebElement getVerificationdropdown() {
		return verificationdropdown;
	}
	public void setVerificationdropdown(WebElement verificationdropdown) {
		this.verificationdropdown = verificationdropdown;
	}
	public WebElement getVerifiedselect() {
		return verifiedselect;
	}
	public void setVerifiedselect(WebElement verifiedselect) {
		this.verifiedselect = verifiedselect;
	}
	public WebElement getSavechange() {
		return savechange;
	}
	public void setSavechange(WebElement savechange) {
		this.savechange = savechange;
	}
}

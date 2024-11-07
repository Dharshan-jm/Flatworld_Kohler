package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PointsCreditManagerPage {

	WebDriver driver;

	public PointsCreditManagerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Add Credit/ Invoice')]")
	private WebElement addCreditInvoiceButton;
	@FindBy(xpath = "//div/input[@formcontrolname='shippedDate']")
	private WebElement invoiceDate;
	@FindBy(xpath = "//div/input[@formcontrolname='invoiceNumber']")
	private WebElement invoiceNumber;
	@FindBy(xpath = "//button[contains(text(),'Ineligible SKU')]")
	private WebElement ineligibleSkuButton;
	@FindBy(xpath = "//input[@formcontrolname='skuName']")
	private WebElement addskuNewName;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement addSkuNewSaveButton;
	@FindBy(xpath = "//mat-label[text()='Total Points']")
	private WebElement skuTotalPoints;
	@FindBy(xpath = "//mat-label[text()='Total List Price']")
	private WebElement skuTotalPrice;
	@FindBy(xpath = "//input[@formcontrolname='bpNumber']")
	private WebElement userid;
	@FindBy(xpath = "(//input[contains(@data-mat-calendar,'mat-datepicker')])[6]")
	private WebElement dateProcessed;
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	private WebElement addCreditPageSaveButton;
	@FindBy(xpath = "(//mat-select[@role='combobox'])[2]/div/div")
	private WebElement skudropdown;
	@FindBy(xpath = "//mat-pseudo-checkbox[contains(@class,'mat-pseudo-checkbox')]")
	private WebElement skucheckbox;
	@FindBy(xpath = "//mat-select[contains(@formcontrolname,'skuRejectionReason')]") private WebElement skurejectiondropwdown;
    @FindBy(xpath = "//span[ contains(text(),'SKU ineligible')]")private WebElement skuineligible;
    
    @FindBy(xpath = "//div/input[contains(@data-placeholder,'Search')]")
	private WebElement skudropdownsearch;
    @FindBy(xpath = "(//span[contains(@class,'text-ellipsis')])[1]")
	private WebElement verifyinvoicenum;
	@FindBy(xpath = "(//td[contains(@role,'cell')])[10]")
	private WebElement verifyinvoicepoint ;
    
	public WebElement getVerifyinvoicenum() {
		return verifyinvoicenum;
	}

	public void setVerifyinvoicenum(WebElement verifyinvoicenum) {
		this.verifyinvoicenum = verifyinvoicenum;
	}

	public WebElement getVerifyinvoicepoint() {
		return verifyinvoicepoint;
	}

	public void setVerifyinvoicepoint(WebElement verifyinvoicepoint) {
		this.verifyinvoicepoint = verifyinvoicepoint;
	}

	public WebElement getSkudropdownsearch() {
		return skudropdownsearch;
	}

	public void setSkudropdownsearch(WebElement skudropdownsearch) {
		this.skudropdownsearch = skudropdownsearch;
	}

	public WebElement getSkurejectiondropwdown() {
		return skurejectiondropwdown;
	}

	public void setSkurejectiondropwdown(WebElement skurejectiondropwdown) {
		this.skurejectiondropwdown = skurejectiondropwdown;
	}

	public WebElement getSkuineligible() {
		return skuineligible;
	}

	public void setSkuineligible(WebElement skuineligible) {
		this.skuineligible = skuineligible;
	}

	public WebElement getSkucheckbox() {
		return skucheckbox;
	}

	public void setSkucheckbox(WebElement skucheckbox) {
		this.skucheckbox = skucheckbox;
	}

	public WebElement getAddCreditInvoiceButton() {
		return addCreditInvoiceButton;
	}

	public WebElement getSkudropdown() {
		return skudropdown;
	}

	public void setSkudropdown(WebElement skudropdown) {
		this.skudropdown = skudropdown;
	}

	public void setAddCreditInvoiceButton(WebElement addCreditInvoiceButton) {
		this.addCreditInvoiceButton = addCreditInvoiceButton;
	}

	public WebElement getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(WebElement invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public WebElement getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(WebElement invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public WebElement getIneligibleSkuButton() {
		return ineligibleSkuButton;
	}

	public void setIneligibleSkuButton(WebElement ineligibleSkuButton) {
		this.ineligibleSkuButton = ineligibleSkuButton;
	}

	public WebElement getAddskuNewName() {
		return addskuNewName;
	}

	public void setAddskuNewName(WebElement addskuNewName) {
		this.addskuNewName = addskuNewName;
	}

	public WebElement getAddSkuNewSaveButton() {
		return addSkuNewSaveButton;
	}

	public void setAddSkuNewSaveButton(WebElement addSkuNewSaveButton) {
		this.addSkuNewSaveButton = addSkuNewSaveButton;
	}

	public WebElement getSkuTotalPoints() {
		return skuTotalPoints;
	}

	public void setSkuTotalPoints(WebElement skuTotalPoints) {
		this.skuTotalPoints = skuTotalPoints;
	}

	public WebElement getSkuTotalPrice() {
		return skuTotalPrice;
	}

	public void setSkuTotalPrice(WebElement skuTotalPrice) {
		this.skuTotalPrice = skuTotalPrice;
	}

	public WebElement getUserid() {
		return userid;
	}

	public void setUserid(WebElement userid) {
		this.userid = userid;
	}

	public WebElement getDateProcessed() {
		return dateProcessed;
	}

	public void setDateProcessed(WebElement dateProcessed) {
		this.dateProcessed = dateProcessed;
	}

	public WebElement getAddCreditPageSaveButton() {
		return addCreditPageSaveButton;
	}

	public void setAddCreditPageSaveButton(WebElement addCreditPageSaveButton) {
		this.addCreditPageSaveButton = addCreditPageSaveButton;
	}

}

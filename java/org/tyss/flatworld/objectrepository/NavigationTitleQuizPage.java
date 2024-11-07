package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationTitleQuizPage {

	WebDriver driver;
	
	public NavigationTitleQuizPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "(//mat-select[@role='combobox'])[3]") private WebElement quizDropDown;
	@FindBy(xpath = "(//span[text()='Quiz'])[2]") private WebElement quizSelectFromDropDown;
	@FindBy(xpath = "//span[text()='Add Slide']") private WebElement quizeAddSlide;
	@FindBy(xpath = "//input[@formcontrolname='passingMarks']") private WebElement quizPassingMark;
	@FindBy(xpath = "//input[@formcontrolname='successMsg']") private WebElement quizSuccessMessage;
	@FindBy(xpath = "//input[@formcontrolname='failMsg']") private WebElement quizFailMessage;
	@FindBy(xpath ="//button[contains(text(),'Add questions')]") private WebElement quizAddQuestionButton;
	@FindBy(xpath ="//*[@id='desc-text-area']") private WebElement quizAddTestField;
	@FindBy(xpath ="//MAT-RADIO-BUTTON[@value='trueFalse']/LABEL/SPAN/SPAN[@class='mat-radio-outer-circle']") private WebElement quizTrueFalseRadioButton;
	@FindBy(xpath ="//mat-label[text()='Options']/following::mat-checkbox/label") private WebElement quizTrueCheckBox;
	@FindBy(xpath ="//button[contains(text(),'Save')]") private WebElement quizAddSaveButton;
	@FindBy(xpath="//button[@class='mat-tooltip-trigger bulk-update-btn-cus']")private WebElement quizEditSaveButton;
	@FindBy(xpath="//mat-icon[text()='close']")private WebElement quizEditCloseButton;

	public WebElement getQuizDropDown() {
		return quizDropDown;
	}
	public void setQuizDropDown(WebElement quizDropDown) {
		this.quizDropDown = quizDropDown;
	}
	public WebElement getQuizSelectFromDropDown() {
		return quizSelectFromDropDown;
	}
	public void setQuizSelectFromDropDown(WebElement quizSelectFromDropDown) {
		this.quizSelectFromDropDown = quizSelectFromDropDown;
	}
	public WebElement getQuizeAddSlide() {
		return quizeAddSlide;
	}
	public void setQuizeAddSlide(WebElement quizeAddSlide) {
		this.quizeAddSlide = quizeAddSlide;
	}
	public WebElement getQuizPassingMark() {
		return quizPassingMark;
	}
	public void setQuizPassingMark(WebElement quizPassingMark) {
		this.quizPassingMark = quizPassingMark;
	}
	public WebElement getQuizSuccessMessage() {
		return quizSuccessMessage;
	}
	public void setQuizSuccessMessage(WebElement quizSuccessMessage) {
		this.quizSuccessMessage = quizSuccessMessage;
	}
	public WebElement getQuizFailMessage() {
		return quizFailMessage;
	}
	public void setQuizFailMessage(WebElement quizFailMessage) {
		this.quizFailMessage = quizFailMessage;
	}
	public WebElement getQuizAddQuestionButton() {
		return quizAddQuestionButton;
	}
	public void setQuizAddQuestionButton(WebElement quizAddQuestionButton) {
		this.quizAddQuestionButton = quizAddQuestionButton;
	}
	public WebElement getQuizAddTestField() {
		return quizAddTestField;
	}
	public void setQuizAddTestField(WebElement quizAddTestField) {
		this.quizAddTestField = quizAddTestField;
	}
	public WebElement getQuizTrueFalseRadioButton() {
		return quizTrueFalseRadioButton;
	}
	public void setQuizTrueFalseRadioButton(WebElement quizTrueFalseRadioButton) {
		this.quizTrueFalseRadioButton = quizTrueFalseRadioButton;
	}
	public WebElement getQuizTrueCheckBox() {
		return quizTrueCheckBox;
	}
	public void setQuizTrueCheckBox(WebElement quizTrueCheckBox) {
		this.quizTrueCheckBox = quizTrueCheckBox;
	}
	public WebElement getQuizAddSaveButton() {
		return quizAddSaveButton;
	}
	public void setQuizAddSaveButton(WebElement quizAddSaveButton) {
		this.quizAddSaveButton = quizAddSaveButton;
	}
	public WebElement getQuizEditSaveButton() {
		return quizEditSaveButton;
	}
	public void setQuizEditSaveButton(WebElement quizEditSaveButton) {
		this.quizEditSaveButton = quizEditSaveButton;
	}
	public WebElement getQuizEditCloseButton() {
		return quizEditCloseButton;
	}
	public void setQuizEditCloseButton(WebElement quizEditCloseButton) {
		this.quizEditCloseButton = quizEditCloseButton;
	}
	
	
}

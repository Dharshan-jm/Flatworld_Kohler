package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import groovy.transform.Final;

public class TrainingPage {
	
	WebDriver driver;
	
	public TrainingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'Training Courses')]")
	private WebElement trainingCourseLink;
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-flat-button mat-button-base']")
	private WebElement trainingPageAddButton;
	@FindBy(xpath="(//div/input[contains(@class,'mat-input')])[1]")
	private WebElement editTrainingCourseIdTextFile;
	@FindBy(xpath="(//div/input[contains(@class,'mat-input')])[2]")
	private WebElement editTrainingCourseNameTextField;
	@FindBy(xpath="//mat-label[contains(text(),'Curriculum *')]/ancestor::div/div[contains(@class,'mat-form-field-flex ng')]")
	private WebElement editTrainingCurriculumDropdown;
	@FindBy(xpath="//input[@placeholder='Search Curriculums']") private WebElement curriculumSearch;
	@FindBy(xpath = "//span[@class='mat-option-text']") private WebElement curriculumSearchCheckBox;
	@FindBy(xpath="(//div[contains(@class,'mat-select-value ng-tns')])[2]/ancestor::mat-select") private WebElement trainingUser;
	@FindBy(xpath = "//input[@placeholder='Search users']") private WebElement trainingUserSearch;
	@FindBy(xpath = "//span[@class='mat-option-text']")  private WebElement trainingUserCheckBox;
	@FindBy(xpath = "//div/input[@formcontrolname='startDate']") private WebElement trainingStartDate;
	@FindBy(xpath = "//div/input[@formcontrolname='endDate']") private WebElement trainingEndDate;
	@FindBy(xpath="//div/input[@type='number']") private WebElement trainingPoint;
	@FindBy(xpath = "//mat-label[contains(text(),'Active')]/ancestor::span/preceding-sibling::span") private WebElement trainingActiveCheckBox;
	@FindBy(xpath = "//button/span[@class='ng-star-inserted']") private WebElement trainingSave;
	@FindBy(xpath="(//span[@class='mat-checkbox-inner-container'])[1]")private WebElement requiredCheckBox;
@FindBy(xpath = "(//span[@class='mat-checkbox-inner-container'])[1]")private WebElement requiredcheckbox;
	
	
	
	public WebElement getRequiredcheckbox() {
		return requiredcheckbox;
	}

	public void setRequiredcheckbox(WebElement requiredcheckbox) {
		this.requiredcheckbox = requiredcheckbox;
	}
	
	
	public WebElement getRequiredCheckBox() {
		return requiredCheckBox;
	}

	public void setRequiredCheckBox(WebElement requiredCheckBox) {
		this.requiredCheckBox = requiredCheckBox;
	}

	public WebElement getTrainingActiveCheckBox() {
		return trainingActiveCheckBox;
	}

	public void setTrainingActiveCheckBox(WebElement trainingActiveCheckBox) {
		this.trainingActiveCheckBox = trainingActiveCheckBox;
	}

	public WebElement getTrainingSave() {
		return trainingSave;
	}

	public void setTrainingSave(WebElement trainingSave) {
		this.trainingSave = trainingSave;
	}

	public WebElement getTrainingStartDate() {
		return trainingStartDate;
	}

	public void setTrainingStartDate(WebElement trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}

	public WebElement getTrainingEndDate() {
		return trainingEndDate;
	}

	public void setTrainingEndDate(WebElement trainingEndDate) {
		this.trainingEndDate = trainingEndDate;
	}

	public WebElement getTrainingPoint() {
		return trainingPoint;
	}

	public void setTrainingPoint(WebElement trainingPoint) {
		this.trainingPoint = trainingPoint;
	}

	public WebElement getTrainingUserCheckBox() {
		return trainingUserCheckBox;
	}

	public void setTrainingUserCheckBox(WebElement trainingUserCheckBox) {
		this.trainingUserCheckBox = trainingUserCheckBox;
	}

	public WebElement getTrainingUser() {
		return trainingUser;
	}

	public void setTrainingUser(WebElement trainingUser) {
		this.trainingUser = trainingUser;
	}

	public WebElement getTrainingUserSearch() {
		return trainingUserSearch;
	}

	public void setTrainingUserSearch(WebElement trainingUserSearch) {
		this.trainingUserSearch = trainingUserSearch;
	}

	public WebElement getCurriculumSearchCheckBox() {
		return curriculumSearchCheckBox;
	}

	public void setCurriculumSearchCheckBox(WebElement curriculumSearchCheckBox) {
		this.curriculumSearchCheckBox = curriculumSearchCheckBox;
	}

	public WebElement getCurriculumSearch() {
		return curriculumSearch;
	}

	public void setCurriculumSearch(WebElement curriculumSearch) {
		this.curriculumSearch = curriculumSearch;
	}

	public WebElement getEditTrainingCourseIdTextFile() {
		return editTrainingCourseIdTextFile;
	}

	public void setEditTrainingCourseIdTextFile(WebElement editTrainingCourseIdTextFile) {
		this.editTrainingCourseIdTextFile = editTrainingCourseIdTextFile;
	}

	public WebElement getEditTrainingCourseNameTextField() {
		return editTrainingCourseNameTextField;
	}

	public void setEditTrainingCourseNameTextField(WebElement editTrainingCourseNameTextField) {
		this.editTrainingCourseNameTextField = editTrainingCourseNameTextField;
	}

	public WebElement getEditTrainingCurriculumDropdown() {
		return editTrainingCurriculumDropdown;
	}

	public void setEditTrainingCurriculumDropdown(WebElement editTrainingCurriculumDropdown) {
		this.editTrainingCurriculumDropdown = editTrainingCurriculumDropdown;
	}

	public WebElement getTrainingCourseLink() {
		return trainingCourseLink;
	}

	public void setTrainingCourseLink(WebElement trainingCourseLink) {
		this.trainingCourseLink = trainingCourseLink;
	}

	public WebElement getTrainingPageAddButton() {
		return trainingPageAddButton;
	}

	public void setTrainingPageAddButton(WebElement trainingPageAddButton) {
		this.trainingPageAddButton = trainingPageAddButton;
	}
	

}

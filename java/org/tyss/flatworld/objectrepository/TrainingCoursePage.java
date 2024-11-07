package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrainingCoursePage {
	
	WebDriver driver;
	
	public TrainingCoursePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Search']") private WebElement trainingCourseSearch;
	@FindBy(xpath = "(//div[contains(text(),'Actions')])[2]") private WebElement trainingCourseAction;
	@FindBy(xpath = "//span[text()=' Edit ']/ancestor::span") private WebElement trainingCourseEdit;
	@FindBy(xpath = "//button[text()='Edit']") private WebElement trainingCourseAddEdit;
	@FindBy(xpath = "//span[text()='Save']") private WebElement trainingCoursePageSaveButton;
	
	

	public WebElement getTrainingCoursePageSaveButton() {
		return trainingCoursePageSaveButton;
	}
	public void SetTrainingCoursePageSaveButton(WebElement trainingPageSaveButton) {
		this.trainingCoursePageSaveButton = trainingPageSaveButton;
	}
	public WebElement getTrainingCourseSearch() {
		return trainingCourseSearch;
	}
	public void setTrainingCourseSearch(WebElement trainingCourseSearch) {
		this.trainingCourseSearch = trainingCourseSearch;
	}
	public WebElement getTrainingCourseAction() {
		return trainingCourseAction;
	}
	public void setTrainingCourseAction(WebElement trainingCourseAction) {
		this.trainingCourseAction = trainingCourseAction;
	}
	public WebElement getTrainingCourseEdit() {
		return trainingCourseEdit;
	}
	public void setTrainingCourseEdit(WebElement trainingCourseEdit) {
		this.trainingCourseEdit = trainingCourseEdit;
	}
	public WebElement getTrainingCourseAddEdit() {
		return trainingCourseAddEdit;
	}
	public void setTrainingCourseAddEdit(WebElement trainingCourseAddEdit) {
		this.trainingCourseAddEdit = trainingCourseAddEdit;
	}
     
	
}

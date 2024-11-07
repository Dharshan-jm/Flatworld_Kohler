package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CurriculumPage {
	
	WebDriver driver;
	
	public CurriculumPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Curriculum Manager']")
	private WebElement curriculumManagerLink;
	
	@FindBy(xpath="//button[contains(@class,'mat-focus-indicator ml-4 mat')]")
	private WebElement curriculumManagerAddButton;
	
	@FindBy(xpath="//div/textarea[@id='training-desc-text-area']")
	private WebElement curriculumManagerDescription;
	
	@FindBy(xpath="//div/input[contains(@id,'mat-input')]")
	private WebElement curriculumManagerName;
	
	@FindBy(xpath="//button[@type='button']/..//span[contains(text(),'Save')]")
	private WebElement curriculumSaveButton;
	
	@FindBy(xpath ="//span[@class='spnMnuIcon ng-star-inserted']")
	private WebElement curriculumManagerMenuLink;
	
	

	public WebElement getCurriculumManagerMenuLink() {
		return curriculumManagerMenuLink;
	}

	public void setCurriculumManagerMenuLink(WebElement curriculumManagerMenuLink) {
		this.curriculumManagerMenuLink = curriculumManagerMenuLink;
	}

	public WebElement getCurriculumManagerLink() {
		return curriculumManagerLink;
	}

	public void setCurriculumManagerLink(WebElement curriculumManagerLink) {
		this.curriculumManagerLink = curriculumManagerLink;
	}

	public WebElement getCurriculumManagerAddButton() {
		return curriculumManagerAddButton;
	}

	public void setCurriculumManagerAddButton(WebElement curriculumManagerAddButton) {
		this.curriculumManagerAddButton = curriculumManagerAddButton;
	}

	public WebElement getCurriculumManagerDescription() {
		return curriculumManagerDescription;
	}

	public void setCurriculumManagerDescription(WebElement curriculumManagerDescription) {
		this.curriculumManagerDescription = curriculumManagerDescription;
	}

	public WebElement getCurriculumManagerName() {
		return curriculumManagerName;
	}

	public void setCurriculumManagerName(WebElement curriculumManagerName) {
		this.curriculumManagerName = curriculumManagerName;
	}

	public WebElement getCurriculumSaveButton() {
		return curriculumSaveButton;
	}

	public void setCurriculumSaveButton(WebElement curriculumSaveButton) {
		this.curriculumSaveButton = curriculumSaveButton;
	}
	
	

}

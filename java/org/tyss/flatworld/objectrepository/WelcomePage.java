package org.tyss.flatworld.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	WebDriver driver;
	@FindBy(id = "email") private WebElement emailIdTextfield;
	@FindBy(id = "password") private WebElement passwordTextfield;
	@FindBy(id = "signInButton") private WebElement signInButton;
	@FindBy(xpath = "//*[contains(@class,'StyledText')]") private List<WebElement> listOfStyledText;

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailIdTextfield() {
		return emailIdTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public List<WebElement> getListOfStyledText() {
		return listOfStyledText;
	}
}

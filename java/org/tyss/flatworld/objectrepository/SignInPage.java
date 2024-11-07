package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;
	@FindBy(id = "email") private WebElement userIdTextfield;
	@FindBy(xpath = "//input[@type='password']") private WebElement passwordTextfield;
	@FindBy(xpath = "//button[normalize-space(text())='Sign In']") private WebElement signInButton;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserIdTextfield() {
		return userIdTextfield;
	}

	public void setUserIdTextfield(WebElement userIdTextfield) {
		this.userIdTextfield = userIdTextfield;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public void setPasswordTextfield(WebElement passwordTextfield) {
		this.passwordTextfield = passwordTextfield;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public void setSignInButton(WebElement signInButton) {
		this.signInButton = signInButton;
	}
	
	//business code
	public void loginInToApp(String username, String password) {
		
		getUserIdTextfield().sendKeys(username);
		getPasswordTextfield().sendKeys(password);
		getSignInButton().click();
	}

}

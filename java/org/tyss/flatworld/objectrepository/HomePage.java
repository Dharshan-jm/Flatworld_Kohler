package org.tyss.flatworld.objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath = "//*[contains(@class,'StyledText')]") private List<WebElement> listOfStyledText;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getListOfStyledText() {
		return listOfStyledText;
	}
}

package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage {
	
	WebDriver driver;
	
	public TransactionPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(//th[@role='columnheader']/../../..//td[@role='cell'])[8]")private WebElement points;
	@FindBy(xpath = "//span[contains(@class,'spnPoints inline-flex')]") private WebElement pointsOnHold;
    @FindBy(xpath="//SPAN[contains(text(),'points')]/*")private WebElement lock;
    @FindBy(xpath = "(//span[contains(@class,'text-ellipsis')])[1]") private WebElement captureinvoice;
    
	
   	public WebElement getCaptureinvoice() {
   		return captureinvoice;
   	}

   	public void setCaptureinvoice(WebElement captureinvoice) {
   		this.captureinvoice = captureinvoice;
   	}

	
	public WebElement getLock() {
		return lock;
	}

	public void setLock(WebElement lock) {
		this.lock = lock;
	}

	public WebElement getPointsOnHold() {
		return pointsOnHold;
	}

	public void setPointsOnHold(WebElement pointsOnHold) {
		this.pointsOnHold = pointsOnHold;
	}

	public WebElement getPoints() {
		return points;
	}

	public void setPoints(WebElement points) {
		this.points = points;
	}
	
	

}

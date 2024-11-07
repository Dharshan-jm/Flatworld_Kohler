package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedeemPage {
	
	WebDriver driver;
	
	public RedeemPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
    
	@FindBy(xpath = "//a[contains(text(),' Redeem')]")private WebElement getRedeem;
	@FindBy(xpath = "//a[contains(text(),' KOHLER Rewards Card')]")private WebElement kohlerRewardsCard;
	@FindBy(xpath = "//input[@type='number']")private WebElement loadMyCardNumber;
	@FindBy(xpath = "//button[text()='Redeem Now']")private WebElement redeemNowButton;
	@FindBy(xpath = "//div[@role='alert']")private WebElement captureActualText;
	@FindBy(xpath = "//a[contains(text(),' KOHLER Direct Gift Cards')]")private WebElement kohlerRewardsGift;
	

	
	public WebElement getKohlerRewardsGift() {
		return kohlerRewardsGift;
	}
	public void setKohlerRewardsGift(WebElement kohlerRewardsGift) {
		this.kohlerRewardsGift = kohlerRewardsGift;
	}
	public WebElement getGetRedeem() {
		return getRedeem;
	}
	public void setGetRedeem(WebElement getRedeem) {
		this.getRedeem = getRedeem;
	}
	public WebElement getKohlerRewardsCard() {
		return kohlerRewardsCard;
	}
	public void setKohlerRewardsCard(WebElement kohlerRewardsCard) {
		this.kohlerRewardsCard = kohlerRewardsCard;
	}
	public WebElement getLoadMyCardNumber() {
		return loadMyCardNumber;
	}
	public void setLoadMyCardNumber(WebElement loadMyCardNumber) {
		this.loadMyCardNumber = loadMyCardNumber;
	}
	public WebElement getRedeemNowButton() {
		return redeemNowButton;
	}
	public void setRedeemNowButton(WebElement redeemNowButton) {
		this.redeemNowButton = redeemNowButton;
	}
	public WebElement getCaptureActualText() {
		return captureActualText;
	}
	public void setCaptureActualText(WebElement captureActualText) {
		this.captureActualText = captureActualText;
	}
	
	
}

package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgramConfigurationPage {
	
	WebDriver driver;
	
	public ProgramConfigurationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
    
	@FindBy(xpath="(//span[contains(text(),' Require Tax form' )]/../..//span[@class='mat-radio-outer-circle'])[1]")private WebElement taxrequireradio;
	@FindBy(xpath="//span[contains(text(),'Save Configurations')]")private WebElement saveconfig;

	public WebElement getTaxrequireradio() {
		return taxrequireradio;
	}
	public void setTaxrequireradio(WebElement taxrequireradio) {
		this.taxrequireradio = taxrequireradio;
	}
	public WebElement getSaveconfig() {
		return saveconfig;
	}
	public void setSaveconfig(WebElement saveconfig) {
		this.saveconfig = saveconfig;
	}
	
	
}

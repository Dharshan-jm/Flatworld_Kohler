package org.tyss.flatworld.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderRedeemptionManagerPage {

	WebDriver driver;
	
	public OrderRedeemptionManagerPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Single User Search / Add New Order')]")private WebElement singleusersearchadd;
	@FindBy(xpath="//div[contains(text(),' Add New Order')]")private WebElement  addneworderbutton;
	@FindBy(xpath="//input[@formcontrolname='bpNumber']")private WebElement username;
	@FindBy(xpath="//input[@formcontrolname='orderDate']")private WebElement orderdate;
	@FindBy(xpath="//input[@formcontrolname='poNumber']")private WebElement ordernumber;
	@FindBy(xpath="//span[contains(text(),'Add Item')]/parent::button[@class='flex items-center ng-star-inserted']")private WebElement additem; 
	@FindBy(xpath="//input[@formcontrolname='externalOrderId']")private WebElement ponumber;
	@FindBy(xpath="//input[@formcontrolname='quantity']")private WebElement quantity;
	@FindBy(xpath="//input[@formcontrolname='price']")private WebElement price;
	@FindBy(xpath="//input[@formcontrolname='points']")private WebElement points;
	@FindBy(xpath="//input[@formcontrolname='itemName']")private WebElement itemname;
	@FindBy(xpath="//input[@formcontrolname='itemVendorName']")private WebElement vendorname;
	@FindBy(xpath="(//div[contains(@class,'mat-select-arrow-wrapper ng-tns')])[4]")private WebElement statusselect;
	@FindBy(xpath="//span[text()='Pending']")private WebElement statuspending;
	@FindBy(xpath="(//span[text()='Save'])[2]")private WebElement addeditordersave;
	@FindBy(xpath="//span[text()='Save']")private WebElement addnewordersave;
//	@FindBy(xpath="")private WebElement

	public WebElement getSingleusersearchadd() {
		return singleusersearchadd;
	}
	public void setSingleusersearchadd(WebElement singleusersearchadd) {
		this.singleusersearchadd = singleusersearchadd;
	}
	public WebElement getAddneworderbutton() {
		return addneworderbutton;
	}
	public void setAddneworderbutton(WebElement addneworderbutton) {
		this.addneworderbutton = addneworderbutton;
	}
	public WebElement getUsername() {
		return username;
	}
	public void setUsername(WebElement username) {
		this.username = username;
	}
	public WebElement getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(WebElement orderdate) {
		this.orderdate = orderdate;
	}
	public WebElement getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(WebElement ordernumber) {
		this.ordernumber = ordernumber;
	}
	public WebElement getAdditem() {
		return additem;
	}
	public void setAdditem(WebElement additem) {
		this.additem = additem;
	}
	public WebElement getPonumber() {
		return ponumber;
	}
	public void setPonumber(WebElement ponumber) {
		this.ponumber = ponumber;
	}
	public WebElement getQuantity() {
		return quantity;
	}
	public void setQuantity(WebElement quantity) {
		this.quantity = quantity;
	}
	public WebElement getPrice() {
		return price;
	}
	public void setPrice(WebElement price) {
		this.price = price;
	}
	public WebElement getPoints() {
		return points;
	}
	public void setPoints(WebElement points) {
		this.points = points;
	}
	public WebElement getItemname() {
		return itemname;
	}
	public void setItemname(WebElement itemname) {
		this.itemname = itemname;
	}
	public WebElement getVendorname() {
		return vendorname;
	}
	public void setVendorname(WebElement vendorname) {
		this.vendorname = vendorname;
	}
	public WebElement getStatusselect() {
		return statusselect;
	}
	public void setStatusselect(WebElement statusselect) {
		this.statusselect = statusselect;
	}
	public WebElement getStatuspending() {
		return statuspending;
	}
	public void setStatuspending(WebElement statuspending) {
		this.statuspending = statuspending;
	}
	public WebElement getAddeditordersave() {
		return addeditordersave;
	}
	public void setAddeditordersave(WebElement addeditordersave) {
		this.addeditordersave = addeditordersave;
	}
	public WebElement getAddnewordersave() {
		return addnewordersave;
	}
	public void setAddnewordersave(WebElement addnewordersave) {
		this.addnewordersave = addnewordersave;
	}
	
	
}

package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.Base;

public class WomanCatalogPage extends Base{

	
	//initialize pagefactory
	public WomanCatalogPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// page objects
	
	@FindBy(xpath="//div[@class='product-image-container']")
	WebElement imagecontainer;
	
	@FindBy(xpath="//div[@class='product-image-container']/a[2]/span")
	WebElement quickviewbtn;
	
	@FindBy(xpath="//p[@id='add_to_cart']")
	WebElement addtocartbtn;
	
	@FindBy(xpath="//p[@id='quantity_wanted_p']/a[2]")
	WebElement additionsign;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']/span/i")
	WebElement proceedcheckout;
	
	//a[@title='Proceed to checkout']/span/i
	// actions
	public void clickonquickview()
	{
		Actions action = new Actions(driver);
		action.moveToElement(imagecontainer).build().perform();
		action.moveToElement(quickviewbtn).click().build().perform();		
	}
	
	public void clickonadd()
	{
		additionsign.click();
	}
	
	public void addtocart()
	{
		addtocartbtn.click();
	}
	
	public OrderPlacingPage clickonproceed()
	{
		proceedcheckout.click();
		return new OrderPlacingPage();
	}
	
	public WebElement proceedbtn()
	{
		return proceedcheckout;
	}
}

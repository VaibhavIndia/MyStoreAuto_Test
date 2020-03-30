package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.Base;

public class OrderPlacingPage extends Base {

	
	// initialize pagefactory 
	public OrderPlacingPage()
	{
		PageFactory.initElements(driver, this);
	}

	// page object
	
	@FindBy(xpath="//span[@id='total_price']")
	WebElement totalpricefield;
	
	
	@FindBy(xpath="(//a[@title='Proceed to checkout']/span/i)[2]")
	WebElement proceedchkbtn;
	
	@FindBy(xpath="//button[@name='processAddress']")
	WebElement proceedaddress;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkbox;
	
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement proceedcarrier;
	
	@FindBy(xpath="//a[@class='cheque']")
	WebElement paybycheque;
	
	@FindBy(xpath="(//button[@type='submit']/span)[2]")
	WebElement confirmbtn;
	
	// Price places
	
	
	@FindBy(xpath="//span[@id='amount']")
	WebElement confirmpageamount;
	
	//actions
	
	public String getpricevalue()
	{
		return totalpricefield.getText();
	}
	
	public void clickonproceed()
	{
		proceedchkbtn.click();
	}
	
	public void clickonproceedaddress()
	{
		proceedaddress.click();
	}

	public void clickcheckbox()
	{
		checkbox.click();
	}
	
	public void proceedcarrier()
	{
		proceedcarrier.click();
	}
	
	public void paybychequeclick()
	{
		paybycheque.click();
	}
	
	public void clickoncnfirmbtn()
	{
		confirmbtn.click();
	}
	
	// amount retreive from pages
	
	
	// amount from order conformation page
	
	public String getfinalpricefromorderconfpage()
	{
		return confirmpageamount.getText();
	}
}


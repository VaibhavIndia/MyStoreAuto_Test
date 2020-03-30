package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.Base;

public class OrderHistoryPage extends Base{
	
	// initialize pagefactory
	public OrderHistoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// pageobjects
	@FindBy(xpath="//td[@class='history_price']")
	WebElement previouspordervalue;
	
	
	//actions
	public String getpreviousordervalue()
	{
		return previouspordervalue.getText();
	}
	

}

package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.Base;

public class MyAccountPage extends Base{
	
	/// initialize pagefactory
	public MyAccountPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Obeject repo..
	@FindBy(xpath="//a[@title='Women']")
	WebElement linktowomencatalog;
	
	
	@FindBy(xpath="//a[@title='Orders']")
	WebElement orderhistorylink;
	
	@FindBy(xpath="//a[@class='account']")
	WebElement username;
	
	
	//Actions
	
	public WomanCatalogPage clickonwomencataloglink()
	{
		linktowomencatalog.click();
		return new WomanCatalogPage();
	}
	
	public OrderHistoryPage clickonorderhistorylink()
	{
		orderhistorylink.click();
		return new OrderHistoryPage();
	}
	
	public String username()
	{
		return username.getText();
	}
	

}

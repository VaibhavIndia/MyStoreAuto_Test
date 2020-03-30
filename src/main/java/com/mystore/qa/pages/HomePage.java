package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.Base;

public class HomePage extends Base{

	// initialize pagefactory
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Obeject repo..
	@FindBy(xpath="//a[@class='login']")
	WebElement loginlink;
	
	
	@FindBy(xpath="//a[@title='Contact Us']")
	WebElement contactuslink;
	
	//Actions
	
	public SigninPage clickonloginlink()
	{
		loginlink.click();
		return new SigninPage();
	}
	
	public void clickoncontactlink()
	{
		contactuslink.click();
	}
		
}

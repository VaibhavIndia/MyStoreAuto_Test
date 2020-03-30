package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.qa.base.Base;

public class SigninPage extends Base{
	
	// initialize pagefactory
	public SigninPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Obeject repo..
	@FindBy(id="email")
	WebElement useremailfield;
	
	
	@FindBy(id="passwd")
	WebElement passwordfield;
	
	@FindBy(xpath="//button[@id='SubmitLogin']/span/i")
	WebElement submitbtn;
	

	@FindBy(id="email_create")
	WebElement createaccount;
	
	@FindBy(id="SubmitCreate")
	WebElement createaccountbtn;
	
	
	
	//Actions
	
	public MyAccountPage dologin(String username, String password) throws Exception
	{
		useremailfield.sendKeys(username);
		passwordfield.sendKeys(password);
		submitbtn.click();
		
		return new MyAccountPage();
	}
	
	public void createaccount(String newemailid)
	{
		createaccount.sendKeys(newemailid);
	}
	
	public CreateAccountPage clickoncreateaccountbtn()
	{
		createaccountbtn.click();
		return new CreateAccountPage();
	}
	
}

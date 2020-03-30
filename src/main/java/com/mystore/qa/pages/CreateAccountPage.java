package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.qa.base.Base;

public class CreateAccountPage extends Base{
	
	// initialize pagefactory
		public CreateAccountPage() 
		{
			PageFactory.initElements(driver, this);
		}
	
	//Obeject repo..
	
		
	@FindBy(xpath="(//div[@class='account_creation']/h3[@class='page-subheading'])[1]")
	WebElement subheading1;
	
	public WebElement subheading()
	{
		return subheading1;
	}
		
	@FindBy(id="id_gender1")
	WebElement mrRadiobox;
	
	public WebElement mrradio()
	{
		return mrRadiobox;
	}
	
	@FindBy(id="id_gender2")
	WebElement mrSRadiobox;
	
	@FindBy(id="customer_firstname")
	WebElement CFirstName;
	
	@FindBy(id="customer_lastname")
	WebElement CLastName;
	
	@FindBy(id="passwd")
	WebElement Password;
	
	@FindBy(id="days")
	WebElement days;	
	//Select selectday = new Select(days);
	
	
	@FindBy(id="months")
	WebElement months;
	//Select selectmonths = new Select(months);
	
	@FindBy(id="years")
	WebElement years;	
	//Select selectyears = new Select(years);
	
	@FindBy(id="firstname")
	WebElement AddressFirstName;
	
	@FindBy(id="lastname")
	WebElement AddressLastName;
	
	@FindBy(id="address1")
	WebElement AddressLine1;

	@FindBy(id="city")
	WebElement Addresscity;
	
	@FindBy(id="id_state")
	WebElement stateddl;	
	//Select selectstate = new Select(stateddl);
	
	@FindBy(id="postcode")
	WebElement AddressPostCode;
	
	@FindBy(id="id_country")
	WebElement countryddl;	
	//Select selectcountry = new Select(countryddl);
	
	@FindBy(id="phone_mobile")
	WebElement Mobilephone;
	

	@FindBy(xpath="//button[@id='submitAccount']/span/i")
	WebElement Registerbtn;
	
	
	// Actions
	
	public void selectmr()
	{
		mrRadiobox.click();
	}
	
	public void selectmrs()
	{
		mrSRadiobox.click();
	}
	
	public void entercustomerfirstName(String customerFirstName)
	{
		CFirstName.sendKeys(customerFirstName);
	}
	
	public void entercustomerlastName(String customerLastName)
	{
		CLastName.sendKeys(customerLastName);
	}
	
	public void entercCustomerpassword(String customerPassword)
	{
		Password.sendKeys(customerPassword);
	}
	
	public void selectday (String dayValue)
	{
		Select sd = new Select(days);
		sd.selectByValue(dayValue);
		//selectday.selectByValue(dayValue);
	}
	
	public void selectmonth(String monthValue)
	{
		Select sm = new Select(months);
		sm.selectByValue(monthValue);
		//selectmonths.selectByValue(monthValue);
	}
	
	public void selectyear(String yearValue)
	{
		Select sy = new Select(years);
		sy.selectByValue(yearValue);
		//selectyears.selectByValue(yearValue);
	}
	
	public void enteraddressfirstname(String addresFirstName)
	{
		AddressFirstName.sendKeys(addresFirstName);
	}
	
	
	public void enteraddresslastname(String addressLastName)
	{
		AddressLastName.sendKeys(addressLastName);
	}
	
	public void enteraddressline1(String addressline1)
	{
		AddressLine1.sendKeys(addressline1);
	}
	
	public void enteraddresscity(String addressCityname)
	{
		Addresscity.sendKeys(addressCityname);
	}
	
	public void selectstate(String addressValue)
	{
		Select ss = new Select(stateddl);
		ss.selectByValue(addressValue);
		//selectstate.selectByValue(addressValue);
	}
	
	public void enteraddresspostalcode(String postalCode)
	{
		AddressPostCode.sendKeys(postalCode);
	}
	
	public void selectcountry(String countryValue)
	{
		Select sc = new Select(countryddl);
		sc.selectByValue(countryValue);
		//selectcountry.selectByValue(countryValue);
	}
	
	public void entermobilephonenumber(String mobileValue)
	{
		Mobilephone.sendKeys(mobileValue);
	}
	
	public MyAccountPage clickonregisterbtn()
	{
		Registerbtn.click();
		return new MyAccountPage();
	}
}

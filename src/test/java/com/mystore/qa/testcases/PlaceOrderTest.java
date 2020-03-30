package com.mystore.qa.testcases;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mystore.qa.base.Base;
import com.mystore.qa.pages.CreateAccountPage;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.OrderPlacingPage;
import com.mystore.qa.pages.SigninPage;
import com.mystore.qa.pages.WomanCatalogPage;
import com.mystore.qa.util.VaibhavExcelUtility;

public class PlaceOrderTest extends Base{
	HomePage homepage;
	SigninPage signinpage;
	CreateAccountPage createaccountpage;
	MyAccountPage myaccountpage;
	WomanCatalogPage womencatpage;
	OrderPlacingPage orderplacingpage;
	
	File fl;
	
	
	public PlaceOrderTest()
	{
		super();
	}
	
	@BeforeTest
	public void setup()
	{
		initialize();
		homepage = new HomePage();
		
	}
	
	@Test
	public void placeorder() throws Exception
	{
		signinpage = homepage.clickonloginlink();
		String filename = System.getProperty("user.dir")+"\\src\\main\\java\\com\\mystore\\qa\\testdata\\testdata.xlsx";
		fl = new File(filename);
		
		ArrayList<String> credentials = VaibhavExcelUtility.getdata(fl, "Sheet1", "Testcase", "Accountinformation");
		String userEmail = credentials.get(1);
		String userPassword = credentials.get(2);
		myaccountpage = signinpage.dologin(userEmail, userPassword);
		womencatpage = myaccountpage.clickonwomencataloglink();
		womencatpage.clickonquickview();
		driver.switchTo().frame(0);
		womencatpage.clickonadd();
		womencatpage.addtocart();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(womencatpage.proceedbtn()));
		orderplacingpage = womencatpage.clickonproceed();
		
		ArrayList<String> ExpectedfinalValue = VaibhavExcelUtility.getdata(fl, "Sheet1", "Testcase", "finalprice");
		String ExpectedfinalCartValue  = ExpectedfinalValue.get(1);
		String actualFinalCartValue = orderplacingpage.getpricevalue();
		Assert.assertEquals(actualFinalCartValue, ExpectedfinalCartValue);
		orderplacingpage.clickonproceed();
		orderplacingpage.clickonproceedaddress();
		orderplacingpage.clickcheckbox();
		orderplacingpage.proceedcarrier();
		orderplacingpage.paybychequeclick();
		String valueonordercnfpage = orderplacingpage.getfinalpricefromorderconfpage();
		Assert.assertEquals(valueonordercnfpage, ExpectedfinalCartValue);
		orderplacingpage.clickoncnfirmbtn();
		System.out.println("Order Placed Successfully");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}

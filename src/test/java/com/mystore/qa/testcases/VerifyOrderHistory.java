package com.mystore.qa.testcases;

import java.io.File;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.Base;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.OrderHistoryPage;
import com.mystore.qa.pages.SigninPage;
import com.mystore.qa.util.VaibhavExcelUtility;

public class VerifyOrderHistory extends Base{
	
	HomePage homepage;
	SigninPage signinpage;
	MyAccountPage myaccountpage;
	OrderHistoryPage orderhistorypage;
	
	
	File fl;
	public VerifyOrderHistory()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		homepage = new HomePage();
	}
	
	@Test
	public void checkorderhistory() throws Exception
	{
		signinpage = homepage.clickonloginlink();
		String filename = System.getProperty("user.dir")+"\\src\\main\\java\\com\\mystore\\qa\\testdata\\testdata.xlsx";
		fl = new File(filename);
		
		ArrayList<String> credentials = VaibhavExcelUtility.getdata(fl, "Sheet1", "Testcase", "Accountinformation");
		String userEmail = credentials.get(1);
		String userPassword = credentials.get(2);
		myaccountpage = signinpage.dologin(userEmail, userPassword);
		orderhistorypage = myaccountpage.clickonorderhistorylink();
		
		ArrayList<String> ExpectedfinalValue = VaibhavExcelUtility.getdata(fl, "Sheet1", "Testcase", "finalprice");
		String ExpectedfinalCartValue  = ExpectedfinalValue.get(1);
		
		String actualvalueonorderhistorypage = orderhistorypage.getpreviousordervalue();
		Assert.assertEquals(actualvalueonorderhistorypage, ExpectedfinalCartValue);
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
